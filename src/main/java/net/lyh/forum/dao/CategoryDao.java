package net.lyh.forum.dao;

import net.lyh.forum.domain.Category;
import net.lyh.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    public Category findById(int id) {
        String sql = "select * from category where id=?";
        Category category = null;
        try {
            category = queryRunner.query(sql, new BeanHandler<>(Category.class, processor), id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    public List<Category> list() {
        String sql = "select * from category order by weight desc";
        List<Category> list = null;
        try {
            list  = queryRunner.query(sql, new BeanListHandler<>(Category.class, processor));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
