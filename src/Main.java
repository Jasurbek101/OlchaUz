import uz.pdp.model.Category;
import uz.pdp.model.Product;
import uz.pdp.model.User;
import uz.pdp.service.CategoryServie;
import uz.pdp.service.ProductService;
import uz.pdp.service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerStr1 = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    // Category category = new Category();
    //static Product product = new Product();

    static UserService userService = new UserService();
    static ProductService productService = new ProductService();
    static CategoryServie categoryServie = new CategoryServie();

    public static void main(String[] args){

        int var = 10;
        while (var != 0) {
            System.out.println( "1.Login\n2.Register " );
            var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    System.out.println(" Enter phoneNumber ");
                    String phoneNumber = scannerStr1.nextLine();

                    System.out.println(" Enter pasword ");
                    String pasword = scannerStr1.nextLine();

                    User currentUser =userService.login(phoneNumber,pasword);
                    if (currentUser != null){
                        if(currentUser.getRole().equals("ADMIN")){
                                forAdmin();
                        } else if (currentUser.getRole().equals("USER")) {
                                forUser();
                        }
                        else{
                            System.out.println(" XXX ");
                        }
                    }
                }
                case 2->{
                    User user = new User();

                    System.out.println(" Enter your name ");
                    user.setName(scannerStr.nextLine());

                    System.out.println("Enter phone number ");
                    user.setPhoneNumber(scannerStr.nextLine());

                    System.out.println(" Enter password ");
                    user.setPassword(scannerStr.nextLine());

                    System.out.println(" Choose the role \n 1 . Admin \n 2 . User ");
                    int n = scannerStr.nextInt();
                    if(n == 1){
                        user.setRole("ADMIN");
                        System.out.println(userService.add(user));
                    } else if (n == 2) {
                        user.setRole("USER");
                        System.out.println(userService.add(user));
                    }else{
                        System.out.println(" Bunday menyu yo'q ");
                        break;
                    }


                }
            }
        }
    }

    private static void forUser() {
        int var = 10;
        while (var != 0 ){
            System.out.println("1.Category 2.Product 3.OrderList 0.back");
            var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    categoryForUser();
                }
                case 2->{
                    productForUser();
                }
                case 3->{
                    OrderListForUSer();
                }
            }
        }
    }

    private static void OrderListForUSer() {
    }

    private static void productForUser() {
    }

    private static void categoryForUser() {
        int var = 10;
        while (var != 0){
            System.out.println(" 1. List of categories\n2.Order List ");
            var = scannerInt.nextInt();
            switch (var){
                case 1-> {
                    categoryServie.showParentCategories();
                }
                case 2-> {}
            }
        }

    }

    private static void forAdmin() {
        int var = 10;
        while (var != 0 ){
            System.out.println("1.Category 2.Product 3.OrderList 0.back");
            var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    categoryForAdmin();//++++++
                }
                case 2->{
                    productForAdmin();//+++++++
                }
                case 3->{
                    OrderListForAdmin();
                }
            }
        }
    }

    private static void OrderListForAdmin(){
    }

    private static void productForAdmin() {
        int var = 10;
        while (var != 0){
        System.out.println(" 1. Add product\n2.Delete product\n3.Show list of products ");
            var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    Product product = new Product();

                    System.out.println(" Enter name of Product ");
                    product.setName(scannerStr.nextLine());

                    System.out.println(" Enter price of product ");
                    product.setPrice(scannerInt.nextDouble());

                    System.out.println(" Enter count of Product ");
                    product.setCount(scannerInt.nextInt());

                    categoryServie.showAllCategories();

                    System.out.println(" Enter category id ");
                    product.setCategoryId(scannerInt.nextInt());

                    System.out.println(productService.add(product));
                }
                case 2->{
                    System.out.println(" Enter Produbct's ID ");
                    productService.delete(scannerInt.nextInt());
                }
                case 3->{
                    productService.showList();
                }
            }
        }
    }

    private static void categoryForAdmin() {
        int var = 10;
        while(var != 0){
            System.out.println(" 1. Add category\n2. Delete Category\n3. List Show List Category \n  0 ->EXIT");
            var = scannerInt.nextInt();
            switch (var){
                 case 1->{
                     Category category = new Category();

                     System.out.println(" Enter new category name ");
                     category.setName(new Scanner(System.in).nextLine());

                     System.out.println(" Enter parent id of category ");
                     category.setParentId(scannerInt.nextInt());

                     System.out.println(categoryServie.add(category));
                 }
                 case 2->{
                     System.out.println(" Enter ID of Category ");
                     System.out.println(categoryServie.delete(scannerInt.nextInt()));
                 }
                 case 3->{
                     categoryServie.showParentCategories();
                     int var1 = 10;
                     while (var1 != 0){
                     System.out.println(" Enter category ID ");
                        var1  = scannerInt.nextInt();
                        categoryServie.showSubCategories(var);
                        if(categoryServie.getById(var1) == null){
                            System.out.println(" Sub categories is emplt ");
                        }
                     }
                     return;
                 }
            }
        }
    }

}