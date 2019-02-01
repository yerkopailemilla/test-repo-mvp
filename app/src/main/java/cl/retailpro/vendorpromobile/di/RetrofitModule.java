package cl.retailpro.vendorpromobile.di;

import android.util.Log;

import java.io.IOException;

import javax.inject.Singleton;

import cl.retailpro.vendorpromobile.ws.LoginService;
import cl.retailpro.vendorpromobile.ws.Session;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    public static final String BASE_URL = "http://$s.vendorpro.cl/MotorDeTareas/";

    @Provides
    public OkHttpClient provideOkHttpClient(Session session){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Log.i("URL", "on interceptor");
                    Request original = chain.request();

                    Request.Builder builder = original.newBuilder();
                    String url = String.format(original.url().toString().replace("$","%"), session.getCompany());
                    builder.url(url);
                    Log.i("URL", url);

                    if(session.getToken() != null && !session.getToken().isEmpty()) {
                        builder.header("Authorization", session.getToken());
                    }

                    Request request = builder.build();
                    return chain.proceed(request);
                })
                .build();
    }


    @Provides
    public Retrofit.Builder provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

}
