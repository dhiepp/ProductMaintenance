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
        if (name.isEmpty()) {
            messages[1] = "You must enter a name for the product.";
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
            //Update product to file
            ProductIO.update(product, path);
            
            url = "/displayProducts";
        }
        else {
            request.setAttribute("product", product);
            request.setAttribute("message", messages);
            url = "/update_product.jsp";
        }

        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
