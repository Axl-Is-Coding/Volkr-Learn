package com.disabngo.blockynexus.view.activity.join;

import com.disabngo.blockynexus.R;
import com.sandboxol.blockmango.GameResManager;
import com.sandboxol.blockmango.GameResNewUpdater;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.MiniGameToken;
import rx.functions.Action1;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements GameResNewUpdater.GameResUpdaterListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiniGameToken f10731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f10732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f10733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ s f10734e;

    p(s sVar, String str, MiniGameToken miniGameToken, int i, long j) {
        this.f10734e = sVar;
        this.f10730a = str;
        this.f10731b = miniGameToken;
        this.f10732c = i;
        this.f10733d = j;
    }

    public /* synthetic */ void a(MiniGameToken miniGameToken, int i, long j, Boolean bool) {
        if (bool.booleanValue()) {
            ReportUtils.resDownloadReport(this.f10734e.f10737a, this.f10734e.f10738b.getGameId(), EventConstant.UNZIP_GAME_MAP_SUCCESS);
            this.f10734e.b(miniGameToken, i, j);
            this.f10734e.j.set(100);
            s sVar = this.f10734e;
            sVar.k.set(sVar.f10737a.getString(R.string.download_map_successfull));
            return;
        }
        ReportUtils.resDownloadReport(this.f10734e.f10737a, this.f10734e.f10738b.getGameId(), EventConstant.UNZIP_GAME_MAP_FAILED);
        s sVar2 = this.f10734e;
        sVar2.k.set(sVar2.f10737a.getString(R.string.download_map_failed));
        s sVar3 = this.f10734e;
        sVar3.b(sVar3.f10737a.getResources().getString(R.string.download_map_failed));
    }

    @Override // com.sandboxol.blockmango.GameResNewUpdater.GameResUpdaterListener
    public void onFailed() {
        ReportUtils.resDownloadReport(this.f10734e.f10737a, this.f10734e.f10738b.getGameId(), EventConstant.DOWNLOAD_GAME_MAP_FAILED);
        ReportDataAdapter.onEvent(this.f10734e.f10737a, EventConstant.ENGINE2_DOWNLOAD_MAP, "1");
        s sVar = this.f10734e;
        sVar.b(sVar.f10737a.getResources().getString(R.string.download_map_failed));
    }

    @Override // com.sandboxol.blockmango.GameResNewUpdater.GameResUpdaterListener
    public void onProgress(double d2, double d3, double d4) {
        this.f10734e.j.set(Integer.valueOf((int) d2));
        s sVar = this.f10734e;
        sVar.k.set(sVar.f10737a.getString(R.string.download_progress, new Object[]{String.valueOf(d2)}));
        if (d2 == 100.0d) {
            s sVar2 = this.f10734e;
            sVar2.k.set(sVar2.f10737a.getString(R.string.checking_map_res_merge));
        }
    }

    @Override // com.sandboxol.blockmango.GameResNewUpdater.GameResUpdaterListener
    public void onSuccess(boolean z) {
        ReportUtils.resDownloadReport(this.f10734e.f10737a, this.f10734e.f10738b.getGameId(), EventConstant.DOWNLOAD_GAME_MAP_SUCCESS);
        ReportDataAdapter.onEvent(this.f10734e.f10737a, EventConstant.ENGINE2_DOWNLOAD_MAP, "0");
        if (!z) {
            ReportUtils.resDownloadReport(this.f10734e.f10737a, this.f10734e.f10738b.getGameId(), EventConstant.UNZIP_GAME_MAP_SUCCESS);
            this.f10734e.b(this.f10731b, this.f10732c, this.f10733d);
            this.f10734e.j.set(100);
            s sVar = this.f10734e;
            sVar.k.set(sVar.f10737a.getString(R.string.download_map_successfull));
            return;
        }
        s sVar2 = this.f10734e;
        sVar2.k.set(sVar2.f10737a.getResources().getString(R.string.unzip_map));
        SandboxReportManager.onEvent("new_game_release_" + this.f10734e.f10738b.getGameId(), this.f10734e.f10738b.getGameId() + ReportEventType.GAME_INTER_BASE, this.f10734e.f10738b.getGameId());
        SandboxReportManager.onEvent("new_game_release_" + this.f10734e.f10738b.getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
        GameResManager gameResManager = this.f10734e.f10741e;
        String str = this.f10730a;
        final MiniGameToken miniGameToken = this.f10731b;
        final int i = this.f10732c;
        final long j = this.f10733d;
        gameResManager.prepareAndCheckGameRes(str, new Action1() { // from class: com.disabngo.blockynexus.view.activity.join.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10708a.a(miniGameToken, i, j, (Boolean) obj);
            }
        });
    }
}
