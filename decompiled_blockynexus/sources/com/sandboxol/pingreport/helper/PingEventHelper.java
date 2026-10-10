package com.sandboxol.pingreport.helper;

import android.database.sqlite.SQLiteException;
import com.sandboxol.greendao.c.C;
import com.sandboxol.pingreport.entity.DaoSession;
import com.sandboxol.pingreport.entity.PingEvent;
import com.sandboxol.pingreport.entity.PingEventDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.d.i;
import org.greenrobot.greendao.d.k;

/* JADX INFO: loaded from: classes4.dex */
public class PingEventHelper extends IDbHelper {
    private static final int MAX_REPORT = 1000;
    private static final String NAME_DB = "bm-pingEvent-db";

    /* JADX INFO: renamed from: me, reason: collision with root package name */
    private static PingEventHelper f18847me;

    protected PingEventHelper(String str) {
        super(str);
    }

    private PingEvent findByGameId(String str) {
        i<PingEvent> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(PingEventDao.Properties.GameId.a(str), new k[0]);
        List<PingEvent> listC = iVarQueryBuilder.c();
        if (listC == null || listC.size() <= 0) {
            return null;
        }
        return listC.get(0);
    }

    private void insertOrReplace(PingEvent pingEvent) {
        try {
            getDao().insertOrReplace(pingEvent);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public static PingEventHelper newInstance() {
        if (f18847me == null) {
            synchronized (PingEventHelper.class) {
                if (f18847me == null) {
                    f18847me = new PingEventHelper(NAME_DB);
                }
            }
        }
        return f18847me;
    }

    public /* synthetic */ void a(String str, int i) {
        PingEvent pingEventFindByGameId = findByGameId(str);
        if (pingEventFindByGameId == null) {
            PingEvent pingEvent = new PingEvent(str);
            pingEvent.addFpsValue(i);
            insertOrReplace(pingEvent);
        } else if (pingEventFindByGameId.getFpsValueList().size() < 1000) {
            pingEventFindByGameId.addFpsValue(i);
            getDao().update(pingEventFindByGameId);
        }
    }

    public /* synthetic */ void b(String str, int i) {
        PingEvent pingEventFindByGameId = findByGameId(str);
        if (pingEventFindByGameId == null) {
            PingEvent pingEvent = new PingEvent(str);
            pingEvent.addPingValue(i);
            insertOrReplace(pingEvent);
        } else if (pingEventFindByGameId.getPingValueList().size() < 1000) {
            pingEventFindByGameId.addPingValue(i);
            getDao().update(pingEventFindByGameId);
        }
    }

    public /* synthetic */ void c(String str, int i) {
        PingEvent pingEventFindByGameId = findByGameId(str);
        if (pingEventFindByGameId == null) {
            PingEvent pingEvent = new PingEvent(str);
            pingEvent.addPingNetValue(i);
            insertOrReplace(pingEvent);
        } else if (pingEventFindByGameId.getNetPingValueList().size() < 1000) {
            pingEventFindByGameId.addPingNetValue(i);
            getDao().update(pingEventFindByGameId);
        }
    }

    public void clearReportEvent(final List<PingEvent> list) {
        post(new Runnable() { // from class: com.sandboxol.pingreport.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f18854a.a(list);
            }
        });
    }

    @Override // com.sandboxol.pingreport.helper.IDbHelper
    protected org.greenrobot.greendao.a init(DaoSession daoSession) {
        return daoSession.getPingEventDao();
    }

    public void insertFpsEvent(final String str, final int i) {
        post(new Runnable() { // from class: com.sandboxol.pingreport.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f18851a.a(str, i);
            }
        });
    }

    public void insertPingEvent(final String str, final int i) {
        post(new Runnable() { // from class: com.sandboxol.pingreport.helper.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f18856a.b(str, i);
            }
        });
    }

    public void insertPingNetEvent(final String str, final int i) {
        post(new Runnable() { // from class: com.sandboxol.pingreport.helper.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f18848a.c(str, i);
            }
        });
    }

    public void loadAllReport(final com.sandboxol.greendao.a.c<List<PingEvent>> cVar) {
        post(new C.a<List<PingEvent>>() { // from class: com.sandboxol.pingreport.helper.PingEventHelper.1
            @Override // com.sandboxol.greendao.c.C.a
            public void onError(Throwable th) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(-1, th.getMessage());
                }
            }

            @Override // com.sandboxol.greendao.c.C.a
            public List<PingEvent> onExecute() {
                List<PingEvent> listLoadAll = PingEventHelper.this.getDao().loadAll();
                ArrayList arrayList = new ArrayList();
                for (PingEvent pingEvent : listLoadAll) {
                    if (!pingEvent.isEmpty()) {
                        arrayList.add(pingEvent);
                    }
                }
                return arrayList;
            }

            @Override // com.sandboxol.greendao.c.C.a
            public void onSuccess(List<PingEvent> list) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onSuccess(list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public PingEventDao getDao() {
        return (PingEventDao) super.getDao();
    }

    public /* synthetic */ void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PingEvent pingEvent = (PingEvent) it.next();
            PingEvent pingEventFindByGameId = findByGameId(pingEvent.getGameId());
            if (pingEventFindByGameId != null) {
                pingEventFindByGameId.getPingValueList().subList(0, pingEvent.getPingValueList().size()).clear();
                pingEventFindByGameId.getNetPingValueList().subList(0, pingEvent.getNetPingValueList().size()).clear();
                pingEventFindByGameId.getFpsValueList().subList(0, pingEvent.getFpsValueList().size()).clear();
                getDao().update(pingEventFindByGameId);
            }
        }
    }
}
