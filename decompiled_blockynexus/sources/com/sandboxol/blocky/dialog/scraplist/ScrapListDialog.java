package com.sandboxol.blocky.dialog.scraplist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import androidx.databinding.e;
import com.sandboxol.center.entity.ScrapTreasureBoxInfo;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.game.R;
import com.sandboxol.game.a.w;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class ScrapListDialog extends HideNavigationBarDialog {
    private w binding;
    public ReplyCommand closeCommand;
    public ScrapListModel listModel;
    public ObservableField<Integer> progress;
    public ObservableField<Integer> rewardQuantity;

    public ScrapListDialog(Context context, ScrapTreasureBoxInfo scrapTreasureBoxInfo) {
        super(context);
        this.rewardQuantity = new ObservableField<>(0);
        this.progress = new ObservableField<>();
        this.closeCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blocky.dialog.scraplist.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f16302a.dismiss();
            }
        });
        initView();
        this.listModel = new ScrapListModel(context, R.string.no_data, scrapTreasureBoxInfo.getScrapList());
        this.rewardQuantity.set(Integer.valueOf(scrapTreasureBoxInfo.getRewardQuantity()));
    }

    private void initView() {
        this.binding = (w) e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_list, (ViewGroup) null, false);
        this.binding.a(this);
        setContentView(this.binding.getRoot());
        setInnerViews(this.binding.f17728c);
    }
}
