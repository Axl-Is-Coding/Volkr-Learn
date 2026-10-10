package com.sandboxol.center.view.dialog.teaminvite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.databinding.BaseDialogTeamInviteBinding;
import com.sandboxol.center.router.manager.FriendManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.TeamMember;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class TeamInviteDialog extends FullScreenDialog {
    private Context context;
    public ObservableField<Integer> friendSize;
    private GameMassage gameMassage;
    public ObservableList<String> inviteList;
    public TeamInviteListLayout listLayout;
    public ReplyCommand onAddFriendClick;
    public ReplyCommand onCancelClick;
    public TeamInviteListModel teamInviteListModel;
    private List<TeamMember> teamMembers;

    public TeamInviteDialog(Context context, GameMassage gameMassage, List<TeamMember> list) {
        super(context);
        this.inviteList = new ObservableArrayList();
        this.friendSize = new ObservableField<>(1);
        this.onAddFriendClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.teaminvite.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f16397a.addFriend();
            }
        });
        this.onCancelClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.teaminvite.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f16396a.onCancel();
            }
        });
        this.context = context;
        this.gameMassage = gameMassage;
        this.teamMembers = list;
        initView();
        ReportDataAdapter.onEvent(context, EventConstant.CLICK_PARTY_ADD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFriend() {
        FriendManager.startSearchFiendActivity(this.context, false);
        ReportDataAdapter.onEvent(this.context, EventConstant.CHAT_ADD_FRIEND_CLICK, "Invite");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancel() {
        if (isShowing()) {
            cancel();
        }
    }

    public void initView() {
        BaseDialogTeamInviteBinding baseDialogTeamInviteBinding = (BaseDialogTeamInviteBinding) e.a(LayoutInflater.from(this.context), R.layout.base_dialog_team_invite, (ViewGroup) null, false);
        baseDialogTeamInviteBinding.setTeamInviteDialog(this);
        setContentView(baseDialogTeamInviteBinding.getRoot());
        this.teamInviteListModel = new TeamInviteListModel(this.context, R.string.no_data, this.friendSize, this.gameMassage, this.teamMembers);
        this.listLayout = new TeamInviteListLayout();
        slideToUp(baseDialogTeamInviteBinding.constraintLayout);
    }
}
