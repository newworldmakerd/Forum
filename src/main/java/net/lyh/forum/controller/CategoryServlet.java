package net.lyh.forum.controller;

import net.lyh.forum.domain.Category;
import net.lyh.forum.service.CategoryService;
import net.lyh.forum.service.impl.CategoryServiceImpl;
import net.lyh.forum.util.DataSourceUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "categoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService=new CategoryServiceImpl();
    public void list(HttpServletRequest req, HttpServletResponse resp){
        List<Category> list = categoryService.list();
        System.out.println(list.toString());
    }
}
