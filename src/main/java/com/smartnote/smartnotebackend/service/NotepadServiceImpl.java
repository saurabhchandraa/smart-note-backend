package com.smartnote.smartnotebackend.service;

import com.smartnote.smartnotebackend.entity.NotepadEntity;
import com.smartnote.smartnotebackend.repository.NotepadRepository;
import com.smartnote.smartnotebackend.usermanagement.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * The type Notepad service.
 */
@Service
public class NotepadServiceImpl implements NotepadService {

    @Autowired
    private NotepadRepository notepadRepository;

    @Override
    public NotepadEntity searchNotepadById(Long userId) {
        return notepadRepository.findByUserId(userId);
    }

    @Override
    public NotepadEntity updateNotepad(NotepadEntity notepadEntity) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();

        if(userDetails !=null ) {
            notepadEntity.setUserId(userDetails.getId());
            NotepadEntity entityFromDb = null;
            entityFromDb = searchNotepadById(userDetails.getId());
            if(entityFromDb !=null ) {
                notepadEntity.setId(entityFromDb.getId());
            }
        }
        return notepadRepository.save(notepadEntity);
    }
}
