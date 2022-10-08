package com.company.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* package whatever; // don't place package name! */

class levenstein {

    /**
     * Calculates the similarity (a number within 0 and 1) between two strings.
     */
    public static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
        /* // If you have StringUtils, you can use it to calculate the edit distance:
        return (longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) /
                                                             (double) longerLength; */
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

    }
    
    // Example implementation of the Levenshtein Edit Distance
    // See http://r...content-available-to-author-only...e.org/wiki/Levenshtein_distance#Java
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }

    public static void printSimilarity(String s, String t) {
        System.out.println(String.format(
            "%.3f is the levenshtein distance similarity between \"%s\" and \"%s\"", similarity(s, t), s, t));
    }
    
   /* public static void printSim(HashSet<String> set, HashSet<String> set2) {
    	System.out.println(String.format(
    	"%.3f is the similarity between \"%s\" and \"%s\"", sim(set, set2), set, set2));
    	}*/
    
    public static double jaro_distance(String s1, String s2) 
    { 
        // If the Strings are equal 
        if (s1 == s2) 
            return 1.0; 
      
        // Length of two Strings 
        int len1 = s1.length(), 
            len2 = s2.length(); 
      
        // Maximum distance upto which matching 
        // is allowed 
        int max_dist = (int) (Math.floor(Math.max(len1, len2) / 2) - 1); 
      
        // Count of matches 
        int match = 0; 
      
        // Hash for matches 
        int hash_s1[] = new int[s1.length()]; 
        int hash_s2[] = new int[s2.length()]; 
      
        // Traverse through the first String 
        for (int i = 0; i < len1; i++)  
        { 
      
            // Check if there is any matches 
            for (int j = Math.max(0, i - max_dist); 
                j < Math.min(len2, i + max_dist + 1); j++) 
      
                // If there is a match 
                if (s1.charAt(i) == s2.charAt(j) && hash_s2[j] == 0)  
                { 
                    hash_s1[i] = 1; 
                    hash_s2[j] = 1; 
                    match++; 
                    break; 
                } 
        } 
      
        // If there is no match 
        if (match == 0) 
            return 0.0; 
      
        // Number of transpositions 
        double t = 0; 
      
        int point = 0; 
      
        // Count number of occurances 
        // where two characters match but 
        // there is a third matched character 
        // in between the indices 
        for (int i = 0; i < len1; i++) 
            if (hash_s1[i] == 1) 
            { 
      
                // Find the next matched character 
                // in second String 
                while (hash_s2[point] == 0) 
                    point++; 
      
                if (s1.charAt(i) != s2.charAt(point++) ) 
                    t++; 
            } 
      
        t /= 2; 
      
        // Return the Jaro Similarity 
        return (((double)match) / ((double)len1) 
                + ((double)match) / ((double)len2) 
                + ((double)match - t) / ((double)match)) 
            / 3.0; 
    } 

    
    public static double jaro_Winkler(String s1, String s2)  
    {  
        double jaro_dist = jaro_distance(s1, s2);  
      
        // If the jaro Similarity is above a threshold  
        if (jaro_dist > 0.7) 
        {  
      
            // Find the length of common prefix  
            int prefix = 0;  
      
            for (int i = 0;  
                i < Math.min(s1.length(), s2.length()); i++)  
            {  
                  
                // If the characters match  
                if (s1.charAt(i) == s2.charAt(i))  
                    prefix++;  
      
                // Else break  
                else
                    break;  
            }  
      
            // Maximum of 4 characters are allowed in prefix  
            prefix = Math.min(4, prefix);  
      
            // Calculate jaro winkler Similarity  
            jaro_dist += 0.1 * prefix * (1 - jaro_dist);  
        }  
        return jaro_dist;  
    }
    
    public static double diceCoefficientOptimized(String s, String t)
    {
    	// Verifying the input:
    	if (s == null || t == null)
    		return 0;
    	// Quick check to catch identical objects:
    	if (s == t)
    		return 1;
            // avoid exception for single character searches
            if (s.length() < 2 || t.length() < 2)
                return 0;

    	// Create the bigrams for string s:
    	final int n = s.length()-1;
    	final int[] sPairs = new int[n];
    	for (int i = 0; i <= n; i++)
    		if (i == 0)
    			sPairs[i] = s.charAt(i) << 16;
    		else if (i == n)
    			sPairs[i-1] |= s.charAt(i);
    		else
    			sPairs[i] = (sPairs[i-1] |= s.charAt(i)) << 16;

    	// Create the bigrams for string t:
    	final int m = t.length()-1;
    	final int[] tPairs = new int[m];
    	for (int i = 0; i <= m; i++)
    		if (i == 0)
    			tPairs[i] = t.charAt(i) << 16;
    		else if (i == m)
    			tPairs[i-1] |= t.charAt(i);
    		else
    			tPairs[i] = (tPairs[i-1] |= t.charAt(i)) << 16;

    	// Sort the bigram lists:
    	Arrays.sort(sPairs);
    	Arrays.sort(tPairs);

    	// Count the matches:
    	int matches = 0, i = 0, j = 0;
    	while (i < n && j < m)
    	{
    		if (sPairs[i] == tPairs[j])
    		{
    			matches += 2;
    			i++;
    			j++;
    		}
    		else if (sPairs[i] < tPairs[j])
    			i++;
    		else
    			j++;
    	}
    	return (double)matches/(n+m);
    }
    
    public static String longestCommonSubstring(String S1, String S2)
    {
        int Start = 0;
        int Max = 0;
        
        for (int i = 0; i < S1.length(); i++)
        {
            for (int j = 0; j < S2.length(); j++)
            {
                int x = 0;
                while (S1.charAt(i + x) == S2.charAt(j + x))
                {
                    x++;
                    if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
                }
                if (x > Max)
                {
                    Max = x;
                    Start = i;
                    //end = i-1;
                }
             }
        }
        return S1.substring(Start, (Start + Max));
        
    }
    //--------------------------------------------------------------------
    
    public static int longestSubstr(String first, String second) {     
        int maxLen = 0;
        int fl = first.length();
        int sl = second.length();
        int[][] table = new int[fl+1][sl+1];
     
        for (int i = 1; i <= fl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    if (table[i][j] > maxLen)
                        maxLen = table[i][j];
                }
            }
        }
        return maxLen;
    }
    
    //---------------------------------------------------------------------------
    public static void main(String[] args) {
    	HashSet<String> set=new HashSet<String>();
    	set.add("One");
    	set.add("Two");
    	set.add("Three");
    	String s1 = set.toString();
    	Iterator<String> i=set.iterator();  
        while(i.hasNext())  
        {  
        System.out.println(i.next());  
        }  
    	//---------------------------------------------------------------------------------
        HashSet<String> set2 =new HashSet<String>();
    	set2.add("six");
    	set2.add("seven");
    	set2.add("eight");
    	String s2 = set2.toString();
    	Iterator<String> j=set2.iterator();  
        while(j.hasNext())  
        {  
        System.out.println(j.next());  
        }  
        //--------------------------------------------------------------------------------
        
        //HashSets for Integers
        HashSet<Integer> num1 = new HashSet<Integer>();
        num1.add(50);
        num1.add(50);
        num1.add(50);
        num1.add(0);
        num1.add(0);
        num1.add(0);
        num1.add(0);
        num1.add(0);
        num1.add(0);
        num1.add(0);
        String s3 = num1.toString();
        System.out.println(s3);
        //----------------------------------------------------------------------------------------
        HashSet<Integer> num2 = new HashSet<Integer>();
        num2.add(3);
        num2.add(1);
        //num2.add("0343128");
        num2.add(2);
        num2.add(0);
        num2.add(0);
        num2.add(0);
        num2.add(32);
        num2.add(0);
        num2.add(0);
        num2.add(32);
        num2.add(0);
        num2.add(0);
        num2.add(0);
        String s4 = num2.toString();
        System.out.println(s4);
        
        //----------------------------------------------------------------------------------------
        
        ArrayList<Integer> ar1 = new ArrayList<Integer>(); 

        ar1.add(50);
        ar1.add(50);
        ar1.add(50);
        ar1.add(0);
        ar1.add(0);
        ar1.add(0);
        ar1.add(0);
        ar1.add(0);
        ar1.add(0);
        ar1.add(0);

        //displaying elements
        System.out.println(ar1);
        String s5 = ar1.toString();
        
        
        
        //----------------------------------------------------------------------------------------
        
        ArrayList<Integer> ar2 = new ArrayList<Integer>(); 

        ar2.add(3);
        ar2.add(1);
        ar2.add(128);
        ar2.add(2);
        ar2.add(0);
        ar2.add(0);
        ar2.add(0);
        ar2.add(32);
        ar2.add(0);
        ar2.add(0);
        ar2.add(32);
        ar2.add(0);
        ar2.add(0);
        ar2.add(0);
        //displaying elements
        System.out.println(ar2 + "\n");
        String s6 = ar2.toString();
        System.out.println("=======================================================================================");
        
        
        //----------------------------------------------------------------------------------------
        System.out.println("The jaro_distance between two strings is " + jaro_distance(s5,s6) + "\n");
        System.out.println("The jaro_Winkler distance between two strings is " + jaro_Winkler(s5,s6) + "\n");
        System.out.println("The levenstein distance between two strings is 0.609 \n"); 
        System.out.println("The Sorensen-Dice coefficient between two strings is " + diceCoefficientOptimized(s5,s6) + "\n");
        System.out.println("The longest commom substring between two strings is " + longestCommonSubstring(s3,s4) + " and the length is " + longestSubstr(s3,s4));
  
        System.out.println("=======================================================================================");
        printSimilarity(s5,s6);
        printSimilarity("", "");
        printSimilarity(s1,s2);
        printSimilarity(s3,s4);
        printSimilarity("1234567890", "1");
        printSimilarity("1234567890", "123");
        printSimilarity("1234567890", "1234567");
        printSimilarity("1234567890", "1234567890");
        printSimilarity("1234567890", "1234567980");
      /*  printSimilarity("47/2010", "472010");
        printSimilarity("47/2010", "472011");
        printSimilarity("47/2010", "AB.CDEF");
        printSimilarity("47/2010", "4B.CDEFG");
        printSimilarity("47/2010", "AB.CDEFG");
        printSimilarity("The quick fox jumped", "The fox jumped");
        printSimilarity("The quick fox jumped", "The fox");
        printSimilarity("The quick fox jumped", "The quick fox jumped off the balcany");
        printSimilarity("kitten", "sitting");*/
    }

}