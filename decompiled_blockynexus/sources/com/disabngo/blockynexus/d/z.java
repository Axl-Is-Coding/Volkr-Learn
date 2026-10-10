package com.disabngo.blockynexus.d;

import com.sandboxol.common.utils.luban.OnCompressListener;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes2.dex */
class z implements OnCompressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f7253a;

    z(ArrayList arrayList) {
        this.f7253a = arrayList;
    }

    @Override // com.sandboxol.common.utils.luban.OnCompressListener
    public void onError(Throwable th) {
    }

    @Override // com.sandboxol.common.utils.luban.OnCompressListener
    public void onStart() {
    }

    @Override // com.sandboxol.common.utils.luban.OnCompressListener
    public void onSuccess(File file) {
        this.f7253a.add(file);
    }
}
