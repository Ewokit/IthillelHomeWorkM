public interface SubscriberService {
    public void UserExceedCityCall(Subscriber[] UserBase, int time);
    public void UserUsedIntercityCall(Subscriber[] UserBase);
    public void UsersFirstLetterOfSurname(Subscriber[] UserBase, String letter);
    public int InternetTrafficConsumptionCity(Subscriber[] UserBase, String city);
    public int NumberUsersWithNegativeBalance(Subscriber[] UserBase);
}
