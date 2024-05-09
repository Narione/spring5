package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service("memberRegisterService")
public class MemberRegisterService {
    @Autowired
    private final MemberDao memberDao;

    // 필드를 파라미터로 갖는 생성자를 선언하기만 하면
    // 자동으로 스프링 빈을 주입해준다.
    public MemberRegisterService(MemberDao memberDao){
        this.memberDao= memberDao;
    }
    public Long regist(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member!=null){
            throw new DuplicateMemberException("dup email"+req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()
        );
        memberDao.insert(newMember);
        return newMember.getId();
    }




}
