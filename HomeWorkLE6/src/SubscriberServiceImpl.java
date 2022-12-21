public class SubscriberServiceImpl implements SubscriberService{

    @Override
    public void UserExceedCityCall(Subscriber[] UserBase, int time) {
        int c = 0;
        System.out.println("Час міського дзвінка: " + time + "хвилини.\n");
        for (int i = 0; i < UserBase.length; i++){
            if (UserBase[i].getCitycall() > time*60){
                c++;
                System.out.println(UserBase[i].toString());
            }
        }
    }

    @Override
    public void UserUsedIntercityCall(Subscriber[] UserBase) {
        int c = 0;
        for (int i = 0; i < UserBase.length; i++) {
            if (UserBase[i].getIntercitycall() > 0) {
                c++;
                System.out.println(UserBase[i].toString());
            }
        }
    }

    @Override
    public void UsersFirstLetterOfSurname(Subscriber[] UserBase, String letter) {
        char[] letters = new char[0];
        int c = 0;

        for (int i = 0; i < UserBase.length; i++) {
            char[] lettersSurname = UserBase[i].getSurname().toCharArray();

            if (letters[0] == lettersSurname[0]) {
                c++;
                System.out.println("\n" + UserBase[i].toString());
            }
        }
    }

    @Override
    public int InternetTrafficConsumptionCity(Subscriber[] UserBase, String city) {

        int intTriC = 0;
        int c = 0;

        for (int i = 0; i < UserBase.length; i++) {
            if (UserBase[i].getCity().toUpperCase().equals(city.toUpperCase())) {
                System.out.print("\n" + UserBase[i].toString());
                c++;
                intTriC += UserBase[i].getInternettraffic();
            }
        }
        return 0;
    }

    @Override
    public int NumberUsersWithNegativeBalance(Subscriber[] UserBase) {

        int c = 0;

        for (int i = 0; i < UserBase.length; i++) {
            if (UserBase[i].getBalance() < 0) {
                c++;
                System.out.println(UserBase[i].toString());
            }
        }
        return 0;
    }
}
