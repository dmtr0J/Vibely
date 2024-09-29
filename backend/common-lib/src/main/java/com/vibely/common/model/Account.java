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
    @NotEmpty
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
    @NotBlank
    @Max(320)
    @Column("email")
    private String email;

    @NotBlank
    @Column("password")
    private String password;

    @Max(160)
    @Column("bio")
    private String bio;

    @Column("image_url")
    private String imageUrl;

    @NotEmpty
    @Column("role")
    private Role role;

    @NotEmpty
    @Column("status")
    private Status status;

    @NotEmpty
    @Column("date_of_birth")
    private LocalDate dateOfBirth;

    @NotEmpty
    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("last_login_at")
    private LocalDateTime lastLoginAt;
}