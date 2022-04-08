package com.example.coursework;

import org.jsoup.nodes.Element;

import java.time.Period;

public class CountryPeriod { // содержит в себе информацию об одном периоде :

    private String link;             // часть сслыки на таблицу
    private String namePeriod;       // название периода
    private short bgYear;            // начало периода
    private short endYear;           // конец периода


    public CountryPeriod(Element period){

        this.link= period.attr("href");
        this.namePeriod=period.attr("title");
        String[] intervals = period.getElementsByTag("div").text().split(" - ");
        this.bgYear=Short.parseShort(intervals[0]);
        this.endYear=Short.parseShort(intervals[1]);


    }

    public boolean compareData(int year){ // дает ответ на вопрос: принадлежит ли входящий год к этому периоду

        if((year>=bgYear)&&(year<=endYear)){
            return true;
        } else return false;

    }








    public String getLink() {
        return link;
    }

    public String getNamePeriod() {
        return namePeriod;
    }

    public short getBgYear() {
        return bgYear;
    }

    public short getEndYear() {
        return endYear;
    }
}
