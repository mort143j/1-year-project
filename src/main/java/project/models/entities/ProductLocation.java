package project.models.entities;

public class ProductLocation {
    private int pLocationID;
    private int stock;
    private int locationFK;
    private int productFK;

    public ProductLocation(int pLocationID, int stock, int locationFK, int productFK) {
        this.pLocationID = pLocationID;
        this.stock = stock;
        this.locationFK = locationFK;
        this.productFK = productFK;
    }
    public ProductLocation(){
    }

    public int getpLocationID() {
        return pLocationID;
    }

    public void setpLocationID(int pLocationID) {
        this.pLocationID = pLocationID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLocationFK() {
        return locationFK;
    }

    public void setLocationFK(int locationFK) {
        this.locationFK = locationFK;
    }

    public int getProductFK() {
        return productFK;
    }

    public void setProductFK(int productFK) {
        this.productFK = productFK;
    }

    @Override
    public String toString() {
        return "ProductLocation{" +
                "pLocationID=" + pLocationID +
                ", stock=" + stock +
                ", locationFK=" + locationFK +
                ", productFK=" + productFK +
                '}';
    }
}
