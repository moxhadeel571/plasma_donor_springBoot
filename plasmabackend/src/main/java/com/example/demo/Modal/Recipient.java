package com.example.demo.Modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "Recipient")
public class Recipient {
    @Id
    private String id;
    private String RName;
    private String RAge;
    private String RBloodType;
    private String RContactinfo;
    private String RAddress;
    private String RUrgency;
    private String RMedicalCOndition;
    private String RStatus;
    private String RMatchedDonor;
    private LocalDateTime RequestDate;
}
