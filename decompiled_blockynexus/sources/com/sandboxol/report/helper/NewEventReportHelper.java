package com.sandboxol.report.helper;

import android.database.sqlite.SQLiteException;
import com.sandboxol.greendao.c.C;
import com.sandboxol.report.entity.DaoSession;
import com.sandboxol.report.entity.NewEventInfoRequest;
import com.sandboxol.report.entity.NewEventInfoRequestDao;
import java.util.List;
import org.greenrobot.greendao.d.i;
import org.greenrobot.greendao.d.k;

/* JADX INFO: loaded from: classes4.dex */
public class NewEventReportHelper extends IDbHelper {
    private static final int MAX_REPORT = 200;
    private static final String NAME_DB = "new-event-report-db";

    /* JADX INFO: renamed from: me, reason: collision with root package name */
    private static NewEventReportHelper f18888me;

    protected NewEventReportHelper(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SynInsertOrReplace, reason: merged with bridge method [inline-methods] */
    public void a(NewEventInfoRequest newEventInfoRequest) {
        try {
            if (getDao().count() > 200) {
                getDao().deleteAll();
            }
            getDao().insertOrReplace(newEventInfoRequest);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public static NewEventReportHelper newInstance() {
        if (f18888me == null) {
            synchronized (NewEventReportHelper.class) {
                if (f18888me == null) {
                    f18888me = new NewEventReportHelper(NAME_DB);
                }
            }
        }
        return f18888me;
    }

    public /* synthetic */ void b(String str) {
        i<NewEventInfoRequest> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(NewEventInfoRequestDao.Properties.EventType.a(str), new k[0]);
        iVarQueryBuilder.b().b();
    }

    @Override // com.sandboxol.report.helper.IDbHelper
    protected org.greenrobot.greendao.a init(DaoSession daoSession) {
        return daoSession.getNewEventInfoRequestDao();
    }

    public void insertOrReplace(final NewEventInfoRequest newEventInfoRequest) {
        post(new Runnable() { // from class: com.sandboxol.report.helper.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f18890a.a(newEventInfoRequest);
            }
        });
    }

    public void loadByEventType(final String str, final com.sandboxol.greendao.a.c<List<NewEventInfoRequest>> cVar) {
        postSync(new C.a<List<NewEventInfoRequest>>() { // from class: com.sandboxol.report.helper.NewEventReportHelper.1
            @Override // com.sandboxol.greendao.c.C.a
            public void onError(Throwable th) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(-1, th.getMessage());
                }
            }

            @Override // com.sandboxol.greendao.c.C.a
            public List<NewEventInfoRequest> onExecute() {
                i<NewEventInfoRequest> iVarQueryBuilder = NewEventReportHelper.this.getDao().queryBuilder();
                iVarQueryBuilder.a(NewEventInfoRequestDao.Properties.EventType.a(str), new k[0]);
                return iVarQueryBuilder.c();
            }

            @Override // com.sandboxol.greendao.c.C.a
            public void onSuccess(List<NewEventInfoRequest> list) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onSuccess(list);
                }
            }
        });
    }

    public void removeByEventType(final String str) {
        post(new Runnable() { // from class: com.sandboxol.report.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f18894a.b(str);
            }
        });
    }

    public void removeByEventTypeAndGameId(final String str, final String str2) {
        post(new Runnable() { // from class: com.sandboxol.report.helper.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f18896a.a(str, str2);
            }
        });
    }

    public void removeEventList(final List<NewEventInfoRequest> list) {
        post(new Runnable() { // from class: com.sandboxol.report.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f18892a.a(list);
            }
        });
    }

    public /* synthetic */ void a(List list) {
        getDao().deleteInTx(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public NewEventInfoRequestDao getDao() {
        return (NewEventInfoRequestDao) super.getDao();
    }

    public /* synthetic */ void a(String str, String str2) {
        i<NewEventInfoRequest> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(iVarQueryBuilder.a(NewEventInfoRequestDao.Properties.EventType.a(str), NewEventInfoRequestDao.Properties.GameId.a(str2), new k[0]), new k[0]);
        iVarQueryBuilder.b().b();
    }
}
