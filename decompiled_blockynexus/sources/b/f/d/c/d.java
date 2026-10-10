package b.f.d.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f2681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f2682b;

    d(p pVar, JSONObject jSONObject) {
        this.f2682b = pVar;
        this.f2681a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2682b.f2720d.a(this.f2681a, (b.f.d.g.a.b) this.f2682b);
    }
}
