package mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import mall.domain.SubCategory;
import mall.model.category.SubCategoryService;

@Slf4j
@Controller
public class SubCategoryController {
	@Autowired private SubCategoryService subCategoryService;
	
	@GetMapping("/admin/subcategory/list")
	@ResponseBody 
	public List<SubCategory> selectAll(@RequestParam("topcategory_id") int topcategory_id) {
		log.debug("@@@@@@@@@@@@@ top " + topcategory_id);
		List subList = subCategoryService.selectByTopCategoryId(topcategory_id);
		
		log.debug("@@@@@@@@@@@@@ subList " + subList);
		return subCategoryService.selectByTopCategoryId(topcategory_id);
	}
}
