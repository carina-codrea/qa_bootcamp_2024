package inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shape extends AbstractShape implements IShape {
    private String color;

    public void draw(){
        System.out.println("drawing a shape");

    }

    public void erase(){
        System.out.println("erase");

    }


    @Override
    public void myMethod() {

    }
}
