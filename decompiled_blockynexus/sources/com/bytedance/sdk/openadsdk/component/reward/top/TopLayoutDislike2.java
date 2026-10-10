package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: loaded from: classes.dex */
public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f5966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f5967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f5969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5970f;
    private b g;
    private CharSequence h;
    private CharSequence i;

    public TopLayoutDislike2(Context context) {
        this(context, null);
    }

    private void d() {
        View view = this.f5965a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.c(view2);
                    }
                }
            });
        }
        ImageView imageView = this.f5966b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TopLayoutDislike2.this.f5970f = !r0.f5970f;
                    TopLayoutDislike2.this.f5966b.setImageResource(TopLayoutDislike2.this.f5970f ? t.d(TopLayoutDislike2.this.getContext(), "tt_mute") : t.d(TopLayoutDislike2.this.getContext(), "tt_unmute"));
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.b(view2);
                    }
                }
            });
        }
        TextView textView = this.f5967c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.a(view2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f5965a;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.f5967c;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.f5967c.getVisibility() == 4) {
                return;
            }
            this.f5967c.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.f5966b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.f5967c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f5967c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        this.f5970f = z;
        this.f5966b.setImageResource(this.f5970f ? t.d(getContext(), "tt_mute") : t.d(getContext(), "tt_unmute"));
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f5966b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.f5967c.setWidth(20);
        this.f5967c.setVisibility(4);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = "";
        this.i = "";
    }

    public TopLayoutDislike2 a(boolean z, h hVar) {
        this.f5968d = z;
        this.f5969e = hVar;
        LayoutInflater.from(getContext()).inflate(t.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.f5965a = findViewById(t.e(getContext(), "tt_top_dislike"));
        this.f5966b = (ImageView) findViewById(t.e(getContext(), "tt_top_mute"));
        this.f5967c = (TextView) findViewById(t.e(getContext(), "tt_top_skip"));
        this.f5967c.setVisibility(0);
        this.f5967c.setText("");
        this.f5967c.setEnabled(false);
        this.f5967c.setClickable(false);
        d();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.i = charSequence2;
        }
        if (this.f5967c != null) {
            CharSequence charSequence3 = this.h;
            if (!TextUtils.isEmpty(this.i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.i);
            }
            this.f5967c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.f5967c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
