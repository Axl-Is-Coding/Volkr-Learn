package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class C2227k implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12896b;

    private C2227k(long j, com.google.android.datatransport.runtime.q qVar) {
        this.f12895a = j;
        this.f12896b = qVar;
    }

    public static D.a a(long j, com.google.android.datatransport.runtime.q qVar) {
        return new C2227k(j, qVar);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.a(this.f12895a, this.f12896b, (SQLiteDatabase) obj);
    }
}
