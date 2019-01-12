package com.wildcodeschool.wizards.springHibernatewizards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.wizards.springHibernatewizards.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}