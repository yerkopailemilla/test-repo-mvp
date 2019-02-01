package cl.retailpro.vendorpromobile.model;

import android.util.Base64;

import javax.inject.Inject;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
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
    public Observable<LoginResponseEntity> createToken(String companyName, String username, String password) {
        byte[] tokenBytes = (username + ":" + password).getBytes();
        String encoded = Base64.encodeToString(tokenBytes, Base64.NO_WRAP);
        return loginRepository.getLoginResult(companyName, encoded);
    }


}
