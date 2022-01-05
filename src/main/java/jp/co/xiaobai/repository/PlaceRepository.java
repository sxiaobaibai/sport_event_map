package jp.co.xiaobai.repository;

import jp.co.xiaobai.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}

