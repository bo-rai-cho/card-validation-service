package com.mastercard.samples.controllers;

import com.mastercard.samples.services.CardValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/card/get")
public class CardValidationController {

    private CardValidationService cardValidationService;

    public CardValidationController(CardValidationService cardValidationService) {
        this.cardValidationService = cardValidationService;
    }

    @RequestMapping(value = "/{cardNumber}", method = GET)
    public ResponseEntity getValidationResult(@PathVariable Long cardNumber) {
        return cardValidationService.getValidationResult(cardNumber);
    }
}
