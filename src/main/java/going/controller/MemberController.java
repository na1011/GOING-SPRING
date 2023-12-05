package going.controller;

import going.common.ConstField;
import going.common.resolver.Login;
import going.model.dto.common.MessageDto;
import going.model.dto.member.MemberLoginDto;
import going.model.dto.member.MemberResponseDto;
import going.model.dto.member.MemberSaveDto;
import going.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String viewLogin(@Login MemberResponseDto loginMember) {
        if (loginMember != null) {
            return "redirect:/";
        }
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberLoginDto params, HttpServletRequest request, Model model) {

        MemberResponseDto loginMember = memberService.login(params);

        if (loginMember == null) {
            MessageDto message = new MessageDto("아이디 또는 비밀번호 오류입니다.", "/member/login?" + params.getAddr());
            model.addAttribute("message", message);
            return "alert";
        }

        HttpSession session = request.getSession();
        session.setAttribute(ConstField.LOGIN_MEMBER, loginMember);
        session.setMaxInactiveInterval(60 * 30);    // 30분

        return params.getAddr() == null ? "redirect:/" : "redirect:" + params.getAddr();
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("MemberSaveDto", new MemberSaveDto());
        return "member/register";
    }

    @PostMapping("/register")
    public String memberRegister(@ModelAttribute MemberSaveDto params) {
        String userName = memberService.saveMember(params);
        return "redirect:/member/login";
    }

    @ResponseBody
    @GetMapping("/validation")
    public int validateEamil(@RequestParam("email") String email) {
        return memberService.validateEmail(email);
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
