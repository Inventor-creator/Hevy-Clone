package HevyClone.Tables;

import jakarta.persistence.*;
@Entity
@Table(name = "authProviderIds")
public class AuthProviderIds {


    @Id
    @Column(name = "authTableId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider")
    private String providerName;

    @Column(name = "providerId" , unique = true)
    private String providerId;

    @OneToOne
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    private User user;

    public AuthProviderIds(){}

    public AuthProviderIds(String providerName, String providerId, User user) {

        this.providerName = providerName;
        this.providerId = providerId;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
