/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
* Doan Hong Hiep - B16DCPT049 - Nhom 6
*/
public class ProductIO {
    public static ArrayList<Product> read(String path) throws IOException {
        ArrayList<Product> products = new ArrayList<Product>();
        
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            String[] data = line.split("\\|");
            String code = data[0];
            String desc = data[1];
            float price = Float.parseFloat(data[2]);
            Product pro = new Product(code, desc, price);
            products.add(pro);
        }
        
        in.close();
        return products;
    } 
    
    public static Product get(String productCode, String path) throws IOException {
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        
        String line;
        while((line = in.readLine()) != null) {
            String productData[] = line.split("\\|");
            if (productData[0].equalsIgnoreCase(productCode)) {
                String code = productData[0];
                String desc = productData[1];
                float price = Float.parseFloat(productData[2]);
                Product product = new Product(code, desc, price);
                
                in.close();
                return product;
            }
        }
        
        in.close();
        return null;
    }
    
    public static void add(Product product, String path) throws IOException {
        File file = new File(path);
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        
        String data = product.getCode() + "|" + product.getDescription() + "|" + product.getPrice();
        out.println(data);
        
        out.close();
    }
        
    public static void update (String oldProductCode, Product product, String path) throws IOException {
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        ArrayList<String> fileContent = new ArrayList<>();
        
        String line;
        while((line = in.readLine()) != null) {
            String productData[] = line.split("\\|");
            if (productData[0].equalsIgnoreCase(oldProductCode)) {
                String newData = product.getCode() + "|" + product.getDescription() + "|" + product.getPrice();
                fileContent.add(newData);
            }
            else {
                fileContent.add(line);
            }
        }
        in.close();
        
        PrintWriter out = new PrintWriter(new FileWriter(file, false));
        for (String productData : fileContent) {
            out.println(productData);
        }
        out.close();
    }
    
    public static void delete(String productCode, String path) throws IOException {
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        ArrayList<String> fileContent = new ArrayList<>();
        
        String line;
        while((line = in.readLine()) != null) {
            String productData[] = line.split("\\|");
            if (!productData[0].equalsIgnoreCase(productCode)) {
                fileContent.add(line);
            }
        }
        in.close();
        
        PrintWriter out = new PrintWriter(new FileWriter(file, false));
        for (String productData : fileContent) {
            out.println(productData);
        }
        out.close();
    }

}