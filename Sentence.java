package com.company;

public class Sentence {

    /*  1. All the sentences in a paragraph must be objects of this class.
        2. 'paragraphNumber' indicates the paragraph that the sentence belongs to.
        3. 'number' indicates the serial of a sentence in a paragraph.
        4. 'score' indicates the score of a sentence.
        5. 'sentence' contains the sentence string.
    */

    int paragraphNumber;
    int number;
    double score;
    String sentence;

    public Sentence(int paragraphNumber, int number, double score, String sentence) {       //parametrized constructor
        this.paragraphNumber = paragraphNumber;
        this.number = number;
        this.score = score;
        this.sentence = sentence;
    }
}