package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.StockException;
import io.endeavourtech.stocks.vo.StockFundamentals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockFundamentalsDao extends BaseDao {
    public  List<StockFundamentals> getStockFundamentals() {
        List<StockFundamentals> stockFundamentalsList = new ArrayList<>();
        try {
            String sql = " SELECT\n" +
                    " TICKER_SYMBOL , SECTOR_ID , SUBSECTOR_ID ,MARKET_CAP ,CURRENT_RATIO \n" +
                    " FROM \n" +
                    " ENDEAVOUR.STOCK_FUNDAMENTALS sf"+
                    " WHERE MARKET_CAP IS NOT NULL" +
                    " ORDER BY SECTOR_ID ASC";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                StockFundamentals stockFundamentals = new StockFundamentals();
                stockFundamentals.setTickerSymbol(resultSet.getString("TICKER_SYMBOL"));
                stockFundamentals.setSectorId(resultSet.getInt("SECTOR_ID"));
                stockFundamentals.setSubSectorId(resultSet.getInt("SUBSECTOR_ID"));
                stockFundamentals.setMarketCap(resultSet.getBigDecimal("MARKET_CAP"));
                stockFundamentals.setCureentRatio(resultSet.getBigDecimal("CURRENT_RATIO"));
                stockFundamentalsList.add(stockFundamentals);

            }

        } catch (SQLException e) {
            throw new StockException("Error reading stocks_lookup table", e);


        }

        return stockFundamentalsList;
    }
}

