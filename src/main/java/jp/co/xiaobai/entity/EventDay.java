package jp.co.xiaobai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="event_day")
public class EventDay {
    @Id
    @Column(name="event_id")
    private Integer eventId;

    @Column(name="event_date_time")
    private Date eventDateTime;

    @Column(name="place_id")
    private Integer placeId;

    public EventDay(Integer eventId, Date eventDateTime,Integer placeId) {
        this.eventId = eventId;
        this.eventDateTime = eventDateTime;
        this.placeId = placeId;
    }

    public EventDay() {
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDate(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "EventDay{" +
                "eventId=" + eventId +
                ", eventDate=" + eventDateTime +
                ", placeId=" + placeId +
                '}';
    }
}
