package com.twitter.sdk.android.core.internal.b;

import android.annotation.SuppressLint;

/* JADX INFO: compiled from: PreferenceStoreStrategy.java */
/* JADX INFO: loaded from: classes5.dex */
public class d<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f20158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<T> f20159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20160c;

    public d(b bVar, e<T> eVar, String str) {
        this.f20158a = bVar;
        this.f20159b = eVar;
        this.f20160c = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a(T t) {
        b bVar = this.f20158a;
        bVar.a(bVar.edit().putString(this.f20160c, this.f20159b.a(t)));
    }

    public T b() {
        return this.f20159b.a(this.f20158a.get().getString(this.f20160c, null));
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a() {
        this.f20158a.edit().remove(this.f20160c).commit();
    }
}
