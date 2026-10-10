package b.f.d.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f2698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f2699b;

    j(p pVar, JSONObject jSONObject) {
        this.f2699b = pVar;
        this.f2698a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2699b.f2720d.a(this.f2698a, (b.f.d.g.a.d) this.f2699b);
    }
}
