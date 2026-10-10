package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IDialogService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes3.dex */
public class DialogManager {
    private static IDialogService iDialogService = (IDialogService) RouteServiceManager.provide(RouterServicePath.EventDialog.DIALOG_SERVICE);

    public static void enterMiniGameDialog(Context context, String str, Game game) {
        IDialogService iDialogService2 = iDialogService;
        if (iDialogService2 != null) {
            iDialogService2.enterMiniGameDialog(context, str, game);
        }
    }

    public static void startFiveStarsDialog(Context context) {
        IDialogService iDialogService2 = iDialogService;
        if (iDialogService2 != null) {
            iDialogService2.startFiveStarsDialog(context);
        }
    }

    public static void enterMiniGameDialog(Context context, String str, Game game, boolean z) {
        IDialogService iDialogService2 = iDialogService;
        if (iDialogService2 != null) {
            iDialogService2.enterMiniGameDialog(context, str, game, z);
        }
    }
}
