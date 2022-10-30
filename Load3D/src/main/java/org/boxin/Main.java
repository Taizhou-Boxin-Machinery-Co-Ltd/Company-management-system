package org.boxin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
	public static void main(String[] args) {
		List<Load> steps = new ArrayList<>();
		File file = new File(System.getProperty("user.dir"), "解析三维");
		List<File> files = null;
		if (file.exists() && file.isDirectory()) {
			files = getFiles(file);
		}
		if (files != null) {
			for (var f : files) {
				Load loadStep = new Load(f);
				steps.add(loadStep);
			}
		}
	}
	public static List<File> getFiles(File file) {
		List<File> files = new ArrayList<>();
		for (var f : Objects.requireNonNull(file.listFiles())) {
			if (f.isDirectory()) {
				files.addAll(getFiles(f));
			} else {
				files.add(f);
			}
		}
		return files;
	}
}
