package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * v3
 * Model 도입
 * ViewName 직접반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 * //frontControllerV4와 비슷
 */
@Controller
@RequestMapping("springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String username,@RequestParam int age, Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";//frontControllerV4와 비슷
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        // Model은 화면에 변화가 필요하면 컨트롤러가 Model에 먼가 담아야하므로 필요하다.
        model.addAttribute("members", members);
        return "members";
    }
}
