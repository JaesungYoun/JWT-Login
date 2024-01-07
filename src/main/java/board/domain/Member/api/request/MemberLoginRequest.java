package board.domain.Member.api.request;


import lombok.Getter;

@Getter // @Data는 객체의 안정성을 보장하기 어렵기 떄문에 @Getter 사용
public class MemberLoginRequest {
    private String email;
    private String password;
}
