/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
public class PapelFilter implements Filter {

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    //private FilterConfig filterConfig = null;

    public PapelFilter() {
    }

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getUserPrincipal() != null) { //If user is already authenticated
            String navigateString = "";
            if (request.isUserInRole("autor")) {
                navigateString = "usuario/autor/area_do_autor.xhtml";
            } else if (request.isUserInRole("orientador")) {
                navigateString = "usuario/orientador/area_do_orientador.xhtml";
            }

                response.sendRedirect(request.getContextPath() + navigateString);
            } else {
                chain.doFilter(servletRequest, servletResponse);
            }
        

    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }

}
