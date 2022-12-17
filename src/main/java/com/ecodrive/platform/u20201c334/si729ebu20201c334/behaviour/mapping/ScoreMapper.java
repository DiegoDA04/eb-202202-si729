package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.mapping;

import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.resource.CreateScoreResource;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.resource.ScoreResource;
import com.ecodrive.platform.u20201c334.si729ebu20201c334.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ScoreMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ScoreResource toResource(Score model) {
        return mapper.map(model, ScoreResource.class);
    }

    public Score toModel(CreateScoreResource resource) {
        return mapper.map(resource, Score.class);
    }

    public Page<ScoreResource> modelListPage(List<Score> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ScoreResource.class), pageable, modelList.size());
    }
}
