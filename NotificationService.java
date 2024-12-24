package O;

public class NotificationService {

        private NotificationMedium notificationMedium;

        public NotificationService(NotificationMedium notificationMedium) {
            this.notificationMedium = notificationMedium;
        }

        public void sendOTP() {
            notificationMedium.sendOtp();
        }


}

