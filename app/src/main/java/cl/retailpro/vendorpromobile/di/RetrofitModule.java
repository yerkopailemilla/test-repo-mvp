package cl.retailpro.vendorpromobile.di;

import java.io.IOException;

import cl.retailpro.vendorpromobile.ws.LoginService;
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

    private final String BASE_URL = "http://xxxxxxx.vendorpro.cl/MotorDeTareas/";
    private final String WS_BASIC_TOKEN = "xxxxxxxxxxx";

    @Provides
    public OkHttpClient provideOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException{
                        Request original = chain.request();

                        Request request = original.newBuilder()
                                .header("Authorization", "Basic " + WS_BASIC_TOKEN)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public LoginService provideLoginService(){
        return provideRetrofit(BASE_URL, provideOkHttpClient()).create(LoginService.class);
    }
}
