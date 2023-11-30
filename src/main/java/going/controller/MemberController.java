package going.controller;

import going.common.ConstField;
import going.domain.form.LoginForm;
import going.domain.form.MemberRegisterForm;
import going.domain.member.Member;
import going.domain.member.Role;
import going.config.resolver.Login;
import going.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String viewRegister(@ModelAttribute MemberRegisterForm form) {
        return "member/register";
    }

    @PostMapping("/register")
    public String memberRegister(@Validated @ModelAttribute MemberRegisterForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/register";
        }

        Role role = null;
        switch (form.getRole()) {
            case "customer" :
                role = Role.CUSTOMER;
            case "business":
                role = Role.BUSINESS;
            case "default":
                role = Role.CUSTOMER;
        }

        Member member = new Member(form.getEmail(), form.getPassword(), role);
        service.memberRegister(member);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String viewLogin(@Login Member loginMember) {
        if (loginMember != null) {
            return "redirect:/";
        }
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request, Model model) {
        Member loginMember = service.login(form.getEmail(), form.getPassword());

        if (loginMember == null) {
            model.addAttribute("msg", "아이디 또는 비밀번호 오류입니다.");
            model.addAttribute("url", "/member/login?addr=" + form.getAddr());
            return "alert";
        }

        HttpSession session = request.getSession();
        session.setAttribute(ConstField.LOGIN_MEMBER, loginMember);
        return form.getAddr() != null ? "redirect:" + form.getAddr() : "redirect:/";
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