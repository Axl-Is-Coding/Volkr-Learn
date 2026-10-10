package com.sandboxol.greendao.c;

import android.content.Context;
import com.sandboxol.greendao.entity.DaoMaster;
import com.sandboxol.greendao.entity.FriendDao;
import com.sandboxol.greendao.entity.GameDao;
import com.sandboxol.greendao.entity.PartyMemberInfoDao;
import com.sandboxol.greendao.entity.TeamUIMessageDao;
import com.sandboxol.greendao.entity.TribeMemberDao;
import com.sandboxol.greendao.entity.UserCacheDao;
import com.sandboxol.greendao.entity.VideoDetailInfoDao;
import com.sandboxol.greendao.entity.VideoInfoDao;

/* JADX INFO: compiled from: DBOpenHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class I extends DaoMaster.DevOpenHelper {
    public I(Context context, String str) {
        super(context, str);
    }

    @Override // com.sandboxol.greendao.entity.DaoMaster.DevOpenHelper, org.greenrobot.greendao.b.b
    public void onUpgrade(org.greenrobot.greendao.b.a aVar, int i, int i2) {
        com.github.yuweiguocn.library.greendao.a.a(aVar, new H(this), (Class<? extends org.greenrobot.greendao.a<?, ?>>[]) new Class[]{GameDao.class, FriendDao.class, VideoInfoDao.class, TeamUIMessageDao.class, PartyMemberInfoDao.class, TribeMemberDao.class, UserCacheDao.class, VideoDetailInfoDao.class});
    }
}
