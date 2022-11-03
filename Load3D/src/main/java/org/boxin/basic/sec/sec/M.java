package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class M {
	public static Entity manifold_solid_brep(String name, Entity close_shell) {
		return new Entity("manifold_solid_brep", name, close_shell);
	}
}
