package com.disabngo.blockynexus.d;

import android.content.Context;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0515l extends OnResponseListener<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f7232b;

    C0515l(Context context, int i) {
        this.f7231a = context;
        this.f7232b = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        m.b(list, EngineEnv.getEngine(0, 0).getResRootPath() + "Media/Setting", "tempWords.txt", "words.txt");
        SharedUtils.putInt(this.f7231a, SharedConstant.SENSITIVE_WORD_VERSION, this.f7232b);
    }
}
