package com.langapp.facade;

import com.langapp.domain.revision.Revision;
import com.langapp.domain.revision.dto.RevisionDto;
import com.langapp.exception.RevisionNotFoundException;
import com.langapp.exception.UserNotFoundException;
import com.langapp.exception.WordNotFoundException;
import com.langapp.mapper.RevisionMapper;
import com.langapp.service.RevisionDbService;
import com.langapp.service.RevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RevisionFacade {
    private final RevisionService service;
    private final RevisionDbService dbService;
    private final RevisionMapper mapper;

    public RevisionDto create(RevisionDto dto) throws UserNotFoundException, WordNotFoundException {
        Revision revision = service.createRevision(dto);
        return mapper.mapToRevisionDto(revision);
    }

    public RevisionDto getById(UUID id) throws RevisionNotFoundException {
        Revision revision = dbService.getRevision(id).orElseThrow(RevisionNotFoundException::new);
        return mapper.mapToRevisionDto(revision);
    }

    public List<RevisionDto> getAll() {
        return mapper.mapToRevisionDtoList(dbService.getRevisions());
    }

    public void deleteById(UUID id) throws RevisionNotFoundException {
        dbService.deleteRevision(id);
    }
}
