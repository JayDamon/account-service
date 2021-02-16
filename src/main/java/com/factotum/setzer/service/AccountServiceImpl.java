package com.factotum.setzer.service;

import com.factotum.setzer.dto.AccountDto;
import com.factotum.setzer.model.Account;
import com.factotum.setzer.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static org.modelmapper.Conditions.isNotNull;

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
                    ModelMapper mapper = new ModelMapper();
                    mapper.getConfiguration().setPropertyCondition(isNotNull());
//                    mapper.typeMap(Account.class, Account.class)
//                            .addMappings(map -> {
//                                map.map(a -> a.getAccountType().getId(), Account::setAccountTypeId);
//                                map.skip(Account::setAccountTypeId);
//                            }).map(updatedAccount, account);
                    return new ModelMapper().map(updatedAccount, Account.class);
                }).flatMap(this.accountRepository::save);
    }
}
