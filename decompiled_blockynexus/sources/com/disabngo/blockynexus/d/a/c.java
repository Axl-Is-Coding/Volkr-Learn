package com.disabngo.blockynexus.d.a;

import android.content.Context;
import com.sandboxol.center.entity.DecorationResourcesResponse;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: DressDownloadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DecorationResourcesResponse f7209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.disabngo.blockynexus.interfaces.a f7210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ e f7211d;

    c(e eVar, Context context, DecorationResourcesResponse decorationResourcesResponse, com.disabngo.blockynexus.interfaces.a aVar) {
        this.f7211d = eVar;
        this.f7208a = context;
        this.f7209b = decorationResourcesResponse;
        this.f7210c = aVar;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f7210c.a(th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        new a().a(this.f7208a, this.f7209b.getVersion(), this.f7210c);
    }
}
