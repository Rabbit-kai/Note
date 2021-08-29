package appdesign1.controller;

import appdesign1.action.SaveProductAction;
import appdesign1.form.ProductForm;
import appdesign1.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/*
请求路径为/input-product和/save-product时会匹配到该Servlet
将域名设为action请求，则可以实现通过网页的域名直接跳转首页，只有Servlet可以实现，Filter做不到
* */
@WebServlet(name = "ControllerServlet",urlPatterns = {"/input-product","/save-product","/index"})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1579L;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String uri = request.getRequestURI();
        /* 该四个都是查找字符中的
        * indexOf(num)
        * indexOf(num1,num2)  从num2的位置开始正序查找
        * lastIndexOf(num)
        * lastIndexOf(num1,num2) 从num2的位置开始倒叙查找
        * */
        int lastindex = uri.lastIndexOf("/");
        String action = uri.substring(lastindex + 1);  /*获取请求url中的action*/
        String dispatchUrl = null;

        if ("input-product".equals(action)){
            dispatchUrl = "/jsp/ProductForm.jsp";
        }else if ("save-product".equals(action)){
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            Product product = new Product();
            product.setDescription(productForm.getDescription());
            product.setName(productForm.getName());

            try {
                product.setPrice( new BigDecimal(productForm.getPrice()));
            }catch (NumberFormatException e){

            }

            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);

            request.setAttribute("product",product);
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }else if ("index".equals(action)){
            dispatchUrl = "/jsp/ProductForm.jsp";
        }

        if (dispatchUrl != null){
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request,response);
        }


    }
}
