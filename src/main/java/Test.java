import TicTacToe.Board;
import TicTacToe.CircleSlot;
import TicTacToe.CrossSlot;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

import java.util.ArrayList;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();
		var box = csg.box3D(10, 50, 10, false);

		csg.view(box);

		var bolle = csg.torus3D(10, 5, 64, 64, false);
		csg.view(bolle, 1);
	}
}
