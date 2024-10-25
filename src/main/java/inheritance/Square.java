package inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }

    public void printCurrentSquare(){
        System.out.println("Square with side " + this.getLength() + " has area of " + this.getArea());
    }

    @Override
    public void draw(){
        System.out.println("Drawing a square");
    }

    @Override
    public String toString(){
        return "My square has  4 sides each " + this.getLength();
    }
}
