package com.da_ta.backend.letter.domain.repository;

import com.da_ta.backend.letter.domain.entity.CollectedLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollectedLetterRepository extends JpaRepository<CollectedLetter, Long> {

    Optional<CollectedLetter> findByLetterIdAndUserIdAndIsActiveTrue(Long letterId, Long userId);

    List<CollectedLetter> findAllByUserIdAndIsActiveTrueOrderByCreatedDateDesc(Long userId);
}
