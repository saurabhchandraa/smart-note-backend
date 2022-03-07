package com.smartnote.smartnotebackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "vocabulary")
public class VocabularyBuilderEntity {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    /**
     * The Word.
     */
    @Column(name = "word")
    private String word;

    /**
     * The Meaning.
     */
    @Column(name = "meaning")
    private String meaning;

    /**
     * The User Id.
     */
    @Column(name = "user_id")
    private Long userId;
}
