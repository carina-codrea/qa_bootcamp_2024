package inheritance;

public class Main {
    public static void main(String[] args) {
        Shape myShape = new Shape();
        myShape.draw();
        myShape.erase();
        myShape.setColor("green");

        System.out.println("The shape has color: " + myShape.getColor());

        Rectangle myRectangle = new Rectangle(4,5);
        myRectangle.draw();

        Square square = new Square(12);
        square.printCurrentSquare();
        square.getDiagonal();
        System.out.println();

        Shape shape1 = new Square();
        Shape shape2 = new Circle();
        Shape shape3 = new Rectangle();
        Shape shape4 = new Triangle();

        shape1.draw();
        shape2.draw();
        shape3.draw();
        shape4.draw();

        Person teacher = new Teacher("UPB");
        teacher.setName("Alex");
        teacher.setName("G");
        teacher.eat();
        ((Teacher)teacher).teachCourse();

        Person student = new Student();
        student.setName("Andrei");
        student.setName("Studentila");
        student.eat();
        ((Student) student).getGrades();



    }
}
