package com.smartnote.smartnotebackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Notepad dto.
 */
@Getter
@Setter
public class NotepadDto {

    private Integer id;
    private String note;
    private Long userId;
}
