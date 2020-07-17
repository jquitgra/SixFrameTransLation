import java.util.Arrays;

public class Union{


    public static void main(String[] args){
        int[] a = {120, 34, 12, 75, 45};
        int[] b = {234, 546, 675, 75, 3};

        System.out.println(Arrays.toString(union(a, b)));
    }

    public static int[] union(int[] a, int[] b){
        int[] ret_ar = new int[a.length+b.length];
        int[] rb = new int[b.length+a.length];

        Arrays.sort(a);
        Arrays.sort(b);
        int counter = 0;
        int counter2 = 5;

        for(int i = 0; i<a.length; i++){
            ret_ar[counter] = a[i];
            counter++;
        }

        int l =0;
        while(l<5){
             rb[counter2] = b[l];
            counter2++;
            l++;
        }
        //System.out.println(Arrays.toString(rb));
       //System.out.println(Arrays.toString(ret_ar));
        for(int k=5; k<ret_ar.length; k++){
            boolean repeat = false;
            for(int k=5; j<rb.length; j++){
                if(ret_ar[k] == rb[j]){
                    repeat = true;
                }
                if(!repeat){
                    ret_ar[counter2] = rb[j];
                    counter2++;
                }
                
            }
        }
        //System.out.println(Arrays.toString(rb));
        return Arrays.copyOf(ret_ar, counter+counter2);

    }
}