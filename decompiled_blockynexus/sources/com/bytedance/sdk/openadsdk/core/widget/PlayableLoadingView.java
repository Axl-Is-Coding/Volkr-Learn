package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class PlayableLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressBar f6548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f6549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6550c;

    public PlayableLoadingView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(t.f(context, "tt_playable_loading_layout"), (ViewGroup) this, true);
        this.f6548a = (ProgressBar) findViewById(t.e(context, "tt_playable_pb_view"));
        this.f6549b = (TextView) findViewById(t.e(context, "tt_playable_progress_tip"));
        this.f6550c = (TextView) findViewById(t.e(context, "tt_playable_play"));
    }

    public void b() {
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.f6550c;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        ProgressBar progressBar = this.f6548a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.f6549b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
        }
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a() {
        setVisibility(8);
    }
}
