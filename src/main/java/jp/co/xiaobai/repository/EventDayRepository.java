package jp.co.xiaobai.repository;

import jp.co.xiaobai.entity.EventDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EventDayRepository extends JpaRepository<EventDay, Integer> {
    @Query("SELECT e.eventId FROM EventDay e WHERE :date <= e.eventDateTime AND e.eventDateTime < :next_date")
    List<Integer> findEventIDByDate(@Param("date") Date date, @Param("next_date") Date next_date);

    @Query("SELECT e.placeId FROM EventDay e WHERE :date <= e.eventDateTime AND e.eventDateTime < :next_date")
    List<Integer> findEventPlaceByDate(@Param("date") Date date, @Param("next_date") Date next_date);
}
