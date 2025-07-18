package mall.model.category;

import java.util.List;

import mall.domain.SubCategory;

public interface SubCategoryService {
	public List selectAll();
	public SubCategory select(int subcategory_id);
}
