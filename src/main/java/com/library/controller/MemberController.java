package com.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.model.Book;
import com.library.model.Member;
import com.library.service.MemberService;

public class MemberController {
	


	@Autowired
	private MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@GetMapping()
	public List<Member> getMembers() {
		logger.info(" Listing all the available Members in library {} -- getMembers() method -- MemberController");
		return memberService.getMembers();
	}
	
	@PostMapping()
	public Member addMember(@RequestBody Member Member) {
		return memberService.addMemberInLibrary(Member);
	}
	
	@GetMapping("/Members/details/{id}")
	public Member getMember(@RequestParam Long id) {
		
		return memberService.getMember(id).get();
	}
	
	@PutMapping("/Members/update/{id}")
	public Member updateMember(@RequestParam Long id, @RequestBody Member Member) {
		return memberService.updateMember(id, Member);
	}
	
	@DeleteMapping("/Members/delete/{id}")
	public String deleteMember(@RequestParam Long id) {
		return memberService.deleteMember(id);
	}
	
	@GetMapping("/books/search/{searchKeyWord")
	public List<Member> searchBook(@RequestParam String searchMember) {
		return memberService.searchBook(searchMember);
	}

}
