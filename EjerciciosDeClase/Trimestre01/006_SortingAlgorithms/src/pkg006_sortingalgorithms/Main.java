/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg006_sortingalgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Diurno
 *
 */
public class Main {

    static Random random = new Random();

    public static void main(String[] args) {

        int[] unsortedArray;
        int[] array;
        double time;

        System.out.println("Sorting Algorithms\n");

        unsortedArray = new int[50_000];
        fillArray(unsortedArray);
        array = unsortedArray.clone();

        System.out.println("·BUBBLE SORT·");
        time = System.nanoTime();
        bubblesort(array);
        time = System.nanoTime() - time;
        System.out.printf("Tiempo empleado: %.4f milisegundos \n", time / 1_000_000);

        array = unsortedArray.clone();
        System.out.println("\n·QUICK SORT·");
        time = System.nanoTime();
        quicksort(array);
        time = System.nanoTime() - time;
        System.out.printf("Tiempo empleado: %.4f milisegundos \n", time / 1_000_000);

        array = unsortedArray.clone();
        System.out.println("\n·HEAP SORT·");
        time = System.nanoTime();
        HeapSort.sort(array);
        time = System.nanoTime() - time;
        System.out.printf("Tiempo empleado: %.4f milisegundos \n", time / 1_000_000);

        array = unsortedArray.clone();
        System.out.println("\n·MERGE SORT·");
        time = System.nanoTime();
        mergeSort(array);
        time = System.nanoTime() - time;
        System.out.printf("Tiempo empleado: %.4f milisegundos", time / 1_000_000);
    }

    // 1 · Bubble Sort
    static void bubblesort(int[] arr) {
        int swaps;
        int temp;

        do {								// Recorreremos el array las veces necesarias
            swaps = 0;							// hasta que no se haga ningún cambio
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {				// Si el número a la derecha del índice actual
                    temp = arr[i + 1];					// es mayor al número del índice i
                    arr[i + 1] = arr[i];				// intercambiamos posiciones
                    arr[i] = temp;
                    swaps++;						// Repetimos hasta que no se haga ningún cambio
                }							// entonces el array estará ordenado
            }

        } while (swaps > 0);
    }

    // 2 · Quick Sort
    static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

//	1 Choose pivot
        int pivotIndex = ThreadLocalRandom.current().nextInt(lowIndex, highIndex);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

// 	2 Partition
// 	Todos los elementos mayores al pivote quedarán a su derecha
// 	y todos los más pequeños quedarán a su izquierda.
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
//          Move left pointer until it finds a value greater than pivot
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
//          Move right Pointer until it finds a value lower than pivot
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);

//	Recursión
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    static void bogosort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            int i = 0;
            while (i < array.length - 1 && sorted) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                }
                i++;
            }
            i = 0;
            while (i < array.length && !sorted) {
                swap(array, i, random.nextInt(array.length));

                i++;
            }
        }
    }

    // 3 · Merge Sort
    static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    // Método para rellenar array con números aleatorios
    static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
    }

}
