package com.sandboxol.imchat.ui.fragment.partydress;

import android.os.Bundle;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.PartyDressManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatStringConstant;
import com.sandboxol.imchat.databinding.FragmentPartyDressBinding;

/* JADX INFO: loaded from: classes4.dex */
public class PartyDressFragment extends BaseFragment<PartyDressViewModel, FragmentPartyDressBinding> {
    private final int INIT_TEAM_MEMBER_NUM = 4;
    private final int INIT_TEAM_NUM = 1;

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_party_dress;
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PartyDressManager.onCreate(getActivity());
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CHAT_ROOM_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public void bindViewModel(FragmentPartyDressBinding fragmentPartyDressBinding, PartyDressViewModel partyDressViewModel) {
        fragmentPartyDressBinding.setViewModel(partyDressViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public PartyDressViewModel getViewModel() {
        GameMassage gameMassage;
        if (getArguments() != null) {
            gameMassage = (GameMassage) getArguments().getSerializable(ChatStringConstant.GAME_MESSAGE_OBJ);
            if (gameMassage != null && gameMassage.getMaxMember() == 0 && gameMassage.getMemberCount() == 0) {
                gameMassage.setMaxMember(4);
                gameMassage.setTeamCount(1);
                gameMassage.setMemberCount(4);
                gameMassage.setTeamType(1);
                gameMassage.setTeamRoom(true);
            }
            if (gameMassage != null && StringConstant.LUCKY_BLOCK_GAME_ID.equals(gameMassage.getGameType())) {
                gameMassage.setMaxMember(2);
                gameMassage.setTeamCount(1);
                gameMassage.setMemberCount(2);
                gameMassage.setTeamType(1);
            }
        } else {
            gameMassage = null;
        }
        return gameMassage != null ? new PartyDressViewModel(this.context, (FragmentPartyDressBinding) this.binding, gameMassage) : new PartyDressViewModel(this.context, (FragmentPartyDressBinding) this.binding, new GameMassage());
    }
}
