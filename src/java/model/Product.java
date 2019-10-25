/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/*
* Doan Hong Hiep - B16DCPT049 - Nhom 6
*/
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
