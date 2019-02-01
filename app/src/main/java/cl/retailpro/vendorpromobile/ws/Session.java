package cl.retailpro.vendorpromobile.ws;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Session {
    private String company;
    private String token;

    @Inject
    public Session() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void clear(){
        this.company = null;
        this.token = null;
    }
}
