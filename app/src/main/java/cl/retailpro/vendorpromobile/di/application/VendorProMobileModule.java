package cl.retailpro.vendorpromobile.di.application;

import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public interface VendorProMobileModule {

    @Binds
    Context bindApplicationContext(VendorProMobileApplication application);
}
