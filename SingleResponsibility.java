public class SingleResponsibility {

    static class ReservationService {

        public String search(String source, String destination) {
            // do searchBuses
            return "Buses Found";
        }

        public String bookTicket(int numberOfSeats) {
            // booking the ticket
            return "Ticket Booked";
        }

    }

    static class TravelInsuranceService{

        public void getTravelInsuranceInfo(int ticketId) {
            // getting the Travel Insurance info
        }

    }

    static class OTPService{
        public void sendOTP(String medium) {
            if(medium.equals("email")) {
                // write email related logic
            }
        }

    }


}
