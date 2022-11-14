package poly.store.controller;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import poly.store.entity.Product;
import poly.store.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	

 @RequestMapping("product/list")
	public String list(Model model ,@RequestParam("cid") Optional<String> cid) {
	 if (cid.isPresent()) {
		  List<Product> list = productService.findByCategoryId(cid.get());
		  model.addAttribute("items",list);
		
	}else {
	 List<Product> list =  productService.findAll();
	 model.addAttribute("items",list);
	}
	 return "product/list";
 }
 
 @RequestMapping("product/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
    Product item = productService.findByid(id);
	model.addAttribute("item",item);
	 return "product/detail";
 }

 @GetMapping("paginate")
 public String paginate(ModelMap model,@RequestParam Optional<String> message,
		 @PageableDefault(size=5,sort="name", direction = Direction.ASC) Pageable pageable) {
	  Page<Product> pages = productService.findAll(pageable);
	  if(message.isPresent()) {
		  model.addAttribute("message",message.get());
	  }
	  model.addAttribute("pages",pages);
	  return "product/listPaginate";
 }
}
