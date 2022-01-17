package com.factotum.accountservice.service;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.model.Account;
import com.factotum.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.modelmapper.Conditions.isNotNull;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Mono<Account> update(AccountDto updatedAccount) {
        return this.accountRepository.findById(updatedAccount.getId())
                .map(account -> {

                    if (updatedAccount.getStartingBalance() != null) {
                        BigDecimal balanceChange = account.getStartingBalance().subtract(updatedAccount.getStartingBalance());
                        account.setCurrentBalance(account.getCurrentBalance().subtract(balanceChange));
                    }
                    ModelMapper mapper = new ModelMapper();
                    mapper.getConfiguration().setPropertyCondition(isNotNull());
                    mapper.map(updatedAccount, account);

                    return account;
                }).flatMap(this.accountRepository::save);
    }

}
