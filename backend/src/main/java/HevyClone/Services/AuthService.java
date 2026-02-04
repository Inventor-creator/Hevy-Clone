package HevyClone.Services;


import HevyClone.Tables.User;
import HevyClone.Util.JwtUtil;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    JwtUtil jwtUtils;

    public Cookie sendJwtCookie(String providerId){



//        Cookie cookie = new Cookie("jwtAuthToken" ,jwtUtils.generateToken() );

        return  null;

    }



}
