package org.expertifie.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.expertifie.lld.NMeetingRoomBookings.*;

public class MeetingRoomBookingService {

    List<Meeting> meetings = new ArrayList<>();

    public boolean addMeeting(NMeetingRoomBookings.Meeting meeting) {
        if(meetings.isEmpty()){
            meetings.add(meeting);
            return true;
        }
        boolean isBooked = meetings.stream().anyMatch(m->m.getRoomId()==meeting.getRoomId() && meeting.startTime.isBefore(m.endTime) && meeting.startTime.isAfter(m.startTime));
        if(isBooked) {
            System.out.println("Sorry! Meeting room for Room No: " + meeting.roomId + " is already booked for that time.");
            return false;
        }
        meetings.add(meeting);
        System.out.println("Meeting room for Room No: "+ meeting.roomId+ "  successfully booked as required.");
        return true;
    }
    public void cancelMeeting(Meeting meeting){
        Meeting cancelMeeting = meetings.stream().filter(m-> m.getMeetingId()==meeting.getMeetingId() && m.getRoomId()==meeting.getRoomId() && meeting.startTime.isEqual(m.startTime) && meeting.endTime.isEqual(m.endTime)).findFirst().orElse(null);
        meetings.remove(cancelMeeting);
        }

}