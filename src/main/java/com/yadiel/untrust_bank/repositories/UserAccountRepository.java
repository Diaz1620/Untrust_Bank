package com.yadiel.untrust_bank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yadiel.untrust_bank.models.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
