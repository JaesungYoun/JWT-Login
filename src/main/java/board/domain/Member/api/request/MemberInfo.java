package board.domain.Member.api.request;


import board.domain.Member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfo {

    private String email;
    private String nickName;
    private String name;
    private int age;


    @Builder
    public MemberInfo(Member member) {
        this.email = member.getEmail();
        this.nickName = member.getNickName();
        this.name = member.getName();
        this.age = member.getAge();
    }

}
