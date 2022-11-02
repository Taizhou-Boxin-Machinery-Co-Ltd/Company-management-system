package org.boxin.d3d;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baka4n
 * @see <p1>using <a href="https://en.wikipedia.org/wiki/ISO_10303-21">wikipedia</a></p1>
 */
@SuppressWarnings("JavadocDeclaration")
public class StpModule {
	private String coding_rules;
	private final List<String> headerLine = new ArrayList<>();
	private final List<String> dataLine = new ArrayList<>();
	public StpModule(File loadFile) {
		if (!loadFile.isDirectory()) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(loadFile), "GBK"))) {
				String line;
				int node = 0;
				while ((line = br.readLine()) != null) {
					if (node == 1) {
						if (line.contains("ENDSEC;")) {
							node = 0;
							continue;
						}
						headerLine.add(line);
						continue;
					}
					if (node == 2) {
						if (line.contains("ENDSEC;")) {
							node = 0;
							continue;
						}
						dataLine.add(line);
						continue;
					}
					if (line.contains("ISO")) {
						coding_rules = line;
					}
					if (line.contains("HEADER;")) {
						node = 1;//头部
					}
					if (line.contains("DATA;")) {
						node = 2;//数据区域
					}
				}
				for (var a : headerLine) {
					System.out.println(a);
				}
				for (var a : dataLine) {
					System.out.println(a);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Header {

	}
}
