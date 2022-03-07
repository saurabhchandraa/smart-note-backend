package com.smartnote.smartnotebackend.service;

import com.smartnote.smartnotebackend.entity.VocabularyBuilderEntity;

import java.util.List;

public interface VocabularyBuilderService {

    List<VocabularyBuilderEntity> searchWordsById(Long userId);

    VocabularyBuilderEntity addWord(VocabularyBuilderEntity vocabularyBuilderEntity);

    void deleteWord(int id);
}
