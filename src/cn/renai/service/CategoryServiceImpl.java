package cn.renai.service;

import cn.renai.mapper.CategoryMapper;
import cn.renai.pojo.Category;
import cn.renai.pojo.Datainfo;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        category.setCid(WebUtils.generateID().substring(0,10));
        categoryMapper.insert(category);
    }

    @Override
    public List queryAll() {
        List<Category> list = categoryMapper.queryAll();
        if (list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void deleteCategory(String category_id) {
        categoryMapper.deleteByPrimaryKey(category_id);
    }

    @Override
    public Category QueryByCid(String cid) {
        return categoryMapper.selectByPrimaryKey(cid);
    }

    @Override
    public List queryByModular_id(String mid) {
        List<Category> list = categoryMapper.queryByModular_id(mid);
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }
}
