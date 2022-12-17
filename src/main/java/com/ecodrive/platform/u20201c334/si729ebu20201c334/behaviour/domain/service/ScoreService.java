package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.service;

import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.model.entity.Score;

import java.util.List;

public interface ScoreService {

    Float getMaxScore(Long driverId);

    Float getAverageScore(Long driverId);
    Score create(Long driverId, Score score);
}
