package io.rong.photoview.scrollerproxy;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ScrollerProxy {
    public static ScrollerProxy getScroller(Context context) {
        int i = Build.VERSION.SDK_INT;
        return i < 9 ? new PreGingerScroller(context) : i < 14 ? new GingerScroller(context) : new IcsScroller(context);
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void forceFinished(boolean z);

    public abstract int getCurrX();

    public abstract int getCurrY();

    public abstract boolean isFinished();
}
