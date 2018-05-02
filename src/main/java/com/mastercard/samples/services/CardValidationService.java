package com.mastercard.samples.services;


import com.mastercard.samples.model.Card;
import org.springframework.http.ResponseEntity;

import java.util.Random;


public class CardValidationService {

    public ResponseEntity getValidationResult(Long cardNumber) {

        return ResponseEntity.ok(new Card("Batman", cardNumber, new Random().nextBoolean()));
    }
}
