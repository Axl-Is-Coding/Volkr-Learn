package com.sandboxol.report.strategy;

import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.report.entity.NewEvent;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class FunnelNewAppStrategy extends BaseReportStrategy {
    public FunnelNewAppStrategy(boolean z) {
        super(z);
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ List clearEvents(List list) {
        return super.clearEvents(list);
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public int endWeight() {
        return 16;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public String getEventType() {
        return NewReportEventType.FUNNEL_NEW_APP_NUMBER;
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ List getEvents() {
        return super.getEvents();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public String getPlatform() {
        return IReportStrategy.PLATFORM_APP;
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ void onAppEvent(String str) {
        super.onAppEvent(str);
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ boolean onFilter(List list, NewEvent newEvent) {
        return super.onFilter(list, newEvent);
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ void onGameEvent(String str, String str2) {
        super.onGameEvent(str, str2);
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ void onLoadData() {
        super.onLoadData();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public int startWeight() {
        return 8;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public int stepLength() {
        return 9;
    }
}
