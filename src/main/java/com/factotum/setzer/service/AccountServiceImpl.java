package com.factotum.setzer.service;

import com.factotum.setzer.model.Account;
import com.factotum.setzer.model.AccountType;
import com.factotum.setzer.repository.AccountRepository;
import com.factotum.setzer.repository.AccountTypeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
    public Mono<Account> save(Account updatedAccount) {
        return this.accountRepository.findById(updatedAccount.getId().longValue())
                .map(account -> {
                    ModelMapper mapper = new ModelMapper();
                    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(isNotNull());
                    mapper.typeMap(Account.class, Account.class)
                            .addMappings(map -> {
                                map.map(a -> a.getAccountType().getId(), Account::setAccountTypeId);
                                map.skip(Account::setAccountTypeId);
                            }).map(updatedAccount, account);
                    return account;
                }).flatMap(this.accountRepository::save);
    }
}
