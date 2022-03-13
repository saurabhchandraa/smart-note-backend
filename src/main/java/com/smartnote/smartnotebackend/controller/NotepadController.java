package com.smartnote.smartnotebackend.controller;

import com.smartnote.smartnotebackend.dto.NotepadDto;
import com.smartnote.smartnotebackend.entity.NotepadEntity;
import com.smartnote.smartnotebackend.mapper.NotepadMapper;
import com.smartnote.smartnotebackend.service.NotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * The type Notepad controller.
 */
@RestController
@RequestMapping("/notepad")
@CrossOrigin("http://localhost:3000/")
public class NotepadController {

    @Autowired
    private NotepadService notepadService;

    @Autowired
    private NotepadMapper mapper;

    /**
     * Search notepad by id response entity.
     *
     * @param userId the user id
     * @return the response entity
     */
    @GetMapping(value="/{userId}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ResponseEntity<NotepadDto> searchNotepadById(@PathVariable Long userId)
    {
        NotepadEntity notepadEntity = notepadService.searchNotepadById(userId);
        NotepadDto notepadDto = null;
        if(notepadEntity !=null ) {
           notepadDto = mapper.toNotepadDto(notepadEntity);
        }
        return ResponseEntity.status(HttpStatus.OK).body(notepadDto);
    }

    /**
     * Update notepad response entity.
     *
     * @param request    the request
     * @param notepadDto the notepad dto
     * @return the response entity
     */
    @PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ResponseEntity<String> updateNotepad(HttpServletRequest request, @RequestBody NotepadDto notepadDto)
    {

        String location = "";
        String responseBody = "";
        NotepadEntity notepadEntity = mapper.toNotepadEntity(notepadDto);
        NotepadEntity entityResponse = notepadService.updateNotepad(notepadEntity);

        location = request.getRequestURI() + "/"+entityResponse.getId();
        responseBody = String.format("{\"id\": %d}" ,entityResponse.getId());

        return ResponseEntity.status(HttpStatus.CREATED).header(location).body(responseBody);
    }


}
