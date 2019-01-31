package cl.retailpro.vendorpromobile.entity;

public class UserSessionEntity {

    private String companyName;
    private String username;
    private String token;

    public UserSessionEntity(String companyName, String username, String token) {
        this.companyName = companyName;
        this.username = username;
        this.token = token;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
