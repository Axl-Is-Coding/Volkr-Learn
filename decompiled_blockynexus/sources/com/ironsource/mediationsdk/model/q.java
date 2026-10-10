package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ProviderSettingsHolder.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q f14945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<p> f14946b = new ArrayList<>();

    private q() {
    }

    public static synchronized q b() {
        if (f14945a == null) {
            f14945a = new q();
        }
        return f14945a;
    }

    public void a(p pVar) {
        if (pVar != null) {
            this.f14946b.add(pVar);
        }
    }

    public boolean a(String str) {
        Iterator<p> it = this.f14946b.iterator();
        while (it.hasNext()) {
            if (it.next().h().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        for (p pVar : this.f14946b) {
            if (pVar.m() && !TextUtils.isEmpty(pVar.i())) {
                p pVarB = b(pVar.i());
                pVar.b(com.ironsource.mediationsdk.utils.j.a(pVar.f(), pVarB.f()));
                pVar.c(com.ironsource.mediationsdk.utils.j.a(pVar.k(), pVarB.k()));
                pVar.a(com.ironsource.mediationsdk.utils.j.a(pVar.d(), pVarB.d()));
            }
        }
    }

    public p b(String str) {
        for (p pVar : this.f14946b) {
            if (pVar.h().equals(str)) {
                return pVar;
            }
        }
        p pVar2 = new p(str);
        a(pVar2);
        return pVar2;
    }
}
