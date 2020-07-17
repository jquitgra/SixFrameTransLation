import java.util.*;
class Problem1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int val = s.nextInt();

        if(val == 1){
            System.out.println("-1");
        }
        else{
            System.out.println(val + " " + val);
        }
    }
}