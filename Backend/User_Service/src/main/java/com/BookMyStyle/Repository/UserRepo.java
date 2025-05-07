package com.BookMyStyle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookMyStyle.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
