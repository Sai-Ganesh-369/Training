public class First{
    public static void main(String [] args){
        int a =40;
        int b =50;
        boolean result = a<5;
        System.out.println(result);  //test the boolean functionality

        byte c= 100;
        byte d= 30;
        int result1 =  c*d;
        System.out.println(result1);
           int result2= ++c;
           int result3 = d++;      // post and pre increment test case
        System.out.println(result2);
        System.out.println(result3);


        if(a > b && a>c){               // finding the biggest numbers in 3 numbers
            System.out.println(a + "is a bigger number than other two numbers ");
        }
        else if (b>c){
            System.out.println(b + "is the bigger number than other two numbers");
        }
        else
            System.out.println(c + "is the biggest number than the other numbers");



        String  result4= c%2==0 ? "even number" : "odd number";   // terirary operator
        System.out.println(result4);


        //switch case
        char n ='g';
        switch (n){
            case 'g':
            System.out.println("switch case");
        }
        



    }


        }
