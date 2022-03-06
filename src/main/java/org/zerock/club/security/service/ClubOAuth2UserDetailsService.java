package org.zerock.club.security.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ClubOAuth2UserDetailsService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        //userRequest 정보로 ClubMember 의 saveSocialMember 메소드 호출하여 생성
        //saveSocialMember 메소드 : 기존에 있는 회원이면 찾아오고, 새로운 회원이면 저장
        //ClubMember 객체를 ClubMemberDto 로 변환하여 return

        log.info("-----");
        log.info("userRequest : " + userRequest);

        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName : " + clientName);
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("-----");
        oAuth2User.getAttributes().forEach((k, v) -> {
            log.info(k + " : " + v);
        });

        return oAuth2User;
    }
}
