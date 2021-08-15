package com.company;

import java.util.Collections;
import java.util.Scanner;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        int n = input.nextInt();
        input.close();

        getSortedArrays(n);
    }

    public static int[][] getSortedArrays(int n) {
        int[][] arrays = new int[n][];

        Integer[] sizes = new Integer[n + 1];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(sizes));

        for (int i = 0; i < n; i++) {
            int size = sizes[i];
            arrays[i] = new int[size];

            for (int j = 0; j < size; j++) {
                int base = (int) (Math.random() * 10);
                arrays[i][j] = base;

            }

            System.out.println(Arrays.toString(arrays[i]));
        }

        System.out.println("Sorted");

        for (int i = 0; i < arrays.length; i++) {
            if(i % 2 == 0) {
                // четное
                arrays[i] = selectionSortAsc(arrays[i]);
            } else {
                // нечетное
                arrays[i] = selectionSortDesc(arrays[i]);
            }

            System.out.println(Arrays.toString(arrays[i]));
        }

        return arrays;
    }

    private static int[] selectionSortAsc(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;

            for (int j = i+1; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }

        return arr;
    }

    private static int[] selectionSortDesc(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int max_i = i;

            for (int j = i+1; j < arr.length; j++) {

                if (arr[j] > max) {
                    max = arr[j];
                    max_i = j;
                }
            }

            if (i != max_i) {
                int tmp = arr[i];
                arr[i] = arr[max_i];
                arr[max_i] = tmp;
            }
        }

        return arr;
    }
}

