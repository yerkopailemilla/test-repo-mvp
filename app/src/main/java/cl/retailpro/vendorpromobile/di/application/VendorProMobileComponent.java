package cl.retailpro.vendorpromobile.di.application;

import javax.inject.Singleton;

import cl.retailpro.vendorpromobile.di.ActivityModule;
import cl.retailpro.vendorpromobile.di.RetrofitModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
                AndroidSupportInjectionModule.class,
                VendorProMobileModule.class,
                ActivityModule.class, RetrofitModule.class
        })

interface VendorProMobileComponent extends AndroidInjector<VendorProMobileApplication> {

    @Component.Builder
    abstract class Builder extends  AndroidInjector.Builder<VendorProMobileApplication> {

    }
}
