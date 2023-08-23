package TicTacToe;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Board
{
    private final double size;
    private final double height;
    private final double borderWidth;
    private final boolean roundSlots;
    private final double slotWidth;

    public Board(double size, double height, double borderWidth, boolean roundSlots)
    {
        this.size = size;
        this.height = height;
        this.borderWidth = borderWidth;
        this.roundSlots = roundSlots;
        this.slotWidth = (size - 4 * borderWidth) / 3;

    }

    public Geometry3D getGeometry(JavaCSG csg)
    {
        var base = csg.box3D(size, size, height, false);

        var slotCutout = roundSlots ?
                csg.cylinder3D(slotWidth, height, 64, false) :
                csg.box3D(slotWidth, slotWidth, height, false);

        slotCutout = csg.translate3D(0.5*slotWidth,0.5*slotWidth,0.5*height).transform(slotCutout);

        var slots = new Geometry3D[9];

        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                var slot = csg.translate3D
                        (
                                -0.5*size + borderWidth + (borderWidth + slotWidth) * i,
                                -0.5*size + borderWidth + (borderWidth + slotWidth) * j,
                                0
                        ).transform(slotCutout);
                slots[i*3+j] = slot;
            }
        }

        base = csg.difference3D(base, slots);


        return csg.cache(base);
    }
}
