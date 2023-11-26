package going.web.controller;

import going.domain.ConstField;
import going.domain.member.MemberVO;
import going.domain.member.Role;
import going.web.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member/*")
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
        return "member/register";
    }

    @PostMapping("/register")
    public String memberRegister(@RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("role") String role_tmp) {
        Role role = null;
        switch (role_tmp) {
            case "customer" :
                role = Role.CUSTOMER;
            case "business":
                role = Role.BUSINESS;
            case "default":
                role = Role.CUSTOMER;
        }

        MemberVO member = new MemberVO(email, password, role);
        service.memberRegister(member);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String viewLogin(@SessionAttribute(name = ConstField.LOGIN_MEMBER, required = false) MemberVO loginMember) {
        if (loginMember != null) {
            return "redirect:/";
        }
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam(name = "addr", defaultValue = "/") String addr, HttpServletRequest request, Model model) {
        MemberVO loginMember = service.login(email, password);

        if (loginMember == null) {
            model.addAttribute("msg", "아이디 또는 비밀번호 오류입니다.");
            model.addAttribute("url", "/member/login?addr=" + addr);
            return "alert";
        }

        HttpSession session = request.getSession();
        session.setAttribute(ConstField.LOGIN_MEMBER, loginMember);
        return "redirect:" + addr;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}
