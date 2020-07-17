import java.util.Random;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Prog29_03{

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 2, 1, 6, 8, 7, 9, 12};
        System.out.println(Arrays.toString(Prog29_03.HeapSort(arr)));
    }

    public static int[] HeapSort(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        int[] output = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            output[i] = pq.peek();
            pq.remove();
        }
        return output;
    }
}