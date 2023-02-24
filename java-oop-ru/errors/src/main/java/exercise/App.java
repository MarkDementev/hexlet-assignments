package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) throws NegativeRadiusException {
        try {
            System.out.println((int) Math.ceil(circle.getSquare()) + "\nВычисление окончено");
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь\nВычисление окончено");
        }
    }
}
// END
