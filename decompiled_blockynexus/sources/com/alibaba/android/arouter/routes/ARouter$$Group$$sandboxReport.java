package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.report.NewSandboxReportService;
import com.sandboxol.report.SandboxReportService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$sandboxReport implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventSandboxReport.NEW_SANDBOX_REPORT, RouteMeta.build(RouteType.PROVIDER, NewSandboxReportService.class, "/sandboxreport/newreport", "sandboxreport", null, -1, Integer.MIN_VALUE));
        map.put(RouterServicePath.EventSandboxReport.SANDBOX_REPORT, RouteMeta.build(RouteType.PROVIDER, SandboxReportService.class, "/sandboxreport/report", "sandboxreport", null, -1, Integer.MIN_VALUE));
    }
}
