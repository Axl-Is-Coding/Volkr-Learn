package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.TeamMember;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TeamAddItemViewModel extends ListItemViewModel<TeamMember> {
    private GameMassage gameMassage;
    public ReplyCommand onClickAdd;

    public TeamAddItemViewModel(Context context, TeamMember teamMember, GameMassage gameMassage) {
        super(context, teamMember);
        this.onClickAdd = new ReplyCommand(new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamAddItemViewModel.1
            @Override // rx.functions.Action0
            public void call() {
            }
        });
        this.gameMassage = gameMassage;
    }
}
