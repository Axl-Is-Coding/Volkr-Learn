package com.sandboxol.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabaseLockedException;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleApi.ISandboxReportService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.utils.AppUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.a.c;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.messager.a.f;
import com.sandboxol.report.config.MessageConst;
import com.sandboxol.report.config.SharedDataKey;
import com.sandboxol.report.entity.EventInfoRequest;
import com.sandboxol.report.entity.EventRequest;
import com.sandboxol.report.helper.SandboxEventReportHelper;
import com.sandboxol.report.web.ReportInfoApi;
import io.reactivex.p;
import io.reactivex.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventSandboxReport.SANDBOX_REPORT)
public class SandboxReportService implements ISandboxReportService {
    private static final String KEY_EVENT = "event";
    private io.reactivex.disposables.b mDisposable;
    private String packageName;
    private int reportInterTime = -1;
    private boolean isReport = false;
    private boolean isReportFinish = true;

    /* JADX INFO: renamed from: com.sandboxol.report.SandboxReportService$1, reason: invalid class name */
    class AnonymousClass1 implements w<Long> {
        final /* synthetic */ Context val$context;

        /* JADX INFO: renamed from: com.sandboxol.report.SandboxReportService$1$1, reason: invalid class name and collision with other inner class name */
        class C01621 implements c<List<EventInfoRequest>> {
            C01621() {
            }

            @Override // com.sandboxol.greendao.a.c
            public void onError(int i, String str) {
                SandboxReportService.this.isReportFinish = true;
            }

            @Override // com.sandboxol.greendao.a.c
            public void onSuccess(List<EventInfoRequest> list) {
                if (list.size() <= 0) {
                    SandboxReportService.this.isReportFinish = true;
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                Long l = AccountCenter.newInstance().userId.get();
                for (EventInfoRequest eventInfoRequest : list) {
                    if (eventInfoRequest.getUserId().longValue() <= 0 || l.longValue() <= 0 || l.equals(eventInfoRequest.getUserId())) {
                        arrayList.add(eventInfoRequest);
                    }
                }
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                ReportInfoApi.reportSandboxData(anonymousClass1.val$context, new EventRequest(arrayList, SandboxReportService.this.packageName), new OnResponseListener() { // from class: com.sandboxol.report.SandboxReportService.1.1.1
                    @Override // com.sandboxol.common.base.web.OnResponseListener
                    public void onError(int i, String str) {
                        SandboxReportService.this.isReportFinish = true;
                    }

                    @Override // com.sandboxol.common.base.web.OnResponseListener
                    public void onServerError(int i) {
                        SandboxReportService.this.isReportFinish = true;
                    }

                    @Override // com.sandboxol.common.base.web.OnResponseListener
                    public void onSuccess(Object obj) {
                        SandboxEventReportHelper.getInstance().removeEventList(arrayList, new c<EventInfoRequest>() { // from class: com.sandboxol.report.SandboxReportService.1.1.1.1
                            @Override // com.sandboxol.greendao.a.c
                            public void onError(int i, String str) {
                                SandboxReportService.this.isReportFinish = true;
                            }

                            @Override // com.sandboxol.greendao.a.c
                            public void onSuccess(EventInfoRequest eventInfoRequest2) {
                                SandboxReportService.this.isReportFinish = true;
                            }
                        });
                    }
                });
            }
        }

        AnonymousClass1(Context context) {
            this.val$context = context;
        }

        @Override // io.reactivex.w
        public void onComplete() {
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (SandboxReportService.this.mDisposable != null) {
                SandboxReportService.this.mDisposable.dispose();
            }
            SandboxReportService.this.mDisposable = bVar;
        }

        @Override // io.reactivex.w
        public void onNext(Long l) {
            if (SandboxReportService.this.isReportFinish) {
                try {
                    SandboxReportService.this.isReportFinish = false;
                    SandboxEventReportHelper.getInstance().loadAllReport(new C01621());
                } catch (SQLiteDatabaseLockedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void _startReport(Context context) {
        p.interval(this.reportInterTime * 1000, TimeUnit.MILLISECONDS).observeOn(io.reactivex.f.b.b()).subscribe(new AnonymousClass1(context));
        MessagerClient.getIns().unRegisterMsg(SandboxReportService.class);
        MessagerClient.getIns().registerMsg1(SandboxReportService.class, MessageConst.SANDBOX_REPORT_EVENT, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.report.SandboxReportService.2
            @Override // com.sandboxol.messager.a.b
            public void onCall(f fVar) {
                EventInfoRequest eventInfoRequest = (EventInfoRequest) fVar.b(SandboxReportService.KEY_EVENT);
                if (eventInfoRequest != null && SandboxReportService.this.isReport && TimeManager.insertExecuteTime(eventInfoRequest)) {
                    SandboxEventReportHelper.getInstance().insertOrReplace(eventInfoRequest);
                }
            }
        });
    }

    private void startReport(Context context) {
        if (AppUtils.isMainProcess()) {
            int reportInternal = getReportInternal();
            if (reportInternal <= 0) {
                stopReport();
            } else {
                if (this.isReport) {
                    return;
                }
                this.reportInterTime = reportInternal;
                this.isReport = true;
                _startReport(context);
            }
        }
    }

    private void stopReport() {
        io.reactivex.disposables.b bVar = this.mDisposable;
        if (bVar != null) {
            bVar.dispose();
            this.mDisposable = null;
        }
        this.isReport = false;
        MessagerClient.getIns().unRegisterMsg(SandboxReportService.class);
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public int getReportInternal() {
        return SharedUtils.getInt(BaseApplication.getContext(), SharedDataKey.KEY_REPORT_INTERNAL, 60);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void onCreate(Context context, String str) {
        this.packageName = str;
        startReport(context);
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void onDestroy() {
        stopReport();
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void onEvent(String str) {
        if (AppUtils.isMainProcess()) {
            if (this.isReport) {
                SandboxEventReportHelper.getInstance().insertOrReplace(new EventInfoRequest(str));
            }
        } else {
            f fVar = new f();
            fVar.a(KEY_EVENT, new EventInfoRequest(str));
            MessagerClient.getIns().sendMsg1(MessageConst.SANDBOX_REPORT_EVENT, fVar);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void setReportInternal(int i) {
        SharedUtils.putInt(BaseApplication.getContext(), SharedDataKey.KEY_REPORT_INTERNAL, i);
        startReport(BaseApplication.getContext());
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void onEvent(String str, String str2) {
        if (AppUtils.isMainProcess()) {
            if (this.isReport) {
                SandboxEventReportHelper.getInstance().insertOrReplace(new EventInfoRequest(str, str2));
            }
        } else {
            f fVar = new f();
            fVar.a(KEY_EVENT, new EventInfoRequest(str, str2));
            MessagerClient.getIns().sendMsg1(MessageConst.SANDBOX_REPORT_EVENT, fVar);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void onEvent(String str, String str2, String str3) {
        if (AppUtils.isMainProcess()) {
            if (this.isReport) {
                EventInfoRequest eventInfoRequest = new EventInfoRequest(str, str2, str3);
                if (TimeManager.insertExecuteTime(eventInfoRequest)) {
                    SandboxEventReportHelper.getInstance().insertOrReplace(eventInfoRequest);
                    return;
                }
                return;
            }
            return;
        }
        f fVar = new f();
        fVar.a(KEY_EVENT, new EventInfoRequest(str, str2, str3));
        MessagerClient.getIns().sendMsg1(MessageConst.SANDBOX_REPORT_EVENT, fVar);
    }

    @Override // com.sandboxol.center.router.moduleApi.ISandboxReportService
    public void onEvent(String str, String str2, String str3, String str4) {
        if (AppUtils.isMainProcess()) {
            if (this.isReport) {
                SandboxEventReportHelper.getInstance().insertOrReplace(new EventInfoRequest(str, str2, str3, str4));
            }
        } else {
            f fVar = new f();
            fVar.a(KEY_EVENT, new EventInfoRequest(str, str2, str3, str4));
            MessagerClient.getIns().sendMsg1(MessageConst.SANDBOX_REPORT_EVENT, fVar);
        }
    }
}
