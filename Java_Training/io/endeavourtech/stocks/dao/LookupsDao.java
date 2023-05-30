package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.StockException;
import io.endeavourtech.stocks.vo.SectorLookup;
import io.endeavourtech.stocks.vo.StocksLookup;
import io.endeavourtech.stocks.vo.SubSectorLookUp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LookupsDao extends BaseDao{

    public List<StocksLookup> getStockslookups() {
        List<StocksLookup> stocksLookupsList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT \n" +
                    "  TICKER_SYMBOL ,TICKER_NAME \n" +
                    " FROM \n" +
                    "  ENDEAVOUR.STOCKS_LOOKUP sl  "

            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                StocksLookup stocksLookup = new StocksLookup();
                stocksLookup.setTickerSymbol(resultSet.getString("TICKER_SYMBOL"));
                stocksLookup.setTickerName(resultSet.getString("TICKER_NAME"));
                stocksLookupsList.add(stocksLookup);

            }

            }catch (SQLException e) {
            throw new StockException("Error reading stocks_lookup table" , e);
        }
        return stocksLookupsList;

        }


    public List<SectorLookup> getSectorLookups(){
        List<SectorLookup> sectorLookups = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT \n" +
                            "  SECTOR_ID ,SECTOR_NAME \n" +
                            "  FROM \n" +
                            "  ENDEAVOUR.SECTOR_LOOKUP sl "
                    );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               SectorLookup sectorLookup = new SectorLookup();
               sectorLookup.setSectorId(resultSet.getInt("SECTOR_ID"));
               sectorLookup.setSectorName(resultSet.getString("SECTOR_NAME"));
               sectorLookups.add(sectorLookup);

            }
        } catch (SQLException e) {
            throw new StockException("Error reading sector_lookup table" , e);
        }
        return sectorLookups;
    }

     public List<SubSectorLookUp> getSubSectorLookUp(){
        List<SubSectorLookUp> subSectorLookUps = new ArrayList<>();
        String sql = "SELECT \n" +
                " \tSUBSECTOR_ID ,SUBSECTOR_NAME \n" +
                " \tFROM \n" +
                " \tENDEAVOUR.SUBSECTOR_LOOKUP sl ";
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 SubSectorLookUp subSectorLookUp = new SubSectorLookUp();
                 subSectorLookUp.setSubSectorId(resultSet.getInt("SUBSECTOR_ID"));
                 subSectorLookUp.setSectorName(resultSet.getString("SUBSECTOR_NAME"));
                 subSectorLookUps.add(subSectorLookUp);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

         return subSectorLookUps;
     }
}
