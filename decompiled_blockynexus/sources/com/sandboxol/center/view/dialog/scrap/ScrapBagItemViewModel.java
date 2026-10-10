package com.sandboxol.center.view.dialog.scrap;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapInfoInBackpack;
import com.sandboxol.center.entity.ScrapMakeSureInfo;
import com.sandboxol.center.entity.XScrapCardInfo;
import com.sandboxol.center.view.dialog.ScrapMakeSureDialog;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapBagItemViewModel extends ListItemViewModel<ScrapInfoInBackpack> {
    private long friendId;
    public ObservableField<Boolean> isFromMain;
    private boolean isPrivate;
    public ReplyCommand onClickCommand;

    public ScrapBagItemViewModel(Context context, ScrapInfoInBackpack scrapInfoInBackpack, ObservableField<Boolean> observableField, long j, boolean z) {
        super(context, scrapInfoInBackpack);
        this.onClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.scrap.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f16392a.onClick();
            }
        });
        this.friendId = j;
        this.isPrivate = z;
        this.isFromMain = observableField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onClick() {
        if (this.isFromMain.get().booleanValue()) {
            new ScrapRewardDescriptionDialog(this.context, ((ScrapInfoInBackpack) this.item).getScrapName(), ((ScrapInfoInBackpack) this.item).getScrapDesc(), ((ScrapInfoInBackpack) this.item).getScrapValue(), false).show();
            return;
        }
        new ScrapMakeSureDialog(this.context, new ScrapMakeSureInfo(((ScrapInfoInBackpack) this.item).getScrapId(), ((ScrapInfoInBackpack) this.item).getScrapName(), "", this.friendId, ((ScrapInfoInBackpack) this.item).getScrapType(), ((ScrapInfoInBackpack) this.item).getScrapPic(), ((ScrapInfoInBackpack) this.item).getScrapLevel()), 0, new ScrapMakeSureDialog.OnMakeSureClickListener() { // from class: com.sandboxol.center.view.dialog.scrap.c
            @Override // com.sandboxol.center.view.dialog.ScrapMakeSureDialog.OnMakeSureClickListener
            public final void onSure(String str) {
                this.f16391a.a(str);
            }
        }).show();
        if (TextUtils.isEmpty(((ScrapInfoInBackpack) this.item).getScrapId())) {
            ReportDataAdapter.onEvent(this.context, "ScrapBagItemViewModel");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(String str) {
        Messenger.getDefault().send(new XScrapCardInfo(AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().nickName.get(), ((ScrapInfoInBackpack) this.item).getScrapId(), ((ScrapInfoInBackpack) this.item).getScrapType(), ((ScrapInfoInBackpack) this.item).getScrapLevel(), ((ScrapInfoInBackpack) this.item).getScrapName(), ((ScrapInfoInBackpack) this.item).getScrapPic(), str, String.valueOf(this.friendId), this.isPrivate, ((ScrapInfoInBackpack) this.item).getScrapDesc(), ((ScrapInfoInBackpack) this.item).getScrapValue()), MessageToken.TOKEN_SEND_SCRAP_CARD);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ScrapInfoInBackpack getItem() {
        return (ScrapInfoInBackpack) super.getItem();
    }
}
