package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.a.f;

/* JADX INFO: loaded from: classes5.dex */
public final class TileOverlay implements IOverlay {
    private f delegate;

    public TileOverlay(f fVar) {
        this.delegate = fVar;
    }

    public final void clearTileCache() {
        f fVar = this.delegate;
        f.c();
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof TileOverlay)) {
            return this.delegate.equals(((TileOverlay) obj).delegate);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        return this.delegate.d();
    }

    public final int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        return this.delegate.e();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        this.delegate.b();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        this.delegate.a(z);
    }
}
