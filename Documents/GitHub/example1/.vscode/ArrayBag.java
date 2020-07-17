import java.util.Arrays;

public class ArrayBag<T>
{
    private int length;
    private T[] bag;
    private int size;

    public ArrayBag(){
        size = 10;
        bag = (T[]) new Object[size];
        length = 0;
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public void add(T item)
    {
        if(length == size){
            bag = Arrays.copyOf(bag, 2*size);
        }

        bag [length++] = item;
    }

    public void remove(T item)
    {
        for(int i = 0; i<length; i++)
        {
            if(bag[i].equals(item)){
                bag[i] = bag[--length];
                break;
            }
        }
    }

    public int count(T item)
    {
        int ctr = 0;
        for(int i = 0; i<length; i++){
            if(bag[i].equals(item)) ctr++;
        }

        return ctr;
    }

    public String toString(){
        String str = "";

        for(int i=0; i<length; i++){
            str += bag[i] + " ";
        }

        return str;
    }
}