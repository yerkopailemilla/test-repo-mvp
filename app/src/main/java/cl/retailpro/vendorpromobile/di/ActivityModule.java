package cl.retailpro.vendorpromobile.di;

import cl.retailpro.vendorpromobile.di.login.LoginModule;
import cl.retailpro.vendorpromobile.di.main.MainModule;
import cl.retailpro.vendorpromobile.di.main.premise.PremiseModule;
import cl.retailpro.vendorpromobile.di.main.resume.ResumeModule;
import cl.retailpro.vendorpromobile.di.splash.SplashModule;
import cl.retailpro.vendorpromobile.view.LoginActivity;
import cl.retailpro.vendorpromobile.view.MainActivity;
import cl.retailpro.vendorpromobile.view.PremisesFragment;
import cl.retailpro.vendorpromobile.view.ResumenFragment;
import cl.retailpro.vendorpromobile.view.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {

    @ContributesAndroidInjector(modules = SplashModule.class)
    SplashActivity contributeSplashActivity();

    @ContributesAndroidInjector(modules = LoginModule.class)
    LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector(modules = MainModule.class)
    MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = ResumeModule.class)
    ResumenFragment contributeResumeFragment();

    @ContributesAndroidInjector(modules = PremiseModule.class)
    PremisesFragment contributePremisesFragment();

    //TODO: Add all activities here! (Example: 'RegisterActivity contributeRegisterActivity();')
}
