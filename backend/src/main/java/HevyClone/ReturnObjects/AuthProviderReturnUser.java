package HevyClone.ReturnObjects;

public class AuthProviderReturnUser {

    private Long userId;
    private String email;
    private String name;
    private Long id;
    private String providerName;
    private String providerId;

    public AuthProviderReturnUser(Long userId, Long id, String providerId ,  String providerName, String email, String name ) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.id = id;
        this.providerName = providerName;
        this.providerId = providerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
