package com.sandboxol.halloween.view.dialog;

import rx.functions.Action0;

/* JADX INFO: compiled from: HalloweenTipsDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class o implements Action0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HalloweenTipsDialog f18702a;

    o(HalloweenTipsDialog halloweenTipsDialog) {
        this.f18702a = halloweenTipsDialog;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.f18702a.f18668a != null) {
            this.f18702a.f18668a.onClick();
            this.f18702a.dismiss();
        }
    }
}
