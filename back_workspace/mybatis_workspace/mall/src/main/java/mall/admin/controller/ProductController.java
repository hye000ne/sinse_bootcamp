package mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class ProductController {
	@RequestMapping(value="/admin/product/registform")
	public String registform() {
		return "secure/product/regist";
	}
}
