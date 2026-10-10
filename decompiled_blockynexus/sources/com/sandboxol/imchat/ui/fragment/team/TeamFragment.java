package com.sandboxol.imchat.ui.fragment.team;

import android.os.Bundle;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatStringConstant;
import com.sandboxol.imchat.databinding.FragmentTeamBinding;

/* JADX INFO: loaded from: classes4.dex */
public class TeamFragment extends BaseFragment<TeamViewModel, FragmentTeamBinding> {
    private final int INIT_TEAM_MEMBER_NUM = 4;
    private final int INIT_TEAM_NUM = 1;

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_team;
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CHAT_ROOM_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public void bindViewModel(FragmentTeamBinding fragmentTeamBinding, TeamViewModel teamViewModel) {
        fragmentTeamBinding.setTeamViewModel(teamViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public TeamViewModel getViewModel() {
        GameMassage gameMassage;
        if (getArguments() != null) {
            gameMassage = (GameMassage) getArguments().getSerializable(ChatStringConstant.GAME_MESSAGE_OBJ);
            if (gameMassage != null && gameMassage.getMaxMember() == 0 && gameMassage.getMemberCount() == 0) {
                gameMassage.setMaxMember(4);
                gameMassage.setTeamCount(1);
                gameMassage.setMemberCount(4);
                gameMassage.setTeamType(2);
                gameMassage.setTeamRoom(true);
                if (StringConstant.LUCKY_BLOCK_GAME_ID.equals(gameMassage.getGameType())) {
                    gameMassage.setMaxMember(2);
                    gameMassage.setTeamCount(1);
                    gameMassage.setMemberCount(2);
                    gameMassage.setTeamType(2);
                }
            }
        } else {
            gameMassage = null;
        }
        SandboxReportManager.onEvent(ReportEvent.NEW_PARTY_VIEW, ReportEventType.NEW_USER_BEHAVIOR, "app");
        return gameMassage != null ? new TeamViewModel(this.context, (FragmentTeamBinding) this.binding, gameMassage) : new TeamViewModel(this.context, (FragmentTeamBinding) this.binding, new GameMassage());
    }
}
