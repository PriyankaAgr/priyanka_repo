package org.example.dsa;

/**
Convert the given Number to a Code and vice-versa

A number can only be in the range of 1 to 190. A number can be transformed to code "xy" such that x is in range [A, S] and y is in range [0,9] and is in increasing order.
For example:

        | Number |  Code  |
        | 1      |  A0    |
        | 2      |  A1    |
        | 11     |  B0    |
        | 100    |  J9    |
        | 190    |  S9    |
Implement function to get Code with given number
f(100) = "J9"

Implement function to get number with given code
f("J9") = 100
**/
public class DecodeString {

    public static void main(String[] args) {
        int x = 106;
String str = "R9";
        System.out.println(code(x));
        System.out.println(decode(str));




    }

    public static String code(int x){

        int r=x%10;
        int q=x/10;
        char ch;
        if(r==0){
            r=9;
            ch= (char) (q+65-1);
        }
        else{
            r=r-1;
            ch=(char)(q+65);

        }
        return ch + "" + r;


    }

    public static int decode(String s){

        char ch1 = s.charAt(0);
        char ch2 = s.charAt(1);

        int x = ch1-65;
        int y = ch2-'0';
        y=(y+1)%10;
        if(y==0){
            x=x+1;
        }



        return Integer.parseInt(x+""+y);


    }



}
