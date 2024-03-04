package com.example.demo.Modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "Admin")
public class Admin {
    @MongoId
    private String id;
    private String AName,ARole,AContactInfo,AACtiveStatus,AState,ACity;
    private LocalDate localDate;
    @DBRef
    private List<Recipient> recipientList;

}
