import java.util.ArrayList;
import java.util.Arrays;

public class Array {


    public static void swapArr (Object[] arr, int i, int j){
        Object s = arr[i];
        arr[i] = arr[j];
        arr[j] = s;
        System.out.println(Arrays.toString(arr));
    }

    public static <T> ArrayList<T> convert (T[] arr){
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        String[] s = {"1", "2", "3", "4", "5"};
        swapArr(s,0,1);
        swapArr(ints, 2, 3);
        convert(ints);
    }
}
