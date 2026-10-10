package com.bytedance.sdk.openadsdk.component.reward.top;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: loaded from: classes.dex */
public class TopLayout1 extends FrameLayout implements a<TopLayout1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f5959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f5960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f5961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f5962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5964f;
    private b g;

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (this.f5959a != null && !TextUtils.isEmpty(charSequence)) {
            this.f5959a.setText(charSequence);
        }
        if (this.f5961c == null || TextUtils.isEmpty(charSequence2)) {
            return;
        }
        this.f5961c.setText(charSequence2);
        if (this.f5963e) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f5961c.getLayoutParams();
        layoutParams.width = (int) (charSequence2.length() <= 2 ? ac.a(getContext(), 53.0f) : ac.a(getContext(), 96.0f));
        this.f5961c.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f5960b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        TextView textView = this.f5959a;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f5962d;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.f5961c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.f5960b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.f5961c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f5961c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        this.f5964f = z;
        this.f5960b.setImageResource(this.f5964f ? t.d(getContext(), "tt_mute") : t.d(getContext(), "tt_unmute"));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.f5961c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
