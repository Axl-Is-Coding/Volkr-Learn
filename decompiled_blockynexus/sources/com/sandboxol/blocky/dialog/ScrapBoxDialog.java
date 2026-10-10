package com.sandboxol.blocky.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.e;
import com.sandboxol.blocky.dialog.scraplist.ScrapListDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapTreasureBoxInfo;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.game.R;
import com.sandboxol.game.a.s;
import com.sandboxol.game.a.u;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class ScrapBoxDialog extends HideNavigationBarDialog {
    private s binding;
    public ObservableList<ScrapTreasureBoxInfo> boxInfos;
    public ReplyCommand closeCommand;
    private boolean isWeekend;
    private Listener listener;
    public ReplyCommand<Integer> positionCommand;
    public ObservableField<Integer> probsNum;
    public ObservableField<Integer> progress;
    public ObservableField<Integer> rewardValue;
    public ObservableList<Integer> status;
    public ObservableField<Integer> todayRemainTime;
    private u weekendBinding;
    public ObservableList<ScrapTreasureBoxInfo> weekendBoxInfos;
    public ObservableList<Integer> weekendStatus;

    public interface Listener {
        void callBack(String str, int i);
    }

    public ScrapBoxDialog(Context context, ObservableList<ScrapTreasureBoxInfo> observableList, ObservableField<Integer> observableField, ObservableField<Integer> observableField2, ObservableField<Integer> observableField3, ObservableField<Integer> observableField4, Listener listener) {
        super(context);
        this.status = new ObservableArrayList();
        this.weekendStatus = new ObservableArrayList();
        this.positionCommand = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.blocky.dialog.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16299a.positionClick(((Integer) obj).intValue());
            }
        });
        this.closeCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blocky.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f16296a.dismiss();
            }
        });
        this.boxInfos = observableList;
        this.progress = observableField;
        this.todayRemainTime = observableField2;
        this.probsNum = observableField3;
        this.rewardValue = observableField4;
        this.listener = listener;
        initView();
        initMessenger();
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_COLLECT_CHEST_PAGE);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_REFRESH_SCRAP_BOX_DIALOG, new Action0() { // from class: com.sandboxol.blocky.dialog.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f16298a.a();
            }
        });
    }

    private void initStatus() {
        this.status.clear();
        for (int i = 0; i < this.boxInfos.size(); i++) {
            this.status.add(Integer.valueOf(this.boxInfos.get(i).getOpenStatus() == 0 ? this.progress.get().intValue() >= this.boxInfos.get(i).getDuration() * 60 ? 1 : 0 : 2));
        }
    }

    private void initView() {
        int i = R.layout.dialog_scrap_box;
        ObservableList<ScrapTreasureBoxInfo> observableList = this.boxInfos;
        if (observableList == null || observableList.size() != 8) {
            initStatus();
            this.binding = (s) e.a(LayoutInflater.from(this.context), i, (ViewGroup) null, false);
            this.binding.a(this);
            setContentView(this.binding.getRoot());
            setInnerViews(this.binding.z);
            return;
        }
        this.weekendBoxInfos = this.boxInfos;
        int i2 = R.layout.dialog_scrap_box_weekend;
        this.isWeekend = true;
        initWeekendStatus();
        this.weekendBinding = (u) e.a(LayoutInflater.from(this.context), i2, (ViewGroup) null, false);
        this.weekendBinding.a(this);
        setContentView(this.weekendBinding.getRoot());
        setInnerViews(this.weekendBinding.H);
    }

    private void initWeekendStatus() {
        this.weekendStatus.clear();
        for (int i = 0; i < this.boxInfos.size(); i++) {
            this.weekendStatus.add(Integer.valueOf(this.boxInfos.get(i).getOpenStatus() == 0 ? this.progress.get().intValue() >= this.boxInfos.get(i).getDuration() * 60 ? 1 : 0 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void positionClick(int i) {
        int iIntValue = this.isWeekend ? this.weekendStatus.get(i).intValue() : this.status.get(i).intValue();
        ScrapTreasureBoxInfo scrapTreasureBoxInfo = this.boxInfos.get(i);
        if (scrapTreasureBoxInfo != null) {
            if (iIntValue == 0) {
                new ScrapListDialog(this.context, scrapTreasureBoxInfo).show();
                return;
            }
            if (iIntValue != 1) {
                if (iIntValue != 2) {
                    return;
                }
                AppToastUtils.showShortPositiveTipToast(this.context, R.string.game_dialog_scrap_box_received_tip);
                return;
            }
            ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_AVAILABLE_COLLECT_CHEST_PAGE);
            if (this.listener != null) {
                if (i <= 4 || AccountCenter.newInstance().vip.get().intValue() >= 1 || this.probsNum.get().intValue() > 5) {
                    this.listener.callBack(this.boxInfos.get(i).getUuid(), i);
                } else {
                    AppToastUtils.showShortPositiveTipToast(this.context, R.string.game_dialog_scrap_box_vip_tip);
                }
            }
        }
    }

    public /* synthetic */ void a() {
        if (this.boxInfos.size() < 5) {
            return;
        }
        if (this.boxInfos.size() == 8) {
            initWeekendStatus();
        } else {
            initStatus();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Messenger.getDefault().unregister(this);
    }
}
