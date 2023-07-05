import java.awt.*;
import java.util.ArrayList;

class Supplier extends Entity {

    private ArrayList<Product> shoppingList;
    private Store target;
    private ArrayList<Store> visited;

    public Supplier(double x, double y,ArrayList<Product> shoppingList) {
        super(x, y);
        this.shoppingList = shoppingList;
        visited = new ArrayList<Store>();

    }

    @Override
    public void draw(Graphics2D g2d) {
        String text = "";
        drawHelper(g2d,text,Color.GREEN);
    }

    @Override
    public void step() {

        if (target == null) {
            int cheapest = Integer.MAX_VALUE;
            double closest = Double.POSITIVE_INFINITY;
            double dist;






                    for (Store s : Common.getStoreList()) {
                        if (!visited.contains(s)) {
                            dist = this.getPosition().distanceTo(s.getPosition().getX(), s.getPosition().getY());
                            if (dist < closest) {
                                closest = dist;
                                target = s;
                            }
                        }
                    }



                    if (closest == Double.POSITIVE_INFINITY) {
                        visited = new ArrayList<Store>();
                    }


        } else {
            double targetX = target.getPosition().getX();
            double targetY = target.getPosition().getY();
            double dist = this.getPosition().distanceTo(targetX, targetY);
            if (dist <= 2 * Common.getEntityDiameter()) {




                            target.replenish();

                            visited.add(target);

                        target = null;

            } else {
                double x = targetX - this.getPosition().getX();
                double y = targetY - this.getPosition().getY();
                if (dist > Common.getsUPPLİERMovementSpeed()) {
                    double vx = x / dist * Common.getsUPPLİERMovementSpeed();
                    double vy = y / dist * Common.getsUPPLİERMovementSpeed();
                    getPosition().setX(getPosition().getX() + vx);
                    getPosition().setY(getPosition().getY() + vy);
                } else {
                    getPosition().setX(x);
                    getPosition().setY(y);
                }

            }
        }
    }
}