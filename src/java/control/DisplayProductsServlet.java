/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductIO;

/*
* Doan Hong Hiep - B16DCPT049 - Nhom 6
*/
public class DisplayProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/products.txt");
        
        ArrayList<Product> products = ProductIO.read(path);
        
        request.setAttribute("products", products);
        String url = "/display_products.jsp";
        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
