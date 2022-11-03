package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class O {
	public static Entity oriented_edge(String label, Entity vertex1, Entity vertex2, Entity edge) {
		return new Entity("oriented_edge", label, vertex1, vertex2, edge);
	}
}
