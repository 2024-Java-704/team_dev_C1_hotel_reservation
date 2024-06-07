package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

//user.javaが空の状態で実行してエラー発生
public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findByEmailAndPassword(String email, String password);
	List<User> findByEmail(String email);
	List<User> findByIdByOrderByasc(Integer id);
}
