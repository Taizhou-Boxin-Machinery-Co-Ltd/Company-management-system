package org.boxin.utils.algorithm;

import java.util.ArrayList;
import java.util.List;

//自制移位
public class Move {
    private final List<String> s = new ArrayList<>();

    public List<String> getS() {
        return s;
    }

    private final int n;
    public Move(byte[] bytes, int n) {
        this.n = n;
        for (var b : bytes) {
            String t = String.format("%08x",b);
            s.add(t);
        }

    }

    public Move lg() {
        List<String> sa = new ArrayList<>(s);
        s.clear();
        for (var b : sa) {
            int m = n % 8;
            String substring = b.substring(0, b.length() - m);
            String substring1 = b.substring(b.length() - m);
            String v = substring1 + substring;
            s.add(v);
        }
        return this;
    }

    public Move rg() {
        List<String> sa = new ArrayList<>(s);
        s.clear();
        for (var b : sa) {
            int m = n / 8;

            String substring = b.substring(0, m+3);
            String substring1 = b.substring(m+3);
            String v = substring1 + substring;
            s.add(v);
        }
        return this;
    }
    //位码+1
    public Move ad(int n) {
        List<String> sa = new ArrayList<>(s);
        s.clear();
        for (var b : sa) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                char c = (char) (b.charAt(i) + n);
                sb.append(c);
            }
            s.add(sb.toString());
        }
        return this;
    }

    public Move del(int n) {
        List<String> sa = new ArrayList<>(s);
        s.clear();
        for (var b : sa) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                char c = (char) (b.charAt(i) - n);
                sb.append(c);
            }
            s.add(sb.toString());
        }
        return this;
    }

}
