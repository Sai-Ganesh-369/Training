package io.endeavourtech.stocks.service;

import io.endeavourtech.stocks.dao.LookupsDao;
import io.endeavourtech.stocks.dao.StockFundamentalsDao;
import io.endeavourtech.stocks.vo.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarketAnalytics {
    private LookupsDao lookupsDao;

    private StockFundamentalsDao stockFundamentalsDao;


    public MarketAnalytics(LookupsDao lookupsDao, StockFundamentalsDao stockFundamentalsDao) {
        this.lookupsDao = lookupsDao;
        this.stockFundamentalsDao = stockFundamentalsDao;
    }

    public void sortingExamples() {
        List<Integer> integersLisr = new ArrayList<>(List.of(5, 4, 8, 9));
        List<String> StringList = new ArrayList<>(List.of("a", "e", "i ", "o"));
        Collections.sort(integersLisr);
        System.out.println("Integer list after the sort: " + integersLisr);
        Collections.sort(StringList);
        System.out.println("String LLIst after the sort : " + StringList);
        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals();
        Collections.sort(stockFundamentalsList);
//        System.out.println(stockFundamentalsList +"**");//ex1

        stockFundamentalsList.sort(new TickerSymbolAsc());  // ex2
//        stockFundamentalsList.sort(new TickerSymbolDsc()); // ex3
        stockFundamentalsList.sort(new Comparator<StockFundamentals>() {    // Annonimus Class
            @Override
            public int compare(StockFundamentals o1, StockFundamentals o2) {
                Integer i1 = o1.getSectorId();
                Integer i2 = o2.getSectorId();
                return i2.compareTo(i1);
            }
        });

// Own tey case
        stockFundamentalsList.sort((o1, o2) -> {
            BigDecimal i1 = o1.getMarketCap();
            BigDecimal i2 = o2.getMarketCap();
            return i2.compareTo(i1);
        });

        // Annonimus Class  in lamda function


        stockFundamentalsList.sort((o1, o2) -> {
            Integer i1 = o1.getSubSectorId();
            Integer i2 = o2.getSubSectorId();
            return i2.compareTo(i1);
        });

        stockFundamentalsList.sort(Comparator.comparing(StockFundamentals::getMarketCap));
        stockFundamentalsList.sort(Comparator.comparing(StockFundamentals::getMarketCap).reversed());


    }

    public void streamsExample() {
        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals();
        List<SectorLookup> sectorLookupsList = lookupsDao.getSectorLookups();
        System.out.println("before filter : " + stockFundamentalsList.size());
        List<StockFundamentals> withoutNullCurrentRatio = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getCureentRatio() != null)
                .collect(Collectors.toList());
        System.out.println("After filter the null values : " + withoutNullCurrentRatio.size());

//        map()--to get tickerSymbol, where  crrent ratio is not null
        List<String> tickers = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getCureentRatio() != null)
                .map(stockFundamentals -> stockFundamentals.getTickerSymbol())
                .collect(Collectors.toList());

        // sorted()  sort by current ratio , high to low

        List<StockFundamentals> sortbyCurrentRatio = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getCureentRatio() != null )
                .sorted(Comparator.comparing((StockFundamentals::getCureentRatio)).reversed())
                .collect(Collectors.toList());

//By sorting on two conditions it takes last(c.r.in this ex) sort condition then give the output
        List<StockFundamentals> sortbyCurrentRatio1 = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getCureentRatio() != null && stockFundamentals.getMarketCap() !=null)
                .sorted(Comparator.comparing(StockFundamentals::getMarketCap).reversed())
                .sorted(Comparator.comparing((StockFundamentals::getCureentRatio)).reversed())
                .collect(Collectors.toList());


//           top 3 by current ratio
        List<StockFundamentals> top3CurrentRatio = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getCureentRatio() != null)
                .sorted(Comparator.comparing((StockFundamentals::getCureentRatio)).reversed())
                .limit(3)
                .collect(Collectors.toList());

//        find a spacific ticker symbol "aapl"
        List<StockFundamentals> spacificTickerAapl = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getTickerSymbol().equals("AAPL"))
                .collect(Collectors.toList());


        // if we dont know the number of o/p  or even exist OR NOT  EX. "AAPL"or not follow Find First

        Optional<StockFundamentals> tickerOptional = stockFundamentalsList.stream()
                .filter(stockFundamentals -> stockFundamentals.getTickerSymbol().equals("AAPL"))
                // if we dont know the number of o/p even exist or not follow Find First
                .findFirst();
        System.out.println("is the object present : " + tickerOptional.isPresent());
        if (tickerOptional.isPresent()) {
            System.out.println("Values in side the optional is :" + tickerOptional.get());
            System.out.println(tickerOptional + "****");
        }
        // above code in traditional for method
        StockFundamentals matchingStockingFundamentals = null;
        for (StockFundamentals stockFundamentals : stockFundamentalsList) {
            if (stockFundamentals.getTickerSymbol().equals("AAPL")) {
                matchingStockingFundamentals = stockFundamentals;
                break;
            }

        }
        if(matchingStockingFundamentals != null){
            System.out.println("matching Stock Fundamentals" + matchingStockingFundamentals);
        }

        //creating a map of sector id by name
        Map<Integer, String> sectorIdByName = sectorLookupsList.stream()
                .collect(Collectors.toMap(
                        sectorLookup -> sectorLookup.getSectorId(), //key
                        sectorLookup -> sectorLookup.getSectorName() // value
                ));

//        when there can ve duplicate obj for key , need to provide merge function
        SectorLookup duplicateSectorLookup = new SectorLookup();
        duplicateSectorLookup.setSectorId(10);
        duplicateSectorLookup.setSectorName("Duplicate");
        sectorLookupsList.add(duplicateSectorLookup);

        sectorIdByName  = sectorLookupsList.stream()
                .collect(Collectors.toMap(
                        sectorLookup -> sectorLookup.getSectorId(), //key
                        sectorLookup -> sectorLookup.getSectorName(),
                        ((v1, v2) -> v2)// merge function

                ));
//        System.out.println(sectorIdByName+ "&&&&&&&&&&&&&");

//        group stock fundamentals by sector  id

        Map<Integer, List<StockFundamentals>> stockBysectorId = stockFundamentalsList.stream()
                .collect(Collectors.groupingBy(stockFundamentals -> stockFundamentals.getSectorId()));
        System.out.println("*****"+stockBysectorId + "@@@@@@");


        //reduce

        Optional<BigDecimal> totalMarketCap = stockFundamentalsList.stream()
                .map(StockFundamentals::getMarketCap)
                .filter(marketCap -> marketCap != null)
                .reduce((marketCap1, marketCap2) -> marketCap1.add(marketCap2));
        if(totalMarketCap.isPresent()){
            System.out.println("Total Market cap is :" + totalMarketCap);
            System.out.println(totalMarketCap);

        }

//         AiisgnMent May 8 th




    }







    public void mapExample() {
        List<SectorLookup> sectorLookupList = lookupsDao.getSectorLookups();
        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals();
        Map<Integer, String> sectorNamesById = new HashMap<>();
        sectorLookupList.forEach(sectorLookup -> {
            int key = sectorLookup.getSectorId();
            String value = sectorLookup.getSectorName();
            sectorNamesById.put(key, value);
        });
        System.out.println("Map contains:" + sectorNamesById);
        int count = 0;
        for (StockFundamentals stockFundamentals : stockFundamentalsList) {
            String sectorName = sectorNamesById.get(stockFundamentals.getSectorId());

            System.out.println("Ticker" + stockFundamentals.getTickerSymbol() +
                    "Market Cap :" + stockFundamentals.getMarketCap() +
                    "Sector Name : " + sectorName);
            count++;
        }
        System.out.println("Loop count" + count);
        System.out.println(sectorNamesById.keySet());

//Group by SectorID ( it is easy in strems, example is in strems)
        Map<Integer, List<String>> tickerSymbolesBySectorId = new HashMap<>(); // sectorId with Tickers

        stockFundamentalsList.forEach(stockFundamentals -> {
            int key = stockFundamentals.getSectorId();
            List<String> tickers = tickerSymbolesBySectorId.get(key);
            if (tickers == null) {
                tickers = new ArrayList<>();
            }
            tickers.add(stockFundamentals.getTickerSymbol());
            tickerSymbolesBySectorId.put(key, tickers);

        });

        tickerSymbolesBySectorId.forEach((key, value) -> {
            System.out.println("Sector id" + key + "count of tickers" + value);
        });

//        Set<Integer> =sectorNamesById.values();
    }

    public void assignmentMap() {

        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals();
        Map<Integer, List<BigDecimal>> marketCapByMxMiAg = new HashMap<>();
        stockFundamentalsList.forEach(stockFundamentals -> {
            int key = stockFundamentals.getSectorId();
            List<BigDecimal> marketcapList = marketCapByMxMiAg.get(stockFundamentals.getSectorId());
            if (marketcapList == null) {
                marketcapList = new ArrayList<>();
            }
            marketcapList.add(stockFundamentals.getMarketCap());
            marketCapByMxMiAg.put(key, marketcapList);

        });
        marketCapByMxMiAg.forEach((key, value) -> {
//            System.out.println("Sector id:" + key + " value: " + value);
            BigDecimal max = Collections.max(value);
//            System.out.println("max value :" + max);

            BigDecimal min = Collections.min(value);
//            System.out.println("minimum value is :" + min);
            BigDecimal sum = BigDecimal.ZERO;
            for (BigDecimal sumMarketCap : value) {
                sum = sum.add(sumMarketCap);
            }

            BigDecimal avg = sum.divide(BigDecimal.valueOf(value.size()), RoundingMode.DOWN);
            System.out.println(" Sector Id is : " + key + "  " + "min value ia: " + min + "  " + "Maximum Value is :" +
                    "" + " " + max +
                    "Avg Value is :" + " " + avg);

        });

    }

    public void assignmentForEach() {
        List<SectorLookup> sectorLookupList = lookupsDao.getSectorLookups();
        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals(); //Assignment
        List<BigDecimal> b = new ArrayList<>(); //1 ( 1 denotes count related code)
        int[] arr = {0};
        sectorLookupList.forEach(sectorLookup -> {
            stockFundamentalsList.forEach(stockFundamentals -> {
                if (sectorLookup.getSectorId() == stockFundamentals.getSectorId()) {
                    BigDecimal c = stockFundamentals.getMarketCap();
                    b.add(c);
                    System.out.println(sectorLookup.getSectorName() + "  " + "  " + stockFundamentals.getTickerSymbol() + "  " +
                            stockFundamentals.getMarketCap());

                }
                arr[0]++;
            });

        });
        System.out.println(b.size());
        System.out.println(arr[0]);
    }

    public void forEachExamples() {

        List<SectorLookup> sectorLookupList = lookupsDao.getSectorLookups();
        List<StockFundamentals> stockFundamentalsList = stockFundamentalsDao.getStockFundamentals(); //Assignment

        sectorLookupList.forEach(k -> System.out.println(k));
        sectorLookupList.forEach(System.out::println);
//        int count = 0;
        sectorLookupList.forEach(sectorLookup -> {
            if (sectorLookup.getSectorId() == 10) ;
            {
                //counter ++   // in lamda fun we are not able to use outside of the lamda fun in for each like normal for each
                System.out.println("Found the helth care sector" + sectorLookup.getSectorName());
            }
        });
    }

    public void analyze1() {
        List<StockFundamentals> stockFundamentals = stockFundamentalsDao.getStockFundamentals();
        System.out.println("Accessing the Stocks Fundamental Table: " + stockFundamentals.size());
    }

    public MarketAnalytics(StockFundamentalsDao stockFundamentalsDao) {
        this.stockFundamentalsDao = stockFundamentalsDao;
    }


    public void analyze() {
        List<SectorLookup> sectorLookups = lookupsDao.getSectorLookups();
        System.out.println("Sector Lookups: " + sectorLookups.size());
        List<StocksLookup> stockslookups = lookupsDao.getStockslookups();
        System.out.println("Stocks Lookups : " + stockslookups.size());
        List<StockFundamentals> stockFundamentals = stockFundamentalsDao.getStockFundamentals();
        System.out.println("Accessing the Stocks Fundamental Table: " + stockFundamentals);

    }

}
