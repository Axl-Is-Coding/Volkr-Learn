package com.google.android.material.chip;

import android.graphics.Typeface;
import com.google.android.material.i.h;

/* JADX INFO: compiled from: Chip.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Chip f13257a;

    a(Chip chip) {
        this.f13257a = chip;
    }

    @Override // com.google.android.material.i.h
    public void a(int i) {
    }

    @Override // com.google.android.material.i.h
    public void a(Typeface typeface, boolean z) {
        Chip chip = this.f13257a;
        chip.setText(chip.chipDrawable.ea() ? this.f13257a.chipDrawable.T() : this.f13257a.getText());
        this.f13257a.requestLayout();
        this.f13257a.invalidate();
    }
}
