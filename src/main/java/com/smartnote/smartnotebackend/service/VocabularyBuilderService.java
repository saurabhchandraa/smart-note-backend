package com.smartnote.smartnotebackend.service;

import com.smartnote.smartnotebackend.entity.VocabularyBuilderEntity;

import java.util.List;

/**
 * The interface Vocabulary builder service.
 */
public interface VocabularyBuilderService {

    /**
     * Search words by id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<VocabularyBuilderEntity> searchWordsById(Long userId);

    /**
     * Add word vocabulary builder entity.
     *
     * @param vocabularyBuilderEntity the vocabulary builder entity
     * @return the vocabulary builder entity
     */
    VocabularyBuilderEntity addWord(VocabularyBuilderEntity vocabularyBuilderEntity);

    /**
     * Delete word.
     *
     * @param id the id
     */
    void deleteWord(int id);
}
