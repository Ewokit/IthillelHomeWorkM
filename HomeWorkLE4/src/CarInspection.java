public class CarInspection extends Car{
    private float fillTheGTc(float distance) {    //заправить
        float refuel = getGTc() - getRemainder();

        setRemainder(getGTc());
        System.out.println("Заправка: " + String.format("%.2f", refuel) + "l \nОстаток топлива: " + getRemainder() + "l");

        return refuel;
    }

    public void determineRemainder(float distance) {
        setRemainder(getRemainder() - distance * getConsumption() / 100);
    }

    public float determineRefuel(float distance) {
        float fuelForRoute = determineFuelForRoute(distance);
        float refuel = 0;

        if (fuelForRoute > getRemainder()) {
            float tmpFuel = fuelForRoute - getRemainder();

            if (getGTc() / 2 > getRemainder()) {
                System.out.println("GTc меньше половины. Вам нужна полная заправка.");
                refuel = fillTheGTc(distance);
            } else {
                System.out.println("Нужно заправиться\n: " + tmpFuel + "l");
                setRemainder(getRemainder() + tmpFuel);
            }

        } else {
            System.out.println("В баке достаточно топлива.");
        }
        return refuel;
    }

    public float determineFuelForRoute(float distance) {
        return getConsumption() * distance / 100;
    }
}
