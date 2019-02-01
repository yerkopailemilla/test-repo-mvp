package cl.retailpro.vendorpromobile.di.login;

import cl.retailpro.vendorpromobile.model.LoginActivityModel;
import cl.retailpro.vendorpromobile.mvp.LoginActivityMVP;
import cl.retailpro.vendorpromobile.presenter.LoginActivityPresenter;
import cl.retailpro.vendorpromobile.repository.LoginRepository;
import cl.retailpro.vendorpromobile.repository.LoginRepositoryInterface;
import cl.retailpro.vendorpromobile.ws.LoginService;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static cl.retailpro.vendorpromobile.di.RetrofitModule.BASE_URL;

@Module(includes = LoginModule.WSModule.class)
public abstract class LoginModule {

    @Binds
    public abstract LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityPresenter loginActivityPresenter);

    @Binds
    public abstract LoginActivityMVP.Model provideLoginActivityModel(LoginActivityModel loginActivityModel);

    @Binds
    abstract LoginRepositoryInterface provideLoginRepository(LoginRepository loginRepository);

    @Module
    public static class WSModule {
        @Provides
        public static LoginService provideLoginService(Retrofit.Builder builder) {
            return builder.baseUrl(BASE_URL).build().create(LoginService.class);
        }
    }
}
