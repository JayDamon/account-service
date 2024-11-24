package com.factotum.accountservice.reciever;

import com.factotum.accountservice.message.UpdateAccountItemMessage;
import com.factotum.accountservice.message.UpdateAccountMessage;
import com.factotum.accountservice.model.Account;
import com.factotum.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class UpdateAccountQueueLReceiver {

    private final AccountRepository accountRepository;

    public UpdateAccountQueueLReceiver(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RabbitListener(queues = "#{updateAccountQueue.name}")
    void receiveMessage(UpdateAccountItemMessage accountItemMessage) {

        log.atDebug().log("Received update account item message: {}", accountItemMessage);

        Flux.fromIterable(accountItemMessage.getAccounts())
                .map(updateAccount ->
                        this.accountRepository.queryByPlaidIdAndTenantId(updateAccount.getPlaidId(), updateAccount.getTenantId())
                                .switchIfEmpty(createNewAccount(updateAccount))
                                .map(account -> {

                                    new ModelMapper().map(updateAccount, account);

                                    log.atDebug().log("Saved new account {}", account);

                                    return this.accountRepository.save(account).subscribe();
                                }).subscribe()
                ).subscribe();
    }

    private Mono<Account> createNewAccount(UpdateAccountMessage updateAccount) {

        Account account = new ModelMapper().map(updateAccount, Account.class);
        account.setStartingBalance(account.getCurrentBalance());

        return Mono.just(account);
    }

}
