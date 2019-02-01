package cl.retailpro.vendorpromobile.ws;


import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LoginService {

    @GET("auth/token")
    Observable<retrofit2.Response<ResponseBody>> getLoginResponse(@Header("Authorization") String token);
}
