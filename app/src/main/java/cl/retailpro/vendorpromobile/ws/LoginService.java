package cl.retailpro.vendorpromobile.ws;


import cl.retailpro.vendorpromobile.entity.LoginResponseEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LoginService {

    @GET("auth/token")
    Observable<LoginResponseEntity> getLoginResponse(String company, String basicToken);
}
