package cl.retailpro.vendorpromobile.repository;

import javax.inject.Inject;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import cl.retailpro.vendorpromobile.entity.UserSessionEntity;
import io.reactivex.Observable;

public class LoginRepository implements LoginRepositoryInterface {

    @Inject
    public LoginRepository() {
    }

    @Override
    public void saveUserSession(UserSessionEntity userSessionEntity) {

    }

    @Override
    public Observable<LoginResponseEntity> getLoginResult() {
        return null;
    }


}
