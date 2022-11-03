package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class E {
	/**
	 * edge curve
	 * @param name lable
	 * @param edge_start vertex 输入参数如 VERTEX_POINT
	 * @param edge_end vertex 输入参数如 VERTEX_POINT
	 * @param same_sense bool 输出.T. or .F. 输出真假
	 * @return entity
	 */
	public static Entity edge_curve(String name, Entity edge_start, Entity edge_end, boolean same_sense) {
		return new Entity("edge_curve", name, edge_start, edge_end, same_sense);
	}

	public static Entity edge_loop(String label, Entity[] list_of_oriented_edge) {
		return new Entity("edge_loop", label, list_of_oriented_edge);
	}
}
