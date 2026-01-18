package com.langapp.mapper;

import com.langapp.domain.revision.Revision;
import com.langapp.domain.revision.dto.RevisionDto;
import com.langapp.domain.user.User;
import com.langapp.domain.word.Word;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RevisionMapper {

    public Revision mapToRevision(final RevisionDto revisionDto, final Word word, final User user) {
        return Revision.builder()
                .id(revisionDto.getId())
                .correctCount(revisionDto.getCorrectCount())
                .incorrectCount(revisionDto.getIncorrectCount())
                .created(revisionDto.getCreated())
                .lastReviewed(revisionDto.getLastReviewed())
                .nextReview(revisionDto.getNextReview())
                .word(word)
                .user(user)
                .build();
    }

    public RevisionDto mapToRevisionDto(final Revision revision) {
        return RevisionDto.builder()
                .id(revision.getId())
                .correctCount(revision.getCorrectCount())
                .incorrectCount(revision.getIncorrectCount())
                .created(revision.getCreated())
                .lastReviewed(revision.getLastReviewed())
                .nextReview(revision.getNextReview())
                .wordId(revision.getWord().getId())
                .userId(revision.getUser().getId())
                .build();
    }

    public List<RevisionDto> mapToRevisionDtoList(final List<Revision> revisions) {
        return revisions.stream()
                .map(this::mapToRevisionDto)
                .collect(Collectors.toList());
    }
}
