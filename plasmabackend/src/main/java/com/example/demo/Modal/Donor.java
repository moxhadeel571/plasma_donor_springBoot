package com.example.demo.Modal;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "donor")
public class Donor {
    @MongoId
private String id;
    private String Name;
    private String Age;
    private String BloodType;
    private String Appproval;
    private String ContactInfo;
    private String Address;
    private String COVIDStatus;
    private String Availability;
    private String MedicalHistory;
    private String DonationHistory;
}
