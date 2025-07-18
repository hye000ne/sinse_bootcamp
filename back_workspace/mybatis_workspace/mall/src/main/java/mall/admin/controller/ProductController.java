package mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import mall.domain.SubCategory;
import mall.domain.TopCategory;
import mall.model.category.SubCategoryService;
import mall.model.category.TopCategoryService;
@Slf4j
@Controller
public class ProductController {
	@Autowired private TopCategoryService topCategoryService;
	@Autowired private SubCategoryService subCategoryService;

	@RequestMapping(value="/admin/product/registform")
	public String registform(Model model) {
		List<TopCategory> topList = topCategoryService.selectAll();
		List<SubCategory> subList = subCategoryService.selectAll();
		log.debug("topList " + topList);
		log.debug("subList " + subList);
		
		model.addAttribute("topList", topList);
		model.addAttribute("subList", subList);
		
		return "secure/product/regist";
	}
	
}
