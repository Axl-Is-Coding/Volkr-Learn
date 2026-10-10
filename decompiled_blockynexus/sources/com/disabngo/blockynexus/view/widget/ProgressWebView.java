package com.disabngo.blockynexus.view.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes.dex */
public class ProgressWebView extends WebView {
    private a mOnScrollChangeListener;
    private ProgressBar progressbar;

    public interface a {
        void a();

        void a(int i, int i2);
    }

    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                ProgressWebView.this.progressbar.setVisibility(8);
                if (ProgressWebView.this.mOnScrollChangeListener != null) {
                    ProgressWebView.this.mOnScrollChangeListener.a();
                }
            } else {
                if (ProgressWebView.this.progressbar.getVisibility() == 8) {
                    ProgressWebView.this.progressbar.setVisibility(0);
                }
                Log.e("progressbar", i + "");
                ProgressWebView.this.progressbar.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }
    }

    public ProgressWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.progressbar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.progressbar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, CommonHelper.dip2px(context, 3.0f), 0, 0));
        this.progressbar.setProgressDrawable(getResources().getDrawable(com.disabngo.blockynexus.R.drawable.bg_progressbar_web));
        this.progressbar.setBackgroundColor(-1);
        addView(this.progressbar);
        setWebChromeClient(new b());
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.mOnScrollChangeListener;
        if (aVar != null) {
            aVar.a(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.mOnScrollChangeListener = aVar;
    }
}
