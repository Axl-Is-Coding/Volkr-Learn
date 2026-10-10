package com.sandboxol.greendao.c;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.greendao.entity.DaoMaster;
import com.sandboxol.greendao.entity.DaoSession;

/* JADX INFO: compiled from: IDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ka extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f18504a;

    ka(String str) {
        super(str);
        this.f18504a = ka.class.getSimpleName();
    }

    protected abstract org.greenrobot.greendao.a a(DaoSession daoSession);

    @Override // com.sandboxol.greendao.c.C
    protected org.greenrobot.greendao.a init(String str) {
        I i = new I(BaseApplication.getContext(), str);
        if (Build.VERSION.SDK_INT >= 28) {
            i.setOpenParams(new SQLiteDatabase.OpenParams.Builder().addOpenFlags(16).build());
        }
        return a(new DaoMaster(i.getWritableDatabase()).newSession());
    }
}
