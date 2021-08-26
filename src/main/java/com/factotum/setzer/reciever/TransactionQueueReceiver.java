package com.factotum.setzer.reciever;

import com.factotum.setzer.config.TransactionQueueConfig;
import com.factotum.setzer.message.TransactionAmountChanged;
import com.factotum.setzer.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionQueueReceiver {

    private final AccountRepository accountRepository;

    public TransactionQueueReceiver(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RabbitListener(queues = TransactionQueueConfig.TRANSACTION_CHANGE)
    void receiveMessage(TransactionAmountChanged amountChanged) {
        accountRepository.queryByIdAndTenantId(amountChanged.getAccountId(), amountChanged.getTenantId())
                .map(a -> {
                    a.setCurrentBalance(
                            a.getCurrentBalance().add(amountChanged.getAmount())
                    );
                    log.info("New Current Balance is: {}", a.getCurrentBalance());
                    return accountRepository.save(a).subscribe();
                })
                .subscribe();
    }

}
