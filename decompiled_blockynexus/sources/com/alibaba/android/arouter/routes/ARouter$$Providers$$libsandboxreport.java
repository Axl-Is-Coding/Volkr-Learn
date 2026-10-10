package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.report.NewSandboxReportService;
import com.sandboxol.report.SandboxReportService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$libsandboxreport implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.INewSandboxReportService", RouteMeta.build(RouteType.PROVIDER, NewSandboxReportService.class, RouterServicePath.EventSandboxReport.NEW_SANDBOX_REPORT, "sandboxReport", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.ISandboxReportService", RouteMeta.build(RouteType.PROVIDER, SandboxReportService.class, RouterServicePath.EventSandboxReport.SANDBOX_REPORT, "sandboxReport", null, -1, Integer.MIN_VALUE));
    }
}
