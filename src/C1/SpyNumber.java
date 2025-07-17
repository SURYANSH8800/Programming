package C1;
import java.util.Scanner;
public class SpyNumber{
    public static boolean spynumber(){
        int num, sum= 0, multi=1;
        Scanner sc = new Scanner(System.in);
        num =sc.nextInt();
        while(num>0){
            int rem = num%10;
            sum=sum+rem;
            multi = multi*rem;
            num = num/10;
        }
        if(sum==multi){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        boolean ans = spynumber();
        System.out.println(ans);
    }
}
