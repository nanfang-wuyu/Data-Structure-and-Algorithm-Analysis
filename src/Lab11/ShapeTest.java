package Lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeTest {
	public static void main(String[] args) {

		List<Circle> circleList = new ArrayList<>();
		Circle.setScreenSize(9);
		StdDraw.setScale(-Shape.getScreenSize(),
				Shape.getScreenSize());
		int y = 10 ;
		for (int i = 1; i <=Shape.getScreenSize(); i += 2) {
			circleList.add(new Circle(i, 0,y -Shape.getScreenSize()));
			y=y+2;
		}
		Collections.sort(circleList);
		for (int i = 0; i < circleList.size(); i++) {
			circleList.get(i).customizedColor(ColorScheme.SKY, i);
		}
	}
}
