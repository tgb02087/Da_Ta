package com.da_ta.backend.letter.domain.entity;

import com.da_ta.backend.common.domain.CommonEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "floated_letter_id"))
@Entity
public class FloatedLetter extends CommonEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "letter_id")
    private Letter letter;

    @OneToMany(mappedBy = "floatedLetter", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Log> logs = new ArrayList<>();
}
