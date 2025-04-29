package ksmybatis.admin.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ksmybatis.admin.member.domain.Member;
import ksmybatis.admin.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @RestController : @Controller + @ResponseBody (주소요청과 데이터를 응답(반환)하는 어노테이션)
 */

//@RestController
//@RequestMapping("/admin/member")
@Slf4j
@RequiredArgsConstructor
public class MemberRestController {

	private final MemberMapper memberMapper;
	/**
	 * 쿼리스트링(요청데이터)을 바인딩하는 방법
	 * 1. 쿼리파라미터 name과 매개변수의 이름이 동일하게 선언
	 * 2. @RequestParam 어노테이션 이용(name, value : 쿼리파라미터의 key | required : 쿼리파라미터 필수여부 | defaultValue : 값이 없을 시 기본값)
	 * 3. 커맨드객체
	 * 
	 * @param memberId : 커맨드 객체처럼 쿼리파라미터 name과 매개변수의 이름이 동일하면 값을 자동으로 바인딩
	 * @return : @@RestController 안 method의  return => 응답데이터
	 */
	
	@PostMapping("/idCheck")
	public boolean idCheck(String memberId, 
						   @RequestParam(name = "memberId", required = false, defaultValue = "id") String userId) {
		boolean isDuplicate = false;
		
		log.info("체크아이디: {}", memberId);
		log.info("체크아이디: {}", userId);
		
		return isDuplicate;
	}
	
	@GetMapping("/test")
	public Member memberInfo() {
		Member memberInfo = new Member();
		memberInfo.setMemberId("ksmartid1");
		memberInfo.setMemberPw("ksmartpw1");
		memberInfo.setMemberGrade("mbr_grd_1");
		memberInfo.setMemberName("홍1");
		memberInfo.setMemberAddress("주소");
		memberInfo.setMemberDetailAddress("상세주소");
		memberInfo.setMemberZip(12345);
		
		return memberInfo;
	}
	
	@GetMapping("/textList")
	public List<Member> testList() {
		
		
		return memberMapper.getMemberList();
	}
}





















