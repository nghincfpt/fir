package poly.store.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.service.OrderService;

@Controller
public class OrderADMINController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/orderADMIN/checkout")
	public String checkout() {
		return "orderADMIN/checkout";
	}
	@RequestMapping("/orderADMIN/list")
	public String list(Model model,HttpServletRequest request) {
		String username =request.getRemoteUser();
	//	model.addAttribute("orders",orderService.findByIdUsername(username));
		model.addAttribute("orders",orderService.findAllUsername(username));
		return "orderADMIN/list";
	}

	@RequestMapping("/orderADMIN/detail/{id}")
	public String detail(@PathVariable("id")Long id,Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "orderADMIN/detail";
	}
}

