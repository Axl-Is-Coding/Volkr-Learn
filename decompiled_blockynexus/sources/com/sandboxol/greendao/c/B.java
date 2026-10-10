package com.sandboxol.greendao.c;

import android.database.sqlite.SQLiteException;
import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;
import java.util.List;

/* JADX INFO: compiled from: BaseGameDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class B extends ka {
    B(String str) {
        super(str);
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getGameDao();
    }

    public /* synthetic */ void b(Game game) {
        try {
            getDao().insertOrReplace(game);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public void a(final Game game) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f18467a.b(game);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public GameDao getDao() {
        return (GameDao) super.getDao();
    }

    public void a(final List<Game> list) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f18470a.b(list);
            }
        });
    }

    public /* synthetic */ void b(List list) {
        try {
            getDao().insertInTx(list);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, com.sandboxol.greendao.a.c<Game> cVar) {
        post(new C2740w(this, str, cVar));
    }

    public void a(int i, com.sandboxol.greendao.a.c<String> cVar) {
        post(new C2741x(this, i, cVar));
    }

    public void b(com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new C2743z(this, cVar));
    }

    public void a() {
        a((com.sandboxol.greendao.a.c<Game>) null);
    }

    public void b(int i, com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new A(this, i, cVar));
    }

    public void a(com.sandboxol.greendao.a.c<Game> cVar) {
        post(new C2742y(this, cVar));
    }
}
