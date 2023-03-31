package com.ktds.ggtest.service;

import com.ktds.ggtest.domain.Member;
import com.ktds.ggtest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpSession httpSession;

    public Optional<Member> getMemberById(Integer id) {
        return memberRepository.findById(id);
    }

    public Member findByMemberId(String memberId){
        return memberRepository.findByMemberId(memberId);
    }



    public boolean login(String memberId, String password) {
        Member member = memberRepository.findByMemberId(memberId);
        if (member != null && member.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    }



//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public void save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
