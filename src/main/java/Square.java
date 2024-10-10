import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Square {
    private double squareSide;

    public double getArea(){
        return Math.pow(squareSide, 2);
    }

    public void printCurrentSquare(){
        System.out.println("Square with side " + this.squareSide + " has area of " + this.getArea());
    }
}
