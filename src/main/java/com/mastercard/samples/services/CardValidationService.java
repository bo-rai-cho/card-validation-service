package com.mastercard.samples.services;


import com.mastercard.samples.model.Card;
import org.springframework.http.ResponseEntity;


import static org.springframework.http.ResponseEntity.ok;


public class CardValidationService {

    public ResponseEntity getValidationResult(Long cardNumber) {

        if (cardNumber > 100) {
            return ok(new Card("Batman", cardNumber, true));
        }

        return ok(new Card("Batman", cardNumber, false));
    }
}
