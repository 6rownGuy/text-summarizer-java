package com.company;

import java.text.BreakIterator;
import java.util.ArrayList;

public class TextProcessor extends Score {

    public ArrayList<Paragraph> paragraphs = new ArrayList<>();
    public ArrayList<Sentence> sentences = new ArrayList<>();
    public ArrayList<Sentence> arrangedSentences = new ArrayList<>();
    public String[] paragraphArray;

    public void setSentences(String text) {
        paragraphArray = text.split("\\n\\n\\n");

        for (int i = 0; i < paragraphArray.length; i++) {

            BreakIterator iterator = BreakIterator.getSentenceInstance();
            String source = paragraphArray[i];
            iterator.setText(source);
            int start = iterator.first();
            paragraphArray[i] = "";

            int sentenceCounter = 0;
            for (int end = iterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = iterator.next()) {
                sentenceCounter++;
                sentences.add(new Sentence(i+1, sentenceCounter, calculateScore(source.substring(start, end),sentenceCounter), source.substring(start, end)));
            }
        }
    }

    public void setParagraphs(String text) {

        paragraphArray = text.split("\\n\\n\\n");
        for (int i = 0; i < paragraphArray.length; i++) {
            paragraphs.add(new Paragraph(i+1, sentences));
        }
    }

    public void selectSentences () {

        for (int i = 0; i < sentences.size()-1; i+=2) {
            switch (new SentenceScoreComparator().compare(sentences.get(i), sentences.get(i+1))) {
                case 1:
                    arrangedSentences.add(sentences.get(i));
                    break;
                case 2:
                    arrangedSentences.add(sentences.get(i+1));
                    break;
                case 3:
                    arrangedSentences.add(sentences.get(i));
                    arrangedSentences.add(sentences.get(i+1));
                    break;
                case -1:
                    break;
            }
        }
    }

    public void display(String text) {
        setParagraphs(text);
        setSentences(text);

        //float x = averageLength();
        //System.out.println(x);
        //System.out.println(paragraphs.get(2).sentences.get(1).sentence);
        displaySummary();
    }

    public void displaySummary () {
        selectSentences();

        for (Sentence arrangedSentence : arrangedSentences) {
            System.out.println(arrangedSentence.sentence);
        }
    }

    public float averageLength () {
        int[] size = new int[sentences.size()];
        int avgSum = 0;

        for (int i = 0; i < sentences.size(); i++) {

            String[] words = sentences.get(i).sentence.split("\\s+");
            size[i] = words.length;
        }

        for (int i = 0; i < sentences.size(); i++) {

            avgSum = avgSum + size[i];
        }
        return avgSum / (float) sentences.size();
    }
}