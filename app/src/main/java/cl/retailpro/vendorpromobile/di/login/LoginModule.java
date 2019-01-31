package cl.retailpro.vendorpromobile.di.login;

import cl.retailpro.vendorpromobile.model.LoginActivityModel;
import cl.retailpro.vendorpromobile.mvp.LoginActivityMVP;
import cl.retailpro.vendorpromobile.presenter.LoginActivityPresenter;
import cl.retailpro.vendorpromobile.repository.LoginRepository;
import cl.retailpro.vendorpromobile.repository.LoginRepositoryInterface;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {

    @Binds
    public abstract LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityPresenter loginActivityPresenter);

    @Binds
    public abstract LoginActivityMVP.Model provideLoginActivityModel(LoginActivityModel loginActivityModel);

    @Binds
    abstract LoginRepositoryInterface provideLoginRepository(LoginRepository loginRepository);
}
