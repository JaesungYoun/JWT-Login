package board.domain.Member.api.response;

import board.domain.Member.Member;
import lombok.Getter;

@Getter
public class MemberLoginResponse {

    private String email;
    private String password;
    private String nickName;
    private String name;
    private int age;

    public MemberLoginResponse(Member member) {
        this.email = member.getEmail();
        this.nickName = member.getNickName();
        this.name = member.getName();
        this.age = member.getAge();
    }

}
