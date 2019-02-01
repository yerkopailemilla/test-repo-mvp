package cl.retailpro.vendorpromobile.presenter;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import cl.retailpro.vendorpromobile.mvp.LoginActivityMVP;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    private Disposable suscription;

    @Inject
    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void signUpButtonClicked() {
        if (view != null) {
            if (view.getCompanyName().trim().isEmpty()) {
                view.showInputCompanyError("Debes ingresar el nombre de tu empresa");
            } else {
                if (view.getUsername().trim().isEmpty()) {
                    view.showInputUsernameError("Debes ingresar el nombre de usuario");
                } else {
                    if (view.getPassword().trim().isEmpty()) {
                        view.showInputPasswordError("Debes ingresar tu contraseña");
                    } else {
                        Disposable disposable = model.createToken(view.getCompanyName().trim(), view.getUsername().trim(), view.getPassword().trim())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(loginResponseEntity -> view.signUpSuccess(),throwable -> {
                                    //any response status code >= 400
                                });

                    }
                }
            }
        }

    }

    @Override
    public void loadLoginData(String company, String username, String password) {


    }

}
