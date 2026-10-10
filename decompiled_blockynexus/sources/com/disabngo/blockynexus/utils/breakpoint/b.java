package com.disabngo.blockynexus.utils.breakpoint;

/* JADX INFO: compiled from: DownloadService.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DownloadService f10509a;

    b(DownloadService downloadService) {
        this.f10509a = downloadService;
    }

    @Override // com.disabngo.blockynexus.utils.breakpoint.a
    public void onCanceled() {
        this.f10509a.f10504a = null;
        this.f10509a.stopForeground(true);
    }

    @Override // com.disabngo.blockynexus.utils.breakpoint.a
    public void onFailed() {
        this.f10509a.f10504a = null;
        this.f10509a.stopForeground(true);
    }

    @Override // com.disabngo.blockynexus.utils.breakpoint.a
    public void onPaused() {
        this.f10509a.f10504a = null;
    }

    @Override // com.disabngo.blockynexus.utils.breakpoint.a
    public void onProgress(int i) {
    }

    @Override // com.disabngo.blockynexus.utils.breakpoint.a
    public void onSuccess() {
        this.f10509a.f10504a = null;
        this.f10509a.stopForeground(true);
    }
}
