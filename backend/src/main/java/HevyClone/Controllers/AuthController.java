package HevyClone.Controllers;

import HevyClone.Services.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true" ,   origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {

        Cookie cookie = new Cookie("jwtAuthToken", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login/success")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User authUser , HttpServletResponse response) throws IOException {

        Cookie cookie = authService.checkUserAndSendCookie(authUser.getAttributes());
//        System.out.println(cookie.getValue());

        response.addCookie(cookie);

        response.sendRedirect("http://localhost:5173/idk");


        return new HashMap<>();
    }

    @GetMapping("/getMe")
    public Map<String, Object> getYourself(HttpServletRequest request){

        Optional<Cookie> jwtCookie = Arrays.stream(request.getCookies())
                .filter(cookie -> "jwtAuthToken".equals(cookie.getName()))
                .findFirst();

        if (jwtCookie.isEmpty()){
            return  new HashMap<>();
        }

        return authService.getUserStuff(jwtCookie.get());

    }


}
