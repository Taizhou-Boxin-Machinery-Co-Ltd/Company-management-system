package org.boxin.utils.algorithm;

import org.boxin.utils.algorithm.g4.ConfigsBaseVisitor;
import org.boxin.utils.algorithm.g4.ConfigsParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Visitor extends ConfigsBaseVisitor<Void> {
    public final Map<Integer, Rec> integerRecMap = new HashMap<>();
    private final Move move;

    public Move getMove() {
        return move;
    }

    public Visitor(Move move) {
        this.move = move;
    }

    @Override
    public Void visitMoveL(ConfigsParser.MoveLContext ctx) {
        integerRecMap.put(integerRecMap.size(), new Rec("lg", Integer.parseInt(ctx.b.getText())));
        return null;
    }

    @Override
    public Void visitMoveR(ConfigsParser.MoveRContext ctx) {
        integerRecMap.put(integerRecMap.size(), new Rec("rg", Integer.parseInt(ctx.b.getText())));
        return null;
    }

    @Override
    public Void visitPlus(ConfigsParser.PlusContext ctx) {
        integerRecMap.put(integerRecMap.size(), new Rec("plus", Integer.parseInt(ctx.b.getText())));
        return null;
    }

    @Override
    public Void visitRide(ConfigsParser.RideContext ctx) {
        integerRecMap.put(integerRecMap.size(), new Rec("ride", Integer.parseInt(ctx.b.getText())));
        return null;
    }

    @Override
    public Void visitAll(ConfigsParser.AllContext ctx) {
        for (var sy : ctx.sy()) {
            visitSy(sy);
        }
        return null;
    }

    @Override
    public Void visitSy(ConfigsParser.SyContext ctx) {
        if (ctx.moveL() != null) {
            return visitMoveL(ctx.moveL());
        } else if (ctx.moveR() != null) {
            return visitMoveR(ctx.moveR());
        } else if (ctx.plus() != null) {
            return visitPlus(ctx.plus());
        } else {
            return visitRide(ctx.ride());
        }
    }

    public void lock() {
        for (var v : integerRecMap.values()) {
            switch (v.ysf) {
                case "lg" -> move.lg(v.value);
                case "rg" -> move.rg(v.value);
                case "plus" -> move.plus(v.value);
                default -> move.ride(v.value);
            }
        }
    }

    public void unlock() {
        for (int i = integerRecMap.size() - 1; i >=0; i--) {
            Rec v = integerRecMap.get(i);
            switch (v.ysf) {
                case "lg" -> move.rg(v.value);
                case "rg" -> move.lg(v.value);
                case "plus" -> move.reduce(v.value);
                default -> move.divide(v.value);
            }
        }
    }

    public record Rec(String ysf, Integer value) {}
}
