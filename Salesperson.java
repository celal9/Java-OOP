import java.awt.*;
import java.util.ArrayList;


class Salesperson extends Entity {


    public Salesperson(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        String text = "";
        drawHelper(g2d,text,Color.GREEN);

    }
    @Override
    public void step() {

    }
}
