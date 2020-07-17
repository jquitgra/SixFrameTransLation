import java.util.Scanner;

final class Problem2{
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int r = s.nextInt();
        long n;
        long k;
        for(int i = 0; i < r; i++){
            n = s.nextLong();
            k = s.nextLong();

            if(n == k){
                System.out.println("1");
                continue;
            }

            long nFac = 1;
            long kFac = 1;
            long nMkFac = n - k - 2;

            for(int j = 2; j < n; j++){
                nFac = nFac * j;

                if(j == k - 1){
                    kFac = nFac;
                }
                if(j == nMkFac){
                    nMkFac = nFac;
                }
            }

            System.out.println(nFac/(kFac * nMkFac));
        }

    }
}