package com.da_ta.backend.account.user.domain.entity;

import com.da_ta.backend.account.user.domain.Role;
import com.da_ta.backend.common.domain.Age;
import com.da_ta.backend.common.domain.CommonEntity;
import com.da_ta.backend.letter.domain.entity.CollectedLetter;
import com.da_ta.backend.letter.domain.entity.Reply;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class User extends CommonEntity {

    @Column(nullable = false, unique = true)
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
    private boolean isAlertActive = true;

    @OneToMany(mappedBy = "reply", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CollectedLetter> collectedLetters = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ban_status_id")
    private BanStatus banStatus;
}
