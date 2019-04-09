package me.Miic.SpringWebTest.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HelloWorldController {

    //Step 1: baby step
    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

    //Step 2: lets see if we can do minor processing
    @RequestMapping("/byteify")
    public String byteify(@RequestParam(value = "input") String input) {
        return Arrays.toString(input.getBytes());
    }

    //Step 3: String manipulation into actual data
    @RequestMapping("/quicksort")
    public String quicksortify(@RequestParam(value = "array") String array) {
        String[] items = array.split(",");
        int[] parsed = new int[items.length];

        for(int i = 0; i < parsed.length; i++) {
            parsed[i] = Integer.parseInt(items[i]);
        }

        quickSort(parsed, 0, parsed.length - 1);

        return Arrays.toString(parsed);
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
        array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    public int partition (int arr[], int low, int high)
    {
        int pivot = arr[high];    // pivot
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high- 1; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;    // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
     arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int hold = array[a];
        array[a] = array[b];
        array[b] = hold;
    }

    @RequestMapping("/fib")
    public String fib(@RequestParam(value = "n") String number) {
        int n = Integer.parseInt(number);
        return fibonacci(n) + "";
    }

    /*
    Recursive fibonacci function. Calculates the Nth place of the fibonacci formula
     */
    private static int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
