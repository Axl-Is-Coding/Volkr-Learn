package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.imchat.BR;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.entity.TeamPositionInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TeamPositionListModel extends DataListModel<TeamPositionInfo> {
    private int teamMaxMemberNum;
    private int teamMembers;

    public TeamPositionListModel(Context context, int i, int i2, int i3) {
        super(context, i);
        this.teamMembers = i2;
        this.teamMaxMemberNum = i3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<TeamPositionInfo> listItemViewModel) {
        gVar.a(BR.ViewModel, R.layout.item_team_position);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TeamPositionInfo>> onResponseListener) {
        for (int i = 0; i < this.teamMembers; i++) {
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<TeamPositionInfo> getItemViewModel(TeamPositionInfo teamPositionInfo) {
        return new TeamPositionItemViewModel(this.context, teamPositionInfo);
    }
}
