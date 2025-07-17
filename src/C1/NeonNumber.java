package C1;
import java.util.Scanner;
public class NeonNumber {
    public static boolean NeonNumber(int number){
        int sum = 0,d,n1;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        n1=number*number;
        while(n1>0){
            d = n1%10;
            sum = sum+d;
            n1 = n1/10;
        }
        if(sum==number){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int number = 0;
        boolean ans = NeonNumber(number);
        System.out.println(ans);
    }
}
