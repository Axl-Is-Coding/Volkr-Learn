package b.f.d.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f2675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f2676b;

    b(p pVar, JSONObject jSONObject) {
        this.f2676b = pVar;
        this.f2675a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2676b.f2720d.a(this.f2675a, (b.f.d.g.a.c) this.f2676b);
    }
}
