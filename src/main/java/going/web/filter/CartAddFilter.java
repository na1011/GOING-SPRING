package going.web.filter;

import going.domain.ConstField;
import jakarta.servlet.*;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/item/cart/add")
public class CartAddFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        try {
            HttpSession session = httpRequest.getSession(false);
            if (session == null || session.getAttribute(ConstField.LOGIN_MEMBER) == null) {
                response.getWriter().write("비로그인");
                return;
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e;
        }
    }
}
