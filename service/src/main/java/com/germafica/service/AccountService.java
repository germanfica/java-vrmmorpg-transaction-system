package com.germafica.service;

import com.germafica.dto.*;
import com.germafica.entity.Account;
import com.germafica.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService {
    // == fields ==
    private AccountRepository accountRepository;

    // == constructors ==
    @Autowired
    private AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // == methods ==
    public AccountDto addAccount(AccountOnly accountOnly) {
        // Create objects
        Account account = new Account(
                accountOnly.getUsername(),
                accountOnly.getFirstName(),
                accountOnly.getLastName(),
                accountOnly.getEmail(),
                accountOnly.getPassword()
        );

        return convertToDto(accountRepository.save(account));
    }

    public AccountDto updateAccount(int id, AccountOnly accountOnly) {
        Account account = accountRepository.findById(id).get();
        Account newAccount = new Account(
                accountOnly.getUsername(),
                accountOnly.getFirstName(),
                accountOnly.getLastName(), accountOnly.getEmail(), accountOnly.getPassword());

        return convertToDto(accountRepository.save(account.update(newAccount)));
    }

    public Iterable<AccountDto> getAllAccounts() {
        // This returns a JSON or XML
        return convertToDto(accountRepository.findAll());
    }

    public AccountDto getAccount(int id) {
        return convertToDto(accountRepository.findById(id).get());
    }

    public DeleteResponseMessage deleteAccount(int id) {
        Account account = new Account();
        account.setId(id);
        accountRepository.delete(account); // Delete an account from the DB

        return new DeleteResponseMessage(""+id, "account",true);
    }

    // == utils ==
    private Set<AccountDto> convertToDto(Iterable<Account> accounts) {
        Set<AccountDto> accountDto = new HashSet<>();

        accounts.forEach(account -> accountDto.add(convertToDto(account)));

        return accountDto;
    }

    private AccountDto convertToDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getUsername(),
                account.getFirstName(),
                account.getLastName(),
                account.getEmail()
        );
    }
}
