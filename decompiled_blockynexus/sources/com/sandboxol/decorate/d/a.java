package com.sandboxol.decorate.d;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.f.j;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;

/* JADX INFO: compiled from: BaseClothe.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected v f17139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected n f17140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected l f17141c;

    public a(v vVar, n nVar, l lVar) {
        this.f17139a = vVar;
        this.f17140b = nVar;
        this.f17141c = lVar;
    }

    public void a(Context context, T t) {
        c(context, t);
        b(context, t);
        d(context, t);
        c(t);
        a(t);
        b(t);
        d(t);
    }

    protected abstract void a(T t);

    protected SingleDressInfo b(long j) {
        SingleDressInfo singleDressInfo = new SingleDressInfo();
        singleDressInfo.setResourceId(j.b(j));
        return singleDressInfo;
    }

    protected abstract void b(Context context, T t);

    protected abstract void b(T t);

    protected abstract void c(Context context, T t);

    protected abstract void c(T t);

    protected abstract void d(Context context, T t);

    protected abstract void d(T t);

    protected boolean a(SingleDressInfo singleDressInfo) {
        return this.f17139a.f17213b.containsKey(16L) && this.f17140b.f17193a.contains(Long.valueOf(singleDressInfo.getTypeId()));
    }

    protected SingleDressInfo a(long j) {
        SingleDressInfo singleDressInfo = new SingleDressInfo();
        singleDressInfo.setResourceId(j.a(j));
        return singleDressInfo;
    }
}
