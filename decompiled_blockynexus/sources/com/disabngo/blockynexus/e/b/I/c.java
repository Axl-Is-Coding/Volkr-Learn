package com.disabngo.blockynexus.e.b.I;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.main.E;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Game;
import rx.functions.Action0;

/* JADX INFO: compiled from: GameGuessYouLikeItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends E {
    public ReplyCommand k;

    public c(Context context, Game game) {
        super(context, game);
        this.k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.I.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f9311a.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Context context = this.context;
        GameDetailManager.enterGameDetail(context, context.getString(R.string.main_game), getItem());
        Messenger.getDefault().send(getItem().getGameId(), MessageToken.TOKEN_GAME_UPDATE_CONTENT_CLICK);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_GUESS_CLICK, getItem().getGameId());
        ReportDataAdapter.onEvent(this.context, "guess_" + getItem().getIndex() + "_click");
    }

    public void b(int i) {
        if (i == 1) {
            Messenger.getDefault().register(this, MessageToken.TOKEN_NEW_USER_MAIN_FRAGMENT_GUIDE_CLICK, new Action0() { // from class: com.disabngo.blockynexus.e.b.I.a
                @Override // rx.functions.Action0
                public final void call() {
                    this.f9310a.h();
                }
            });
        }
    }

    public /* synthetic */ void h() {
        i();
        SharedUtils.putBoolean(this.context, SharedConstant.SHOW_MAIN_FRAGMENT_GUIDE_DIALOG, true);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_NOV_CLICK);
    }
}
