package uz.pdp.service;

import uz.pdp.model.Category;
import uz.pdp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements BaseService {
    static List<Product> products = new ArrayList<>();

    public boolean add(Product product){

        for (Product product1 : products) {
            if (product1 != null) {
                if (product1.getName().equals(product.getName())) {
                    return false;
                }
            }
        }

        for (Category category : CategoryServie.categories) {
            if (category != null) {
                if (category.getId() == product.getCategoryId() && getById(product.getCategoryId()) == null) {
                        products.add(product);
                    System.out.println(" Product added successful ");
                    return true;
                }
            }
        }
        System.out.println(" Product Added Unsuccessful ");
        return false;
    }

    @Override
    public boolean delete(int productId) {
        for (Product product : products) {
            if (product != null) {
                if (product.getId() == productId) {
                    products.remove(product);
                    System.out.println(" Product Deleted Successful ");
                    return true;
                }
            }
        }
        System.out.println(" Product Deleted Unsuccessful ");
        return false;
    }

    @Override
    public Object getById(int productId) {
        for (Product product : products) {
            if (product != null) {
                if (product.getId() == productId) {
                        return product;
                }
            }
        }
        System.out.println(" This product is not found ");
        return null;
    }

    public void showList(){
        for (Product product : products) {
            if (product!=null){
                System.out.println(product);
            }
        }
    }
}
