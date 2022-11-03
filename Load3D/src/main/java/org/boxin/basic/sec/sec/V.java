package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class V {
	/**
	 *
	 * @param label  label
	 * @param point 传参例如cartesian_point
	 * @return entity
	 */
	public static Entity vertex_point(String label, Entity point) {
		return new Entity("vertex_point", label, point);
	}
}
