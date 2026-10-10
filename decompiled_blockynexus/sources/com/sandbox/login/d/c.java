package com.sandbox.login.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.sandbox.login.entity.DaoMaster;
import com.sandbox.login.entity.DaoSession;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: compiled from: IDbHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f15706a = c.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f15707b = BaseApplication.getContext();

    c(String str) {
        b bVar = new b(this.f15707b, str);
        if (Build.VERSION.SDK_INT >= 28) {
            bVar.setOpenParams(new SQLiteDatabase.OpenParams.Builder().addOpenFlags(16).build());
        }
        a(new DaoMaster(bVar.getWritableDatabase()).newSession());
    }

    protected abstract void a(DaoSession daoSession);
}
