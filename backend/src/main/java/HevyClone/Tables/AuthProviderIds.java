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
}
