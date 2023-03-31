package com.ktds.ggtest.service;

import com.ktds.ggtest.domain.Member;
import com.ktds.ggtest.domain.Notice;
import com.ktds.ggtest.repository.MemberRepository;
import com.ktds.ggtest.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void createNotice(Integer id, String title, String content,
                               String author, LocalDateTime createDate) {
        Notice notice = new Notice();
        Member member = new Member();

        notice.setId(id);
        notice.setTitle(title);
        notice.setContent(content);
        notice.setAuthor(author);
        notice.setCreateDate(createDate.now());
//        notice.setMember(member);

        Member mem1 = new Member();
        mem1.setId(1);
        mem1.setName("홍길동");
        mem1.setMemberId("hong");
        mem1.setPassword("1234");

        // member_id가 null이 아닌 값이 들어가려면, Member 객체를 생성하여 id를 설정한 후, Notice 객체의 member 속성으로 설정해야 합니다.
        Member memberpk = memberRepository.findById(mem1.getId()).orElseThrow(() -> new RuntimeException("Member not found"));
        notice.setMember_pk(memberpk);

        noticeRepository.save(notice);
    }
}
