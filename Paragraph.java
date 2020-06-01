package com.company;

import java.util.ArrayList;

public class Paragraph {

    /*  1. All the paragraphs in the text must be objects of this class.
        2. 'number' indicates the paragraph number.
        3. 'sentences' contains all the sentences in that paragraph.
    */

    int number;
    ArrayList<Sentence> sentences;

    public Paragraph() {
        this (0, null);
    }

    public Paragraph(int number, ArrayList<Sentence> sentences) {
        this.number = number;
        this.sentences = sentences;
    }
    public void setParagraphs(String text) {
        //to be overloaded
    }

    public int countParagraphs (String text) {
        return 0;
        //to be overloaded
    }
}