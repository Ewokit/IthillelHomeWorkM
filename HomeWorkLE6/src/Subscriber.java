public class Subscriber {
    private String identifier;
    private String surname;
    private String name;
    private String patronymic;
    private String city;
    private String phonenum;
    private String contractnum;
    private float balance;
    private int citycall;
    private int intercitycall;
    private int internettraffic;

    public Subscriber(String identifier, String surname, String name, String patronymic, String city,
                      String phonenum, String contractnum, float balance, int citycall, int intercitycall, int internettraffic) {
        this.identifier = identifier;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
        this.phonenum = phonenum;
        this.contractnum = contractnum;
        this.balance = balance;
        this.citycall = citycall;
        this.intercitycall = intercitycall;
        this.internettraffic = internettraffic;
    }

    public Subscriber(String identifier, String белаш, String ніна, String олексіївна, String гадяч, String phonenum, String ac06, String s, String s1, String s2, String s3) {
    }


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic = patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getContractnum() {
        return contractnum;
    }

    public void setContractnum(String contractnum) {
        this.contractnum = contractnum;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getCitycall() {
        return citycall;
    }

    public void setCitycall(int citycall) {
        this.citycall = citycall;
    }

    public int getIntercitycall() {
        return intercitycall;
    }

    public void setIntercitycall(int intercitycall) {
        this.intercitycall = intercitycall;
    }

    public int getInternettraffic() {
        return internettraffic;
    }

    public void setInternettraffic(int internettraffic) {
        this.internettraffic = internettraffic;

    }

    public void toString(int index) {
        String r = "";
        switch (index) {

            case 1:
                r = "Ідентифікатор: " + identifier + "\nНомер договору: №" + contractnum +
                        "\nПовне ім'я: " + surname + " " + name + " " + patronymic + "\nМісто: " + city +
                        "\nТелефонний номер: " + phonenum + "\nМіський дзвінок: " + convertTime(citycall) + "\n";
                break;

            case 2:
                r = "Ідентифікатор: " + identifier + "\nНомер договору: №" + contractnum +
                        "\nПовне ім'я: " + surname + " " + name + " " + patronymic + "\nМісто: " + city +
                        "\nТелефонний номер: " + phonenum + "\nЧас міжміського дзвінка: " + convertTime(intercitycall) + "\n";
                break;
            case 3:
                r = "Ідентифікатор: " + identifier + "\nНомер договору: №" + contractnum +
                        "\nПовне ім'я: " + surname + " " + name + " " + patronymic +
                        "\nМісто: " + city + "\nТелефонний номер: " + phonenum + "\nБаланс: " + balance + "UAH" +
                        "\nМіський дзвінок: " + convertTime(citycall) +
                        "\nЧас міжміського дзвінка: " + convertTime(intercitycall) +
                        "\nІнтернет трафік: " + internettraffic + " Gb";
                break;

            case 4:
                r = "Ідентифікатор: " + identifier + "\nНомер договору: №" + contractnum +
                        "\nПовне ім'я: " + surname + " " + name + " " + patronymic + "\nМісто: " + city +
                        "\nТелефонний номер: " + phonenum + "\nІнтернет трафік: " + internettraffic + " Mb\n";
                break;
            case 5:
                r = "Ідентифікатор: " + identifier + "\nНомер договору: №" + contractnum +
                        "\nПовне ім'я: " + surname + " " + name + " " + patronymic + "\nТелефонний номер: " + phonenum +
                        "\nБаланс: " + balance + " UAH\n";
        }
        return;
    }

    public String convertTime(int TIS){
    String time = "";

            int tmpMinute = TIS % 3600;
            int hour = (TIS - tmpMinute) / 3600;
            int second = tmpMinute % 60;
            int minute = (tmpMinute - second) / 60;

            if (hour > 9) {
                time += hour + ":";
            } else if (hour > 0) {
                time += "0" + hour + ":";
            } else {
                time += "00:";
            }

            if (minute > 9) {
                time += minute + ":";
            } else if (minute > 0) {
                time += "0" + minute + ":";
            } else {
                time += "00:";
            }

            if (second > 9) {
                time += second;
            } else if (second > 0) {
                time += "0" + second;
            } else {
                time += "00";
            }

            return time;
        }
    }