package com.sandboxol.pingreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabaseLockedException;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.moduleApi.IPingReportService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.a.c;
import com.sandboxol.messager.b.a;
import com.sandboxol.pingreport.config.SharedDataKey;
import com.sandboxol.pingreport.dto.PingEventDto;
import com.sandboxol.pingreport.entity.PingEvent;
import com.sandboxol.pingreport.event.EventTask;
import com.sandboxol.pingreport.event.FpsEventTask;
import com.sandboxol.pingreport.event.IEvent;
import com.sandboxol.pingreport.event.NetPingEventTask;
import com.sandboxol.pingreport.event.PingEventTask;
import com.sandboxol.pingreport.helper.PingEventHelper;
import com.sandboxol.pingreport.web.PingReportApi;
import io.reactivex.disposables.b;
import io.reactivex.p;
import io.reactivex.w;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventPing.PING_REPORT)
public class PingReportService implements IPingReportService, IEvent {
    private static final int DEFAULT_INTER_TIME = 300;
    private static volatile boolean isStart;
    private b mDisposable;
    private int reportInterTime = 300;
    private EventTask pingTask = new PingEventTask(this);
    private EventTask netPingTask = new NetPingEventTask(this);
    private EventTask fpsTask = new FpsEventTask(this);

    private void _startReport() {
        p.interval(this.reportInterTime * 1000, TimeUnit.MILLISECONDS).observeOn(io.reactivex.f.b.b()).subscribe(new w<Long>() { // from class: com.sandboxol.pingreport.PingReportService.1
            @Override // io.reactivex.w
            public void onComplete() {
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.w
            public void onSubscribe(b bVar) {
                synchronized (PingReportService.class) {
                    if (PingReportService.this.mDisposable != null) {
                        PingReportService.this.mDisposable.dispose();
                    }
                    PingReportService.this.mDisposable = bVar;
                    boolean unused = PingReportService.isStart = true;
                }
            }

            @Override // io.reactivex.w
            public void onNext(Long l) {
                try {
                    PingEventHelper.newInstance().loadAllReport(new c<List<PingEvent>>() { // from class: com.sandboxol.pingreport.PingReportService.1.1
                        @Override // com.sandboxol.greendao.a.c
                        public void onError(int i, String str) {
                        }

                        @Override // com.sandboxol.greendao.a.c
                        public void onSuccess(final List<PingEvent> list) {
                            if (list.size() > 0) {
                                PingReportApi.reportPingEvent(new PingEventDto(BaseApplication.getApp().getPackageName(), list), new OnResponseListener() { // from class: com.sandboxol.pingreport.PingReportService.1.1.1
                                    @Override // com.sandboxol.common.base.web.OnResponseListener
                                    public void onError(int i, String str) {
                                    }

                                    @Override // com.sandboxol.common.base.web.OnResponseListener
                                    public void onServerError(int i) {
                                    }

                                    @Override // com.sandboxol.common.base.web.OnResponseListener
                                    public void onSuccess(Object obj) {
                                        PingEventHelper.newInstance().clearReportEvent(list);
                                    }
                                });
                            }
                        }
                    });
                } catch (SQLiteDatabaseLockedException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private boolean isMainProcess() {
        return BaseApplication.getApp().getPackageName().equals(a.a(BaseApplication.getApp()));
    }

    private void startReport() {
        if (isMainProcess()) {
            int reportInternal = getReportInternal();
            if (reportInternal <= 0) {
                stopReport();
            } else {
                this.reportInterTime = reportInternal;
                _startReport();
            }
        }
    }

    private void stopReport() {
        synchronized (PingReportService.class) {
            if (this.mDisposable != null) {
                this.mDisposable.dispose();
                this.mDisposable = null;
                isStart = false;
            }
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPingReportService
    public int getReportInternal() {
        return SharedUtils.getInt(BaseApplication.getContext(), SharedDataKey.KEY_PING_REPORT_INTERNAL, 60);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IPingReportService
    public void initService(Context context) {
        startReport();
    }

    @Override // com.sandboxol.pingreport.event.IEvent
    public boolean isCanReport() {
        if (!isStart) {
            synchronized (PingReportService.class) {
                if (!isStart) {
                    startReport();
                }
            }
        }
        return isStart;
    }

    @Override // com.sandboxol.center.router.moduleApi.IPingReportService
    public void onFpsEvent(String str, int i) {
        this.fpsTask.onReport(str, i);
    }

    @Override // com.sandboxol.center.router.moduleApi.IPingReportService
    public void onNetPingEvent(String str, int i) {
        this.netPingTask.onReport(str, i);
    }

    @Override // com.sandboxol.center.router.moduleApi.IPingReportService
    public void onPingEvent(String str, int i) {
        this.pingTask.onReport(str, i);
    }

    @Override // com.sandboxol.center.router.moduleApi.IPingReportService
    public void setReportInternal(int i) {
        SharedUtils.putInt(BaseApplication.getContext(), SharedDataKey.KEY_PING_REPORT_INTERNAL, i);
        startReport();
    }
}
