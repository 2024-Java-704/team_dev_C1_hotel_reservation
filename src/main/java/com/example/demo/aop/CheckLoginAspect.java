package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Aspect
@Component
public class CheckLoginAspect {

	@Autowired
	Account account;

	@Around("execution(* com.example.demo.controller.AccountController.menuUser*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.editUser*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.detailBook*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.logBook*(..)) ||"
			+ "execution(* com.example.demo.controller.BookController.createBook*(..)) ||"
			+ "execution(* com.example.demo.controller.BookController.confirmBook*(..)) ||"
			+ "execution(* com.example.demo.controller.BookController.finishBook*(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {

		if (account == null || account.getId() == null || account.getId() == null) {
			System.err.println("Not Login");
			// リダイレクト先を指定する
			// パラメータを渡すことでログインControllerで
			// 個別のメッセージをThymeleafに渡すことも可能
			return "redirect:/";
		}
		// Controller内のメソッドの実行
		return jp.proceed();
	}
}