package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class A {
	public static Entity axis2_placement_3d(String name, Entity location, Entity axis, Entity ref_direction) {
		return new Entity("axis2_placement_3d", name, location, axis, ref_direction);
	}

	public static Entity advanced_face(String label, Entity[] set_face_bound, boolean BOOLEAN) {
		return new Entity("advanced_face", label, set_face_bound, BOOLEAN);
	}

	public static Entity a3m_equivalence_accuracy_association(String id, String name, String description, Entity specific_accuracy, Entity accuracy) {
		return new Entity("a3m_equivalence_accuracy_association", id, name, description, specific_accuracy, accuracy);
	}
}
