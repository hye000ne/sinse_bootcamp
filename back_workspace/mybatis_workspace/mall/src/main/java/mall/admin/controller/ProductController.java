package mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Product;
@Slf4j
@Controller
public class ProductController {
	@RequestMapping(value="/admin/product/registform")
	public String registform() {
		return "secure/product/regist";
	}
	
	@PostMapping("admin/product/regist")
	public String regist(Product product) {
		
		
		return "redirect:/admin/admin/product/list";
	}
}
