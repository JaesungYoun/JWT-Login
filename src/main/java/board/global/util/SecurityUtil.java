package board.global.util;

import board.domain.Member.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static String getMemberEmail() {
        CustomUserDetails member = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return member.getEmail();
    }

}
