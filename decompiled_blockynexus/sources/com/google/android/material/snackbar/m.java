package com.google.android.material.snackbar;

import android.os.Handler;
import com.google.android.material.snackbar.v;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements v.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13603a;

    m(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13603a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.v.a
    public void a(int i) {
        Handler handler = BaseTransientBottomBar.f13578a;
        handler.sendMessage(handler.obtainMessage(1, i, 0, this.f13603a));
    }

    @Override // com.google.android.material.snackbar.v.a
    public void show() {
        Handler handler = BaseTransientBottomBar.f13578a;
        handler.sendMessage(handler.obtainMessage(0, this.f13603a));
    }
}
