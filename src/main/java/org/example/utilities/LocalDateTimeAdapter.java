package org.example.utilities;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr);
    }

    @Override
    public String marshal(LocalDateTime dateTime) {
        return dateTime.toString();
    }
}