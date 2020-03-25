package com.company;

public class Score{

    /*Contains one public method calculateScore that returns score of a sentence*/

    public double calculateScore (String sentence, int number) {
        // to calculate score of each sentence

        float avg = new TextProcessor().averageLength();
        double score = 0.0;
        int ctr = 0;
        int uCtr = 0;
        String[] words = sentence.split("\\s+");


        if (number == 1)
            score += 8;

        if (words.length >= avg)
            // if (no of words > avg no of words)

            score+=5;

        for (String word : words) {
            if (word.length() >= 6)
                // if word length >= 6

                ctr++;
        }
        score = score + (0.5*ctr);

        for (int i = 0; i < words.length-1; i++) {

            if (! (words[i].equals(words[i+1])) ) {
                uCtr++;
                // count  the number of unique words in a sentence
            }
        }

        if(uCtr >= 6)
            score += 1;

        for (String word : words) {
            if (Character.isDigit(word.charAt(0)))
                // if the sentence contains a numeric value

                score += 5;
            else if (word.charAt(0) == '\"' || word.charAt(word.length() - 1) == '\"')
                // if the sentence contains quotations

                score += 5;
        }

        for (int i = 1; i < words.length; i++) {
            if(Character.isUpperCase(words[i].charAt(0)))
                // if the sentence contains a proper noun or abbr

                score+=5;
        }

        return score;
    }
}