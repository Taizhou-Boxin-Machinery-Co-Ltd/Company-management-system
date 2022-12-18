package org.boxin.g4;

public class CelVisitor extends BXEXCELBaseVisitor<Void> {
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
            if (!sheet.xlsx_x().isEmpty()) {
                for (var xlxs_x : sheet.xlsx_x()) {
                    int x = Integer.parseInt(xlxs_x.x.getText());
                    if (xlxs_x.xlsx_a() != null) {
                        for (var xlsx_xa : xlxs_x.xlsx_a()) {
                            double d = xlsx_xa.double_ != null ?
                                    Double.parseDouble(xlsx_xa.double_.getText()) :
                                    xlsx_xa.int_ != null ?
                                            Integer.parseInt(xlsx_xa.int_.getText()) :
                                            0;
                            String str = xlsx_xa.string != null ?
                                    xlsx_xa.string.getText().substring(
                                            xlsx_xa.string.getText().indexOf("\"") + 1,
                                            xlsx_xa.string.getText().lastIndexOf("\"")
                                    ) :
                                    null;
                            String value = str != null ? str : String.valueOf(d);
                        }
                    }
                }
                for (var xlsx_xa : sheet.xlxs_xa()) {
                    for (int i = 0; i < xlsx_xa.xa.getText().length(); i++) {
                        var char_ = xlsx_xa.xa.getText().charAt(i);
                        String x = "";
                        String a = "";
                        try {
                            Integer.parseInt(String.valueOf(char_));
                            x += String.valueOf(char_);
                        } catch (NumberFormatException e) {
                            a += String.valueOf(char_);
                        }
                    }
                }
            }

        }
        return super.visitCc1(ctx);
    }
}
