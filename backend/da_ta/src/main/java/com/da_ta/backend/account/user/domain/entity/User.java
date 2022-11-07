package com.da_ta.backend.account.user.domain.entity;

import com.da_ta.backend.account.user.domain.Role;
import com.da_ta.backend.common.domain.Age;
import com.da_ta.backend.common.domain.CommonEntity;
import com.da_ta.backend.letter.domain.entity.Collection;
import com.da_ta.backend.letter.domain.entity.Reply;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Entity
public class User extends CommonEntity implements UserDetails {

    @Column(nullable = false)
    private String kakaoId;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Age age = Age.AGE_ALL;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.MEMBER;

    @NotNull
    @Builder.Default
    private boolean alertOption = true;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Collection> collectedLetters = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ban_status_id")
    private BanStatus banStatus;

    @Override
    public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.role.getCode()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void updateAgeRange(String ageRange) {
        this.age = Age.valueOf(ageRange);
    }

    public void updateAlertOption(boolean alertOption) {
        this.alertOption = alertOption;
    }

    public void deleteUser() {
        super.delete();
    }
}
