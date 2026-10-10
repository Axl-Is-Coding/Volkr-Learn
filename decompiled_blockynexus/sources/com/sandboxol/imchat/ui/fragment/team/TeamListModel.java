package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.TeamMember;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TeamListModel extends DataListModel<TeamMember> implements ItemTouchHelperAdapter {
    private GameMassage gameMassage;
    private List<TeamMember> list;
    private List<TeamMember> teamMembers;

    public TeamListModel(Context context, int i, List<TeamMember> list, GameMassage gameMassage, int i2) {
        super(context, i);
        this.teamMembers = list;
        this.gameMassage = gameMassage;
        initData(i2);
    }

    private void initData(int i) {
        this.list = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            this.list.add(new TeamMember(false, true, TextEllipsizeUtil.SignLib.END_POINT, i2));
        }
    }

    private List<TeamMember> moveCaptainToFirst() {
        List<TeamMember> list = this.teamMembers;
        if (list != null && list.size() > 1) {
            int i = 0;
            while (true) {
                if (i >= this.teamMembers.size()) {
                    break;
                }
                if (this.teamMembers.get(i).isCaptain()) {
                    Collections.swap(this.teamMembers, i, 0);
                    break;
                }
                i++;
            }
        }
        return this.teamMembers;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getInsertToken() {
        return ChatMessageToken.TOKEN_TEAM_INSERT_MEMBER;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<TeamMember> listItemViewModel) {
    }

    @Override // com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperAdapter
    public void onItemDismiss(int i) {
        this.list.remove(i);
        Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
    }

    @Override // com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperAdapter
    public boolean onItemMove(int i, int i2) {
        if (i != i2) {
            Collections.swap(this.list, i, i2);
        }
        Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
        return true;
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TeamMember>> onResponseListener) {
        Messenger.getDefault().send(Integer.valueOf(this.teamMembers.size()), ChatMessageToken.TOKEN_TEAM_MEMBER_NUM_UPDATE);
        moveCaptainToFirst();
        Observable.from(this.teamMembers).subscribe(new Action1<TeamMember>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamListModel.1
            @Override // rx.functions.Action1
            public void call(TeamMember teamMember) {
                TeamListModel.this.list.set(teamMember.getPosition(), teamMember);
            }
        });
        onResponseListener.onSuccess(this.list);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<TeamMember> getItemViewModel(TeamMember teamMember) {
        return teamMember.isLast() ? new TeamAddItemViewModel(this.context, teamMember, this.gameMassage) : new TeamMemberItemViewModel(this.context, teamMember, this.gameMassage.isCaptain());
    }
}
