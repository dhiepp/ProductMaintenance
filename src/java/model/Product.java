package model;

public class Product {
    private String code;
    private String description;
    private float price = -1;

    public Product(String code, String description, float price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Product() {}
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
}
