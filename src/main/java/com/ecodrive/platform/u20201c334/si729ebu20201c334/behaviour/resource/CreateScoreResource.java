package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateScoreResource {

    @NotNull
    private Float value;

}
