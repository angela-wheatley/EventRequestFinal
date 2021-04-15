package com.tts.eventrequest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
public class EventForm
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long eventId;
    
    private String eventName;
    private String eventDate;
    private String eventLocation;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    
    public Event convertToEvent()
    {
        Event event = new Event();
        event.setEventName(this.eventName);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            event.setEventDate(format.parse(this.eventDate));
        }
        catch(ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        event.setEventLocation(this.eventLocation);
        event.setCustomerFirstName(this.customerFirstName);
        event.setCustomerLastName(this.customerLastName);
        event.setCustomerEmail(this.customerEmail);
        return event;
    }
}
