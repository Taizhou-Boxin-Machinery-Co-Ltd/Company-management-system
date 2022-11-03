package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class S {

	public static Entity surface_side_style(String name, Entity styles) {
		return new Entity("surface_side_style", name, styles);
	}

	public static Entity styled_item(String label, Entity set_of_presentation_layer_assignment, Entity representation) {
		return new Entity("styled_item", label, set_of_presentation_layer_assignment, representation);
	}
}
