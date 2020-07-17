public class codeFrag{

    public static void main(String[] args){
        int[] a = {1, 23, 43, 5, 65, 78};
        System.out.println(finding(a, 777));
    }

    public static boolean finding(int[] a, int e){
        boolean found = false;
        for(int i=0; i<a.length; i++){
            if(a[i] == e){
                found = true;
            }
        }
        return found;
    }

}