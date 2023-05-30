import java.util.Objects;

public class Stock {
    static String AAPL = "AAPL";
    int marketCap;
    String tickerSymbol;

    int closePrice;
     int openPrice;

    public Stock(String tickerSymbol) {

        this.tickerSymbol = tickerSymbol;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Stock stock = (Stock) that;
        return Objects.equals(tickerSymbol, stock.tickerSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickerSymbol);
    }

    boolean isMidCap() {
        System.out.println("Ticker symbol length: " + tickerSymbol.length());
        if (marketCap > 1000000) {
            System.out.println("is true");
            return true;

        }

        System.out.println("is false");
        return false;
    }

//    public String getTickerSymbol() {
//        return tickerSymbol;
//    }
}
