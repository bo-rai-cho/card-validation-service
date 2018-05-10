package com.mastercard.samples.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Card {

    private String owner;
    private Long cardNumber;
    private Boolean valid;

}
