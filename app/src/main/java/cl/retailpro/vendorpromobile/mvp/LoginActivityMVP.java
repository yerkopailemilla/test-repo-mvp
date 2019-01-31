package cl.retailpro.vendorpromobile.mvp;

import android.widget.EditText;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import io.reactivex.Observable;

public interface LoginActivityMVP {

    interface View {

        String getCompanyName();
        String getUsername();
        String getPassword();

        void showInputCompanyError(String inputError);
        void showInputUsernameError(String inputError);
        void showInputPasswordError(String inputError);

        void showProgress();
        void hideProgress();

        void signUpSuccess();
    }

    interface Presenter {

        void setView(LoginActivityMVP.View view);
        void signUpButtonClicked();
        void loadLoginData(String company, String username, String password);

    }

    interface Model {

        void createToken(String companyName, String username, String password);
        Observable<LoginResponseEntity> resultLogin();

    }
}
