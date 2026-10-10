package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.imchat.entity.TeamPositionInfo;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TeamPositionItemViewModel extends ListItemViewModel<TeamPositionInfo> {
    public TeamPositionItemViewModel(Context context, TeamPositionInfo teamPositionInfo) {
        super(context, teamPositionInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TeamPositionInfo getItem() {
        return (TeamPositionInfo) super.getItem();
    }
}
