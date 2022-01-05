package jp.co.xiaobai.service;

import jp.co.xiaobai.entity.EventDayPlace;
import jp.co.xiaobai.entity.EventInfo;
import jp.co.xiaobai.entity.Place;
import jp.co.xiaobai.repository.EventDayRepository;
import jp.co.xiaobai.repository.EventInfoRepository;
import jp.co.xiaobai.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EventPlaceService {
    final int IDX_BEGIN = 0;
    final int IDX_END = 1;
    final int DEFAULT_DURATION = 1;
    @Autowired
    EventInfoRepository eventInfoRepository;
    @Autowired
    EventDayRepository eventDayRepository;
    @Autowired
    PlaceRepository placeRepository;

    List<EventInfo> getAllEvent() {
        System.out.println(eventDayRepository.findAll());
        return null;
    }

    public List<EventDayPlace> getEventsFromDate(Date date) {
        List<Date> beginAndEndDay = getBeginAndEndDay(date, DEFAULT_DURATION);
        List<Integer> eventIds = eventDayRepository.findEventIDByDate(beginAndEndDay.get(IDX_BEGIN), beginAndEndDay.get(IDX_END));
        List<Integer> placeIds = eventDayRepository.findEventPlaceByDate(beginAndEndDay.get(IDX_BEGIN), beginAndEndDay.get(IDX_END));
        return findEventDayPlace(date, eventIds, eventInfoRepository, placeIds, placeRepository);
    }

    public String[] getDuration(Date startDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        List<Date> beginAndEndDay = getBeginAndEndDay(startDate, DEFAULT_DURATION);
        String[] ret = {df.format(beginAndEndDay.get(IDX_BEGIN)), df.format(beginAndEndDay.get(IDX_END))};
        return ret;
    }

    private List<EventDayPlace> findEventDayPlace(Date date, List<Integer> eventIds, EventInfoRepository eventInfoRepository, List<Integer> placeIds, PlaceRepository placeRepository) {
        List<EventDayPlace> eventDayPlaces = new ArrayList<>();
        for (int i = 0; i < eventIds.size(); ++i) {
            Optional<EventInfo> eventInfo = eventInfoRepository.findById(eventIds.get(i));
            Optional<Place> place = placeRepository.findById(placeIds.get(i));
            if (eventInfo.isPresent() && place.isPresent()) {
                eventDayPlaces.add(new EventDayPlace(eventInfo.get().getName(), date, place.get().getName(), place.get().getLongitude(), place.get().getLatitude(), eventInfo.get().getUrl()));
            }
        }
        return eventDayPlaces;
    }
    private List<Date> getBeginAndEndDay(Date date, Integer duration) {
        List<Date> beginAndEndDay = new ArrayList<>();
        beginAndEndDay.add(DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
        beginAndEndDay.add(DateUtils.ceiling(date, Calendar.DAY_OF_MONTH));
        return beginAndEndDay;
    }
}