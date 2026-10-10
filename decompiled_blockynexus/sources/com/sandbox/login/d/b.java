package com.sandbox.login.d;

import android.content.Context;
import com.sandbox.login.entity.DaoMaster;
import com.sandbox.login.entity.UserRecordDao;

/* JADX INFO: compiled from: DBOpenHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends DaoMaster.DevOpenHelper {
    public b(Context context, String str) {
        super(context, str);
    }

    @Override // com.sandbox.login.entity.DaoMaster.DevOpenHelper, org.greenrobot.greendao.b.b
    public void onUpgrade(org.greenrobot.greendao.b.a aVar, int i, int i2) {
        com.github.yuweiguocn.library.greendao.a.a(aVar, new a(this), (Class<? extends org.greenrobot.greendao.a<?, ?>>[]) new Class[]{UserRecordDao.class});
    }
}
