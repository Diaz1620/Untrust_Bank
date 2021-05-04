package com.yadiel.untrust_bank.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yadiel.untrust_bank.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
