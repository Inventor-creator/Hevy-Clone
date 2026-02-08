package HevyClone.Services;


import HevyClone.Repos.AuthProviderIdRepo;
import HevyClone.Repos.UserRepo;
import HevyClone.ReturnObjects.AuthProviderReturnUser;
import HevyClone.Tables.AuthProviderIds;
import HevyClone.Tables.User;
import HevyClone.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    JwtUtil jwtUtils;

    @Autowired
    AuthProviderIdRepo aIdRepo;

    @Autowired
    UserRepo uRepo;



    public Cookie checkUserAndSendCookie( Map<String, Object> authUserVals){

        Integer userId;
        Cookie cookie;
        String providerId = (String ) authUserVals.get("sub");
        String userMail = (String ) authUserVals.get("email");

        Optional<AuthProviderReturnUser> user = aIdRepo.getUserIfExists(providerId);

        if(user.isPresent()){

            AuthProviderReturnUser gottenUser = user.get();

            cookie = new Cookie("jwtAuthToken" , jwtUtils.generateToken(gottenUser.getUserId() , userMail) );


        }
        else{

            User newUser = new User(authUserVals.get("email").toString() , authUserVals.get("name").toString()  );
            AuthProviderIds authProviderIds = new AuthProviderIds("google", authUserVals.get("sub").toString(),  newUser);

            User savedUser  = uRepo.save(newUser);
            aIdRepo.save(authProviderIds);

            cookie = new Cookie("jwtAuthToken" , jwtUtils.generateToken(savedUser.getUserId(), userMail) );



        }

        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 120);

        return cookie;

    }

    public Map<String , Object> getUserStuff(Cookie  cookie){


        String value = cookie.getValue();

        if(!jwtUtils.validateToken(value)){
            return null;
        }

        //add more shit when needed
        Claims claims = jwtUtils.extractAllClaims(value);

        try {
            Number userId = claims.get("userId", Number.class);

            Map<String, Object> map = new HashMap<>();
            User dbUser = uRepo.getReferenceById(userId.longValue());



            map.put("userId", userId.longValue());
            map.put("userName" , dbUser.getName());
            map.put("role" , "user");

            return map;
        }catch(Exception e){
            return null;
        }


    }



}
