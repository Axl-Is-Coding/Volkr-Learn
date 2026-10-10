package com.google.android.material.bottomsheet;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.C0313a;

/* JADX INFO: compiled from: BottomSheetDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BottomSheetDialog f13230d;

    f(BottomSheetDialog bottomSheetDialog) {
        this.f13230d = bottomSheetDialog;
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        if (!this.f13230d.f13221f) {
            bVar.g(false);
        } else {
            bVar.a(1048576);
            bVar.g(true);
        }
    }

    @Override // androidx.core.view.C0313a
    public boolean a(View view, int i, Bundle bundle) {
        if (i == 1048576) {
            BottomSheetDialog bottomSheetDialog = this.f13230d;
            if (bottomSheetDialog.f13221f) {
                bottomSheetDialog.cancel();
                return true;
            }
        }
        return super.a(view, i, bundle);
    }
}
