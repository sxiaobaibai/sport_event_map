package jp.co.xiaobai.entity;

import java.util.Date;

public class EventDayPlace {
    private String name;
    private Date dateAndTime;
    private String place;
    private Float longitude;
    private Float latitude;
    private String URL;

    public EventDayPlace(String name, Date dateAndTime, String place, Float longitude, Float latitude, String url) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
        URL = url;
    }

    public String getName() {
        return name;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public String getPlace() {
        return place;
    }

    public Float getLongitude() {
        return longitude;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Float getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "EventDayPlace{" +
                "name='" + name + '\'' +
                ", dateAndTime=" + dateAndTime +
                ", place='" + place + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", URL='" + URL + '\'' +
                '}';
    }
}
