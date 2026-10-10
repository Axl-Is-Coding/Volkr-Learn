package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f15519a = new int[ShapeEntity.ShapeType.values().length];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f15520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f15521c;

    static {
        f15519a[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        f15519a[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        f15519a[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        f15519a[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        f15520b = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        f15520b[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        f15520b[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        f15520b[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        f15521c = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        f15521c[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        f15521c[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        f15521c[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
