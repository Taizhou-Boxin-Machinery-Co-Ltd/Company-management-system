package org.boxin.basic.sec;

public record Entity(String name, Object... value) {
	@Override
	public String toString() {
		return name();
	}
}
