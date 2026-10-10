package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f1227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1228c;

    public AccessibilityClickableSpanCompat(int i, b bVar, int i2) {
        this.f1226a = i;
        this.f1227b = bVar;
        this.f1228c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1226a);
        this.f1227b.a(this.f1228c, bundle);
    }
}
