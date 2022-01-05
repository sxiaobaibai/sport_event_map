package jp.co.xiaobai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "event_info")
public class EventInfo implements Serializable {
    @Id
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
