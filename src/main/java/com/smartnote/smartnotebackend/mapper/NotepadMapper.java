package com.smartnote.smartnotebackend.mapper;

import com.smartnote.smartnotebackend.dto.NotepadDto;
import com.smartnote.smartnotebackend.entity.NotepadEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotepadMapper {

    /**
     * The Model mapper.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * The Type map entity to dto.
     */
    private TypeMap<NotepadEntity, NotepadDto> typeMapEntityToDto;

    /**
     * The Type map dto to entity.
     */
    private TypeMap<NotepadDto, NotepadEntity> typeMapDtoToEntity;

    /**
     * To task dto task dto.
     *
     * @param entity the entity
     * @return the task dto
     */
    public NotepadDto toNotepadDto(NotepadEntity entity) {

        if(typeMapEntityToDto == null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            typeMapEntityToDto = modelMapper.createTypeMap(NotepadEntity.class, NotepadDto.class);
        }
        return typeMapEntityToDto.map(entity);
    }

    /**
     * To task entity task entity.
     *
     * @param dto the dto
     * @return the task entity
     */
    public NotepadEntity toNotepadEntity(NotepadDto dto) {

        if(typeMapDtoToEntity == null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            typeMapDtoToEntity = modelMapper.createTypeMap(NotepadDto.class, NotepadEntity.class);
        }
        return typeMapDtoToEntity.map(dto);
    }
}
