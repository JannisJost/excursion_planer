package com.bbbaden.excursion_plan;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jannis
 */
@Named(value = "excursionFilter")
@SessionScoped
public class ExcursionFilterBean implements Serializable {

    ArrayList<String> excursions = new ArrayList<>();

    String day = "0", weather = "0", school = "0", daytime = "0", children = "1";
    boolean weekday, goodWeather, holidays, duringDaytime, withChildren;
    boolean skittle, outdoorPool, indoorPool, dunkelwald, music, bakingcourse, schieferbergwerk, gokurs, billard, racingCar, openair, basketWeaving, waterfall, zooVisit;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public ArrayList<String> getExcursions() {
        return excursions;
    }

    public void setExcursions(ArrayList<String> excursions) {
        this.excursions = excursions;
    }
    

    public void chooseExcursion() {
        excursions.clear();
        weekday = ("0".equals(day));
        goodWeather = ("0".equals(weather));
        holidays = ("0".equals(school));
        duringDaytime = ("0".equals(daytime));
        withChildren = ("1".equals(children));
        filterExcursions();
        putMatchingExcursion();
    }

    public void filterExcursions() {
        skittle = !duringDaytime || !weekday;
        outdoorPool = goodWeather && duringDaytime;
        indoorPool = !(holidays && !weekday);
        dunkelwald = outdoorPool;
        music = !duringDaytime && !holidays;
        bakingcourse = !weekday && !goodWeather;
        schieferbergwerk = duringDaytime || (!weekday && holidays);
        gokurs = (!weekday && !goodWeather) || (weekday && !duringDaytime && goodWeather);
        billard = !withChildren && (!duringDaytime || !weekday);
        racingCar = !withChildren && duringDaytime && holidays && !weekday;
        openair = goodWeather && (!duringDaytime || !weekday);
        basketWeaving = holidays && !goodWeather && weekday;
        waterfall = duringDaytime;
        zooVisit = true;
    }

    public void putMatchingExcursion() {
        if (skittle) {
            excursions.add("Kegeln");
        }
        if (outdoorPool) {
            excursions.add("Freibad");
        }
        if (indoorPool) {
            excursions.add("Hallenbad");
        }
        if (dunkelwald) {
            excursions.add("Dunkelwald");
        }
        if (music) {
            excursions.add("Musikkurs");
        }
        if (bakingcourse) {
            excursions.add("Brotbackkurs");
        }
        if (schieferbergwerk) {
            excursions.add("Schieferbergwerk");
        }
        if (gokurs) {
            excursions.add("Go Kurs");
        }
        if (billard) {
            excursions.add("Billard");
        }
        if (racingCar) {
            excursions.add("Rennauto");
        }
        if (openair) {
            excursions.add("Open Air Kino");
        }
        if (basketWeaving) {
            excursions.add("Korbflechten");
        }
        if (waterfall) {
            excursions.add("Wasserfall");
        }
        if (zooVisit) {
            excursions.add("Zoobesuch");
        }
    }

    public String nextPage() {
        return "result";
    }
}
