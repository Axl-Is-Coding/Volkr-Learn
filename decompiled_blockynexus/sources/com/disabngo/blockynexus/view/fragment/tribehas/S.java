package com.disabngo.blockynexus.view.fragment.tribehas;

import android.app.Activity;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeHasViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class S implements Action1<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ T f11990a;

    S(T t) {
        this.f11990a = t;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Boolean bool) {
        if (bool.booleanValue()) {
            this.f11990a.I();
        } else {
            if (!(this.f11990a.f11991a instanceof Activity) || ((Activity) this.f11990a.f11991a).isFinishing()) {
                return;
            }
            ((Activity) this.f11990a.f11991a).finish();
        }
    }
}
