package io.rong.photoview.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(14)
public class IcsScroller extends GingerScroller {
    public IcsScroller(Context context) {
        super(context);
    }

    @Override // io.rong.photoview.scrollerproxy.GingerScroller, io.rong.photoview.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }
}
