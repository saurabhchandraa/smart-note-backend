package com.smartnote.smartnotebackend.mapper;

import com.smartnote.smartnotebackend.dto.VocabularyBuilderDto;
import com.smartnote.smartnotebackend.entity.VocabularyBuilderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VocabularyMapper {

    /**
     * The Model mapper.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * The Type map entity to dto.
     */
    private TypeMap<VocabularyBuilderEntity, VocabularyBuilderDto> typeMapEntityToDto;

    /**
     * The Type map dto to entity.
     */
    private TypeMap<VocabularyBuilderDto, VocabularyBuilderEntity> typeMapDtoToEntity;

    /**
     * To task dto task dto.
     *
     * @param entity the entity
     * @return the task dto
     */
    public VocabularyBuilderDto toTaskDto(VocabularyBuilderEntity entity) {

        if(typeMapEntityToDto == null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            typeMapEntityToDto = modelMapper.createTypeMap(VocabularyBuilderEntity.class, VocabularyBuilderDto.class);
        }
        return typeMapEntityToDto.map(entity);
    }

    /**
     * To task entity task entity.
     *
     * @param dto the dto
     * @return the task entity
     */
    public VocabularyBuilderEntity toTaskEntity(VocabularyBuilderDto dto) {

        if(typeMapDtoToEntity == null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            typeMapDtoToEntity = modelMapper.createTypeMap(VocabularyBuilderDto.class, VocabularyBuilderEntity.class);
        }
        return typeMapDtoToEntity.map(dto);
    }
}
