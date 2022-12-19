package org.boxin.g4;

import org.antlr.v4.runtime.Token;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CelVisitor extends BXEXCELBaseVisitor<Void> {
    public final Map<String, Map<String, Map<Integer, Map<String, Serializable>>>> fileSheetXAValueMap = new HashMap<>();
    @Override
    public Void visitAll(BXEXCELParser.AllContext ctx) {
        for (var c1 : ctx.c1()) {
            visitC1(c1);
        }
        return null;
    }

    @Override
    public Void visitC1(BXEXCELParser.C1Context ctx) {
        for (var cc1 : ctx.cc1()) {
            visitCc1(cc1);
        }
        return null;
    }

    @Override
    public Void visitCc1(BXEXCELParser.Cc1Context ctx) {
        String fileName = ctx.fileName.getText();
        for (var sheet : ctx.sheet()) {
            String sheetName = sheet.sheetName.getText();
            /*
                0 {
                     A "a2" ,
                    B "a3"
                }
                2 A "a1"
            */
            if (!sheet.xlsx_x().isEmpty()) {
                for (var xlxs_x : sheet.xlsx_x()) {
                    int x = Integer.parseInt(xlxs_x.x.getText());
                    if (xlxs_x.xlsx_a() != null) {
                        for (var xlsx_xa : xlxs_x.xlsx_a()) {
                            getSerializable(xlsx_xa.string, xlsx_xa.double_, xlsx_xa.int_, fileName, sheetName, x, xlsx_xa.y.getText());
                        }
                    }
                }
            }
            /*
                A1 "abb",
            */
            if (!sheet.xlxs_xa().isEmpty()) {
                for (var xlsx_xa : sheet.xlxs_xa()) {
                    StringBuilder x = new StringBuilder();
                    StringBuilder a = new StringBuilder();
                    String xlsx_xa_xa = xlsx_xa.xa.getText();
                    for (int i = 0; i < xlsx_xa_xa.length(); i++) {
                        try {
                            Integer.parseInt(String.valueOf(xlsx_xa_xa.charAt(i)));
                            x.append(xlsx_xa_xa.charAt(i));
                        } catch (NumberFormatException e) {
                            a.append(xlsx_xa_xa.charAt(i));
                        }
                    }
                    getSerializable(xlsx_xa.string, xlsx_xa.double_, xlsx_xa.int_, fileName, sheetName, Integer.parseInt(x.toString()), a.toString());
                }
            }

        }
        return super.visitCc1(ctx);
    }

    private void getSerializable(Token string, Token double_, Token int_, String fileName, String sheetName, int x, String a) {
        final Serializable serializable = string != null ?
                string.getText().substring(
                        string.getText().indexOf("\"") + 1,
                        string.getText().lastIndexOf("\"")
                ) :
                double_ != null ?
                        Double.parseDouble(double_.getText()) :
                        int_ != null ?
                                Integer.parseInt(int_.getText()) :
                                "";
        final Map<String, Map<Integer, Map<String, Serializable>>> sheetXAValueMap =
                fileSheetXAValueMap.isEmpty() || !fileSheetXAValueMap.containsKey(fileName) ?
                        new HashMap<>() :
                        fileSheetXAValueMap.get(fileName);
        final Map<Integer, Map<String, Serializable>> XYValueMap =
                sheetXAValueMap.isEmpty() || !sheetXAValueMap.containsKey(sheetName) ?
                        new HashMap<>() :
                        sheetXAValueMap.get(sheetName);
        final Map<String, Serializable> YValueMap =
                XYValueMap.isEmpty() || !XYValueMap.containsKey(x) ?
                        new HashMap<>() :
                        XYValueMap.get(x);
        YValueMap.put(a, serializable);
        XYValueMap.put(x, YValueMap);
        sheetXAValueMap.put(sheetName, XYValueMap);
        fileSheetXAValueMap.put(fileName, sheetXAValueMap);
    }
}
