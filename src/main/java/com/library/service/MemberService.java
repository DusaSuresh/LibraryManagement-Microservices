package com.library.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.model.Member;
import com.library.repository.MemberRepository;

public class MemberService {
	

	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> getMembers() {
		logger.info(" {} getMembers method calling in MemberService");
		return memberRepository.findAll();
	}

	public Member addMemberInLibrary(Member Member) {
		logger.info(" {} addMemberInLibrary method calling in MemberService", Member);
		return memberRepository.save(Member);
	}

	public Optional<Member> getMember(Long id) {
		logger.info(" {} getMember method calling in MemberService", id);
		return memberRepository.findById(id);
	}

	public Member updateMember(Long id, Member member) {
		logger.info(" {} updateMember method calling in MemberService", id);
		Member memberDetails = memberRepository.findById(id).get();
		memberDetails.setEmail(member.getEmail());
		memberDetails.setMemberShipType(member.getMemberShipType());
		memberDetails.setName(member.getName());
		return memberRepository.save(memberDetails);
	}

	public String deleteMember(Long id) {
		logger.info(" {} deleteMember method calling in MemberService", id);
		memberRepository.deleteById(id);
		return "Member deleted successfully";
	}

	public List<Member> searchBook(String searchMember) {
		// TODO Auto-generated method stub
		return memberRepository.search(searchMember);
	}



}
