package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation_288 {
    /**
     https://leetcode.com/problems/unique-word-abbreviation/description/
     An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

     a) it                      --> it    (no abbreviation)

     1
     b) d|o|g                   --> d1g

     1    1  1
     1---5----0----5--8
     c) i|nternationalizatio|n  --> i18n

     1
     1---5----0
     d) l|ocalizatio|n          --> l10n
     Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

     Example:
     Given dictionary = [ "deer", "door", "cake", "card" ]

     isUnique("dear") -> false
     isUnique("cart") -> true
     isUnique("cane") -> false
     isUnique("make") -> true
     * */

    class ValidWordAbbr {

        Map<String, Integer> abbrevationCounter = new HashMap<String, Integer>();
        Map<String, Integer> dictionary = new HashMap<String, Integer>();

        private String getAbbreviation(String word) {
            if (word.length() <= 2) {
                return word;
            }
            return word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
        }

        public ValidWordAbbr(String[] dictionary) {
            Set<String> actualDictionary = new HashSet<String>();
            for(String d : dictionary) {
                actualDictionary.add(d);
            }
            for(String word : actualDictionary) {
                String abbr = getAbbreviation(word);
                Integer counter = abbrevationCounter.get(abbr) == null ? 0 : abbrevationCounter.get(abbr);
                counter++;
                abbrevationCounter.put(abbr, counter);
                counter = this.dictionary.get(word) == null ? 0 : this.dictionary.get(word);
                counter++;
                this.dictionary.put(word, counter);
            }
        }

        public boolean isUnique(String word) {
            String abbr = getAbbreviation(word);
            if (!dictionary.keySet().contains(word) && abbrevationCounter.get(abbr) == null) {
                return true;
            }
            if (dictionary.keySet().contains(word)
                    && abbrevationCounter.get(abbr) == 1
                    && dictionary.get(word) == 1) {
                return true;
            }
            return false;
        }
    }
}


/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
