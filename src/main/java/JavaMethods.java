public class JavaMethods {
    public static void main(String[] args) {
       /* float myFloat = myFirstMethod(50,70);
        System.out.println(myFloat); */

       /* int number = 31;
        printMessage(number); */

        // drawFullShape(4,5);
        //drawShapeOutline(5,8);
        //drawShapeCorners(4,4);

       // addNumber(1, 100);
       // addNumber(500f, 600f);
       // addNumber(105.6, 88.45);

    }

    public static float myFirstMethod(float input1, float input2){
        return input1 + input2;

    }

    public static boolean isOddNumber(int number){
       return number % 2 != 0;
    }

    public static void printMessage(int number){
        System.out.println(isOddNumber(number) ? number + " is odd number" : number + " is even number");
    }


    public static void drawFullShape(int width, int height){
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                System.out.print("*");

            }
            System.out.println();

        }
    }

    public static void drawFullShape(int length) {
        drawFullShape(length, length);
    }


    public static void drawShapeOutline(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void drawShapeOutline(int length) {
        drawShapeOutline(length, length);
    }

    public static void drawShapeCorners(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 && j == 0) ||
                        (i==0 & j == width -1) ||
                        (i == height - 1 && j == 0) ||
                        (i==height-1 && j == width-1)) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void drawShapeCorners(int length) {
        drawShapeCorners(length, length);
    }

    public static void addNumber(int i, int j){
        System.out.println("adding 2 int numbers with sum " + (i + j));

    }

    public static void addNumber(float i, float j){
        System.out.println("adding 2 float numbers with sum " + (i + j));

    }

    public static void addNumber(double i, double j){
        System.out.println("adding 2 double numbers with sum " + (i + j));

    }
}
