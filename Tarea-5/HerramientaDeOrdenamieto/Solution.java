import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Data implements Comparable<Data> {
    int value, count, index;

    public Data(int value, int count, int index) {
        this.value = value;
        this.count = count;
        this.index = index;
    }

    public int compareTo(Data obj) {
        if (this.count != obj.count)
            return obj.count - this.count;
        return this.index - obj.index;
    }
}

public class Solution {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        Map<Integer, Data> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Data data = map.get(arr[i]);
            if (data == null)
                map.put(arr[i], new Data(arr[i], 1, i));
            else
                data.count++;
        }

        Data[] values = map.values().toArray(new Data[0]);
        Arrays.sort(values);

        int k = 0;
        for (Data data : values)
            for (int j = 0; j < data.count; j++) 
                arr[k++] = data.value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = scanner.nextInt();
        sort(numbers);
        String numbersFormatted = Arrays.toString(numbers)
            .replace(",", "")
            .replace("[", "")
            .replace("]", "")
            .trim();  
        System.out.println(numbersFormatted);
        scanner.close();
    }
}