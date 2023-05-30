public class PassingVariables {
    public static void main(String[] args) {
      int result =  sumOfNumbers(1,2);
      int result2 = sumOfNumbers(5,6);
//      sumOfThreeNumbers(6,7 , 8);
        System.out.println(sumOfThreeNumbers(8,9 ,8));

      int a=5;
      int b = 6;
      int resultMal= multiplicationOfTwoNum(a,b);
       // System.out.println("a value is" + a);
        //System.out.println(resultMal);


        Stock aapl = new Stock("AAPL");
        System.out.println(aapl);
        aapl.marketCap = 100;
        //System.out.println(aapl + "check 1");
        //System.out.println(aapl.marketCap);
        Stock googl = new Stock("GOOGL");
        googl.marketCap=2000;

        stockAnalysis(aapl,googl);
        //System.out.println(aapl.marketCap);
        //System.out.println(aapl.tickerSymbol);

    }

    private static int sumOfThreeNumbers(int i, int i1, int i2) {

        int result = i + i1 + i2;
        return result;
    }



    private static void stockAnalysis(Stock stock1, Stock stock2) {
        System.out.println(stock1);
        stock1.marketCap= 400;
        stock1= new Stock("MSFT");
        System.out.println(stock1.marketCap);
    }

    private static int multiplicationOfTwoNum(int a, int b) {
         a=6;
        int mul = a*b;
        return mul;
    }


    private static int sumOfNumbers(int num1, int num2) {
        int sum = num1+num2;
        return sum;

    }
}
