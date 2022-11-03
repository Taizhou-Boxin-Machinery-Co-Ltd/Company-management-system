package org.boxin;

import org.boxin.d3d.FileLoad;
import org.boxin.d3d.StpModule;
import org.boxin.d3d.StpModule.Data.NoteData;

import java.io.File;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir"), "解析三维");
		FileLoad.getFile(file);
		FileLoad.find();
		for (var a : FileLoad.stp) {
			StpModule stpModule = new StpModule(a);
			System.out.println(stpModule.getHeader().getStpVersion());
//			System.out.println(stpModule.getHeader().getCreateTime());
//			NoteData x = stpModule.getData().getCodes().get(111);
//			System.out.println(x.code());
//			for (String value : x.values()) {
//				System.out.println(value);
//			}
			System.out.println("\n");
			//System.out.println(stpModule.getHeader().getStpVersion());
			//System.out.println(stpModule.getHeader().getCreateTime());
		}
	}

}
