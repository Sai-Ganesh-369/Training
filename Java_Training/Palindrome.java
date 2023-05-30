import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the any string that you want to check:");
        String str = sc.next();
        String org_str = str;

        String rev = "";
        int len = str.length();
        for (int i =len-1; i>=0; i--){
            rev = rev+str.charAt(i);
        }
        if(org_str== rev){
            System.out.println(org_str + "is a PALINDROME");
        }
        else{
            System.out.println(org_str + " is not a PALINDROME");
        }
    }
}
