package com.sandboxol.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public class PageLoadingView extends FrameLayout {
    private boolean isShowFailed;
    private ImageView ivLoadFailed;
    private ImageView ivLoading;
    private AnimationDrawable loadingAnim;
    private TextView tvLoadFailed;

    public PageLoadingView(Context context) {
        this(context, null);
    }

    private void initView(int i, Drawable drawable) {
        View.inflate(getContext(), R.layout.view_page_loading, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llBg);
        this.ivLoading = (ImageView) findViewById(R.id.ivLoading);
        this.ivLoadFailed = (ImageView) findViewById(R.id.ivLoadFailed);
        this.tvLoadFailed = (TextView) findViewById(R.id.tvLoadFailed);
        this.loadingAnim = (AnimationDrawable) this.ivLoading.getBackground();
        linearLayout.setBackgroundColor(i);
        if (drawable != null) {
            this.ivLoadFailed.setBackground(drawable);
        }
        start(true);
    }

    private void start(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        if (!this.loadingAnim.isRunning()) {
            this.loadingAnim.start();
        }
        this.ivLoading.setVisibility(0);
        this.ivLoadFailed.setVisibility(8);
    }

    public void failed() {
        failed("No data");
    }

    public void setFailedHint(String str) {
        this.tvLoadFailed.setText(str);
        stop();
    }

    public void stop() {
        if (this.loadingAnim.isRunning()) {
            this.loadingAnim.stop();
        }
        this.ivLoading.setVisibility(8);
        this.ivLoadFailed.setVisibility(0);
    }

    public void success() {
        if (this.loadingAnim.isRunning()) {
            this.loadingAnim.stop();
        }
        setVisibility(8);
    }

    public PageLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void failed(String str) {
        if (!this.isShowFailed && !str.equals(getContext().getString(R.string.connect_server_time_out)) && !str.equals(getContext().getString(R.string.connect_server_no_connect)) && !str.equals(getContext().getString(R.string.connect_server_un_know)) && !str.equals(getContext().getString(R.string.connect_error_code)) && !str.equals(getContext().getString(R.string.connect_repeat_login)) && !str.equals(getContext().getString(R.string.inner_error)) && !str.equals(getContext().getString(R.string.time_out)) && !str.equals(getContext().getString(R.string.network_connection_failed)) && !str.equals(getContext().getString(R.string.user_be_report)) && !str.equals(getContext().getString(R.string.error_tip_runtime))) {
            setVisibility(8);
        } else {
            setVisibility(0);
            setFailedHint(str);
        }
    }

    public PageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageLoadingView);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.PageLoadingView_background_color, Color.parseColor("#00000000"));
        this.isShowFailed = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PageLoadingView_isShowFailed, true);
        initView(color, typedArrayObtainStyledAttributes.getDrawable(R.styleable.PageLoadingView_failDrawable));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void start() {
        start(false);
    }
}
