package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductIO {
    public static ArrayList<Product> getAll(String path) throws IOException {
        ArrayList<Product> products = new ArrayList<Product>();
        
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        
        String line;
        while ((line = in.readLine()) != null) {
            String[] data = line.split("\\|");
            String code = data[0];
            String name = data[1];
            String desc = data[2];
            int weight = Integer.parseInt(data[3]);
            float price = Float.parseFloat(data[4]);
            Product pro = new Product(code, name, desc, weight, price);
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
            String data[] = line.split("\\|");
            if (data[0].equals(productCode)) {
                String code = data[0];
                String name = data[1];
                String desc = data[2];
                int weight = Integer.parseInt(data[3]);
                float price = Float.parseFloat(data[4]);
                Product product = new Product(code, name, desc, weight, price);
                
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
        
        String data = product.getCode() + "|" + product.getName() + "|" + product.getDescription() + "|"
                + product.getWeight() + "|"+ product.getPrice();
        out.println(data);
        
        out.close();
    }
        
    public static void update (Product product, String path) throws IOException {
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        ArrayList<String> fileContent = new ArrayList<>();
        
        String line;
        while((line = in.readLine()) != null) {
            String data[] = line.split("\\|");
            if (data[0].equals(product.getCode())) {
                String newData = product.getCode() + "|" + product.getName() + "|" + product.getDescription() + "|"
                        + product.getWeight() + "|"+ product.getPrice();
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
            String data[] = line.split("\\|");
            if (!data[0].equals(productCode)) {
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
