package com.disabngo.blockynexus.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.sandboxol.center.router.moduleApi.IDialogService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventDialog.DIALOG_SERVICE)
public class DialogService implements IDialogService {
    @Override // com.sandboxol.center.router.moduleApi.IDialogService
    public void enterMiniGameDialog(Context context, String str, Game game) {
        DialogC1122va dialogC1122va = new DialogC1122va(context, str, game);
        dialogC1122va.show();
        dialogC1122va.a();
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IDialogService
    public void startFiveStarsDialog(Context context) {
        D.c(context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IDialogService
    public void enterMiniGameDialog(Context context, String str, Game game, boolean z) {
        DialogC1122va dialogC1122va = new DialogC1122va(context, str, game);
        dialogC1122va.a(z);
        dialogC1122va.show();
        dialogC1122va.a();
    }
}
