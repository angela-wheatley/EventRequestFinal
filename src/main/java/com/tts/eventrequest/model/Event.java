package com.tts.eventrequest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long eventId;
    
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
}
