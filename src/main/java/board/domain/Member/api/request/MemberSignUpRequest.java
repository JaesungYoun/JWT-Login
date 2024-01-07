package board.domain.Member.api.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * 화원가입 요청 api(dto)
 */
@Getter
public class MemberSignUpRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    private String name;
    private int age;
}
