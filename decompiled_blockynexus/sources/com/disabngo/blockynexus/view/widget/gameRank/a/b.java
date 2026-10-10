package com.disabngo.blockynexus.view.widget.gameRank.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.GameRankingInfo;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: compiled from: GameSelectItemViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends ListItemViewModel<GameRankingInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f12086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12088c;

    public b(Context context, String str, long j, GameRankingInfo gameRankingInfo) {
        super(context, gameRankingInfo);
        this.f12086a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.widget.gameRank.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f12085a.h();
            }
        });
        this.f12087b = j;
        this.f12088c = str;
    }

    public Drawable f() {
        GameRankingInfo item = getItem();
        if (item.getTypeId() >= 0) {
            return this.f12087b == item.getTypeId() ? BaseApplication.getContext().getResources().getDrawable(R.color.bg_discover_rang_press) : BaseApplication.getContext().getResources().getDrawable(R.color.bg_discover_rang);
        }
        String str = this.f12088c;
        return (str == null || str.isEmpty() || !this.f12088c.equals(item.getSortType())) ? BaseApplication.getContext().getResources().getDrawable(R.color.bg_discover_rang) : BaseApplication.getContext().getResources().getDrawable(R.color.bg_discover_rang_press);
    }

    public /* synthetic */ void h() {
        if (getItem().getTypeId() >= 0) {
            Messenger.getDefault().send(Long.valueOf(getItem().getTypeId()), MessageToken.TOKEN_SELECT_DISCOVER_TYPE);
        } else {
            Messenger.getDefault().send(getItem().getSortType(), MessageToken.TOKEN_SELECT_DISCOVER_TYPE);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GameRankingInfo getItem() {
        return (GameRankingInfo) super.getItem();
    }
}
