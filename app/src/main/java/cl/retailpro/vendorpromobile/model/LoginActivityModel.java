package cl.retailpro.vendorpromobile.model;

import javax.inject.Inject;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import cl.retailpro.vendorpromobile.entity.UserSessionEntity;
import cl.retailpro.vendorpromobile.mvp.LoginActivityMVP;
import cl.retailpro.vendorpromobile.repository.LoginRepository;
import io.reactivex.Observable;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository loginRepository;

    @Inject
    public LoginActivityModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void createToken(String companyName, String username, String password) {
        loginRepository.saveUserSession(new UserSessionEntity(companyName, username, password));
    }

    @Override
    public Observable<LoginResponseEntity> resultLogin() {
        return null;
    }

}
