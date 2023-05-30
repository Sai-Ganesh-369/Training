package io.endeavourtech.stocks;

import io.endeavourtech.stocks.dao.LookupsDao;
import io.endeavourtech.stocks.dao.StockFundamentalsDao;
import io.endeavourtech.stocks.service.MarketAnalytics;

public class StocksApplication {
    public static void main(String[] args) {
        try(LookupsDao lookupsDao = new LookupsDao();
        StockFundamentalsDao stockFundamentalDao =new StockFundamentalsDao()){
            MarketAnalytics marketAnalytics = new MarketAnalytics(lookupsDao,stockFundamentalDao);
          //  marketAnalytics.analyze();
            //marketAnalytics.sortingExamples();
//           marketAnalytics.forEachExamples();
           // marketAnalytics.sortingExamples();
//            marketAnalytics.mapExample();
            marketAnalytics.streamsExample();
//             marketAnalytics.assignmentForEach();
//            marketAnalytics.assignmentMap();
        }
    }
}
