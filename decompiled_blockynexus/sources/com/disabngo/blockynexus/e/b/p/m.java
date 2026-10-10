package com.disabngo.blockynexus.e.b.p;

import android.util.Log;
import rx.Subscriber;

/* JADX INFO: compiled from: CheckUpdateViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends Subscriber<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f10042a;

    m(o oVar) {
        this.f10042a = oVar;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
        if (this.f10042a.f10046c + 1 >= this.f10042a.f10045b.size()) {
            this.f10042a.f10046c = 0;
        } else {
            this.f10042a.f10046c++;
        }
        o oVar = this.f10042a;
        oVar.p.set((String) oVar.f10045b.get(this.f10042a.f10046c));
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Log.w("rx", "onError: " + th.toString());
    }
}
