package com.yadiel.untrust_bank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yadiel.untrust_bank.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
