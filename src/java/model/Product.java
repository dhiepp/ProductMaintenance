package model;

public class Product {
    private String code;
    private String name;
    private String description;
    private int weight;
    private float price;

    public Product(String code, String name, String description, int weight, float price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

    public Product() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
