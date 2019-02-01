package cl.retailpro.vendorpromobile.repository;

import javax.inject.Inject;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import cl.retailpro.vendorpromobile.entity.UserSessionEntity;
import cl.retailpro.vendorpromobile.ws.LoginService;
import cl.retailpro.vendorpromobile.ws.Session;
import io.reactivex.Observable;

public class LoginRepository implements LoginRepositoryInterface {

    private LoginService loginService;
    private Session session;

    @Inject
    public LoginRepository(LoginService loginService, Session session){
        this.loginService = loginService;
        this.session = session;
    }

    @Override
    public void saveUserSession(UserSessionEntity userSessionEntity) {

    }

    @Override
    public Observable<LoginResponseEntity> getLoginResult(String company, String token) {
        session.setCompany(company);
        return this.loginService.getLoginResponse("Basic " + token).map(response -> {
            String jwtToken = response.headers().get("jwt");
            session.setToken("Bearer " + jwtToken);
            int status = response.code();
            String statusMessage = response.message();
            LoginResponseEntity entity = new LoginResponseEntity();
            entity.setJwtToken(jwtToken);
            entity.setStatus(status);
            entity.setStatusMessage(statusMessage);
            return entity;
        });
    }


}
