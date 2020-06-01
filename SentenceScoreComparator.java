package com.company;

public class SentenceScoreComparator {

    /*  1: Consider only first statement
        2: Consider only second statement
        3: Consider both first and second
       -1: Do not consider any statement
     */

    int compare (Sentence first, Sentence second) {
        if (first.score < 5.0 && second.score < 5.0)
            return -1;
        else if (first.score > 8.0 && second.score > 8.0)
            return 3;
        else if (first.score > second.score)
            return 1;
        else if (first.score < second.score)
            return 2;
        return 0;
    }
}