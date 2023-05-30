public class ArrayOFObjects {




    public static void main(String[] args) {


        Stock s1 = new Stock("AAPL");

        s1.marketCap = 1000;
        Stock s2 = new Stock("GOOGL");
        s2.marketCap = 2000;

        Stock s3 = new Stock("MSFT");
        s3.marketCap = 3000;

        Stock[] arrayOfObjects = {s1, s2, s3};
        addingOfMarketcap(arrayOfObjects);

        s1.isMidCap();
        System.out.println(s1.isMidCap());

    }

    private static int addingOfMarketcap(Stock[] arrayOfObjects) {
        int sum1 = 0;
        for (int i = 0; i < arrayOfObjects.length; i++) {
            sum1 = sum1 + arrayOfObjects[i].marketCap;
        }
        System.out.println("normal for loop result  is : " + sum1);
//        by using for each loop
            int sum2 = 0;
        for (Stock i : arrayOfObjects) {
            sum2 = i.marketCap;
            sum2 = sum2 + i.marketCap;
//            sum = sum +
//            System.out.println(sum2);
//            System.out.println("for each result : " + sum2);
        }
        System.out.println("for each result : " + sum2);

        return sum2;


//    }
    }
}