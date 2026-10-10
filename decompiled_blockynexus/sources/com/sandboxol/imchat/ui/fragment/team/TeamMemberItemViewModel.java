package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.TeamMember;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.ui.dialog.TeamDialog;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TeamMemberItemViewModel extends ListItemViewModel<TeamMember> {
    private boolean isMyRoom;
    public ReplyCommand onClickDelete;
    public ReplyCommand onClickHead;

    public TeamMemberItemViewModel(Context context, TeamMember teamMember, boolean z) {
        super(context, teamMember);
        this.onClickDelete = new ReplyCommand(new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamMemberItemViewModel.1
            @Override // rx.functions.Action0
            public void call() {
                if (TeamMemberItemViewModel.this.isMyRoom) {
                    new TeamDialog(((ListItemViewModel) TeamMemberItemViewModel.this).context).setDetailText(((ListItemViewModel) TeamMemberItemViewModel.this).context.getString(R.string.party_remove_member)).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamMemberItemViewModel.1.1
                        @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                        public void onClick() {
                            TeamMemberItemViewModel.this.removeMember();
                        }
                    }).show();
                }
            }
        });
        this.onClickHead = new ReplyCommand(new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamMemberItemViewModel.2
            @Override // rx.functions.Action0
            public void call() {
                Messenger.getDefault().send(Long.valueOf(((TeamMember) ((ListItemViewModel) TeamMemberItemViewModel.this).item).getUserId()), ChatMessageToken.TOKEN_TEAM_CLICK_HEAD);
            }
        });
        this.isMyRoom = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void removeMember() {
        Messenger.getDefault().send(Long.valueOf(((TeamMember) this.item).getUserId()), ChatMessageToken.TOKEN_TEAM_REMOVE_MEMBER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable topIcon() {
        if (this.isMyRoom) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_team_", ((TeamMember) this.item).isCaptain() ? "captain" : "delete", "mipmap-xhdpi"));
        }
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_team_", ((TeamMember) this.item).isCaptain() ? "captain" : "empty", "mipmap-xhdpi"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TeamMember getItem() {
        return (TeamMember) super.getItem();
    }
}
