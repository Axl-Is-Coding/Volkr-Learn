package com.iab.omid.library.ironsrc.adsession;

import android.view.View;
import com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f14541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f14542b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b.e.a.a.a.e.a f14544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f14545e;
    private boolean i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b.e.a.a.a.e.a> f14543c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14546f = false;
    private boolean g = false;
    private String h = UUID.randomUUID().toString();

    g(c cVar, d dVar) {
        this.f14542b = cVar;
        this.f14541a = dVar;
        b(null);
        this.f14545e = dVar.a() == AdSessionContextType.HTML ? new com.iab.omid.library.ironsrc.publisher.a(dVar.g()) : new com.iab.omid.library.ironsrc.publisher.c(dVar.c(), dVar.d());
        this.f14545e.a();
        b.e.a.a.a.b.a.a().a(this);
        this.f14545e.a(cVar);
    }

    private void b(View view) {
        this.f14544d = new b.e.a.a.a.e.a(view);
    }

    private void c(View view) {
        Collection<g> collectionB = b.e.a.a.a.b.a.a().b();
        if (collectionB == null || collectionB.size() <= 0) {
            return;
        }
        for (g gVar : collectionB) {
            if (gVar != this && gVar.e() == view) {
                gVar.f14544d.clear();
            }
        }
    }

    private void l() {
        if (this.i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.ironsrc.adsession.b
    public void a() {
        if (this.g) {
            return;
        }
        this.f14544d.clear();
        k();
        this.g = true;
        j().e();
        b.e.a.a.a.b.a.a().c(this);
        j().b();
        this.f14545e = null;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.b
    public void a(View view) {
        if (this.g) {
            return;
        }
        b.e.a.a.a.d.e.a(view, "AdView is null");
        if (e() == view) {
            return;
        }
        b(view);
        j().h();
        c(view);
    }

    @Override // com.iab.omid.library.ironsrc.adsession.b
    public void b() {
        if (this.f14546f) {
            return;
        }
        this.f14546f = true;
        b.e.a.a.a.b.a.a().b(this);
        this.f14545e.a(b.e.a.a.a.b.g.a().d());
        this.f14545e.a(this, this.f14541a);
    }

    public List<b.e.a.a.a.e.a> c() {
        return this.f14543c;
    }

    void d() {
        l();
        j().f();
        this.i = true;
    }

    public View e() {
        return this.f14544d.get();
    }

    public boolean f() {
        return this.f14546f && !this.g;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.f14542b.a();
    }

    public String i() {
        return this.h;
    }

    public AdSessionStatePublisher j() {
        return this.f14545e;
    }

    public void k() {
        if (this.g) {
            return;
        }
        this.f14543c.clear();
    }
}
