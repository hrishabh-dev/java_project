
import java.util.Arrays;

public class permutation{
    public static void permute(int []arr,int start){
        if (start==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i=0;i<arr.length;i++){
            int temp=arr[start];
            arr[start]=arr[i];
            arr[i]=temp;
            permute(arr,start+1);

            temp=arr[start];
            arr[start]=arr[i];
            arr[i]=temp;
    
        }


    }


    public static void main(String[] args) {
        int [] arr={1,2,3,4};
        permute(arr,0);
        
    }
}