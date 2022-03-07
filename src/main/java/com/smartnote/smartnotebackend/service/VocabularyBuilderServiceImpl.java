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

    @Autowired
    private void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.userDetailsService(userDetailsService);
    }

    @Override
    public List<VocabularyBuilderEntity> searchWordsById(Long userId) {
        return vocabularyBuilderRepository.findAllByUserId(userId);
    }

    @Override
    public VocabularyBuilderEntity addWord(VocabularyBuilderEntity vocabularyBuilderEntity) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl client = (UserDetailsImpl) auth.getPrincipal();
        Long id =  client.getId();

        vocabularyBuilderEntity.setUserId(id);
        return vocabularyBuilderRepository.save(vocabularyBuilderEntity);
    }

    @Override
    public void deleteWord(int id) {
        vocabularyBuilderRepository.deleteById(id);
    }


}
