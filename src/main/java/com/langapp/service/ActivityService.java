package com.langapp.service;

import com.langapp.domain.activity.*;
import com.langapp.domain.activity.request.*;
import com.langapp.domain.lesson.Lesson;
import com.langapp.domain.sentence.Sentence;
import com.langapp.domain.text.Text;
import com.langapp.domain.word.Word;
import com.langapp.exception.*;
import com.langapp.repository.LessonRepository;
import com.langapp.repository.SentenceRepository;
import com.langapp.repository.TextRepository;
import com.langapp.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ActivityService {

    private final ActivityDbService dbService;
    private final LessonRepository lessonRepository;
    private final SentenceRepository sentenceRepository;
    private final TextRepository textRepository;
    private final WordRepository wordRepository;

    public Activity createListeningActivity(ListeningActivityCreateRequest request) throws LessonNotFoundException, TextNotFoundException {

        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        Text text = textRepository.findById(request.getTextId()).orElseThrow(TextNotFoundException::new);

        Activity activity = Activity.builder()
                .activityType(ActivityType.LISTENING)
                .order(request.getOrder())
                .lesson(lesson)
                .build();

        ListeningActivity listening = new ListeningActivity();
        listening.setActivity(activity);
        listening.setText(text);

        activity.setListeningActivity(listening);

        return dbService.saveActivity(activity);
    }

    public Activity createMemoryActivity(MemoryActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        List<Word> words = wordRepository.findAllById(request.getWordIds());

        if (words.size() != request.getWordIds().size()) {
            throw new WordNotFoundException();
        }

        Activity activity = Activity.builder()
                .activityType(ActivityType.MEMORY)
                .order(request.getOrder())
                .lesson(lesson)
                .words(words)
                .build();

        MemoryActivity memory = new MemoryActivity();
        memory.setActivity(activity);
        memory.setWords(words);

        activity.setMemoryActivity(memory);

        return dbService.saveActivity(activity);
    }

    public Activity createQuizSentencesActivity(QuizSentencesActivityCreateRequest request) throws LessonNotFoundException, SentenceNotFoundException {
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        List<Sentence> sentences = sentenceRepository.findAllById(request.getSentenceIds());

        if (sentences.size() != request.getSentenceIds().size()) {
            throw new SentenceNotFoundException();
        }

        Activity activity = Activity.builder()
                .activityType(ActivityType.QUIZ_SENTENCES)
                .order(request.getOrder())
                .lesson(lesson)
                .build();

        QuizSentencesActivity quizSentences = new QuizSentencesActivity();
        quizSentences.setActivity(activity);
        quizSentences.setSentences(sentences);

        activity.setQuizSentencesActivity(quizSentences);

        return dbService.saveActivity(activity);
    }

    public Activity createQuizWordsActivity(QuizWordsActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        List<Word> words = wordRepository.findAllById(request.getWordIds());

        if (words.size() != request.getWordIds().size()) {
            throw new WordNotFoundException();
        }

        Activity activity = Activity.builder()
                .activityType(ActivityType.QUIZ_WORDS)
                .order(request.getOrder())
                .lesson(lesson)
                .words(words)
                .build();

        QuizWordsActivity quizWords = new QuizWordsActivity();
        quizWords.setActivity(activity);
        quizWords.setWords(words);

        activity.setQuizWordsActivity(quizWords);

        return dbService.saveActivity(activity);

    }

    public Activity createReviewActivity(ReviewActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        List<Word> words = wordRepository.findAllById(request.getWordIds());

        if (words.size() != request.getWordIds().size()) {
            throw new WordNotFoundException();
        }

        Activity activity = Activity.builder()
                .activityType(ActivityType.REVIEW)
                .order(request.getOrder())
                .lesson(lesson)
                .words(words)
                .build();

        ReviewActivity review = new ReviewActivity();
        review.setActivity(activity);
        review.setWords(words);

        activity.setReviewActivity(review);

        return dbService.saveActivity(activity);
    }

    public Activity createTextActivity(TextActivityCreateRequest request) throws LessonNotFoundException, TextNotFoundException {

        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        Text text = textRepository.findById(request.getTextId()).orElseThrow(TextNotFoundException::new);

        Activity activity = Activity.builder()
                .activityType(ActivityType.TEXT)
                .order(request.getOrder())
                .lesson(lesson)
                .build();

        TextActivity textActivity = new TextActivity();
        textActivity.setActivity(activity);
        textActivity.setText(text);

        activity.setTextActivity(textActivity);

        return dbService.saveActivity(activity);
    }

    public Activity createWordsActivity(WordsActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(LessonNotFoundException::new);
        List<Word> words = wordRepository.findAllById(request.getWordIds());

        if (words.size() != request.getWordIds().size()) {
            throw new WordNotFoundException();
        }

        Activity activity = Activity.builder()
                .activityType(ActivityType.WORDS)
                .order(request.getOrder())
                .lesson(lesson)
                .words(words)
                .build();

        WordsActivity wordsActivity = new WordsActivity();
        wordsActivity.setActivity(activity);
        wordsActivity.setWords(words);

        activity.setWordsActivity(wordsActivity);

        return dbService.saveActivity(activity);
    }

    public Activity getActivity(UUID id) throws ActivityNotFoundException {
        return dbService.getActivity(id).orElseThrow(ActivityNotFoundException::new);
    }

    public List<Activity> getActivities() {
        return dbService.getActivities();
    }

    public void deleteActivity(UUID id) {
        dbService.deleteActivity(id);
    }

}
