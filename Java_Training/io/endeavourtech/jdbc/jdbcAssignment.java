package io.endeavourtech.jdbc;

import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jdbcAssignment {

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new OracleDriver());
            String jdbcUrl = "jdbc:oracle:thin:@//endeavourtech.ddns.net:31000/NE_Srikar";
            String userName = "endeavourapp";
            String password = "rPRLZx2nkuEQ9H5mH9bs77LzM";

            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);//            extractedp1(connection);   // in class printSectorId(Close price and ticker Symbol// Assignme



            List<String>  tkrs = List.of("AAPL", "GOOGL" , "MSFT");
            String sql = """
                      SELECT
                      MARKET_CAP ,
                      TICKER_SYMBOL\s
                      FROM\s
                      ENDEAVOUR.STOCK_FUNDAMENTALS sf\s
                      WHERE\s
                      sf.TICKER_SYMBOL = ?
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(String tkr : tkrs){
                preparedStatement.setString(1,tkr);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    System.out.println("Market cap for the given tiker is : " + resultSet.getString("TICKER_SYMBOL")
                            + " " + " and M_cap  is : "+ " " + resultSet.getBigDecimal("MARKET_CAP") );
                }
            }





//            assinment1(connection);     // Assignment in first method using collections method


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void assinment1(Connection connection) throws SQLException {
        ArrayList<String> tickerList = new ArrayList<>();
        tickerList.add("AAPL");
        tickerList.add("AA");
        tickerList.add("JNJ");
        tickerList.add("GOOGL");
        //String tickerString = String.join(",", tickerList);
        String placeholders = String.join(",", Collections.nCopies(tickerList.size(), "?"));
        String sql = "SELECT MARKET_CAP, TICKER_SYMBOL FROM ENDEAVOUR.STOCK_FUNDAMENTALS WHERE TICKER_SYMBOL IN (" + placeholders + ")";
        System.out.println(placeholders);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < tickerList.size(); i++) {
            preparedStatement.setString(i + 1, tickerList.get(i));
        }


        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Market Cap for a given Ticker Symbol is: " + resultSet.getBigDecimal("MARKET_CAP") + " " + resultSet.getString("TICKER_SYMBOL"));
        }
    }
}