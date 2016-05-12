package by.it.servlets;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        if (null == session)
            resp.sendRedirect("login.jsp");
        else
            if (true == (boolean)session.getAttribute("UserIn"))
                filterChain.doFilter(req, resp);
            else
                resp.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {

    }
}
