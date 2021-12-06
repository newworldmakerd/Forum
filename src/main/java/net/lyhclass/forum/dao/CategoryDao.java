package net.lyhclass.forum.dao;

import net.lyhclass.forum.domain.Category;
import net.lyhclass.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner queryRunner=new QueryRunner(DataSourceUtil.getDataSource());
    private BeanProcessor beanProcessor=new BeanProcessor();
    private RowProcessor processor=new BasicRowProcessor(beanProcessor);
    private Category findById(int id){
        String sql="select from category where id=?";
        Category category=null;
        try {
         category  = queryRunner.query(sql,new BeanHandler<>(Category.class,processor),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    public List<Category> list(){
        String sql="select * from category order by weight desc";
        List<Category> list=null;
        try {
            list  = queryRunner.query(sql,new BeanListHandler<>(Category.class,processor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
