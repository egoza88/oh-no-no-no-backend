package com.ohnonono.parking.service;

import com.ohnonono.parking.PinDB;
import com.ohnonono.parking.dto.AuthResponse;
import com.ohnonono.parking.http.RequestManagerAuth;
import com.ohnonono.parking.model.Credentials;
import com.ohnonono.parking.response.model.PinResponse;
import com.ohnonono.parking.response.model.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

//    @Autowired
//    private RequestManagerSchedule requestManagerSchedule;

    @Override
    public ResponseEntity<String> getSchedule(String token) {
        return new ResponseEntity<>("{\n" +
                "    \"winstrom\": {\n" +
                "        \"@version\": \"1.0\",\n" +
                "        \"udalost\": [\n" +
                "            {\n" +
                "                \"id\": \"1\",\n" +
                "                \"lastUpdate\": \"2021-04-13T09:42:11.397+02:00\",\n" +
                "                \"cenik\": \"\",\n" +
                "                \"firma\": \"\",\n" +
                "                \"zahajeni\": \"2021-04-17T09:45:00\",\n" +
                "                \"dokonceni\": \"2021-04-17T16:15:00\",\n" +
                "                \"predmet\": \"\",\n" +
                "                \"typAkt\": \"code:UDÁLOST\",\n" +
                "                \"typAkt@ref\": \"/c/rezervace1/typ-aktivity/1.json\",\n" +
                "                \"typAkt@showAs\": \"UDÁLOST: Událost\",\n" +
                "                \"zodpPrac\": \"team1.uzivatel4\",\n" +
                "                \"zodpPrac@ref\": \"/c/rezervace1/uzivatel/1.json\",\n" +
                "                \"zodpPrac@showAs\": \"admin\",\n" +
                "                \"majetek\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"41\",\n" +
                "                \"lastUpdate\": \"2021-04-16T23:04:21.274+02:00\",\n" +
                "                \"cenik\": \"\",\n" +
                "                \"firma\": \"\",\n" +
                "                \"zahajeni\": \"2021-04-17T08:15:00\",\n" +
                "                \"dokonceni\": \"2021-04-17T14:30:00\",\n" +
                "                \"predmet\": \"\",\n" +
                "                \"typAkt\": \"code:UDÁLOST\",\n" +
                "                \"typAkt@ref\": \"/c/rezervace1/typ-aktivity/1.json\",\n" +
                "                \"typAkt@showAs\": \"UDÁLOST: Událost\",\n" +
                "                \"zodpPrac\": \"team1.uzivatel9\",\n" +
                "                \"zodpPrac@ref\": \"/c/rezervace1/uzivatel/1.json\",\n" +
                "                \"zodpPrac@showAs\": \"admin\",\n" +
                "                \"majetek\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"42\",\n" +
                "                \"lastUpdate\": \"2021-04-16T23:33:09.927+02:00\",\n" +
                "                \"cenik\": \"\",\n" +
                "                \"firma\": \"\",\n" +
                "                \"zahajeni\": \"2021-04-17T11:00:00\",\n" +
                "                \"dokonceni\": \"2021-04-17T18:15:00\",\n" +
                "                \"predmet\": \"103\",\n" +
                "                \"typAkt\": \"code:UDÁLOST\",\n" +
                "                \"typAkt@ref\": \"/c/rezervace1/typ-aktivity/1.json\",\n" +
                "                \"typAkt@showAs\": \"UDÁLOST: Událost\",\n" +
                "                \"zodpPrac\": \"team1.uzivatel16\",\n" +
                "                \"zodpPrac@ref\": \"/c/rezervace1/uzivatel/1.json\",\n" +
                "                \"zodpPrac@showAs\": \"admin\",\n" +
                "                \"majetek\": \"\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createReservation(String token) {
        return getSchedule(token);
    }

    @Override
    public ResponseEntity<String> deleteReservation(String token, String reservationId) {
        return getSchedule(token);
    }
}
