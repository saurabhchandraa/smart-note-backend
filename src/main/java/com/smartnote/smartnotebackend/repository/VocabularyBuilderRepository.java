package com.smartnote.smartnotebackend.repository;

import com.smartnote.smartnotebackend.entity.VocabularyBuilderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VocabularyBuilderRepository extends JpaRepository<VocabularyBuilderEntity, Integer> {

    List<VocabularyBuilderEntity> findAllByUserId(Long userId);
}
