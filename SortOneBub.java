package org.example;

public class SortOneBub {
    //Put the data structure here.

    static void BubbleSort(int arr[],int n) {
        int i, j, temp;
        boolean swapped = false;

        //
        for (i = 0; i < n - 1; i++) {

            for (j = 0; j < n - 1 - i; j++) {
                //Swapping numbers
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    swapped = true; //Check if the values were swapped
                }
            }
            /* If there was no swap, stop sorting */
            if (swapped == false) {
                break;
            }
        }
     }
    }