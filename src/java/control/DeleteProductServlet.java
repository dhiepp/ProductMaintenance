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
public class DeleteProductServlet extends HttpServlet {
    
    @Override
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
                url = "/delete_product.jsp";
            }
        }
        
        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/products.txt");
        
        String productCode = request.getParameter("productCode");
        
        if (productCode != null) {
            ProductIO.delete(productCode, path);
        }
        
        String url = "/displayProducts";
        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);    
    }

}
