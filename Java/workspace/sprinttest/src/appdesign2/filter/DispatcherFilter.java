package appdesign2.filter;

import appdesign2.action.SaveProductAction;
import appdesign2.form.ProductForm;
import appdesign2.model.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;

@WebFilter(filterName = "DispatcherFilter",urlPatterns = "/*")
public class DispatcherFilter implements Filter {
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {

    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest reqs = (HttpServletRequest) req;
        String uri = reqs.getRequestURI();
        int lastindex = uri.lastIndexOf("/");
        String action = uri.substring(lastindex + 1);  /*获取请求url中的action*/
        String dispatchUrl = null;

        if ("input-product".equals(action)){
            dispatchUrl = "/jsp/ProductForm.jsp";
        }else if ("save-product".equals(action)){
            ProductForm productForm = new ProductForm();
            productForm.setName(req.getParameter("name"));
            productForm.setDescription(req.getParameter("description"));
            productForm.setPrice(req.getParameter("price"));

            Product product = new Product();
            product.setDescription(productForm.getDescription());
            product.setName(productForm.getName());

            try {
                product.setPrice( new BigDecimal(productForm.getPrice()));
            }catch (NumberFormatException e){

            }

            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);

            req.setAttribute("product",product);
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }else if ("index".equals(action)){
            dispatchUrl = "/jsp/ProductForm.jsp";
        }

        if (dispatchUrl != null){
            RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
            rd.forward(req,resp);
        }else {
            chain.doFilter(req, resp);
        }



    }



}
