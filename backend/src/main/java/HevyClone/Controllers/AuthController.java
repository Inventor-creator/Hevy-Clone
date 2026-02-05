package HevyClone.Controllers;

import HevyClone.Services.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/login/success")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User authUser , HttpServletResponse response) throws IOException {

        Cookie cookie = authService.checkUserAndSendCookie(authUser.getAttributes());
        System.out.println(cookie.getValue());



        response.addCookie(cookie);

        response.sendRedirect("http://localhost:5173/idk");


        return authUser.getAttributes();
    }




}
