package poly.store.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import poly.store.entity.Order;
import poly.store.entity.Product;
import poly.store.service.OrderService;
import poly.store.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username =request.getRemoteUser();
	//	model.addAttribute("orders",orderService.findByIdUsername(username));
		model.addAttribute("orders",orderService.findByIdUsername(username));
		return "order/list";
	}

	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id")Long id,Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}
	@GetMapping("/order/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String fileName="order.csv";
		
		String headerKey ="content-Disposition";
		String headerValue ="attachment; filename=" +fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Order> listUsers =orderService.listAll();
		ICsvBeanWriter cswriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
	   String[] csvHeader = {"order ID","CreateDate","Address",""};
	   String[] nameMapping = {"id","CreateDate","Address"};
	   cswriter.writeHeader(csvHeader);
	   
	   for(Order order : listUsers) {
		   cswriter.write(order, nameMapping);
	   }
	cswriter.close();
	}
}
