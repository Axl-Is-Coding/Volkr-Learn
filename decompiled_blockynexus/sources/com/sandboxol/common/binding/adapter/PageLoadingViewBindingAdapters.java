package com.sandboxol.common.binding.adapter;

import android.text.TextUtils;
import com.sandboxol.common.widget.PageLoadingView;

/* JADX INFO: loaded from: classes3.dex */
public class PageLoadingViewBindingAdapters {
    public static void initPageLoadingView(PageLoadingView pageLoadingView, String str, boolean z, boolean z2, boolean z3) {
        if (!z3) {
            pageLoadingView.setVisibility(8);
            return;
        }
        pageLoadingView.setVisibility(0);
        if (z2) {
            pageLoadingView.setFailedHint(str);
            pageLoadingView.start();
        } else if (z) {
            pageLoadingView.success();
        } else if (TextUtils.isEmpty(str)) {
            pageLoadingView.failed();
        } else {
            pageLoadingView.failed(str);
        }
    }
}
