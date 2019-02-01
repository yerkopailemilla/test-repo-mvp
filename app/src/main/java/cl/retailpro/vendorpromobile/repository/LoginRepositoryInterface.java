package cl.retailpro.vendorpromobile.repository;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import cl.retailpro.vendorpromobile.entity.UserSessionEntity;
import io.reactivex.Observable;

public interface LoginRepositoryInterface {

    void saveUserSession(UserSessionEntity userSessionEntity);

    Observable<LoginResponseEntity> getLoginResult(String company, String token);
}
