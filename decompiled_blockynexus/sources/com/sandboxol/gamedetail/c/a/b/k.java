package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.greendao.entity.AuthorInfo;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameDetailIntroduceModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public void a(Context context, long j, List<AuthorInfo> list, boolean z, boolean z2) {
        if (z) {
            DialogUtils.newsInstant().showLoadingDialog(context);
        }
        GameApi.getAuthorList(context, j, new i(this, list, z, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            DialogUtils.newsInstant().hideLoadingDialog();
        }
    }

    public void a(Context context, Game game, ObservableField<String> observableField, ObservableField<Boolean> observableField2) {
        if (game != null) {
            GameApi.getGameUpdateContent(context, game, new j(this, context, game.getGameId(), observableField, observableField2));
        }
    }
}
