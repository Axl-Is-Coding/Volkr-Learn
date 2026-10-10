package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.d.a.AbstractC2226j;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.f f13003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2220d f13004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f13005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f13006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f13007f;
    private final com.google.android.datatransport.runtime.e.a g;

    public m(Context context, com.google.android.datatransport.runtime.backends.f fVar, InterfaceC2220d interfaceC2220d, s sVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, com.google.android.datatransport.runtime.e.a aVar2) {
        this.f13002a = context;
        this.f13003b = fVar;
        this.f13004c = interfaceC2220d;
        this.f13005d = sVar;
        this.f13006e = executor;
        this.f13007f = aVar;
        this.g = aVar2;
    }

    boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13002a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void a(com.google.android.datatransport.runtime.q qVar, int i, Runnable runnable) {
        this.f13006e.execute(h.a(this, qVar, i, runnable));
    }

    static /* synthetic */ void a(m mVar, com.google.android.datatransport.runtime.q qVar, int i, Runnable runnable) {
        try {
            try {
                com.google.android.datatransport.runtime.synchronization.a aVar = mVar.f13007f;
                InterfaceC2220d interfaceC2220d = mVar.f13004c;
                interfaceC2220d.getClass();
                aVar.a(k.a(interfaceC2220d));
                if (!mVar.a()) {
                    mVar.f13007f.a(l.a(mVar, qVar, i));
                } else {
                    mVar.a(qVar, i);
                }
            } catch (SynchronizationException unused) {
                mVar.f13005d.a(qVar, i + 1);
            }
        } finally {
            runnable.run();
        }
    }

    static /* synthetic */ Object a(m mVar, com.google.android.datatransport.runtime.q qVar, int i) {
        mVar.f13005d.a(qVar, i + 1);
        return null;
    }

    void a(com.google.android.datatransport.runtime.q qVar, int i) {
        BackendResponse backendResponseA;
        com.google.android.datatransport.runtime.backends.m mVar = this.f13003b.get(qVar.b());
        Iterable iterable = (Iterable) this.f13007f.a(i.a(this, qVar));
        if (iterable.iterator().hasNext()) {
            if (mVar == null) {
                com.google.android.datatransport.runtime.b.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", qVar);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC2226j) it.next()).a());
                }
                g.a aVarA = com.google.android.datatransport.runtime.backends.g.a();
                aVarA.a(arrayList);
                aVarA.a(qVar.c());
                backendResponseA = mVar.a(aVarA.a());
            }
            this.f13007f.a(j.a(this, backendResponseA, iterable, qVar, i));
        }
    }

    static /* synthetic */ Object a(m mVar, BackendResponse backendResponse, Iterable iterable, com.google.android.datatransport.runtime.q qVar, int i) {
        if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
            mVar.f13004c.b((Iterable<AbstractC2226j>) iterable);
            mVar.f13005d.a(qVar, i + 1);
            return null;
        }
        mVar.f13004c.a((Iterable<AbstractC2226j>) iterable);
        if (backendResponse.c() == BackendResponse.Status.OK) {
            mVar.f13004c.a(qVar, mVar.g.getTime() + backendResponse.b());
        }
        if (!mVar.f13004c.b(qVar)) {
            return null;
        }
        mVar.f13005d.a(qVar, 1);
        return null;
    }
}
