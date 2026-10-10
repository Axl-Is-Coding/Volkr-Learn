package com.sandboxol.pingreport.helper;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.greendao.c.C;
import com.sandboxol.pingreport.entity.DaoMaster;
import com.sandboxol.pingreport.entity.DaoSession;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IDbHelper extends C {
    protected final String TAG;

    protected IDbHelper(String str) {
        super(str);
        this.TAG = IDbHelper.class.getSimpleName();
    }

    protected abstract org.greenrobot.greendao.a init(DaoSession daoSession);

    @Override // com.sandboxol.greendao.c.C
    protected org.greenrobot.greendao.a init(String str) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getContext(), str, null);
        if (Build.VERSION.SDK_INT >= 28) {
            devOpenHelper.setOpenParams(new SQLiteDatabase.OpenParams.Builder().addOpenFlags(16).build());
        }
        return init(new DaoMaster(devOpenHelper.getWritableDatabase()).newSession());
    }
}
