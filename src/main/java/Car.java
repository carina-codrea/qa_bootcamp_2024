import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Car {
    private String model;
    private String color;
    private String type;
    private final double MAX_SPEED = 100;
    private double currentSpeed;
    private float cylinderCapacity;
    private float currentMileage;
    private double carPosition; // compared to magnetic north
    private final int MAX_GEAR = 6;
    private int currentGear;


    public Car (String color, String type, float cylinderCapacity,String model, double carPosition) {
        this.model = model;
        this.color = color;
        this.type = type;
        this.cylinderCapacity = cylinderCapacity;
        this.carPosition = carPosition;
    }

    public Car(String model, String color, String type, double currentSpeed, float cylinderCapacity, float currentMileage, double carPosition, int currentGear) {
        this.model = model;
        this.color = color;
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.cylinderCapacity = cylinderCapacity;
        this.currentMileage = currentMileage;
        this.carPosition = carPosition;
        this.currentGear = currentGear;
    }


    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > MAX_SPEED){
            System.out.println("Invalid speed " + MAX_SPEED);
        }
        else {
            this.currentSpeed = currentSpeed;
        }

    }

    public void startCar(){
        currentGear = 1;
        currentSpeed = 5;
    }

    public void steerLeft(float angle){
        carPosition -= angle;

    }

    public void steerRight(float angle){
        carPosition += angle;
    }

    public void stopCar(){
        currentSpeed = 0;
        currentGear = 0;
    }

    public void increaseMileage(float mileage){
        currentMileage += mileage;
    }

    public void accelerate(double speedDelta){
        if (currentSpeed + speedDelta > MAX_SPEED){
            currentSpeed = MAX_SPEED;
        }
        else {
            currentSpeed += speedDelta;
        }

    }

    public void decelerate(double speedDelta){
        if (currentSpeed - speedDelta < 0){
            currentSpeed = 0;
        }
        else{
            currentSpeed -= speedDelta;
        }
    }

    public void gearUp(){
      if (currentGear < MAX_GEAR){
          currentGear ++;
      }

    }

    public void gearDown(){
        if (currentGear > 0){
            currentGear --;

        }
    }

    public void printCar() {
        System.out.println("---------------------");
        System.out.println("Car model: " + model);
        System.out.println("Car color: " + color);
        System.out.println("Car type: " + type);
        System.out.println("Car position: " + carPosition);
        System.out.println("Mileage: " + currentMileage);
        System.out.println("Current gear: " + currentGear);
        System.out.println("Current speed: " + currentSpeed);
    }
}
