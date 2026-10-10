package com.sandboxol.report.helper;

import android.database.sqlite.SQLiteException;
import com.sandboxol.greendao.c.C;
import com.sandboxol.report.entity.DaoSession;
import com.sandboxol.report.entity.EventInfoRequest;
import com.sandboxol.report.entity.EventInfoRequestDao;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SandboxEventReportHelper extends IDbHelper {
    private static final int MAX_REPORT = 200;
    private static final String NAME_DB = "event-report-db";

    /* JADX INFO: renamed from: me, reason: collision with root package name */
    private static SandboxEventReportHelper f18889me;

    private SandboxEventReportHelper(String str) {
        super(str);
    }

    public static synchronized SandboxEventReportHelper getInstance() {
        if (f18889me == null) {
            f18889me = new SandboxEventReportHelper(NAME_DB);
        }
        return f18889me;
    }

    public /* synthetic */ void a(EventInfoRequest eventInfoRequest) {
        try {
            if (getDao().count() > 200) {
                getDao().deleteAll();
            }
            getDao().insertOrReplace(eventInfoRequest);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.report.helper.IDbHelper
    protected org.greenrobot.greendao.a init(DaoSession daoSession) {
        return daoSession.getEventInfoRequestDao();
    }

    public void insertOrReplace(final EventInfoRequest eventInfoRequest) {
        post(new Runnable() { // from class: com.sandboxol.report.helper.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f18899a.a(eventInfoRequest);
            }
        });
    }

    public void loadAllReport(final com.sandboxol.greendao.a.c<List<EventInfoRequest>> cVar) {
        postSync(new C.a<List<EventInfoRequest>>() { // from class: com.sandboxol.report.helper.SandboxEventReportHelper.1
            @Override // com.sandboxol.greendao.c.C.a
            public void onError(Throwable th) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(-1, th.getMessage());
                }
            }

            @Override // com.sandboxol.greendao.c.C.a
            public List<EventInfoRequest> onExecute() {
                return SandboxEventReportHelper.this.getDao().loadAll();
            }

            @Override // com.sandboxol.greendao.c.C.a
            public void onSuccess(List<EventInfoRequest> list) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onSuccess(list);
                }
            }
        });
    }

    public void removeEventList(final List<EventInfoRequest> list, final com.sandboxol.greendao.a.c<EventInfoRequest> cVar) {
        post(new C.a<EventInfoRequest>() { // from class: com.sandboxol.report.helper.SandboxEventReportHelper.2
            @Override // com.sandboxol.greendao.c.C.a
            public void onError(Throwable th) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(-1, th.getMessage());
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.greendao.c.C.a
            public EventInfoRequest onExecute() {
                SandboxEventReportHelper.this.getDao().deleteInTx(list);
                return null;
            }

            @Override // com.sandboxol.greendao.c.C.a
            public void onSuccess(EventInfoRequest eventInfoRequest) {
                com.sandboxol.greendao.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onSuccess(eventInfoRequest);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public EventInfoRequestDao getDao() {
        return (EventInfoRequestDao) super.getDao();
    }
}
