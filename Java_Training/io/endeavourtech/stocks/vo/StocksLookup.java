package io.endeavourtech.stocks.vo;

public class StocksLookup {
    private  String tickerSymbol;
    private String tickerName;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    @Override
    public String toString() {
        return "StocksLookup{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", tickerName='" + tickerName + '\'' +
                '}';
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }
}



