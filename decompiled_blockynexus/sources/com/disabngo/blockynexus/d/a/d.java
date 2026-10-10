package com.disabngo.blockynexus.d.a;

import android.util.Log;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: DressDownloadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements com.disabngo.blockynexus.interfaces.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f7212a;

    d(e eVar) {
        this.f7212a = eVar;
    }

    @Override // com.disabngo.blockynexus.interfaces.a
    public void a() {
        Log.e("checkClothesResSuccess", "Success!");
    }

    @Override // com.disabngo.blockynexus.interfaces.a
    public void a(Throwable th) {
        Log.e("pasteClothesResFailed", "clothesVerifyError");
    }

    @Override // com.disabngo.blockynexus.interfaces.a
    public void a(long j) {
        if (j != 0) {
            Log.e("checkClothesResCopy", "Success!");
            if (this.f7212a.f7214b == null) {
                this.f7212a.f7214b = BaseApplication.getContext();
            }
            SharedUtils.putLong(this.f7212a.f7214b, SharedConstant.CLOTHES_RES_VERSION_CODE, j);
        } else {
            Log.e("checkClothesResError", "Interface Error!");
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_FRIEND_HIDE_DRESS_LOADING);
        DressManager.reloadActor();
    }
}
