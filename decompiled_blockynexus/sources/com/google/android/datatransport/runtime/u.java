package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.v;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: TransportRuntime.java */
/* JADX INFO: loaded from: classes.dex */
public class u implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile v f13024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f13025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f13026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.d.e f13027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.m f13028e;

    u(com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, com.google.android.datatransport.runtime.d.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.m mVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.q qVar) {
        this.f13025b = aVar;
        this.f13026c = aVar2;
        this.f13027d = eVar;
        this.f13028e = mVar;
        qVar.a();
    }

    public static void a(Context context) {
        if (f13024a == null) {
            synchronized (u.class) {
                if (f13024a == null) {
                    v.a aVarG = h.g();
                    aVarG.a(context);
                    f13024a = aVarG.build();
                }
            }
        }
    }

    private static Set<com.google.android.datatransport.b> b(i iVar) {
        return iVar instanceof j ? Collections.unmodifiableSet(((j) iVar).a()) : Collections.singleton(com.google.android.datatransport.b.a("proto"));
    }

    public com.google.android.datatransport.runtime.scheduling.jobscheduling.m b() {
        return this.f13028e;
    }

    public static u a() {
        v vVar = f13024a;
        if (vVar != null) {
            return vVar.d();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public com.google.android.datatransport.f a(i iVar) {
        Set<com.google.android.datatransport.b> setB = b(iVar);
        q.a aVarA = q.a();
        aVarA.a(iVar.getName());
        aVarA.a(iVar.getExtras());
        return new C2228r(setB, aVarA.a(), this);
    }

    @Override // com.google.android.datatransport.runtime.t
    public void a(p pVar, com.google.android.datatransport.g gVar) {
        this.f13027d.a(pVar.f().a(pVar.c().c()), a(pVar), gVar);
    }

    private l a(p pVar) {
        l.a aVarA = l.a();
        aVarA.a(this.f13025b.getTime());
        aVarA.b(this.f13026c.getTime());
        aVarA.a(pVar.g());
        aVarA.a(new k(pVar.b(), pVar.d()));
        aVarA.a(pVar.c().a());
        return aVarA.a();
    }
}
