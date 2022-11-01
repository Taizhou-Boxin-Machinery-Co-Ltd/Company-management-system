package org.boxin.d3d;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLoad {
	public static final List<String> strings = Arrays.asList(
			"sldprt","sldasm","slddrw",//solidworks files, part files
			"prt",//part files,UGII, proEngineer part
			"asm",// assembly files, proEngineer assembly
			"drw",//drawing files
			"dxf", "dwg",//autocad files
			"psd",//adobe photoshop files
			"ai",//adobe illustrator files
			"lfp", "sldlfp",//lib feat part
			"prtdot", "asmdot", "drwdot",//template 模板文件
			"x_t", "smt_txt", "xmt_bin",//parasolid
			"igs", "iges",//IGES
			"step", "stp",//step ap 203/214
			"ifc",//IFC 2x3
			"sat","vda",//ACIS
			"wrl", "stl",//vrml
			"cgr",//catia graphics
			"catpart", "catproduct",//catia v5
			"xpr",//proEngineer part
			"xas"//proEngineer assembly

	);
	public static final List<File> solidworksFiles = new ArrayList<>();
	public static final List<File> prtFiles = new ArrayList<>();
	public static final List<File> assemblyFiles = new ArrayList<>();
	public static final List<File> drawingFiles = new ArrayList<>();
	public static final List<File> autodesk = new ArrayList<>();
	public static final List<File> adobe = new ArrayList<>();
	public static final List<File> listAll = new ArrayList<>();
	public static final List<File> DLT = new ArrayList<>();//Design Library Templates -> solidworks
	public static final List<File> igs = new ArrayList<>();
	public static final List<File> stp = new ArrayList<>();
	public static final List<File> ifc = new ArrayList<>();//工业基础类
	public static final List<File> acis = new ArrayList<>();// acis app files
	public static final List<File> vrml = new ArrayList<>();//Virtual Reality Modeling Language
	public static final List<File> catia = new ArrayList<>();
	public static final List<File> proEngineer = new ArrayList<>();
	public static final List<File> ug = new ArrayList<>();
	public static final List<File> solidEdge = new ArrayList<>();
	public static final List<File> cadKey = new ArrayList<>();
	public static final List<File> add_ins = new ArrayList<>();
	public static final List<File> idf = new ArrayList<>();
	public static void find() {
		for (var tmp : listAll) {
			if (is(tmp, "*.sldprt")) {
				solidworksFiles.add(tmp);
				prtFiles.add(tmp);
			}
			if (is(tmp, "*.sldasm")) {
				solidworksFiles.add(tmp);
				assemblyFiles.add(tmp);
			}
			if (is(tmp, "*.slddrw")) {
				solidworksFiles.add(tmp);
				drawingFiles.add(tmp);
			}
			if (is(tmp, "*.prt")) {
				prtFiles.add(tmp);
				proEngineer.add(tmp);
				ug.add(tmp);
				cadKey.add(tmp);
			}
			if (is(tmp, "*.asm")) {
				assemblyFiles.add(tmp);
				proEngineer.add(tmp);
				solidEdge.add(tmp);
			}
			if (is(tmp, "*.drw")) drawingFiles.add(tmp);
			if (is(tmp, "*.dxf", "*.dwg","*.ipt", "*.iam")) autodesk.add(tmp);
			if (is(tmp, "*.psd", "*.ai")) adobe.add(tmp);
			if (is(tmp, "*.lfp", "*.sldlfp")) DLT.add(tmp);// Lib Feat Part
			if (is(tmp, "*.igs", "*.iges")) igs.add(tmp);
			if (is(tmp, "*.step", "*.stp")) stp.add(tmp);
			if (is(tmp, "*.ifc")) ifc.add(tmp);
			if (is(tmp, "*.sat", "*.vda"))acis.add(tmp);
			if (is(tmp, "*.wrl", "*.stl"))vrml.add(tmp);
			if (is(tmp, "*.cgr", "*.catpart", "*.catproduct")) catia.add(tmp);
			if (is(tmp, "*.prt.*", "*.xpr", "*.asm.*", "*.xas")) proEngineer.add(tmp);
			if (is(tmp, "*.par", "*.psm")) solidEdge.add(tmp);
			if (is(tmp,  "*.ckd")) cadKey.add(tmp);
			if (is(tmp, "*.dll")) add_ins.add(tmp);
			if (is(tmp, "*.emn", "*.brd", "*.bdf", "*.idb")) idf.add(tmp);

		}
	}

	/**
	 * {@code 用于判断是否为这个文件类型}
	 * @param key 文件
	 * @param values 判断键
	 * @return is
	 */
	public static boolean is(File key, String... values) {
		for (var value : values) {
			var fileStr = key.getPath().toLowerCase();

			var split = fileStr.split("\\.");//示例将文件a.b.c
			if (split[0].contains("~")) {
				return false;
			}
			if (value.contains(".")) {
				var split_ = value.split("\\.");
				boolean aBoolean = true;
				for (int i = split_.length - 1; i >=0;i--) {
					aBoolean = split_[i].contains("*") ? aBoolean : aBoolean && split[split.length - split_.length + i].contains(split_[i]);
				}
				return aBoolean;
			}

		}
		return false;
	}

	public static boolean contains(File key, String... contains) {
		for (var tmp : contains) {
			if (key.getPath().toLowerCase().contains(tmp)) {
				return true;
			}
		}
		return false;
	}

	public static void getFile(File file) {
		if (file.exists() && file.isDirectory()) {
			var f = file.listFiles();
			if (f != null) {
				for (var fi : f) {
					getFile(fi);
				}
			}
		} else {
			listAll.add(file);
		}
	}

}
