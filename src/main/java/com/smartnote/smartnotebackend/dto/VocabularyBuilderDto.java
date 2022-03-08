package com.smartnote.smartnotebackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VocabularyBuilderDto {

    private Integer id;
    private String word;
    private String meaning;
    private Long userId;
    private String userName;
}
