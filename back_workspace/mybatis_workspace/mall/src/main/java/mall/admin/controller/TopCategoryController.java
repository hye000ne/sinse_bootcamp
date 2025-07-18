package mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mall.domain.TopCategory;
import mall.model.category.TopCategoryService;

@Controller
public class TopCategoryController {
	@Autowired private TopCategoryService topCategoryService;
	
	
	@GetMapping("/admin/topcategory/list")
	@ResponseBody //응답 데이터 형식이 html 문서가 아닌, json 등의 순수 데이터일 경우
				// view resolver인 internalresourceViewResolver가 동작하지 않음
				// 접두어, 점미어 조합을 시도하지 않음. 즉 response.setContentType("application/json")과 동일
	public List<TopCategory> selectAll(Model model) {
		return topCategoryService.selectAll();
	}
}
