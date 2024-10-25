import inheritance.Rectangle;
import inheritance.Square;

public class ObjectsCourse {
    public static void main(String[] args) {
        Car dacia1300 = new Car("RED","Sedan",1300,"dacia 1300", 45);

        dacia1300.printCar();


        dacia1300.startCar();
        dacia1300.accelerate(20);
        dacia1300.gearUp();
        dacia1300.steerRight(45);
        dacia1300.increaseMileage(5);
        dacia1300.stopCar();

        dacia1300.printCar();

        Square square = new Square(5);
        square.printCurrentSquare();

        for (String value : args){
            Square square1 = new Square(Double.parseDouble(value));
            square1.printCurrentSquare();

        }

        Rectangle rectangle = new Rectangle(10,12);
        System.out.println("Area is : " + rectangle.getArea() + " diagonal is : " + rectangle.getDiagonal() + " perimeter is: " + rectangle.getPerimeter());
    }
}
