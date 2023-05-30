package io.endeavourtech.jdbc;

import oracle.jdbc.OracleDriver;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new OracleDriver());
            String jdbcUrl = "jdbc:oracle:thin:@//endeavourtech.ddns.net:31000/NE_Srikar";
            String userName = "endeavourapp";
            String password = "rPRLZx2nkuEQ9H5mH9bs77LzM";

            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);//            extractedp1(connection);   // in class printSectorId(Close price and ticker Symbol// Assignme

//            printSectorsIDs(connection); // class example

//            String tickerSymbol = "AAPL";
// 1           printMarketCap(connection, tickerSymbol);
//  2          BigDecimal marketCap = new BigDecimal("10000000000");
//            BigDecimal currentRatio = new BigDecimal("5");
//
//   3         printDifferentConditions(connection, marketCap, currentRatio);

//            ArrayList<String> art = new ArrayList<>();
//            art.add("MSFT");
//            art.add("AAPL");

//            String array[] ={ "AAPL","MSFT"};

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

//
//            String sql = """
//                      SELECT
//                      MARKET_CAP ,
//                      TICKER_SYMBOL
//                      FROM
//                      ENDEAVOUR.STOCK_FUNDAMENTALS sf
//                      WHERE
//                      sf.TICKER_SYMBOL = ?
//                    """;
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
////            Array array = connection.createArrayOf("String" , new Object[]{"AAPL"});
////            Array array1 = connection.createArrayOf("String",new Object[]{"MSFT"});
////            Object[] array = {"AAPL"};
////            Array tk1 = connection.createArrayOf("String" , array);
////            Object[] array1 = {"MSFT"};
////            Array tk2 = connection.createArrayOf("String", array1);
//            preparedStatement.setString(1, tickerString);
//            preparedStatement.setString(2, tickerString);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                System.out.println(" Market Cap for a given Ticker Symbol is :"
//                        + resultSet.getBigDecimal("MARKET_CAP")
//                +"  " + resultSet.getString("TICKER_SYMBOL"));
//                }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printDifferentConditions(Connection connection, BigDecimal marketCap, BigDecimal currentRatio)
            throws SQLException {
        String sql = """
                SELECT TICKER_SYMBOL , MARKET_CAP ,CURRENT_RATIO \s
                FROM ENDEAVOUR.STOCK_FUNDAMENTALS sf \s
                WHERE CURRENT_RATIO IS NOT NULL  AND (CURRENT_RATIO >? OR MARKET_CAP >?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setBigDecimal(1, currentRatio);
        preparedStatement.setBigDecimal(2, marketCap);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Ticker symbols for the give currentRatio and MarketCap: "
                    + resultSet.getString("TICKER_SYMBOL")+  "  "
                   +resultSet.getBigDecimal("MARKET_CAP") + "  "
                    +resultSet.getBigDecimal("MARKET_CAP"));
        }
    }

    private static void printMarketCap(Connection connection, String tickerSymbol) throws SQLException {
        String sql = """
                    SELECT MARKET_CAP    FROM ENDEAVOUR.STOCK_FUNDAMENTALS sf  WHERE  TICKER_SYMBOL  = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tickerSymbol);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println( " Market _Cap :" + resultSet.getBigDecimal("MARKET_CAP"));
        }
    }

    private static void printSectorsIDs(Connection connection) throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT CLOSE_PRICE  " +
                "FROM ENDEAVOUR.STOCKS_PRICE_HISTORY sph  WHERE SPH .TICKER_SYMBOL ='MSFT'");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        while (resultSet1.next()){
            System.out.println("second_Quarry result is " +" " + resultSet1.getBigDecimal("CLOSE_PRICE"));
        }
    }

    private static void extractedp1(Connection connection) throws SQLException {
        String sql = """
                    SELECT\s
                        sph.CLOSE_PRICE ,
                        sph.TICKER_SYMBOL ,
                        SPH2.TICKER_SYMBOL ,
                        sph.TRADING_DATE\s
                    FROM\s
                        ENDEAVOUR.STOCKS_PRICE_HISTORY sph ,
                        ENDEAVOUR.STOCKS_PRICE_HISTORY sph2\s
                    WHERE\s
                --		sph.TRADING_DATE = TO_DATE('2022','YYYY')
                --		AND SPH2 .TRADING_DATE =TO_DATE('2022','YYYY') while doing to date it will give random dates
                         sph.CLOSE_PRICE =sph2.CLOSE_PRICE\s
                        AND sph.TICKER_SYMBOL !=sph2.TICKER_SYMBOL
                        AND sph.TRADING_DATE = SPH2 .TRADING_DATE\s
                        AND EXTRACT (YEAR FROM SPH.TRADING_DATE)=2022
                    ORDER BY
                        SPH.CLOSE_PRICE ASC\s
                """;


        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getBigDecimal("CLOSE_PRICE")  +" " + resultSet.getString("TICKER_SYMBOL"));
//                System.out.println(resultSet);
        }
    }
}
