package com.smartnote.smartnotebackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "notepad")
public class NotepadEntity {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    /**
     * The Note.
     */
    @Column(name = "note")
    private String note;

    /**
     * The User Id.
     */
    @Column(name = "user_id")
    private Long userId;
}
