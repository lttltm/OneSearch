package com.lttltm.fans.onesearch.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

//    @Inject
//    private TokenService tokenService;
//
//    @Inject
//    private AccessTokenRepository accessTokenRepository;
//
//    @Inject
//    private JHipsterProperties jHipsterProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication)
        throws IOException, ServletException {

//        User user = (User)authentication.getPrincipal();
//
//        List<AccessToken> accessTokens = accessTokenRepository.findByUsername(user.getUsername()).stream()
//            .map(accessToken ->tokenService.getAccessToken(accessToken.getClientId()))
//            .collect(Collectors.toList());
//
//        String tokenInfo = tokenService.refreshTokenForLogin(jHipsterProperties.getToken().getClientId(), jHipsterProperties.getToken().getClientSecret(), accessTokens.get(0).getRefreshToken());
//
//        //Gson gson = new Gson();
//
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.getWriter().write(tokenInfo);
//        response.getWriter().flush();
//        response.getWriter().close();
    }
}
