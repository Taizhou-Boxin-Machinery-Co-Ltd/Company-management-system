package org.boxin.d3d;

import java.io.*;
import java.util.*;

import static org.boxin.basic.StringSec.*;

/**
 * @author baka4n
 * @see <p1>using <a href="https://en.wikipedia.org/wiki/ISO_10303-21">wikipedia</a></p1>
 */
@SuppressWarnings("JavadocDeclaration")
public class StpModule {
	private String coding_rules;
	private Header header;
	private Data data;
	public StpModule(File loadFile) {
		if (!loadFile.isDirectory()) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(loadFile), "GB2312"))) {
				String line;
				final var ref = new Object() {
					int node = 0;
					final List<String> headerLine = new ArrayList<>();
					final List<String> dataLine = new ArrayList<>();
				};
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					//整理代码段
					sb.append(line);
					//结束整理

				}
				List<String> code = new ArrayList<>(Arrays.asList(sb.toString().split(";")));
				code.forEach(read -> {
					switch (ref.node) {
						case 0 -> {
							if (lower(read).contains("iso")) {
								coding_rules = read;
							} else if (lower(read).contains("header")) {
								ref.node = 1;
							} else if (lower(read).contains("data")) {
								ref.node = 2;
							}
						}
						case 1 -> {
							if (lower(read).contains("endsec")) ref.node = 0;
							else ref.headerLine.add(read);
						}
						case 2 -> {
							if (lower(read).contains("endsec")) ref.node = 0;
							else ref.dataLine.add(read);
						}
					}

				});
				header = new Header(ref.headerLine);
				data = new Data(ref.dataLine);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String lower(String str) {
		return str.toLowerCase().trim();
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
			var ref = new Object() {
				int node = 0;
				int node1 = 0;
			};
			header.forEach(line -> {
				var a = saveILString(line, "(", ")", 1);
				var split = a.contains(",") ? a.split(",") : new String[] { a };
				switch (ref.node) {
					case 0 -> {
							if (lower(line).contains("description")) {
								stpVersion = saveILString(split[ref.node1], "'", "'", 1);
								ref.node = 1;

							} else if (lower(line).contains("name")) {

								default_File_Name = saveILString(split[ref.node1], "'", "'", 1);

								ref.node = 2;
							} else if (lower(line).contains("schema")) {
								EXPRESS = saveILString(split[ref.node1], "'", "'", 1);

							}

					}
					case 1 -> {

						implementation_level = saveILString(split[ref.node1 + 1], "'", "'", 1);

						ref.node = 0;
					}
					case 2 -> {
						var c = saveILString(split[ref.node1 + 1], "'", "'", 1);
						switch (ref.node1) {
							case 0 -> createTime = c;
							case 1 -> email = c;
							case 2 -> company_name = c;
							case 3 -> preprocessor_version = c;
							case 4 -> originating_system = c;
							case 5 -> {
								authorize_to_email = c;
								ref.node1 = -1;
								ref.node = 0;
							}
						}
						ref.node1++;
					}
				}
			});
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
			var ref = new Object() {
				final Map<Integer, NoteData> codes = new HashMap<>();
			};
			data.forEach(line -> {
				List<String> list = new ArrayList<>();
				var a = line.split("=");
				var num = Integer.parseInt(a[0].replace("#", "").trim());
				var code = save0IString(a[1], "(", 1);
				var b = saveILString(a[1], "(", ")", 1);
				var split = b.contains(",") ? b.split(",") : new String[] {b};
				//var split = saveILString(a[1], "(", ")", 1).split(",");
				for (var s : split) {
					list.add(s.contains("'") ? saveILString(s, "'", "'", 1) : s);


					list.add(split[split.length - 1].contains("'") ? saveILString(split[split.length - 1], "'", "'", 1) : split[split.length - 1]);
				}

				var date = new NoteData(code, list.toArray(new String[0]));
				ref.codes.put(num, date);
			});
		}
		private record NoteData(String code, String[] vaules) {
		}
	}
}
