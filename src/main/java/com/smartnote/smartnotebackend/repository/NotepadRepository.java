package com.smartnote.smartnotebackend.repository;

import com.smartnote.smartnotebackend.entity.NotepadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotepadRepository extends JpaRepository<NotepadEntity, Integer> {

    NotepadEntity findByUserId(Long userId);
}
