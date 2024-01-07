package board.domain.Member.api.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * 회원정보 수정 요청 Dto
 */

@Getter
public class UpdateInfoRequest {

    @NotBlank
    private String email;

    private String nickname;

    private String name;

    private int age;
}
