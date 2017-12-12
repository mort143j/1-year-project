package project.models.entities;

public class Product {
    private int productID;
    private String name;
    private float costPrice;
    private float salesPrice;
    private int productNumber;

    public Product(int productID, String name, float costPrice, float salesPrice, int productNumber) {
        this.productID = productID;
        this.name = name;
        this.costPrice = costPrice;
        this.salesPrice = salesPrice;
        this.productNumber = productNumber;
    }
    public Product(){
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", costPrice=" + costPrice +
                ", salesPrice=" + salesPrice +
                ", productNumber=" + productNumber +
                '}';
    }
}