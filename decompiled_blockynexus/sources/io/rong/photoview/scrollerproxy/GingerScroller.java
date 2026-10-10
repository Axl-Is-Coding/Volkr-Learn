package io.rong.photoview.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(9)
public class GingerScroller extends ScrollerProxy {
    private boolean mFirstScroll = false;
    protected final OverScroller mScroller;

    public GingerScroller(Context context) {
        this.mScroller = new OverScroller(context);
    }

    @Override // io.rong.photoview.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        if (this.mFirstScroll) {
            this.mScroller.computeScrollOffset();
            this.mFirstScroll = false;
        }
        return this.mScroller.computeScrollOffset();
    }

    @Override // io.rong.photoview.scrollerproxy.ScrollerProxy
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // io.rong.photoview.scrollerproxy.ScrollerProxy
    public void forceFinished(boolean z) {
        this.mScroller.forceFinished(z);
    }

    @Override // io.rong.photoview.scrollerproxy.ScrollerProxy
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Override // io.rong.photoview.scrollerproxy.ScrollerProxy
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Override // io.rong.photoview.scrollerproxy.ScrollerProxy
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }
}
