package com.sandboxol.greendao.c;

import android.database.sqlite.SQLiteException;
import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import com.sandboxol.greendao.entity.GameDiskCacheInfoDao;
import java.util.List;

/* JADX INFO: compiled from: GameDiskCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class fa extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static fa f18489b;

    private fa(String str) {
        super(str);
    }

    public static synchronized fa newInstance() {
        if (f18489b == null) {
            f18489b = new fa("bm-game-disk-cache-db");
        }
        return f18489b;
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getGameDiskCacheInfoDao();
    }

    public GameDiskCacheInfo b(String str) {
        return getDao().load(str);
    }

    public /* synthetic */ void c(GameDiskCacheInfo gameDiskCacheInfo) {
        try {
            getDao().insertOrReplace(gameDiskCacheInfo);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, com.sandboxol.greendao.a.c<GameDiskCacheInfo> cVar) {
        post(new C2722da(this, str, cVar));
    }

    public List<GameDiskCacheInfo> b() {
        org.greenrobot.greendao.d.i<GameDiskCacheInfo> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(GameDiskCacheInfoDao.Properties.IsNewEngine.a(1), new org.greenrobot.greendao.d.k[0]);
        return iVarQueryBuilder.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public GameDiskCacheInfoDao getDao() {
        return (GameDiskCacheInfoDao) super.getDao();
    }

    public void a(final GameDiskCacheInfo gameDiskCacheInfo) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f18505a.c(gameDiskCacheInfo);
            }
        });
    }

    public void b(GameDiskCacheInfo gameDiskCacheInfo) {
        getDao().insertOrReplace(gameDiskCacheInfo);
    }

    public void c(String str) {
        getDao().deleteByKey(str);
    }

    public void a(com.sandboxol.greendao.a.c<List<GameDiskCacheInfo>> cVar) {
        post(new ea(this, cVar));
    }

    public GameDiskCacheInfo a(Game game, GameDiskCacheInfo gameDiskCacheInfo) {
        if (gameDiskCacheInfo == null) {
            gameDiskCacheInfo = new GameDiskCacheInfo();
        }
        if (game != null) {
            gameDiskCacheInfo.setGameId(game.getGameId());
            gameDiskCacheInfo.setGameCoverPic(game.getGameCoverPic());
            gameDiskCacheInfo.setGameName(game.getGameName());
            gameDiskCacheInfo.setGameTitle(game.getGameTitle());
            gameDiskCacheInfo.setIsNewEngine(game.getIsNewEngine());
            gameDiskCacheInfo.setIsUgcGame(game.getIsUgcGame());
        }
        return gameDiskCacheInfo;
    }

    public void a() {
        getDao().deleteAll();
    }
}
