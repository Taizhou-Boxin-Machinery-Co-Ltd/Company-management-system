package org.boxin;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.boxin.utils.Hash;
import org.boxin.utils.algorithm.Configs;
import org.boxin.utils.algorithm.Move;
import org.boxin.utils.algorithm.Visitor;
import org.boxin.utils.algorithm.g4.ConfigsLexer;
import org.boxin.utils.algorithm.g4.ConfigsParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T {
    public static void main(String[] args) throws IOException {
        String a = "台州市博新机械有限公司";
//        String hash = Hash.getSHA1(a);
//        System.out.println(hash);
        Move m = new Move(a.getBytes(StandardCharsets.UTF_8));
        Configs.createOrLoad();
        CharStream str = CharStreams.fromPath(Configs.file1.toPath());
        ConfigsLexer lexer = new ConfigsLexer(str);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        ConfigsParser parser = new ConfigsParser(stream);
        final var all = parser.all();
        Visitor visitor = new Visitor(m);
        visitor.visitAll(all);
        System.out.println(visitor.getMove().bytes2String());
    }
}
