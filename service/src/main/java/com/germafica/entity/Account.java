package com.germafica.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a user account.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
// @ToString // don't use it
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "Account")
@Table(name = "account")
public class Account {
    // == fields ==
    @Column(nullable = false)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true, nullable = false, updatable = false)
    @Size(max = 20)
    @NonNull
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(max = 45)
    @NonNull
    private String firstName;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(max = 45)
    @NonNull
    private String lastName;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(max = 45)
    @NonNull
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(120)")
    @Size(max = 120)
    @NonNull
    private String password;

    // == associations ==

    // == belongs relationship ==
    @Getter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @LazyCollection( LazyCollectionOption.EXTRA )
    private Set<PlayerCharacter> playerCharacters = new HashSet<>();

    // == type-specific ==
    public Account update(Account account) {
        if(account.getUsername()!=null) this.setUsername(account.getUsername());
        if(account.getFirstName()!=null) this.setFirstName(account.getFirstName());
        if(account.getLastName()!=null) this.setLastName(account.getLastName());
        if(account.getEmail()!=null) this.setEmail(account.getEmail());
        if(account.getPassword()!=null) this.setPassword(account.getPassword());

        return this;
    }
}
