package com.tencent.mapsdk.raster.model;

/* JADX INFO: loaded from: classes5.dex */
public class TencentMapOptions {
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
    public static final int LOGO_POSITION_TOP_LEFT = 3;
    public static final int LOGO_POSITION_TOP_RIGHT = 2;
    private boolean enableHandDrawMap = false;

    public TencentMapOptions enableHandDrawMap(boolean z) {
        this.enableHandDrawMap = z;
        return this;
    }

    public boolean isHandDrawMapEnable() {
        return this.enableHandDrawMap;
    }
}
