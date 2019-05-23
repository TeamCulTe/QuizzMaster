package com.imie.a2dev.teamculte.quizzmaster.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class used to test the associated entity.
 */
public final class QuestionTest {
    /**
     * Stores the tested entity.
     */
    private Question question;

    @Before
    public void setUp() throws Exception {
        this.question = new Question();
    }

    @Test
    public void testGetCorrectAnswer() {
        String valuePrefix = "value";
        Answer[] answers = new Answer[Question.ANSWER_NB];
        int correctAnswerIndex = 1;

        for (int i = 0; i < Question.ANSWER_NB; i++) {
            answers[i] = new Answer(valuePrefix + String.valueOf(i));
        }

        this.question.setAnswers(answers);
        this.question.setCorrectAnswerIndex(correctAnswerIndex);

        assertEquals(answers[correctAnswerIndex], this.question.getCorrectAnswer());
    }
}
