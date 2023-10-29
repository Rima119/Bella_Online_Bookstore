package rm.DAO;

import java.util.List;


import rm.entity.CategoryDB;

public interface CategoryDAO {
	
	public boolean addCategory(CategoryDB c);
	public List<CategoryDB> getAllCategory();
	public CategoryDB getCategoryByName(String name);
	public boolean UpdateCategory(CategoryDB c);
	public boolean deleteCategory(String name);
	public List<CategoryDB> AllCategories();
}
