package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.tile.MapTile;
import com.tencent.mapsdk.rastercore.tile.c;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UrlTileProvider implements TileProvider {
    @Override // com.tencent.mapsdk.raster.model.TileProvider
    public final Tile getTile(int i, int i2, int i3, MapTile.MapSource mapSource, Object... objArr) {
        URL tileUrl = getTileUrl(i, i2, i3, objArr);
        if (tileUrl == null) {
            return null;
        }
        return new Tile(i, i2, i3, c.a(tileUrl));
    }

    public abstract URL getTileUrl(int i, int i2, int i3, Object... objArr);
}
