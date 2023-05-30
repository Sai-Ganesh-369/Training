package io.endeavourtech.stocks.vo;

import java.util.Comparator;

public class TickerSymbolDsc implements Comparator<StockFundamentals> {
    @Override
    public int compare(StockFundamentals o1, StockFundamentals o2) {
        return o2.getTickerSymbol().compareTo(o1.getTickerSymbol());
    }
}
