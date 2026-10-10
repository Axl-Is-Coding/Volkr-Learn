package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class v extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f13343a = C.b().getMaximum(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f13344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final e<?> f13345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    C2232d f13346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final C2230b f13347e;

    v(u uVar, e<?> eVar, C2230b c2230b) {
        this.f13344b = uVar;
        this.f13345c = eVar;
        this.f13347e = c2230b;
    }

    private void a(Context context) {
        if (this.f13346d == null) {
            this.f13346d = new C2232d(context);
        }
    }

    int b() {
        return (this.f13344b.a() + this.f13344b.f13342f) - 1;
    }

    boolean c(int i) {
        return (i + 1) % this.f13344b.f13341e == 0;
    }

    int d(int i) {
        return (i - this.f13344b.a()) + 1;
    }

    boolean e(int i) {
        return i >= a() && i <= b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13344b.f13342f + a();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f13344b.f13341e;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean b(int i) {
        return i % this.f13344b.f13341e == 0;
    }

    @Override // android.widget.Adapter
    public Long getItem(int i) {
        if (i < this.f13344b.a() || i > b()) {
            return null;
        }
        return Long.valueOf(this.f13344b.b(d(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.v.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    int a() {
        return this.f13344b.a();
    }

    int a(int i) {
        return a() + (i - 1);
    }
}
