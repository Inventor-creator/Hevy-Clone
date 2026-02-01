package HevyClone.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/login/success")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User authUser) {

        return authUser.getAttributes();
    }
}
