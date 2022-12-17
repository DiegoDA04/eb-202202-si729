package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.api.rest;

import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.service.ScoreService;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.mapping.ScoreMapper;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.resource.CreateScoreResource;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.resource.ScoreResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/drivers/{driverId}/scores", produces = "application/json")
@Tag(name = "Driving Scores")
public class ScoresController {

    private final ScoreService scoreService;
    private final ScoreMapper mapper;

    public ScoresController(ScoreService scoreService, ScoreMapper mapper) {
        this.scoreService = scoreService;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get max or average score by driver")
    public ResponseEntity<?> getMaxOrAverageScore(@RequestParam("scope") Long scope, @PathVariable Long driverId)
    {
        if(scope == 0){
            return new ResponseEntity<>(mapper.toResource(new Score()
                    .withValue(scoreService.getMaxScore(driverId))
            ),HttpStatus.OK);
        }
        if(scope == 1)
        {
            return new ResponseEntity<>(mapper.toResource(new Score().withValue(scoreService.getAverageScore(driverId))),HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Scope value not specified");
    }

    @PostMapping
    @Operation(summary = "Add a new driving score")
    public ResponseEntity<ScoreResource> createDrivingScore(@PathVariable Long driverId, @RequestBody CreateScoreResource resource)
    {
        return new ResponseEntity<>(mapper.toResource(scoreService.create(driverId,mapper.toModel(resource))),HttpStatus.CREATED);
    }
}