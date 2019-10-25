/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductIO;

/**
 *
 * @author Hiep
 */
public class UpdateProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/products.txt");
        
        String url = "/displayProducts";
        String productCode = request.getParameter("productCode");
        if (productCode != null) {
            Product product = ProductIO.get(productCode, path);
            if (product != null) {
                request.setAttribute("product", product);
                url = "/update_product.jsp";
            }
        }
        
        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/products.txt");
        
        String[] message = new String[3];
        String url = "";
        boolean filled = true;
          
        //Get product info
        String oldProductCode = request.getParameter("oldProductCode");
        String code = request.getParameter("code");
        String desc = request.getParameter("desc");
        String priceString = request.getParameter("price");
        
        //Check empty fields
        if (code.isEmpty()) {
            message[0] = "You must enter a code for the product.";
            filled = false;
        }
        if (desc.isEmpty()) {
            message[1] = "You must enter a description for the product.";
            filled = false;
        }
               
        //Check price number
        float price = -1;
        try {
            price = Float.parseFloat(priceString);
            if (price < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            message[2] = "You must enter a valid price number for the price.";
            filled = false;
        }
        
        //Create product object
        Product product = new Product(code, desc, price);
        
        if (filled) {
            //Update product to file
            ProductIO.update(oldProductCode, product, path);
            
            url = "/displayProducts";
        }
        else {
            request.setAttribute("oldProductCode", oldProductCode);
            request.setAttribute("product", product);
            request.setAttribute("message", message);
            url = "/update_product.jsp";
        }

        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
