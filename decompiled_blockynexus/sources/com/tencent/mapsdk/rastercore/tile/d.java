package com.tencent.mapsdk.rastercore.tile;

import com.tencent.mapsdk.rastercore.tile.MapTile;

/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f19664a = new int[MapTile.MapSource.values().length];

    static {
        try {
            f19664a[MapTile.MapSource.WORLD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19664a[MapTile.MapSource.TENCENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19664a[MapTile.MapSource.SATELLITE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
