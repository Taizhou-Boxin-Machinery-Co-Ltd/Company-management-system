package org.boxin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Load {
	private int stpVersion;
	protected String docStandards;
	private final List<String> strings = new ArrayList<>();
	protected boolean isStep = false;
	protected boolean isIgs = false;
	protected final File file;


	public Load(File file) {
		this.file = file;
		ap(file);
	}
	private int i = 0;
	public Load load3DProperties() {
		for (var str : strings) {
			if (str.contains("ISO-10303-21")) {
				docStandards = str.replace(";", "").trim();
			} else if (str.contains("HEADER")) {
				i = 1;
			}
			if (i == 1 /*代表HEADER开始*/&& str.contains("FILE_DESCRIPTION")) {
				//文件描述
				String tmp = str.substring(str.indexOf("'") + 1, str.lastIndexOf("'"));
				stpVersion = Integer.parseInt(tmp.substring(tmp.indexOf("AP") + 2).trim());
				if (tmp.contains("AP")) {
					this.setStep(true);
				}

			}
		}
		return this;
	}

	public int getStpVersion() {
		return stpVersion;
	}

	private void ap(File file) {
		if (!file.exists() || file.isDirectory()) {
			System.out.println("not file");
		}
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				strings.add(strings.size(), line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isStep() {
		return isStep;
	}

	public void setStep(boolean step) {
		isStep = step;
	}

	public static final List<Load> loads = new ArrayList<>();

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

	public static void loadStep(File file, String[] subFix_) {
		List<File> files = null;
		if (file.exists() && file.isDirectory()) {
			files = getFiles(file);
		}
		if (files != null) {
			for (var f : files) {
				final var subFix = f.getName().toLowerCase().substring(f.getName().toLowerCase().lastIndexOf(".") + 1);
				for (var a : subFix_) if (subFix.equals(a)) loads.add(new Load(f).load3DProperties());
			}
		}
	}

}
