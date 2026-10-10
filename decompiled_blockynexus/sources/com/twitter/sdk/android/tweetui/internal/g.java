package com.twitter.sdk.android.tweetui.internal;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/* JADX INFO: compiled from: ClickableLinkSpan.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g extends ClickableSpan implements HighlightedClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20415e;

    public g(int i, int i2, boolean z) {
        this(i, i2, true, z);
    }

    @Override // com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
    public void a(boolean z) {
        this.f20415e = z;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.f20413c) {
            textPaint.setColor(this.f20411a);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        if (this.f20415e) {
            textPaint.bgColor = this.f20412b;
        } else {
            textPaint.bgColor = 0;
        }
        if (this.f20414d) {
            textPaint.setUnderlineText(true);
        }
    }

    g(int i, int i2, boolean z, boolean z2) {
        this.f20412b = i;
        this.f20411a = i2;
        this.f20413c = z;
        this.f20414d = z2;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
    public boolean a() {
        return this.f20415e;
    }
}
