package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    RecoveryRoomService service;

    @Autowired
    public RecoveryRoomTypeFormatter(RecoveryRoomService service){
        this.service = service;
    }

    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        RecoveryRoomType findRecoveryRoomType = this.service.getRecoveryRoomType(text);
        if(findRecoveryRoomType != null) {
            return findRecoveryRoomType;
        }
        throw new ParseException("Recovery room type could not be found", 0);
    }
    
}
