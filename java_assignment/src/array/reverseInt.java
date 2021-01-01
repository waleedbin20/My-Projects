package array;
import java.util.Arrays;
public class reverseInt {
    public static void main(String[] args) {
        int[]array = {1,2,3,4};
        String re = Arrays.toString(reverseIntArr(array));
        System.out.println(re);

    }
    public static int[] reverseIntArr(int[] array){
        int[] result = new int[4];
        int j = array.length-1;
        for(int i=0; i<array.length; i++){
            result[i]= array[j];
            j--;
        }
        return result;
    }

}
