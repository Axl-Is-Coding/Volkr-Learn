package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class BlockmanWebView extends WebView {
    public BlockmanWebView(Context context) {
        super(context);
    }

    private static Context getFixedContext(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i < 21 || i >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    public BlockmanWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet, 0);
    }
}
