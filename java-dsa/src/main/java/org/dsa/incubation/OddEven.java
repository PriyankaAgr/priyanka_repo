package org.dsa.incubation;


/**
 *
 * segregate even and odd numbers in an array without using extra space while maintaining their relative order,
 * int[] arr={1,25,6,0,23,9,10,28,8}
 * output:=6,0,10,28,8,1,25,23,9
 */
public class OddEven {

    public static void main(String[] args) {
         int[] arr={1,25,6,0,23,9,10,28,8};
         int n = arr.length;
         sortArr(arr,0,n);
         for(int i : arr) System.out.print(i+",");

    }

    public static void sortArr(int[] arr, int st, int n){

        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                int tmp = arr[i];
                for(int j=i;j>st;j--){
                    arr[j]=arr[j-1];
                }
                arr[st++]=tmp;
            }
        }

    }
}
