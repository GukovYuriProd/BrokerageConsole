package com.github.gukovprod;

public class BankPosition {
    public String index;
    public String lastUpdateTime;
    public String positionName;
    public String lastPrice;
    public String margin;
    public String volume;
    public String SpredWeek;
    public String SpredMonth;
    public String SpredFromYearStart;
    public String SpredByYear;
    public String Capital;

    public BankPosition (String PositionIndex,
                         String Update,
                         String Name,
                         String Price,
                         String Margin,
                         String Volume,
                         String SPWeek,
                         String SPMonth,
                         String SPFromYearStart,
                         String SPByYear,
                         String SPCapital){

        index = PositionIndex;
        lastUpdateTime = Update;
        positionName = Name;
        lastPrice = Price;
        margin = Margin;
        volume = Volume;
        SpredWeek = SPWeek;
        SpredMonth = SPMonth;
        SpredFromYearStart = SPFromYearStart;
        SpredByYear = SPByYear;
        Capital = SPCapital;
    }

    @Override
    public String toString() {
        return "Index: " + index +
                "; Last update: " + lastUpdateTime +
                "; Name: " + positionName +
                "; Last price: " + lastPrice +
                "; Margin: " + margin +
                "; Volume: " + volume +
                "; Week change: " + SpredWeek +
                "; Month change: " + SpredMonth +
                "; Year start change: " + SpredFromYearStart +
                "; Year change: " + SpredByYear +
                "; Capital: " + Capital;
    }
}
