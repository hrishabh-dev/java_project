
import java.util.*;

public class algo {
    static boolean solved=false;
    static int n;
    static int []arr={1,2,0,4,0,0,7,6};
    public static boolean poss(int n,int rows,int []arr){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==n){
                return false;
            }
        }
        return true;


    }
    public static void solve(){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0){
                for (int n=1;n<arr.length+1;n++){
                    if (poss(n, i, arr)==true){
                        arr[i]=n;
                        solve();
                        if (solved){
                            return;
                        }
                        arr[i]=0;

                    }
                }   return;
            }
        }solved=true;


    }

    public static void main(String[] args) {
        solve();
        if (solved){
            System.out.println(Arrays.toString(arr));
        }


        
    }
    
}
