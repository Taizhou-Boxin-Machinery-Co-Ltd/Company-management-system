package org.boxin.basic;

/**
 * 示例：12345678 index of（"12345678", "1"） int = 1;
 */
public class StringSec {
	public static int indexOf(String name, String mChar) {
		//从1开始计数
		return name.indexOf(mChar) + 1;
	}
	public static int lastIndexOf(String name, String mChar) {
		return name.lastIndexOf(mChar) + 1;
	}

	/**
	 * 12345678971 保留字段1和7的字符串 saveString（name, "1", "7"）; 1234567
	 * @param name string
	 * @param char1 char
	 * @param char2 char
	 * @return string
	 */
	public static String saveIIString(String name, String char1, String char2) {
		return name.substring(name.indexOf(char1), name.indexOf(char2) + 1);
	}

	public static String saveIIString(String name, String char1, String char2, int i) {
		return name.substring(name.indexOf(char1) + i, name.indexOf(char2) + 1 - i);
	}

	/**
	 * 12345678971 保留字段1和7的字符串 saveString（name, "1", "7"）; 1234567897
	 * @param name string
	 * @param char1 char
	 * @param char2 char
	 * @return string
	 */
	public static String saveILString(String name, String char1, String char2) {
		return name.substring(name.indexOf(char1), name.lastIndexOf(char2) + 1);
	}

	public static String saveILString(String name, String char1, String char2, int i) {
		return name.substring(name.indexOf(char1)  + i, name.lastIndexOf(char2) + 1 - i);
	}

	public static String save0IString(String name, String char1) {
		return name.substring(0, name.indexOf(char1) + 1);
	}

	public static String save0IString(String name, String char1, int i) {
		return name.substring(0, name.indexOf(char1) + 1 - i);
	}

	public static String saveI0String(String name,  String char1, int i) {
		return name.substring(name.indexOf(char1) + i);
	}
	public static String saveI0String(String name,  String char1) {
		return name.substring(name.indexOf(char1));
	}

	/**
	 * 12345678917 保留字段1和7的字符串 saveString（name, "1", "7"）; 17
	 * @param name string
	 * @param char1 char
	 * @param char2 char
	 * @return string
	 */
	public static String saveLIString(String name, String char1, String char2) {
		return name.substring(name.lastIndexOf(char1), name.indexOf(char2) + 1);
	}

	/**
	 * 找到顺位第n个指定字符位置
	 * @param name string
	 * @param mChar char
	 * @param n int
	 * @return int
	 */
	public static int indexNOf(String name, String mChar, int n) {
		int a = 0;
		String b = name;
		for (int i = 0 ; i <= n ;i++) {
			if (!b.contains(mChar)) {
				break;
			}
			a += b.indexOf(mChar) + 1;
			b = b.substring(b.indexOf(mChar) + 1);
		}
		return a;
	}

	public static int lastIndexNOf(String name, String mChar, int n) {
		String b = name;
		int a = 0;
		for (int i = 0 ; i <= n ; i++) {
			if (!b.contains(mChar)) {
				break;
			}
			var c = b.lastIndexOf(mChar) + 1;
			b = b.substring(0, b.lastIndexOf(mChar));
			if (a == 0) {
				a = c;
				continue;
			}
			a -= c;
		}
		return a;
	}
}
