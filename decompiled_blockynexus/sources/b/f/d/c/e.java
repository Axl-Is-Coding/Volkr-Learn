package b.f.d.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f2683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f2684b;

    e(p pVar, JSONObject jSONObject) {
        this.f2684b = pVar;
        this.f2683a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2684b.f2720d.a(this.f2683a);
    }
}
