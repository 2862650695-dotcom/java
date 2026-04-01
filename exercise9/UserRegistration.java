
public class UserRegistration {
    public boolean validateUserId(String userId) {
        return userId != null && userId.matches("^U\\d{3}$");
    }

    public boolean validateUserInfo(String userInfo) {
        return userInfo != null && !userInfo.isBlank() && userInfo.length() >= 5;
    }
}