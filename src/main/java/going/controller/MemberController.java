package going.controller;

import going.common.ConstField;
import going.model.member.MemberLoginDto;
import going.model.member.MemberResponseDto;
import going.model.member.MemberSaveDto;
import going.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String viewLogin() {


       /* if (loginMember != null) {
            return "redirect:/";
        }*/
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberLoginDto params, BindingResult bindingResult, HttpServletRequest request, Model model) {

        MemberResponseDto loginMember = memberService.login(params);

        if (loginMember == null) {
            model.addAttribute("msg", "아이디 또는 비밀번호 오류입니다.");
            model.addAttribute("url", "/member/login");
            return "alert";
        }

        HttpSession session = request.getSession();
        session.setAttribute(ConstField.LOGIN_MEMBER, loginMember);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String viewRegister(@ModelAttribute MemberSaveDto params) {
        return "member/register";
    }

    @PostMapping("/register")
    public String memberRegister(@ModelAttribute MemberSaveDto params) {

        String userName = memberService.saveMember(params);

        return "redirect:/member/login";
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
