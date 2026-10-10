package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.TeamUIMessageDao;

/* JADX INFO: compiled from: ChatMessageDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class G extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static G f18424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18425c;

    private G(String str) {
        super(str);
        this.f18425c = 0L;
    }

    public static synchronized G newInstance() {
        if (f18424b == null) {
            f18424b = new G("bm-team-chat-db");
        }
        return f18424b;
    }

    public void a(long j) {
        this.f18425c = j;
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getTeamUIMessageDao();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public TeamUIMessageDao getDao() {
        return (TeamUIMessageDao) super.getDao();
    }
}
