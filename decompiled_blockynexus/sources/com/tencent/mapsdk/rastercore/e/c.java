package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes5.dex */
public interface c {
    boolean checkInBounds();

    void destroy();

    void draw(Canvas canvas);

    boolean equalsRemote(c cVar);

    String getId();

    float getZIndex();

    int hashCodeRemote();

    boolean isVisible();

    void remove();

    void setVisible(boolean z);

    void setZIndex(float f2);
}
