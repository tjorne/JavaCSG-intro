package TicTacToe;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CrossSlot
{
    private final double size;
    private final double height;
    private final double borderWidth;
    private final double slotWidth;


    public CrossSlot(double size, double height, double borderWidth)
    {
        this.size = size;
        this.height = height;
        this.borderWidth = borderWidth;
        this.slotWidth = (size - 4 * borderWidth) / 3;
    }

    public Geometry3D getGeometry(JavaCSG csg)
    {
        var cross = csg.box3D(slotWidth, height, height, false);

        cross = csg.rotate3DZ(csg.degrees(45.0)).transform(cross);

        var box = csg.box3D(slotWidth, height, height, false);
        box = csg.rotate3DZ(csg.degrees(-45.0)).transform(box);

        cross = csg.union3D(cross, box);

        return csg.cache(cross);
    }
}
