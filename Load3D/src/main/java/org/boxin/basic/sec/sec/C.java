package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;
import org.boxin.basic.sec.Point;

public class C {

	/**
	 * @param label label
	 * @param point 坐标
	 * @return 实体
	 */
	public static Entity cartesian_point(String label, Point point) {
		return new Entity("cartesian_point", label, point);
	}

	/**
	 *
	 * @param label label
	 * @param set_of_face 例如advanced_face
	 * @return entity
	 */
	public static Entity closed_shell(String label, Entity... set_of_face/*设置面*/) {
		return new Entity("closed_shell", label, set_of_face);
	}

	public static Entity colour_rgb(String name, String r, String g, String b) {
		return new Entity("colour_rgb", name, r, g, b);
	}

}
