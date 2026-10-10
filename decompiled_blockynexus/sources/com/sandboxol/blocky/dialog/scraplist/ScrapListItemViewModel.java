package com.sandboxol.blocky.dialog.scraplist;

import android.content.Context;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class ScrapListItemViewModel extends ListItemViewModel<ScrapTreasureRewardInfo> {
    public ReplyCommand onShowDetail;

    public ScrapListItemViewModel(Context context, ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
        super(context, scrapTreasureRewardInfo);
        this.onShowDetail = new ReplyCommand(new Action0() { // from class: com.sandboxol.blocky.dialog.scraplist.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f16303a.showDetail();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDetail() {
        new ScrapRewardDescriptionDialog(this.context, ((ScrapTreasureRewardInfo) this.item).getScrapName(), ((ScrapTreasureRewardInfo) this.item).getScrapDesc(), ((ScrapTreasureRewardInfo) this.item).getScrapValue(), true).show();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ScrapTreasureRewardInfo getItem() {
        return (ScrapTreasureRewardInfo) super.getItem();
    }
}
