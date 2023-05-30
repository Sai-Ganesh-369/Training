package io.endeavourtech.stocks.vo;

import java.util.Comparator;

public class TickerSymbolAsc implements Comparator<StockFundamentals> {
    @Override
    public int compare(StockFundamentals o1, StockFundamentals o2) {
        return o1.getTickerSymbol().compareTo(o2.getTickerSymbol());
    }
}
