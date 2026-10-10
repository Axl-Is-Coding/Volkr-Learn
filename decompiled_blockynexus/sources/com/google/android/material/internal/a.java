package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0313a;

/* JADX INFO: compiled from: CheckableImageButton.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CheckableImageButton f13454d;

    a(CheckableImageButton checkableImageButton) {
        this.f13454d = checkableImageButton;
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        bVar.c(this.f13454d.isCheckable());
        bVar.d(this.f13454d.isChecked());
    }

    @Override // androidx.core.view.C0313a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f13454d.isChecked());
    }
}
