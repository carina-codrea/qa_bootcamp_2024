package inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape {
    private double length;
    private double width;

    public double getArea(){
        return length * width;
    }

    public double getDiagonal(){
        return Math.sqrt(Math.pow(length,2) + Math.pow(width,2));
    }

    public double getPerimeter(){
        return 2 * (length + width);
    }
}
