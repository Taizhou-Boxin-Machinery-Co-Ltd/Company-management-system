package org.boxin.basic;

public class StpSec {
	public static class Point {
		private final String x;
		private final String y;
		private final String z;

		public Point(String x, String y, String z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String getX() {
			return x;
		}

		public String getY() {
			return y;
		}

		public String getZ() {
			return z;
		}
	}
	public static class Entity {
		private final String name;
		private final Object[] value;
		public Entity(String name ,Object... value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public Object[] getValue() {
			return value;
		}
	}

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
	public static Entity manifold_solid_brep(String name, Entity close_shell) {
		return new Entity("manifold_solid_brep", name, close_shell);
	}

	public static Entity presentation_layer_assignment(String label, String text, Entity item) {
		return new Entity("presentation_layer_assignment", label, text, item);
	}

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

	public static Entity surface_side_style(String name, Entity styles) {
		return new Entity("surface_side_style", name, styles);
	}

	public static Entity colour_rgb(String name, String r, String g, String b) {
		return new Entity("colour_rgb", name, r, g, b);
	}

	public static Entity direction(String name, String... a) {
		return new Entity("direction", name, a);
	}

	public static Entity axis2_placement_3d(String name, Entity location, Entity axis, Entity ref_direction) {
		return new Entity("axis2_placement_3d", name, location, axis, ref_direction);
	}



	public static Entity advanced_face(String label, Entity[] set_face_bound, boolean BOOLEAN) {
		return new Entity("advanced_face", label, set_face_bound, BOOLEAN);
	}

	public static Entity face_outer_bound(String label, Entity loop, boolean BOOLEAN) {
		return new Entity("face_outer_bound", label, loop, BOOLEAN);
	}

	public static Entity edge_loop(String label, Entity[] list_of_oriented_edge) {
		return new Entity("edge_loop", label, list_of_oriented_edge);
	}

	public static Entity oriented_edge(String label, Entity vertex1, Entity vertex2, Entity edge) {
		return new Entity("oriented_edge", label, vertex1, vertex2, edge);
	}
	public static Entity styled_item(String label, Entity set_of_presentation_layer_assignment, Entity representation) {
		return new Entity("styled_item", label, set_of_presentation_layer_assignment, representation);
	}

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
