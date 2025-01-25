package org.example.dsa;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/**Write a program to Find k closest elements to a given value

 Input: K = 4, X = 35

 arr[] = {12, 16, 22, 30, 35, 39, 42,

 45, 48, 50, 53, 55, 56}

 Output: 30 39 42 45
 **/

class NClosestElement {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        int[] arr = {12, 16, 22, 30, 35, 39, 42,45,48,50,53,55,56};
        int K=4;
        int[] res= new int[K];
        int n = arr.length;
        int X=49;

        int idx =  search(arr,0,n-1,X);
       // System.out.println(idx);
        if(idx==-1){
            System.out.println(-1);
            return;
        }
        int k=0;
        int l=idx-1;
        int r=idx+1;

        while(k<K){
           if(l>=0 && r<n) {
               if (arr[idx] - arr[l] <= arr[r] - arr[idx]) {
                   res[k++] = arr[l];
                   l--;
               } else if (arr[r] - arr[idx] <= arr[idx] - arr[l]) {
                   res[k++] = arr[r];
                   r++;
               }
           }
           else{
               if(l<=0){
                   res[k++]=arr[r++];
               }
               else {
                   res[k++]=arr[l--];
               }
           }

        }

        for(int i=0;i<K;i++){
            System.out.println(res[i]);
        }

    }

    public static int search(int[] arr, int l,int r, int X){
        if(X<arr[l] || X>arr[r]){
            return -1;
        }
        while(l<=r) {
            int mid = (l + r) / 2;
            if (arr[mid] == X) {
                return mid;
            } else if (X < arr[mid]) {
                r=mid-1;
            } else if (X > arr[mid]) {
                l=mid+1;
            }
        }

        return -1;
    }
}













