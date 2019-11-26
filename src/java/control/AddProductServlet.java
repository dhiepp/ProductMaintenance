package control;

import data.ProductDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductIO;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        ServletContext context = getServletContext();

        String url = "/add_product.jsp";
        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/products.txt");
        
        String[] messages = new String[5];
        String url = "";
        boolean filled = true;
          
        //Get product info
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String weightString = request.getParameter("weight");
        String priceString = request.getParameter("price");
        
        //Check empty fields
        if (code.isEmpty()) {
            messages[0] = "You must enter a code for the product.";
            filled = false;
        }
        if (name.isEmpty()) {
            messages[1] = "You must enter a description for the product.";
            filled = false;
        }
        if (desc.isEmpty()) {
            messages[2] = "You must enter a description for the product.";
            filled = false;
        }
        
        //Check weight number
        int weight = -1;
        try {
            weight = Integer.parseInt(weightString);
            if (weight < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            messages[3] = "You must enter a valid weight number.";
            filled = false;
        }  
        //Check price number
        float price = -1;
        try {
            price = Float.parseFloat(priceString);
            if (price < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            messages[4] = "You must enter a valid price number.";
            filled = false;
        }
        
        //Create product object
        Product product = new Product(code, name, desc, weight, price);
        
        if (filled) {
            //Add product to DB
            ProductDB.insertProduct(product);
            
            url = "/displayProducts";
        }
        else {
            request.setAttribute("product", product);
            request.setAttribute("message", messages);
            url = "/add_product.jsp";
        }

        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
