package going.web.filter;

import going.domain.ConstField;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = {"/myPage/*"})
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();

        try {
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute(ConstField.LOGIN_MEMBER) == null) {
                request.setAttribute("msg", "로그인이 필요한 페이지 입니다.");
                request.setAttribute("url", "/member/login?addr=" + requestURI);
                request.getRequestDispatcher(ConstField.ALERT_PAGE).forward(request, response);
                return;
            }
            chain.doFilter(request, response);

        } catch (Exception e) {
            throw e;
        }
    }

}
