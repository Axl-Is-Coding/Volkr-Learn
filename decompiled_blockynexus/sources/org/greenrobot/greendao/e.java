package org.greenrobot.greendao;

import android.database.Cursor;
import java.util.List;

/* JADX INFO: compiled from: InternalQueryDaoAccess.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<T, ?> f23626a;

    public e(a<T, ?> aVar) {
        this.f23626a = aVar;
    }

    public List<T> a(Cursor cursor) {
        return this.f23626a.loadAllAndCloseCursor(cursor);
    }

    public T b(Cursor cursor) {
        return this.f23626a.loadUniqueAndCloseCursor(cursor);
    }
}
