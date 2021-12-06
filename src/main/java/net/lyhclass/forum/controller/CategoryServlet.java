package net.lyhclass.forum.controller;

import net.lyhclass.forum.dao.CategoryDao;
import net.lyhclass.forum.domain.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "categoryServlet",urlPatterns = {"/categoryServlet"})
public class CategoryServlet extends BaseServlet{
    private CategoryDao categoryDao=new CategoryDao();
    /**
     * 返回全部分类
     */
    public void list(HttpServletRequest req, HttpServletResponse resp){
        List<Category> list = categoryDao.list();
        System.out.println(list.toString());
        req.setAttribute("categoryList",list );
    }
}
