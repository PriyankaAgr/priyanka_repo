package org.example.dsa;

import java.util.Arrays;

//char c[]={'H','E','L','L','O',' ',' ','W','O','R','L','D'}; 
// replace all space with "%20" without any inbuild function and without declaring any other string /variable.
public class StringReplace {

    public static void main(String[] args){
        char[] ch={'H','E','L','L','O',' ',' ','W','O','R','L','D', '\0','\0', '\0', '\0'};
       // char[] ch = {'H','E','L','L','O',' ',' ','W','O','R','L','D', '\0', '\0', '\0', '\0', '\0', '\0'};  // Extra space for %20 replacement


        replaceFn(ch, 12);
        System.out.print("{");
        for(char c : ch) {
            System.out.print(c);
        }
        System.out.print("}");


    }

    private static void replaceFn(char[] ch,int n) {
        
                int spaceCount = 0;
                for (char c : ch) {
                    if (c == ' ') {
                        spaceCount++;
                    }
                }

                // Calculate the new length of the array after replacement
                int newLength = n + spaceCount * 2;  // Each space requires two additional slots

                // Modify the array in place from the end
                int indexOriginal = n - 1;
                int indexNew = newLength - 1;

                while (indexOriginal >= 0) {
                    if (ch[indexOriginal] == ' ') {
                        ch[indexNew--] = '0';
                        ch[indexNew--] = '2';
                        ch[indexNew--] = '%';
                    } else {
                        ch[indexNew--] = ch[indexOriginal];
                    }
                    indexOriginal--;
                }

                // Print the modified array


    }
}
