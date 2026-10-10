package com.tencent.tp;

import android.content.Context;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes5.dex */
class x extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f19727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19729c;

    public x(Context context, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        this.f19727a = context;
        this.f19728b = z4;
        this.f19729c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            e.a(this.f19727a.getApplicationContext());
            new u().a(this.f19727a.getApplicationContext(), this.f19729c);
            if (!this.f19728b) {
                return null;
            }
            m.a().a(this.f19727a);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
