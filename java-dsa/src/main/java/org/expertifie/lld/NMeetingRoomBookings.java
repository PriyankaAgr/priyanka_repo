package org.expertifie.lld;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

public class NMeetingRoomBookings {

    @Getter
    @Setter
    static class MeetingRoom {

        int roomId;
        int meetingId;
        boolean isAvailable;
        String status;


    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Meeting {
        int meetingId;
        int organiserId;
        int roomId;
        List<User> invitees;
        LocalDateTime startTime;
        LocalDateTime endTime;
        LocalDateTime bookedTimeStamp;


    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class User {

        int userId;
        String userName;
        String department;
        String email;
        String role;

    }
}


