package com.travelgo.user.entity.embeded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
public class ContactNumber {
    private String whatsApp;
    private String telegram;
    private String home;
}
