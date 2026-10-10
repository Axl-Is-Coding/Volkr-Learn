package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: renamed from: androidx.appcompat.widget.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
class C0310x extends I {
    final /* synthetic */ AppCompatSpinner.b j;
    final /* synthetic */ AppCompatSpinner k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0310x(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner.b bVar) {
        super(view);
        this.k = appCompatSpinner;
        this.j = bVar;
    }

    @Override // androidx.appcompat.widget.I
    public androidx.appcompat.view.menu.m a() {
        return this.j;
    }

    @Override // androidx.appcompat.widget.I
    @SuppressLint({"SyntheticAccessor"})
    public boolean b() {
        if (this.k.getInternalPopup().c()) {
            return true;
        }
        this.k.showPopup();
        return true;
    }
}
