package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.persistence;

import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.model.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {

    Score findFirstByDriverIdOrderByValueDesc(Long driverId);

    @Query("SELECT AVG(s.value) FROM Score s WHERE s.driverId=:driverId")
    Float findAverageScore(Long driverId);

}
