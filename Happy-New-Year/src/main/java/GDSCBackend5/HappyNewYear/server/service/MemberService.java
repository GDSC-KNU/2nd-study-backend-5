package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import GDSCBackend5.HappyNewYear.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateUserId(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateUserId(Member member) {
        List<Member> members = memberRepository.findByUserId(member.getUserId());
        if (!(members.isEmpty())) {
            throw new IllegalStateException("동일한 아이디가 이미 존재합니다.");
        }
    }

    public Member authentication(Member member, String password) {
        if (member.getPassword().equals(password)) {
            return member;
        }
        return null;
    }
}
