public class Main {
    private static CarInspection car = new CarInspection();
    private static float totalCost = 0;

    public static void main(String[] args) {
        float fuelCost = Float.parseFloat(args[0]);
        action(fuelCost);
    }

    private static void action(float fuelCost) {
        String[] route = {"Odesa", "KryveOzero", "Zhashkiv", "Kyiv"};
        float[] distance = {178.5f, 152.8f, 148.2f};

        for (int i = 1; i < route.length; i++) {
            String tmpRoute = route[i - 1] + " -> " + route[i];
            float tmpDistance = distance[i - 1];

            System.out.println("\nМаршрут: " + tmpRoute + " (" + tmpDistance + "km)" +
                    "\nТопливо на маршрут: " + String.format("%.2f", car.determineFuelForRoute(tmpDistance)) + "l" +
                    "\nОстаток топлива: " + String.format("%.2f", car.getRemainder()) + "l");

            float tmpRfuel = car.determineRefuel(tmpDistance);

            if (tmpRfuel > 0) {
                float tmpTotalCost = tmpRfuel * fuelCost;
                System.out.println(
                        "Заправка " + String.format("%.2f", tmpRfuel) + "l Стоимость " + String.format("%.2f",tmpTotalCost) + "UAH");

                totalCost += tmpTotalCost;
            }
            car.determineRemainder(tmpDistance);
        }

        System.out.println("\nОстаток после маршрута " + String.format("%.2f", car.getRemainder()) + "l" +
                "\nДеньги были потрачены\n: " + String.format("%.2f", totalCost) + "UAH");
    }
}
