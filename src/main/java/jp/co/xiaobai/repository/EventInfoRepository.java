package jp.co.xiaobai.repository;

import jp.co.xiaobai.entity.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventInfoRepository extends JpaRepository<EventInfo, Integer> {
}
