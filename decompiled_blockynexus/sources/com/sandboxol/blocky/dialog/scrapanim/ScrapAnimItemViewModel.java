package com.sandboxol.blocky.dialog.scrapanim;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class ScrapAnimItemViewModel extends ListItemViewModel<ScrapTreasureRewardInfo> {
    public ObservableField<Boolean> isFromMain;
    public ReplyCommand onDescCommand;

    public ScrapAnimItemViewModel(Context context, ScrapTreasureRewardInfo scrapTreasureRewardInfo, boolean z) {
        super(context, scrapTreasureRewardInfo);
        this.isFromMain = new ObservableField<>(false);
        this.onDescCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blocky.dialog.scrapanim.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f16300a.f();
            }
        });
        this.isFromMain.set(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        new ScrapRewardDescriptionDialog(this.context, ((ScrapTreasureRewardInfo) this.item).getScrapName(), ((ScrapTreasureRewardInfo) this.item).getScrapDesc(), ((ScrapTreasureRewardInfo) this.item).getScrapValue(), true).show();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ScrapTreasureRewardInfo getItem() {
        return (ScrapTreasureRewardInfo) super.getItem();
    }
}
