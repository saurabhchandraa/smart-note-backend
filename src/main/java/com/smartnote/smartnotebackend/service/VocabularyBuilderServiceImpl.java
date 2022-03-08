package com.smartnote.smartnotebackend.service;

import com.smartnote.smartnotebackend.entity.VocabularyBuilderEntity;
import com.smartnote.smartnotebackend.repository.VocabularyBuilderRepository;
import com.smartnote.smartnotebackend.usermanagement.entity.User;
import com.smartnote.smartnotebackend.usermanagement.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyBuilderServiceImpl implements VocabularyBuilderService{

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private VocabularyBuilderRepository vocabularyBuilderRepository;

    @Override
    public List<VocabularyBuilderEntity> searchWordsById(Long userId) {
        return vocabularyBuilderRepository.findAllByUserId(userId);
    }

    @Override
    public VocabularyBuilderEntity addWord(VocabularyBuilderEntity vocabularyBuilderEntity) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();

        vocabularyBuilderEntity.setUserId(userDetails.getId());
        return vocabularyBuilderRepository.save(vocabularyBuilderEntity);
    }

    @Override
    public void deleteWord(int id) {
        vocabularyBuilderRepository.deleteById(id);
    }


}
