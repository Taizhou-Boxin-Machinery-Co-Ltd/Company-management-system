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
	private final List<String> dataLine = new ArrayList<>();
	private Header header;
	public StpModule(File loadFile) {
		if (!loadFile.isDirectory()) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(loadFile), "GB2312"))) {
				String line;
				int node = 0;
				List<String> headerLine = new ArrayList<>();
				while ((line = br.readLine()) != null) {
					switch (node) {
						case 0 -> {
							if (line.contains("HEADER;")) {
								node = 1;//头部
							}
							if (line.contains("DATA;")) {
								node = 2;//数据区域
							}
							if (line.contains("ISO")) {
								coding_rules = line;
							}
						}
						case 1 -> {
							if (line.contains("ENDSEC;")) {
								node = 0;
								continue;
							}
							headerLine.add(line);
						}
						case 2 -> {
							if (line.contains("ENDSEC;")) {
								node = 0;
								continue;
							}
							dataLine.add(line);
						}
					}

				}
				header = new Header(headerLine);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCoding_rules() {
		return coding_rules;
	}

	public Header getHeader() {
		return header;
	}

	public static class Header {
		private String stpVersion;
		private String implementation_level;//1 default for 1994, 2 or 3 for 1995
		private String default_File_Name;
		private String createTime;
		private String email;
		private String company_name;
		private String preprocessor_version;
		private String originating_system;
		private String authorize_to_email;
		private String EXPRESS;
		public Header(List<String> header) {
			int node = 0;
			int node1 = 0;
			for (var h : header) {
				final String[] split = h.substring(h.indexOf("'") + 1).split("'");
				switch (node) {
					case 0 -> {
						if (h.contains("FILE_DESCRIPTION")) {
							stpVersion = h.split("'")[1];
							node = 1;
						} else if (h.contains("FILE_NAME")) {
							default_File_Name = h.split("'")[1];
							node = 2;
						} else if (h.contains("FILE_SCHEMA")) {
							EXPRESS = split[0];
						}
					}
					case 1 -> {
						implementation_level = split[0];
						node = 0;
					}
					case 2 -> {
						switch (node1) {
							case 0 -> {
								createTime = split[0];
								node1 = 1;
							}
							case 1 -> {
								email = split[0];
								node1 = 2;
							}
							case 2 -> {
								company_name = split[0];
								node1 = 3;
							}
							case 3 -> {
								preprocessor_version = split[0];
								node1 = 4;
							}
							case 4 -> {
								originating_system = split[0];
								node1 = 5;
							}
							case 5 -> {
								authorize_to_email = split[0];
								node1 = 0;
								node = 0;
							}
						}
					}
				}

			}
		}

		public String getStpVersion() {
			return stpVersion;
		}

		public String getImplementation_level() {
			return implementation_level;
		}

		public String getDefault_File_Name() {
			return default_File_Name;
		}

		public String getCreateTime() {
			return createTime;
		}

		public String getEmail() {
			return email;
		}

		public String getCompany_name() {
			return company_name;
		}

		public String getPreprocessor_version() {
			return preprocessor_version;
		}

		public String getOriginating_system() {
			return originating_system;
		}

		public String getAuthorize_to_email() {
			return authorize_to_email;
		}

		public String getEXPRESS() {
			return EXPRESS;
		}
	}
	public static class Data {
		public Data(List<String> data) {
			int node = 0;
			for (var d : data) {
				switch (node) {
					case 0 -> {
						node = 1;
					}
					case 1 -> {

					}
				}
			}
		}
	}
}
