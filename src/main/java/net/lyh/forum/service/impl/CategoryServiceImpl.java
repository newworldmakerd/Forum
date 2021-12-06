package net.lyh.forum.service.impl;

import net.lyh.forum.dao.CategoryDao;
import net.lyh.forum.domain.Category;
import net.lyh.forum.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao=new CategoryDao();
    @Override
    public List<Category> list() {
        return categoryDao.list();
    }
}
