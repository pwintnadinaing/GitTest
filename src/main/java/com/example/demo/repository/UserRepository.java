package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM UserEntity u WHERE u.status<>true")
    public List<UserEntity> showAllUsers();

    @Modifying @Transactional
    @Query("UPDATE UserEntity u SET u.status=true WHERE u.id=?1")
    public void deleteUser(Integer id);


    public UserEntity findByEmail(String email);
}
