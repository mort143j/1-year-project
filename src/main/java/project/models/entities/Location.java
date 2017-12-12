package project.models.entities;

public class Location {
    private int locationID;
    private String bookcase;
    private String shelf;
    private String box;

    public Location(int locationID, String bookcase, String shelf, String box) {
        this.locationID = locationID;
        this.bookcase = bookcase;
        this.shelf = shelf;
        this.box = box;
    }
    public Location(){

    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getBookcase() {
        return bookcase;
    }

    public void setBookcase(String bookcase) {
        this.bookcase = bookcase;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", bookcase='" + bookcase + '\'' +
                ", shelf='" + shelf + '\'' +
                ", box='" + box + '\'' +
                '}';
    }
}
