package com.codewithjasitha.bumblebee.project.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithjasitha.bumblebee.project.dao.CategoryDao;
import com.codewithjasitha.bumblebee.project.model.Category;

public class CategoryService {
	
		private  static  CategoryService categoryServiceobj;
			
			public CategoryService() {
				
			}
			
			public static synchronized CategoryService getCategoryServiceInstance() {
				if(categoryServiceobj == null) {
					categoryServiceobj = new CategoryService();
					
				}
				
				return categoryServiceobj;
			}
			
			private CategoryDao getCategoryDao() {
				return new CategoryDao();
			}
			
			
			//category services
			
			public boolean registerCategory(Category category) throws ClassNotFoundException, SQLException {
				
				return getCategoryDao().addCategory(category);
			}
			
			public Category getSpecificCategory(int categoryCode) throws ClassNotFoundException, SQLException {
				return getCategoryDao().getSpecificCategory(categoryCode);
			}
			
			public List<Category> getallcategory() throws ClassNotFoundException, SQLException{
				return getCategoryDao().getAllCategory();
			}
			
			public boolean editCategory(Category category) throws ClassNotFoundException, SQLException {
				return getCategoryDao().updateCategory(category);
			}
			
			public boolean deleteCategory(int categoryCode) throws ClassNotFoundException, SQLException {
				return getCategoryDao().deleteCategory(categoryCode);
			}
			
			
			
			
		
}

