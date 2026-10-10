package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: loaded from: classes.dex */
public class RewardDislikeToast extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f5990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f5991b;

    public RewardDislikeToast(Context context) {
        this(context, null);
    }

    public void b() {
        setVisibility(8);
        this.f5990a.removeCallbacksAndMessages(null);
    }

    public RewardDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f5991b = new TextView(context);
        this.f5991b.setClickable(false);
        this.f5991b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iA = (int) ac.a(o.a(), 20.0f);
        int iA2 = (int) ac.a(o.a(), 12.0f);
        this.f5991b.setPadding(iA, iA2, iA, iA2);
        this.f5991b.setLayoutParams(layoutParams);
        this.f5991b.setTextColor(-1);
        this.f5991b.setTextSize(16.0f);
        this.f5991b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(ac.a(o.a(), 6.0f));
        this.f5991b.setBackgroundDrawable(gradientDrawable);
        addView(this.f5991b);
    }

    public RewardDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5990a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5990a.removeCallbacksAndMessages(null);
        this.f5990a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (RewardDislikeToast.this.f5991b != null) {
                    RewardDislikeToast.this.f5991b.setText(String.valueOf(str));
                }
                RewardDislikeToast.this.setVisibility(0);
            }
        });
        this.f5990a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                RewardDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void a() {
        setVisibility(8);
        this.f5990a.removeCallbacksAndMessages(null);
    }
}
