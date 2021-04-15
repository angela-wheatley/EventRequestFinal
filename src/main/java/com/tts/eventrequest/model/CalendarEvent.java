package com.tts.eventrequest.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalendarEvent
{
    public String title;
    public String start;
    public String location;
    
    public CalendarEvent(String title, Date start, String location)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.title = title;
        this.start = format.format(start);
        this.location = location;   
    }

}
