package board.domain.Member.controller;


import board.domain.Member.api.request.*;
import board.domain.Member.api.response.MemberLoginResponse;
import board.domain.Member.service.MemberService;
import board.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping("/signUp")
    public void signUp(@RequestBody @Valid MemberSignUpRequest memberSignUpRequest) throws Exception {
        System.out.println("aaa");
        memberService.signUp(memberSignUpRequest);

    }


    /**
     * 회원 로그인
     */

    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest, HttpServletRequest httpServletRequest) throws Exception {


        // 1. 회원 정보 조회 
        MemberLoginResponse loginMember = memberService.login(memberLoginRequest);


        // 2. 세션에 회원 정보 저장 & 세션 유지 시간 설정
        if (loginMember != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginMember",loginMember);
            session.setMaxInactiveInterval(60 * 30);
        }
        return ResponseEntity.ok(loginMember);
    }

    /**
     * 회원 로그아웃
     */
    @PostMapping("/members/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    /**
     * 회원정보 수정
     */
    @PutMapping("members/update")
    public void updateMemberInfo(@RequestBody @Valid UpdateInfoRequest updateInfoRequest) throws Exception {
        memberService.updateMemberInfo(updateInfoRequest, SecurityUtil.getMemberEmail());
    }

    /**
     * 패스워드 변경
     */

    @PutMapping("members/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest) throws Exception {
        memberService.updatePassword(SecurityUtil.getMemberEmail(), updatePasswordRequest.getAsIspassword(), updatePasswordRequest.getToBePassword());

    }

    /**
     * 회원 탈퇴
     */

    @DeleteMapping("members/delete")
    public void delete(@RequestBody @Valid MemberDeleteRequest memberDeleteRequest) throws Exception {
        memberService.deleteMember(memberDeleteRequest.getPassword(),SecurityUtil.getMemberEmail());
    }

    /**
     * 회원 정보 조회
     */

    @GetMapping("members/{id}")
    public ResponseEntity<MemberInfo> getMemberInfo(@Valid String email) throws Exception{
        MemberInfo memberInfo = memberService.getmemberInfo(email);
        return ResponseEntity.ok(memberInfo);
    }

    /**
     * 유저가 자신의 정보 조회
     */

    @GetMapping("/members")
    public ResponseEntity<MemberInfo> getMyInfo() throws Exception {
        MemberInfo memberInfo = memberService.getMyinfo();
        return ResponseEntity.ok(memberInfo);
    }



}
