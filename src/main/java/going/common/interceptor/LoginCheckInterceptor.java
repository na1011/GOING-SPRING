package going.common.interceptor;

import going.common.ConstField;
import going.model.dto.common.MessageDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute(ConstField.LOGIN_MEMBER) == null) {
            MessageDto message = new MessageDto("로그인이 필요한 페이지입니다.", "/member/login?" + requestURI);
            request.setAttribute("message", message);
            request.getRequestDispatcher(ConstField.ALERT_PAGE).forward(request, response);
            return false;
        }
        return true;
    }
}
