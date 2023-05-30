package io.endeavourtech.stocks.test;

import io.endeavourtech.stocks.dao.LookupsDao;
import io.endeavourtech.stocks.dao.StockFundamentalsDao;
import io.endeavourtech.stocks.vo.SectorLookup;
import io.endeavourtech.stocks.vo.StockFundamentals;
import io.endeavourtech.stocks.vo.SubSectorLookUp;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStrems {

    private StockFundamentalsDao stockFundamentalsDao;
    private LookupsDao lookupsDao;


    public TestStrems(StockFundamentalsDao stockFundamentalsDao) {
        this.stockFundamentalsDao = stockFundamentalsDao;
    }
//        map()--to get tickerSymbol, where  crrent ratio is not null

//    public void assignment() {
//        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals();
//        List<SectorLookup> sectorLookupsList = lookupsDao.getSectorLookups();
//        List<String> CurrentRatioByTkr = stockFundamentalsList.stream()
//                .filter(stockFundamentals -> stockFundamentals.getCureentRatio() != null)
//                .map(stockFundamentals -> stockFundamentals.getTickerSymbol())
//                .collect(Collectors.toList());
////        System.out.println(CurrentRatioByTkr);
//        //        find a spacific ticker symbol "aapl"
//        stockFundamentalsList.stream()
//                .filter(stockFundamentals -> stockFundamentals.getTickerSymbol().equals("MSFT"));
//
//        //        group stock fundamentals by sector  id
//        Map<Integer, List<StockFundamentals>> stockFunBySecId = stockFundamentalsList.stream()
//                .collect(Collectors.groupingBy(stockFundamentals -> stockFundamentals.getSectorId()));
//
//
////    For each sector, find the sub-sector which has the highest market cap and print the results in this format:
////
////    Sector Name , Sub-sector Name, Ticker symbol, Market cap
//
////        Map<BigDecimal, List<StockFundamentals>> marketCap = stockFundamentalsList.stream()
////                .collect(Collectors.groupingBy(stockFundamentals -> stockFundamentals.getMarketCap()));
//
//
//
//        Optional<BigDecimal> totalMarketCap = stockFundamentalsList.stream()
//                .map(StockFundamentals::getMarketCap)
//
//                .filter(marketCap -> marketCap != null)
//                .reduce((marketCap1, marketCap2) -> marketCap1.add(marketCap2));
//        if(totalMarketCap.isPresent()){
//            System.out.println("Total Market cap is :" + totalMarketCap);
//            System.out.println(totalMarketCap);
//
//        }
//
//        Map<Integer, List<StockFundamentals>> stockBySectorId = stockFundamentalsList.stream()
//                .collect(Collectors.groupingBy(StockFundamentals::getSectorId));
//        for (Map.Entry<Integer, List<StockFundamentals>> sectorEntry : stockBySectorId.entrySet()) {
//            int sectorId = sectorEntry.getKey();
//            List<StockFundamentals> stockInSector = sectorEntry.getValue();
//
//            Optional<StockFundamentals> maxMarketCapBySub = stockInSector.stream()
//                    .collect(Collectors.maxBy(Comparator.comparing(StockFundamentals::getMarketCap)));
//
////            maxMarketCapBySub.isPresent()
//            }
//
//
//        }
//
//



    public static void main(String[] args) {
        StockFundamentalsDao stockFundamentalsDao1 = new StockFundamentalsDao();
        TestStrems tst = new TestStrems(stockFundamentalsDao1);
//        tst.assignment();
        tst.assignment8();

    }


    public void assignment8(){

        List<SectorLookup> sectorLookupsList = lookupsDao.getSectorLookups();
        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals();
        List<SubSectorLookUp> subSectorLookUpList = lookupsDao.getSubSectorLookUp();
        Map<Integer, List<StockFundamentals>> sfBySectorId = stockFundamentalsList.stream()
                .collect(Collectors.groupingBy(stockFundamentals -> stockFundamentals.getSectorId()));
        sfBySectorId.forEach((key,valu)->{
            Optional<StockFundamentals> maxMarketCap = valu.stream()
                    .max(Comparator.comparing(StockFundamentals::getMarketCap));
            System.out.println(maxMarketCap);

        });

    }
}

