package com.dockerforjavadevelopers.hello;

public class RotateArray { 
    final static int MAX_CHAR = 256;
  
    // Function to find if two strings are equal 
    static boolean isCountZero(int[] count) 
    { 
        for (int i = 0; i < MAX_CHAR; i++) 
            if (count[i] != 0) 
                return false; 
        return true; 
    } 
  
    static int countAnagrams(String text, String word) 
    { 
        int N = text.length(); 
        int n = word.length(); 
  
        // Check for first window. The idea is to 
        // use single count array to match counts 
        int[] count = new int[MAX_CHAR]; 
        for (int i = 0; i < n; i++) 
            count[word.charAt(i)]++; 
        for (int i = 0; i < n; i++) 
            count[text.charAt(i)]--; 
  
        // If first window itself is anagram 
        int res = 0; 
        if (isCountZero(count)) 
            res++; 
  
        for (int i = n; i < N; i++) { 
  
            // Add last character of current 
            // window 
            count[text.charAt(i)]--; 
  
            // Remove first character of previous 
            // window. 
            count[text.charAt(i - n)]++; 
  
            // If count array is 0, we found an 
            // anagram. 
            if (isCountZero(count)) 
                res++; 
        } 
        return res; 
    } 
    
    //quick sort
    static void sortBinaryArray(int a[], int n) 
    { 
        int j = -1; 
        for (int i = 0; i < n; i++) { 
  
            // if number is smaller than 1 
            // then swap it with j-th number 
            if (a[i] < 1) { 
                j++; 
                int temp = a[j]; 
                a[j] = a[i]; 
                a[i] = temp; 
            } 
        } 
    } 

    
    
  
    public static void main(String args[]) {
		
        String text = "forxxorfxdofr"; 
        String word = "for"; 
        System.out.println(countAnagrams(text, word));
        
        int a[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 
                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 }; 

    int n = a.length; 

    sortBinaryArray(a, n); 

    for (int i = 0; i < n; i++) 
        System.out.println(a[i] + " ");

}
   
} 
