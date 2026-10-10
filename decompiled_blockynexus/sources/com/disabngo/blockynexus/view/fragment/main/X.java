package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Game;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: PageMoreGameItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class X extends E {
    public ReplyCommand k;

    public X(Context context, Game game) {
        super(context, game);
        this.k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.B
            @Override // rx.functions.Action0
            public final void call() {
                this.f11755a.h();
            }
        });
        List<String> downloadGames = AppInfoCenter.newInstance().getAppConfig().getDownloadGames();
        if (downloadGames != null) {
            Iterator<String> it = downloadGames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().equals(getItem().getGameId()) && SharedUtils.getBoolean(context, SharedConstant.IS_BED_WAR_DOWNLOAD)) {
                    this.j.set(true);
                    break;
                }
            }
        }
        this.j.set(Boolean.valueOf(SharedUtils.getBoolean(context, SharedConstant.IS_BED_WAR_DOWNLOAD, false)));
    }

    public /* synthetic */ void h() {
        Context context = this.context;
        GameDetailManager.enterGameDetail(context, context.getString(R.string.main_game), getItem());
        Messenger.getDefault().send(getItem().getGameId(), MessageToken.TOKEN_GAME_UPDATE_CONTENT_CLICK);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_MORE_CLICK, getItem().getGameId());
    }
}
