package HevyClone.Tables;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String picture;

    @Column(unique = true)
    private String googleId;

    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getters and setters
}

enum AuthProvider {
    LOCAL, GOOGLE
}