package com.da_ta.backend.letter.controller.dto.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckImageLetterResponse {

    private boolean harmfulness;
    private String message;
}
