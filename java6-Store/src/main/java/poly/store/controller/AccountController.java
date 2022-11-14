package poly.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.entity.Account;
import poly.store.service.AccountService;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	
	@RequestMapping("")
	public String list(Model model) {
		
		return "assets/admin/authority/account/listAccount";
	}
}
