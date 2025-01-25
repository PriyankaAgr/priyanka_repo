package org.example.dsa;
//
/**
 You have a cube storeroom where the width , height , length of the room is n
 u r asked to place n boxes in the room where each box is the cube of unit side length
 there are however some rules to placing the boxes.
 u can place the box anywhere on the floor if box x is placed on top of the y
 then each side of the 4 vertical side of the box y must either be adjacent to
 another box or to a wall given an integer n , return the minimum possible number of boxes touching the floor.
 for example input 3 output 3 input 4 output 3
         **/

class Solution {
     public int longestDecomposition(String text) {
         int n = text.length();
         int left = 0, right = n - 1;
         int leftStart = 0, rightStart = n - 1;
         int segments = 0;

         while (left <= right) {
             // Increment pointers
             left++;
             right--;

             // Compare characters from both ends
             if (text.substring(leftStart, left).equals(text.substring(right + 1, rightStart + 1))) {
                 // If match found, increment segments count
                 segments += 2;
                 // Move to the next segments
                 leftStart = left;
                 rightStart = right;
             }
         }

         // Check if there's a middle segment that wasn't counted
         if (leftStart <= rightStart) {
             segments++;
         }

         return segments;
     }
 }