package board.domain.Member.service;

import board.domain.Member.CustomUserDetails;
import board.domain.Member.Member;
import board.domain.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {


    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email)
            .orElseThrow(() -> {
                return new UsernameNotFoundException("존재하지 않는 이메일입니다.");
            });

        return new CustomUserDetails(member);
    }
}
