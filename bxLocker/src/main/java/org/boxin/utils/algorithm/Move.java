package org.boxin.utils.algorithm;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//自制移位
@SuppressWarnings("UnusedReturnValue")
public class Move {
    private final List<String> s = new ArrayList<>();
    private List<String> temp;

    public List<String> getS() {
        return s;
    }

    public Move(byte[] bytes) {
        for (var b : bytes) {
            String t = String.format("%08x",b);
            s.add(t);
        }
    }

    public String bytes2String() {
        List<String> s2 = new ArrayList<>(this.s);
        byte[] bytes = new byte[s2.size()];
        for (int i = 0; i < s2.size(); i++) {
            bytes[i] = (byte) Integer.parseInt(s2.get(i), 16);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public Move lg(int n) {
        temp = new ArrayList<>(s);
        s.clear();
        for (var b : temp) {
            int m = n % 4;
            String substring = b.substring(0, b.length() - m);
            String substring1 = b.substring(b.length() - m);
            String v = substring1 + substring;
            s.add(v);
        }
        return this;
    }

    public Move rg(int n) {
        temp = new ArrayList<>(s);
        s.clear();
        for (var b : temp) {
            int m = n % 4;

            String substring = b.substring(0, m);
            String substring1 = b.substring(m);
            String v = substring1 + substring;
            s.add(v);
        }
        return this;
    }
    //位码+1
    public Move plus(int n) {
        temp = new ArrayList<>(s);
        s.clear();
        int nn = n % 3000000;
        for (var b : temp) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                char c = (char) (b.charAt(i) + nn);
                sb.append(c);
            }
            s.add(sb.toString());
        }
        return this;
    }
    public Move reduce(int n) {
        temp = new ArrayList<>(s);
        s.clear();
        int nn = n % 3000000;
        for (var b : temp) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                char c = (char) (b.charAt(i) - nn);
                sb.append(c);
            }
            s.add(sb.toString());
        }
        return this;
    }

    public Move ride(int n) {
        temp = new ArrayList<>(s);
        s.clear();
        int nn = n % 401;
        for (var b : temp) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                char c = (char) (b.charAt(i) * nn);
                sb.append(c);
            }
            s.add(sb.toString());
        }
        return this;
    }

    public Move divide(int n) {
        temp = new ArrayList<>(s);
        s.clear();
        int nn = n % 401;
        for (var b : temp) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                char c = (char) (b.charAt(i) / nn);
                sb.append(c);
            }
            s.add(sb.toString());
        }
        return this;
    }

}
