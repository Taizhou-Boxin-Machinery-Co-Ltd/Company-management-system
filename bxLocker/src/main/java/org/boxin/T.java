package org.boxin;

import org.boxin.utils.Hash;
import org.boxin.utils.algorithm.Move;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T {
    public static void main(String[] args) throws Exception {
        String a = "台州市博新机械有限公司";
//        String hash = Hash.getSHA1(a);
//        System.out.println(hash);
        Hash hash = new Hash(a);
        Move m = new Move(a.getBytes(StandardCharsets.UTF_8), 3);
        int n = 1000000000;
        final List<String> s = new ArrayList<>(m.getS());
        m.lg().lg().ad(n);
        final List<String> s1 = new ArrayList<>(m.getS());
        m.del(n).rg().rg();
        final List<String> s2 = new ArrayList<>(m.getS());
        for (int i = 0; i < s1.size(); i++) {
            System.out.println(s.get(i) + "    " + s1.get(i) + "    " + s2.get(i));
        }

        System.out.println(hash.getSHA1());
        System.out.println(hash.getSHA224());
        System.out.println(hash.getSHA256());
        System.out.println(hash.getSHA384());
        System.out.println(hash.getSHA512());

    }
}
