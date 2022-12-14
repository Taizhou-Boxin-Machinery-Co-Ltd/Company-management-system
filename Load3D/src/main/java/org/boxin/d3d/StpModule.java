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
				List<String> code = new ArrayList<>(Arrays.asList(sb.toString().trim().split(";")));
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
		return str.toLowerCase();
	}

	public String getCoding_rules() {
		return coding_rules;
	}

	public Header getHeader() {
		return header;
	}

	public Data getData() {
		return data;
	}

	public static class Header {
		private int stpVersion;
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
			};
			header.forEach(line -> {
				ref.node = lower(line).contains("description")
						? 1 : lower(line).contains("name")
						? 2 : lower(line).contains("schema")
						? 3 : 0;
				var a = saveILString(line, "(", ")", 1);
				var split = a.split(",");
				switch (ref.node) {
					case 1 -> invokeDescription(split);
					case 2 -> invokeName(split);
					case 3 -> EXPRESS = saveILString(split[0], "'", "'", 1);
				}
			});
		}
		public final void invokeName(String[] split) {
			default_File_Name = saveILString(split[0], "'", "'", 1);
			createTime = saveILString(split[1], "'", "'", 1);
			email = saveILString(split[2], "'", "'", 1);
			company_name = saveILString(split[3], "'", "'", 1);
			preprocessor_version = saveILString(split[4], "'", "'", 1);
			originating_system = saveILString(split[5], "'", "'", 1);
			authorize_to_email = saveILString(split[6], "'", "'", 1);
		}
		public final void invokeDescription(String[] split) {
			stpVersion = Integer.parseInt(
					saveI0String(
							saveILString(split[0], "'", "'", 1),
							"AP"
					).replace("AP", "")
			);
			implementation_level = saveILString(split[1], "'", "'", 1);
		}

		public int getStpVersion() {
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
		private final Map<Integer, NoteData> codes = new HashMap<>();
		private final Map<Integer, String> nc = new HashMap<>();
		public Data(List<String> data) {

			data.forEach(line -> {

				//初步获取#行代码
				var a = line.split("=");
				var num = Integer.parseInt(a[0].replace("#", "").trim());
				var code = a[1];
				nc.put(num, code);
				System.out.println( num + ":" + code);
			});
		}

		public record DataRecord(String method, Object... objects) {

		}

		public Map<Integer, NoteData> getCodes() {
			return codes;
		}

		public record NoteData(String code, String[] values) {
			@Override
			public String toString() {
				return code;
			}
			public String[] toStrings() {
				return values;
			}
		}
	}
}
