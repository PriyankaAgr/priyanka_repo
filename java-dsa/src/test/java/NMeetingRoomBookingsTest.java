
import org.expertifie.lld.MeetingRoomBookingService;
import org.expertifie.lld.NMeetingRoomBookings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.expertifie.lld.NMeetingRoomBookings.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NMeetingRoomBookingsTest {

    MeetingRoomBookingService bookingService = new MeetingRoomBookingService();


    @Test
    public void test_MeetingRoomBooking(){
        List<User> invitees = new ArrayList<>();
        invitees.add(new User(1,"John","Tech","John@abc.com", "Manager"));
        invitees.add(new User(2,"Ray","Tech","Ray@abc.com", "Lead"));
        Assertions.assertTrue(bookingService.addMeeting(new Meeting(1004, 1,1, invitees, LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3), LocalDateTime.now())));
        Assertions.assertTrue(bookingService.addMeeting(new Meeting(1001, 1,1, invitees, LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(6), LocalDateTime.now())));
        Assertions.assertFalse(bookingService.addMeeting(new Meeting(1002, 2,1, invitees, LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(1))));
        Assertions.assertTrue(bookingService.addMeeting(new Meeting(1003, 1,2, invitees, LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5), LocalDateTime.now().plusMinutes(30))));
        Assertions.assertFalse(bookingService.addMeeting(new Meeting(1003, 1,2, invitees, LocalDateTime.now().plusHours(4).plusMinutes(30), LocalDateTime.now().plusHours(5), LocalDateTime.now().plusMinutes(30))));

    }

}
