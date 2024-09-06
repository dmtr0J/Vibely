package com.vibely.common.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("accounts")
public class Account {

    @Id
    @Column("account_id")
    private Long id;

    @NotBlank
    @Size(min = 1, max = 16)
    @Column("username")
    private String username;

    @NotBlank
    @Size(min = 1, max = 50)
    @Column("name")
    private String name;

    @Email
    @Max(320)
    @Column("email")
    private String email;

    @NotBlank
    @Max(255)
    @Column("password")
    private String password;

    @Max(160)
    @Column("bio")
    private String bio;

    @Max(20)
    @Column("role")
    private Role role;

    @NotNull
    @Column("date_of_birth")
    private LocalDate dateOfBirth;

    @Column("image_url")
    private String imageUrl;

    @Column("locked")
    private boolean isLocked;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("last_login_at")
    private LocalDateTime lastLoginAt;
}