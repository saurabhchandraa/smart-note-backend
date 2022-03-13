package com.smartnote.smartnotebackend.service;

import com.smartnote.smartnotebackend.entity.NotepadEntity;

/**
 * The interface Notepad service.
 */
public interface NotepadService {

    /**
     * Search notepad by id notepad entity.
     *
     * @param userId the user id
     * @return the notepad entity
     */
    NotepadEntity searchNotepadById(Long userId);

    /**
     * Update notepad notepad entity.
     *
     * @param notepadEntity the notepad entity
     * @return the notepad entity
     */
    NotepadEntity updateNotepad(NotepadEntity notepadEntity);
}
