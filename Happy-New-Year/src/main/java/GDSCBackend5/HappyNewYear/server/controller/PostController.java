package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberSignupRequest;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import GDSCBackend5.HappyNewYear.server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/post")

public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private MemberService memberService;
    @GetMapping("/view")
    public String viewPost(Model model) {
        Member member=new Member();
        member.signup("Dawoon98", "1234", "Dawoon");

        memberService.join(member);

        String userToken= member.getToken();

        Post post1 =new Post();
        Post post2 =new Post();
        Post post3 =new Post();

        post1.posting("hi", "bye", "test",userToken);
        post2.posting("Dawn", "bye", "test",userToken);
        post3.posting("DaeYoung", "bye", "test",userToken);

        postService.write(post1);
        postService.write(post2);
        postService.write(post3);

        model.addAttribute("member", postService.viewPostList(userToken));
        return "postview";
    }

}