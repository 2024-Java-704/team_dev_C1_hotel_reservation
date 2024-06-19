package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;
import com.example.demo.model.AdminAccount;

@Aspect
@Component
public class CheckLoginAspect {

	@Autowired
	Account account;

	@Autowired
	AdminAccount adminAccount;

	@Around("execution(* com.example.demo.controller.AccountController.menuUser*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.editUser*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.detailBook*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.logBook*(..)) ||"
			+ "execution(* com.example.demo.controller.BookController.createBook*(..)) ||"
			+ "execution(* com.example.demo.controller.BookController.confirmBook*(..)) ||"
			+ "execution(* com.example.demo.controller.BookController.finishBook*(..)) ||"
			+ "execution(* com.example.demo.controller.AccountController.viewHistory*(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {

		if (account == null || account.getId() == null) {
			System.err.println("Not Login");
			return "redirect:/login";
		}

		return jp.proceed();
	}

	@Around("execution(* com.example.demo.controller.AdminAccountController.AdminTop*(..)) ||"
			+ "execution(* com.example.demo.controller.AdminAccountController.AdminIndexUser*(..)) ||"
			+ "execution(* com.example.demo.controller.AdminAccountController.AdminEditUser*(..)) ||"
			+ "execution(* com.example.demo.controller.AdminBookController.*(..)) ||"
			+ "execution(* com.example.demo.controller.AdminInnController.*(..))")
	public Object checkAdminLogin(ProceedingJoinPoint jp) throws Throwable {

		if (adminAccount == null || adminAccount.getName() == null) {
			System.err.println("Not Login");
			return "redirect:/admin/login";
		}

		return jp.proceed();
	}
}