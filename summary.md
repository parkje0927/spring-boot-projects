## 스프링 시큐리티 기본 API & Filter 이해
### 인증 API - 사용자 정의 보안 기능 구현
- WebSecurityConfigureAdapter : 스프링 시큐리티의 웹 보안 기능 초기화 및 설정
  - SecurityConfig : 사용자 정의 보안 설정 클래스 / WebSecurityConfigureAdapter 를 상속 
- HttpSecurity : 세부적인 보안 기능을 설정할 수 있는 API 제공
  - 인증 API : http.logout(), http.csrf()..
  - 인가 API : http.authorizeRequests().antMatchers("/admin")..