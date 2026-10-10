package com.sandboxol.report;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleApi.INewSandboxReportService;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.utils.AppUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseExceptionListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.messager.a.f;
import com.sandboxol.report.config.MessageConst;
import com.sandboxol.report.config.SharedDataKey;
import com.sandboxol.report.entity.NewEventInfoRequest;
import com.sandboxol.report.strategy.FunnelAppStrategy;
import com.sandboxol.report.strategy.FunnelGameFrequencyStrategy;
import com.sandboxol.report.strategy.FunnelGameNumStrategy;
import com.sandboxol.report.strategy.FunnelNewAppStrategy;
import com.sandboxol.report.strategy.IReportStrategy;
import com.sandboxol.report.web.ReportInfoApi;
import io.reactivex.p;
import io.reactivex.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventSandboxReport.NEW_SANDBOX_REPORT)
public class NewSandboxReportService implements INewSandboxReportService {
    private static final String KEY_APP_EVENT = "key.app.event";
    private static final String KEY_EVENT = "ke.event";
    private static final String KEY_EVENT_PLATFORM = "key.event.paltform";
    private static final String KEY_EVENT_TYPE = "key.event.type";
    private static final String KEY_GAME_EVENT = "key.game.event";
    private static final String KEY_GAME_ID = "ke.game.id";
    private io.reactivex.disposables.b mDisposable;
    private int reportInterTime = -1;
    private boolean isReport = false;
    private boolean isReportFinish = true;
    private Map<String, IReportStrategy> reportStrategyMaps = new HashMap();
    private Map<String, List<NewEventInfoRequest>> delEvents = new HashMap();

    /* JADX INFO: renamed from: com.sandboxol.report.NewSandboxReportService$2, reason: invalid class name */
    class AnonymousClass2 implements w<Long> {
        AnonymousClass2() {
        }

        public /* synthetic */ void a() {
            NewSandboxReportService.this.isReportFinish = true;
        }

        @Override // io.reactivex.w
        public void onComplete() {
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (NewSandboxReportService.this.mDisposable != null) {
                NewSandboxReportService.this.mDisposable.dispose();
            }
            NewSandboxReportService.this.mDisposable = bVar;
        }

        @Override // io.reactivex.w
        public void onNext(Long l) {
            if (NewSandboxReportService.this.isReportFinish) {
                NewSandboxReportService.this.isReportFinish = false;
                NewSandboxReportService.this.handleReportEvent(new Action0() { // from class: com.sandboxol.report.a
                    @Override // rx.functions.Action0
                    public final void call() {
                        this.f18886a.a();
                    }
                });
            }
        }
    }

    private void _onAppEvent(String str, String str2) {
        IReportStrategy iReportStrategy = this.reportStrategyMaps.get(str);
        if (iReportStrategy != null) {
            iReportStrategy.onAppEvent(str2);
        }
    }

    private void _onGameEvent(String str, String str2, String str3) {
        IReportStrategy iReportStrategy = this.reportStrategyMaps.get(str);
        if (iReportStrategy != null) {
            iReportStrategy.onGameEvent(str2, str3);
        }
    }

    private void _startReport(Context context) {
        p.interval(this.reportInterTime * 1000, TimeUnit.MILLISECONDS).observeOn(io.reactivex.f.b.b()).subscribe(new AnonymousClass2());
        MessagerClient.getIns().unRegisterMsg(NewSandboxReportService.class);
        MessagerClient.getIns().registerMsg1(NewSandboxReportService.class, MessageConst.SANDBOX_NEW_REPORT_EVENT, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.report.b
            @Override // com.sandboxol.messager.a.b
            public final void onCall(f fVar) {
                this.f18887a.a(fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delEvents() {
        for (Map.Entry<String, List<NewEventInfoRequest>> entry : this.delEvents.entrySet()) {
            IReportStrategy iReportStrategy = this.reportStrategyMaps.get(entry.getKey());
            if (iReportStrategy != null && entry.getValue().size() > 0) {
                iReportStrategy.clearEvents(entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReportEvent(final Action0 action0) {
        ArrayList arrayList = new ArrayList();
        this.delEvents.clear();
        for (Map.Entry<String, IReportStrategy> entry : this.reportStrategyMaps.entrySet()) {
            List<NewEventInfoRequest> events = entry.getValue().getEvents();
            if (events.size() > 0) {
                arrayList.addAll(events);
                this.delEvents.put(entry.getKey(), events);
            }
        }
        if (arrayList.size() > 0) {
            ReportInfoApi.newReportSandboxData(BaseApplication.getApp(), arrayList, new OnResponseExceptionListener() { // from class: com.sandboxol.report.NewSandboxReportService.1
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i, String str) {
                    action0.call();
                }

                @Override // com.sandboxol.common.base.web.OnResponseExceptionListener
                public void onErrorWithData(int i, Throwable th) {
                    action0.call();
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i) {
                    action0.call();
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(Object obj) {
                    NewSandboxReportService.this.delEvents();
                    action0.call();
                }
            });
        } else {
            action0.call();
        }
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
                this.isReport = true;
                this.reportInterTime = reportInternal;
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
        MessagerClient.getIns().unRegisterMsg(NewSandboxReportService.class);
    }

    public /* synthetic */ void a(f fVar) {
        if (this.isReport) {
            String strC = fVar.c(KEY_EVENT_PLATFORM);
            if (KEY_APP_EVENT.equals(strC)) {
                _onAppEvent(fVar.c(KEY_EVENT_TYPE), fVar.c(KEY_EVENT));
            } else if (KEY_GAME_EVENT.equals(strC)) {
                _onGameEvent(fVar.c(KEY_EVENT_TYPE), fVar.c(KEY_EVENT), fVar.c(KEY_GAME_ID));
            }
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.INewSandboxReportService
    public int getReportInternal() {
        return SharedUtils.getInt(BaseApplication.getContext(), SharedDataKey.KEY_NEW_REPORT_INTERNAL, 60);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.INewSandboxReportService
    public void onAppEvent(String str, String str2) {
        if (AppUtils.isMainProcess()) {
            if (this.isReport) {
                _onAppEvent(str, str2);
            }
        } else {
            f fVar = new f();
            fVar.b(KEY_EVENT_TYPE, str);
            fVar.b(KEY_EVENT, str2);
            fVar.b(KEY_EVENT_PLATFORM, KEY_APP_EVENT);
            MessagerClient.getIns().sendMsg1(MessageConst.SANDBOX_NEW_REPORT_EVENT, fVar);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.INewSandboxReportService
    public void onCreate(Context context) {
        this.reportStrategyMaps.put(NewReportEventType.FUNNEL_APP_NUMBER, new FunnelAppStrategy(true));
        this.reportStrategyMaps.put(NewReportEventType.FUNNEL_NEW_APP_NUMBER, new FunnelNewAppStrategy(true));
        this.reportStrategyMaps.put(NewReportEventType.FUNNEL_GAME_NUMBER, new FunnelGameNumStrategy(true));
        this.reportStrategyMaps.put(NewReportEventType.FUNNEL_GAME_FREQUENCY, new FunnelGameFrequencyStrategy(false));
        startReport(context);
    }

    @Override // com.sandboxol.center.router.moduleApi.INewSandboxReportService
    public void onDestroy() {
        this.reportStrategyMaps.clear();
        stopReport();
    }

    @Override // com.sandboxol.center.router.moduleApi.INewSandboxReportService
    public void onGameEvent(String str, String str2, String str3) {
        if ("g1008".equals(str3)) {
            str2 = str2.replace("g1008", StringConstant.BED_WAR_HALL_GAME_ID);
            str3 = StringConstant.BED_WAR_HALL_GAME_ID;
        }
        if (StringConstant.LUCKY_BLOCK_GAME_ID.equals(str3)) {
            str2 = str2.replace(StringConstant.LUCKY_BLOCK_GAME_ID, StringConstant.LUCKY_BLOCK_HALL_GAME_ID);
            str3 = StringConstant.LUCKY_BLOCK_HALL_GAME_ID;
        }
        if (AppUtils.isMainProcess()) {
            if (this.isReport) {
                _onGameEvent(str, str2, str3);
            }
        } else {
            f fVar = new f();
            fVar.b(KEY_EVENT_TYPE, str);
            fVar.b(KEY_EVENT, str2);
            fVar.b(KEY_GAME_ID, str3);
            fVar.b(KEY_EVENT_PLATFORM, KEY_GAME_EVENT);
            MessagerClient.getIns().sendMsg1(MessageConst.SANDBOX_NEW_REPORT_EVENT, fVar);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.INewSandboxReportService
    public void setReportInternal(int i) {
        SharedUtils.putInt(BaseApplication.getContext(), SharedDataKey.KEY_NEW_REPORT_INTERNAL, i);
        startReport(BaseApplication.getContext());
    }
}
