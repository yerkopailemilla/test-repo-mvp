package cl.retailpro.vendorpromobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.retailpro.vendorpromobile.R;
import cl.retailpro.vendorpromobile.mvp.LoginActivityMVP;
import dagger.android.support.DaggerAppCompatActivity;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends DaggerAppCompatActivity implements LoginActivityMVP.View {

    @BindView(R.id.login_et_companyname) EditText login_et_companyname;
    @BindView(R.id.login_et_username) EditText login_et_username;
    @BindView(R.id.login_et_password) EditText login_et_password;
    @BindView(R.id.login_switch_remember) Switch login_switch_remember;
    @BindView(R.id.login_btn_signup) Button login_btn_signup;
    @BindView(R.id.login_progressbar) ProgressBar login_progressbar;

    @Inject
    LoginActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        login_btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.signUpButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public String getCompanyName() {
        return login_et_companyname.getText().toString();
    }

    @Override
    public String getUsername() {
        return login_et_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return login_et_password.getText().toString();
    }

    @Override
    public void showInputCompanyError(String inputError) {
        login_et_companyname.setError(inputError);
    }

    @Override
    public void showInputUsernameError(String inputError) {
        login_et_username.setError(inputError);
    }

    @Override
    public void showInputPasswordError(String inputError) {
        login_et_password.setError(inputError);
    }

    @Override
    public void showProgress() {
        login_progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        login_progressbar.setVisibility(View.GONE);
    }

    @Override
    public void signUpSuccess() {
        Intent toMain = new Intent(this, MainActivity.class);
        toMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toMain);
        Toasty.success(this, "Ingresando correctamente", Toast.LENGTH_SHORT, true).show();

        byte[] authPetri = ("sori.antola@petrizzio.cl:santola915").getBytes(); //c29yaS5hbnRvbGFAcGV0cml6emlvLmNsOnNhbnRvbGE5MTU=
        byte[] authGeneral = ("rpro_1:64F9k2Wr").getBytes(); // cnByb18xOjY0RjlrMldy
        String webServiceToken = Base64.encodeToString(authGeneral, Base64.NO_WRAP);
        Log.d("TOKEN_BASIC", webServiceToken);
    }

}
