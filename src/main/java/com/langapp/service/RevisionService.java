package com.langapp.service;

import com.langapp.domain.revision.Revision;
import com.langapp.domain.revision.dto.RevisionDto;
import com.langapp.domain.user.User;
import com.langapp.domain.word.Word;
import com.langapp.exception.UserNotFoundException;
import com.langapp.exception.WordNotFoundException;
import com.langapp.mapper.RevisionMapper;
import com.langapp.repository.UserRepository;
import com.langapp.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RevisionService {
    private final RevisionDbService dbService;
    private final RevisionMapper mapper;
    private final UserRepository userRepository;
    private final WordRepository wordRepository;

    public Revision createRevision(RevisionDto dto) throws UserNotFoundException, WordNotFoundException {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(UserNotFoundException::new);
        Word word = wordRepository.findById(dto.getWordId()).orElseThrow(WordNotFoundException::new);

        Revision revision = mapper.mapToRevision(dto, word, user);

        return dbService.saveRevision(revision);
    }
}
