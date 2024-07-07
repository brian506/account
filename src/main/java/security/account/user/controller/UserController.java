package security.account.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import security.account.user.dto.SignupDto;
import security.account.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입 api
    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignupDto signupDto) throws Exception{
        userService.signUp(signupDto);
        return "success";
    }


}
