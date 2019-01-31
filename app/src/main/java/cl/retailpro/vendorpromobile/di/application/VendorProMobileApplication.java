package cl.retailpro.vendorpromobile.di.application;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class VendorProMobileApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerVendorProMobileComponent.builder().create(this);
    }
}
