package net.enterComputer.site.service;

import net.enterComputer.site.model.RegisterAccount;
import net.enterComputer.site.repositroy.RegisterAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    RegisterAccountRepository repository;

    @Override
    public void saveNewAccount(RegisterAccount account) {
        this.repository.save(account);
    }
}
