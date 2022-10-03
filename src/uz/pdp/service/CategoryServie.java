package uz.pdp.service;

import uz.pdp.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServie implements BaseService{

    static List<Category> categories = new ArrayList<>();


    public boolean add(Category category){
        for (Category category1 : categories) {
            if(category != null){
                if (category1.getName().equals(category.getName())) {
                    System.out.println(" This user has in baza ");
                    return false;
                }
            }
        }
        System.out.println(" Added successful ");
        categories.add(category);
        return true;
    }


    @Override
    public boolean delete(int id) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getId() == id) {
                    System.out.println(" Deleted successful");
                    categories.remove(category);
                    return true;
                }
            }
        }
        System.out.println(" Deleted Unsuccessful");
        return false;
    }

    @Override
    public Object getById(int id) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getId() == id) {
                    return category;
                }
            }
        }
        System.out.println(" Category Not Founded ");
        return null;
    }

    public void showParentCategories(){
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == 0) {
                    System.out.println(category);
                }
            }
        }
    }

    public void showAllCategories(){
        for (Category category : categories){
            if (category!=null)
                System.out.println(category);
        }
    }

    public void showSubCategories(int parentId){
        for (Category category:categories) {
            if (category!=null){
                if (category.getParentId()==parentId){
                    System.out.println(category);
                }
            }
        }
    }
}
