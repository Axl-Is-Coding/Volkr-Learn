package c.t.m.g;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2883a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f2888f = "0M100WJ33N1CQ08O";
    private boolean g = false;
    private int h = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2884b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2885c = true;

    public C(Context context, String str, String str2) {
        this.f2886d = "";
        this.f2887e = "";
        this.f2883a = context.getApplicationContext();
        this.f2886d = str;
        this.f2887e = str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("appid:" + this.f2884b);
        sb.append(",uuid:" + this.f2886d);
        sb.append(",channelid:" + this.f2887e);
        sb.append(",isSDKMode:" + this.f2885c);
        sb.append(",isTest:false");
        sb.append(",testAppid:" + this.h);
        sb.append("]");
        return sb.toString();
    }
}
