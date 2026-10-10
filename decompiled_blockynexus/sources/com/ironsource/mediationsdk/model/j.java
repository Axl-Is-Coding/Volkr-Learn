package com.ironsource.mediationsdk.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: OfferwallConfigurations.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<k> f14909a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f14910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f14911c;

    public j(c cVar) {
        this.f14911c = cVar;
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.f14909a.add(kVar);
            if (this.f14910b == null) {
                this.f14910b = kVar;
            } else if (kVar.a() == 0) {
                this.f14910b = kVar;
            }
        }
    }

    public c a() {
        return this.f14911c;
    }
}
