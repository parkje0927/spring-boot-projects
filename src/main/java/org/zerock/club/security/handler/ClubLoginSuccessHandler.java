package org.zerock.club.security.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class ClubLoginSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //(ClubMemberDto)authentication.getPrincipal() 에서 정보를 찾아옴.
        //social 로 진입한 사람이면서 password, id 가 맞다면 redirect

        log.info("-----");
        log.info("onAuthenticationSuccess");

        //principal, isFromSocial 인지 확인
        Object principal = authentication.getPrincipal();

        //처음 로그인한 것인지 아니라면 password 가 맞는지 확인
        redirectStrategy.sendRedirect(request, response, "/sample/hello");

    }
}
