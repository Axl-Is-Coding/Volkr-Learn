package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes3.dex */
public interface IDialogService extends IBaseService {
    void enterMiniGameDialog(Context context, String str, Game game);

    void enterMiniGameDialog(Context context, String str, Game game, boolean z);

    void startFiveStarsDialog(Context context);
}
