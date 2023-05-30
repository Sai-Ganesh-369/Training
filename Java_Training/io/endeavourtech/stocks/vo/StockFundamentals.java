package io.endeavourtech.stocks.vo;

import java.math.BigDecimal;

public class StockFundamentals implements  Comparable<StockFundamentals>{
 private String tickerSymbol;

    @Override
    public String toString() {
        return "StockFundamentals{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", sectorId=" + sectorId +
                ", subSectorId=" + subSectorId +
                ", marketCap=" + marketCap +
                ", cureentRatio=" + cureentRatio +
                '}';
    }

    private int sectorId;
 private int subSectorId;
 private BigDecimal marketCap;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public int getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(int subSectorId) {
        this.subSectorId = subSectorId;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public BigDecimal getCureentRatio() {
        return cureentRatio;
    }

    public void setCureentRatio(BigDecimal cureentRatio) {
        this.cureentRatio = cureentRatio;
    }

    private BigDecimal cureentRatio;

    @Override
    public int compareTo(StockFundamentals that) {
        return that.tickerSymbol.compareTo(this.tickerSymbol);
    }
}
