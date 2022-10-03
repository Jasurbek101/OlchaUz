package uz.pdp.model;

public class Product extends Base{
    private double price;
    private int count;
    private int categoryId;

    public Product() {
    }

    public Product(double price, int count, int categoryId) {
        this.price = price;
        this.count = count;
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", categoryId=" + categoryId +
                '}';
    }
}
