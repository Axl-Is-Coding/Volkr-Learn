package com.disabngo.blockynexus.e.b.N;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.j.f;
import com.disabngo.blockynexus.view.fragment.main.E;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.gamedetail.c.a.a.va;
import com.sandboxol.greendao.entity.Game;
import rx.functions.Action0;

/* JADX INFO: compiled from: LatelyGameItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends E {
    private ObservableField<Boolean> k;
    private ObservableField<Boolean> l;
    public ReplyCommand m;

    public c(Context context, Game game, ObservableField<Boolean> observableField) {
        super(context, game);
        this.k = new ObservableField<>(false);
        this.m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.N.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9359a.h();
            }
        });
        this.l = observableField;
    }

    public /* synthetic */ void a(f fVar, boolean z) {
        if (!z) {
            AppToastUtils.showShortPositiveTipToast(this.context, R.string.check_resource_failed);
        }
        fVar.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void h() {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(((Game) this.item).getGameId());
        if (gameProgressInfo != null && gameProgressInfo.getIsDownload().get().booleanValue()) {
            AppToastUtils.showShortPositiveTipToast(this.context, R.string.dialog_download_info_ing);
            return;
        }
        final f fVar = new f(this.context);
        fVar.show();
        new va(this.context, this.l, this.k, new va.a() { // from class: com.disabngo.blockynexus.e.b.N.b
            @Override // com.sandboxol.gamedetail.c.a.a.va.a
            public final void a(boolean z) {
                this.f9360a.a(fVar, z);
            }
        }).a((Game) this.item);
        Messenger.getDefault().send(getItem().getGameId(), MessageToken.TOKEN_GAME_UPDATE_CONTENT_CLICK);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_REC_CLICK, getItem().getGameId());
    }
}
