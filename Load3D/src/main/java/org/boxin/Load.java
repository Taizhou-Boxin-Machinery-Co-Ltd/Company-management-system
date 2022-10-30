package org.boxin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Load {
	private int stpVersion;
	private final List<String> strings = new ArrayList<>();
	private boolean isStep = false;
	private boolean isIgs = false;


	public Load(File file) {
		ap(file);
		for (var a : strings) {
			if (a.contains("STEP AP")) {
				this.setStep(true);
				String ap = a.substring(a.indexOf("AP") + 2);
				var b = ap.substring(0,  ap.indexOf("'"));
				stpVersion = Integer.parseInt(b);
				System.out.println(stpVersion);
				break;
			}
		}
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

	private void setStep(boolean step) {
		isStep = step;
	}
}
