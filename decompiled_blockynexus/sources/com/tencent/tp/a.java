package com.tencent.tp;

import android.content.Context;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes5.dex */
class a extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f19684a;

    public a(Context context) {
        this.f19684a = context;
    }

    private String a(Context context) {
        try {
            return s.a(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private void a() {
        v.a(this.f19684a);
        r.a("Language:" + s.f());
        r.a("cpu_model:" + a(this.f19684a));
        r.a("simulator_name:" + s.b(this.f19684a));
        r.a("adb:" + v.b(this.f19684a));
        r.a("info:on initialize done");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            a();
            return null;
        } catch (Exception e2) {
            r.a("*#07#:" + e2.toString());
            return null;
        }
    }
}
