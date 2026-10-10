package com.google.android.datatransport.runtime.d;

import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.u;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f12920a = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f12921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f12922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.f f12923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InterfaceC2220d f12924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f12925f;

    public c(Executor executor, com.google.android.datatransport.runtime.backends.f fVar, s sVar, InterfaceC2220d interfaceC2220d, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.f12922c = executor;
        this.f12923d = fVar;
        this.f12921b = sVar;
        this.f12924e = interfaceC2220d;
        this.f12925f = aVar;
    }

    @Override // com.google.android.datatransport.runtime.d.e
    public void a(q qVar, l lVar, com.google.android.datatransport.g gVar) {
        this.f12922c.execute(a.a(this, qVar, gVar, lVar));
    }

    static /* synthetic */ void a(c cVar, q qVar, com.google.android.datatransport.g gVar, l lVar) {
        try {
            m mVar = cVar.f12923d.get(qVar.b());
            if (mVar != null) {
                cVar.f12925f.a(b.a(cVar, qVar, mVar.a(lVar)));
                gVar.onSchedule(null);
            } else {
                String str = String.format("Transport backend '%s' is not registered", qVar.b());
                f12920a.warning(str);
                gVar.onSchedule(new IllegalArgumentException(str));
            }
        } catch (Exception e2) {
            f12920a.warning("Error scheduling event " + e2.getMessage());
            gVar.onSchedule(e2);
        }
    }

    static /* synthetic */ Object a(c cVar, q qVar, l lVar) {
        cVar.f12924e.a(qVar, lVar);
        cVar.f12921b.a(qVar, 1);
        return null;
    }
}
