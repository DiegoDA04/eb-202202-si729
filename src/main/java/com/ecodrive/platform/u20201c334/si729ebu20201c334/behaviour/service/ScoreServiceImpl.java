package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.service;

import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.persistence.ScoreRepository;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.service.ScoreService;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ScoreServiceImpl implements ScoreService {

    private static final String ENTITY = "Score";
    private final ScoreRepository scoreRepository;
    private final Validator validator;

    public ScoreServiceImpl(ScoreRepository scoreRepository, Validator validator) {
        this.scoreRepository = scoreRepository;
        this.validator = validator;
    }

    @Override
    public Float getMaxScore(Long driverId) {
        return scoreRepository.findFirstByDriverIdOrderByValueDesc(driverId).getValue();
    }

    @Override
    public Float getAverageScore(Long driverId) {
        return scoreRepository.findAverageScore(driverId);
    }

    @Override
    public Score create(Long driverId, Score score) {

        score.setDriverId(driverId);

        Set<ConstraintViolation<Score>> violations = validator.validate(score);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return scoreRepository.save(score);
    }
}
