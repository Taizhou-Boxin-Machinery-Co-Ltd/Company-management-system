package org.boxin;

import org.boxin.d3d.FileLoad;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir"), "解析三维");
		FileLoad.getFile(file);
		FileLoad.find();
		for (var a : FileLoad.solidworksFiles) {
			System.out.println(a);
		}
	}

}
