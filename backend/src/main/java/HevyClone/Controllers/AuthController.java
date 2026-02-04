package HevyClone.Controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/login/success")
    public Map<String, Object> user( @AuthenticationPrincipal OAuth2User authUser )  {

//        String token = getJwtToken(authUser.getAttributes());

//        res.sendRedirect("http://localhost:5173/idk");

        return authUser.getAttributes();
    }


    private String getJwtToken( Map<String, Object> authUser) {

        System.out.println(authUser);
        return  "";
    }

}
