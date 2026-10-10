package com.disabngo.blockynexus.e.b.y;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.model.IModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0960k implements IModel {
    public void a() {
        GameApi.countUploadVersion(String.valueOf(EngineEnv.v1().getEngineVersion()), (int) EngineEnv.v2().getEngineVersion(), new C0959j(this));
    }
}
