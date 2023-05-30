public class ControlFlow {
    public static void main(String[] args) {
        int i = 2;
        boolean bool = i %2 ==0;
        if(bool){
            System.out.println(i + "is a Even Number");
        }
        else {
            System.out.println(i + "  is an odd Number");
        }
        if (i>=0 && i%2==0){
            System.out.println(i+" is a positive and even Number ");
        }
        if (i>=0 || i%2==0) {
            System.out.println(i + " is a positive or even Number ");
        }
        if((i==1 || i==2)&&(i==3 ||i ==5)){
            System.out.println("wrong");
        }
         String s = i%2==0 ? "even":"odd"; //Turnory operator
        System.out.println(s);


        investStock("AAPL");
    }

    private static void investStock(String stock) {
        switch(stock){
            case "AAPL" -> System.out.println("buy");
            case "tsla" -> System.out.println("sell");
            default -> System.out.println("buy any of it");
        }
        switch(stock){
            case"AAPL":
                System.out.println("buy this one");
                break;
            case"TSLA" :
                System.out.println("buy this one");

        }
            String stock1 = "TSLA";
        switch(stock1) {
            case "AAPL":
                System.out.println("buy this one");
                break;
            case "TSLA":
                System.out.println("buy this one" + stock1);
        }
        String stock2 = stock1=="TSLA"? "BUY" : "SELL";

        int[] intArray = {1,2,3,45,6};
        int index = 0;
        while(index<intArray.length){
            System.out.println("this is the element i n  the length " + intArray[index]);
            index++;
        }


//        break

        elementExist(intArray, 7);

//        continue
        processEvenNumber(intArray);

//        do while
        index =4;
        do{
            System.out.println(index);
        }while (false);


//        Checking equality

        int i = 100;
        int j =100;
        if(i == j ){
            System.out.println("both numbers are same");
        }
        Stock aapl1 = new Stock("AAPL");
        Stock aapl2 = new Stock("AAPL");
        if(aapl1.equals(aapl2)){
            System.out.println("stock objects are equal, using equal method()");
        }

//        if(aapl1 == aapl2){
//            System.out.println("both stocks are same");
//        }
        if(!aapl1.equals("AAPL")){ //both obj are differnt class
            System.out.println("checking not equals method");

            if(!aapl1.equals(null)){
                System.out.println("checking of null");
            }


        }


//            break


        }

    private static void processEvenNumber(int[] intArray) {
        for (int element : intArray){
            if (element%2 != 0){
                continue;
            }
            System.out.println("do some processimg");
        }
    }

    private static boolean elementExistwithReturn(int[] intArray, int searchElement) {
        for (int element : intArray) {
            if (element == searchElement) {
                return true;
            }
        }
        return false;
    }


    private static boolean elementExist (int[] intArray, int searchElement) {
        boolean result = false;
        for (int element : intArray) {
            if (element == searchElement){
                result = true;
                break;
            }
        }
        return result;
    }
}




