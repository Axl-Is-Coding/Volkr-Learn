package b.d.a.b;

import android.util.Log;

/* JADX INFO: compiled from: AndroidLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2522a;

    public a(String str) {
        this.f2522a = str;
    }

    @Override // b.d.a.b.g
    public void a(String str) {
        Log.d("isoparser", String.valueOf(this.f2522a) + ":" + str);
    }
}
