package com.tencent.mapsdk.rastercore.c;

import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.CameraPosition;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CameraPosition f19472d;

    public final void a(CameraPosition cameraPosition) {
        this.f19472d = cameraPosition;
    }

    @Override // com.tencent.mapsdk.rastercore.c.a
    public final void a(com.tencent.mapsdk.rastercore.d.f fVar) {
        com.tencent.mapsdk.rastercore.d.b bVarC = fVar.c();
        if (this.f19466a) {
            bVarC.a(com.tencent.mapsdk.rastercore.c.a(this.f19472d.getTarget()), this.f19467b, this.f19468c);
        } else {
            bVarC.b(com.tencent.mapsdk.rastercore.c.a(this.f19472d.getTarget()));
        }
        if (this.f19472d.getZoom() > WheelView.DividerConfig.FILL) {
            bVarC.b(this.f19472d.getZoom(), false, this.f19468c);
        }
    }

    @Override // com.tencent.mapsdk.rastercore.c.a
    public final boolean a() {
        return false;
    }
}
