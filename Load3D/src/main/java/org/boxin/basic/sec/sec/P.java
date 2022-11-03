package org.boxin.basic.sec.sec;

import org.boxin.basic.sec.Entity;

public class P {
	public static Entity presentation_layer_assignment(String label, String text, Entity item) {
		return new Entity("presentation_layer_assignment", label, text, item);
	}
}
