package com.factotum.accountservice.service;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.model.Account;
import com.factotum.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplUnitTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountService accountService;

    private static final UUID accountIdOne = UUID.fromString("43b38f84-ed18-4801-803f-2f4be3119d3f");

    @BeforeEach
    void setUp() {
        this.accountService = new AccountServiceImpl(this.accountRepository);
    }

    @Test
    void update_GivenStartingBalanceIsChanged_ThenCurrentBalanceIsUpdated() {

        // Arrange
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountIdOne);
        accountDto.setStartingBalance(BigDecimal.valueOf(50.04));

        Account account = new Account();
        account.setCurrentBalance(BigDecimal.valueOf(20));
        account.setStartingBalance(BigDecimal.valueOf(35));

        when(this.accountRepository.findById(any(UUID.class))).thenReturn(Mono.just(account));
        when(this.accountRepository.save(any(Account.class))).thenAnswer(i -> Mono.just(i.getArgument(0)));

        // Act
        Account updatedAccount = this.accountService.update(accountDto).block();

        // Assert
        assertThat(updatedAccount, is(not(nullValue())));
        assertThat(updatedAccount.getCurrentBalance(), is(equalTo(BigDecimal.valueOf(35.04))));

    }

    @Test
    void update_GivenNoChangeToCurrentBalance_ThenDoNotUpdateCurrentBalance() {

        // Arrange
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountIdOne);

        Account account = new Account();
        account.setCurrentBalance(BigDecimal.valueOf(20));
        account.setStartingBalance(BigDecimal.valueOf(35));

        when(this.accountRepository.findById(any(UUID.class))).thenReturn(Mono.just(account));
        when(this.accountRepository.save(any(Account.class))).thenAnswer(i -> Mono.just(i.getArgument(0)));

        // Act
        Account updatedAccount = this.accountService.update(accountDto).block();

        // Assert
        assertThat(updatedAccount, is(not(nullValue())));
        assertThat(updatedAccount.getCurrentBalance(), is(equalTo(BigDecimal.valueOf(20))));

    }

}
