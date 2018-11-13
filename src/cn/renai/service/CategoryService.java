package cn.renai.service;

import cn.renai.pojo.Category;
import cn.renai.pojo.Datainfo;

import java.util.List;

public interface CategoryService {
    public void addCategory(Category category);
    public List queryAll();
    public void deleteCategory(String category_id);
    public Category QueryByCid(String cid);

    public List queryByModular_id(String mid);

    public void updateCategory(Category category);
}
