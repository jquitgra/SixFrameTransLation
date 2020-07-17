//Pre-formating pasting in VSCode
import java.util.Arrays;

public class diffSet{

    public static void main(String[] args){
        int[] a1 = {12, 23, 43, 54,6,  7, 78, 8};
        int[] a2 = {23, 54, 76,879, 98, 12};
        System.out.println(Arrays.toString(diffSet(a1, a2)));
        System.out.println(Arrays.toString(intersection(a1, a2)));
    }

    public static int[] diffSet(int[] a1, int[] a2){
        int[] ar = new int[a1.length+a2.length];
        int counter = 0;
        for(int i = 0; i<a1.length; i++){
            boolean repeated = false;
            for(int j=0; j<a2.length; j++){
                if(a1[i] == a2[j]){
                    repeated = true;
                }
            }
            if(!repeated){
                ar[counter] = a1[i];
                counter++;
            }
            
        }
        return Arrays.copyOf(ar, counter);
    }

    public static int[] intersection(int[] a, int[] b){
        int[] ar = new int[a.length+b.length];
        int counter = 0;
        for(int i =0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                if(a[i] == b[j]){
                    ar[counter] = a[i];
                    counter++;
                }
            }
        }
        return Arrays.copyOf(ar, counter);
    }
}