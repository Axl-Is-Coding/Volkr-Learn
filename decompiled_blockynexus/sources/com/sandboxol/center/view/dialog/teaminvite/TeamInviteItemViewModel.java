package com.sandboxol.center.view.dialog.teaminvite;

import android.content.Context;
import android.os.CountDownTimer;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.RongIMManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.TeamMember;
import com.umeng.analytics.pro.au;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class TeamInviteItemViewModel extends ListItemViewModel<Friend> {
    public ObservableField<String> countDownTimeText;
    private CountDownTimer countDownTimer;
    private GameMassage gameMassage;
    public ReplyCommand onInviteClick;
    private List<TeamMember> teamMembers;

    public TeamInviteItemViewModel(Context context, Friend friend, GameMassage gameMassage, List<TeamMember> list) {
        super(context, friend);
        this.countDownTimeText = new ObservableField<>("");
        this.onInviteClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.teaminvite.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f16398a.onInvite();
            }
        });
        this.gameMassage = gameMassage;
        this.teamMembers = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onInvite() {
        startDownTimer();
        if (((Friend) this.item).getFriendPartyStatus() != null) {
            Iterator<TeamMember> it = this.teamMembers.iterator();
            while (it.hasNext()) {
                if (it.next().getTeamId().equals(((Friend) this.item).getFriendPartyStatus().getTeamId())) {
                    AppToastUtils.showShortNegativeTipToast(this.context, R.string.base_party_friend_in_party);
                    return;
                }
            }
        }
        RongIMManager.sendInviteTeamMessage(this.context, TribeCenter.newInstance().tribeClanId.get().longValue() == ((Friend) this.item).getUserId(), String.valueOf(((Friend) this.item).getUserId()), this.gameMassage);
        AppToastUtils.showShortPositiveTipToast(this.context, R.string.base_tribe_invite_success);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_PARTY_INVITE);
    }

    private void startDownTimer() {
        if (this.countDownTimer == null) {
            this.countDownTimer = new CountDownTimer(10000L, 1000L) { // from class: com.sandboxol.center.view.dialog.teaminvite.TeamInviteItemViewModel.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    TeamInviteItemViewModel.this.countDownTimeText.set("");
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    TeamInviteItemViewModel.this.countDownTimeText.set((j / 1000) + au.ax);
                }
            };
        }
        this.countDownTimer.start();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.countDownTimer = null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Friend getItem() {
        return (Friend) super.getItem();
    }
}
