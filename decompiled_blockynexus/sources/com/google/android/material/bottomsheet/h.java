package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: BottomSheetDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends BottomSheetBehavior.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomSheetDialog f13232a;

    h(BottomSheetDialog bottomSheetDialog) {
        this.f13232a = bottomSheetDialog;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
    public void a(View view, float f2) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
    public void a(View view, int i) {
        if (i == 5) {
            this.f13232a.cancel();
        }
    }
}
