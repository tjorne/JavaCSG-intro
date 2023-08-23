package TicTacToe;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CircleSlot
{
    private final double size;
    private final double height;
    private final double borderWidth;
    private final double slotWidth;


    public CircleSlot(double size, double height, double borderWidth)
    {
        this.size = size;
        this.height = height;
        this.borderWidth = borderWidth;
        this.slotWidth = (size - 4 * borderWidth) / 3;
    }

    public Geometry3D getGeometry(JavaCSG csg)
    {
//        var circle = csg.cylinder3D(slotWidth, height, 64, false);
        var circle = csg.flatRing3D(slotWidth-borderWidth, slotWidth, height, 64, false);
//        return csg.cache(circle);
        return circle;
    }
}
