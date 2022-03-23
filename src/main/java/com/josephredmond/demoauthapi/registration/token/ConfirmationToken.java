package com.josephredmond.demoauthapi.registration.token;

import com.josephredmond.demoauthapi.applicationuser.ApplicationUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @SequenceGenerator(name="confirmation_token_sequence_generator", sequenceName = "confirmation_token_sequence_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confirmation_token_sequence_generator")
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    private ApplicationUser applicationUser;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, ApplicationUser applicationUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.applicationUser = applicationUser;
    }
}
