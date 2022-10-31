package org.boxin;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir"), "解析三维");
		Load.loadStep(file, new String[]{"step","stp"});
		for (Load load : Load.loads) {
			System.out.println(load.getStpVersion());

		}
	}

}
