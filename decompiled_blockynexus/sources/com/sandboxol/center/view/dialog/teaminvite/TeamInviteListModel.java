package com.sandboxol.center.view.dialog.teaminvite;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.FriendManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.utils.TeamInviteComparator;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.TeamMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes3.dex */
public class TeamInviteListModel extends DataListModel<Friend> {
    private ObservableField<Integer> friendSize;
    private GameMassage gameMassage;
    private List<TeamMember> teamMembers;

    public TeamInviteListModel(Context context, int i, ObservableField<Integer> observableField, GameMassage gameMassage, List<TeamMember> list) {
        super(context, i);
        this.friendSize = observableField;
        this.gameMassage = gameMassage;
        this.teamMembers = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hasTribe(List<Friend> list) {
        if (list.size() == 0 || TribeCenter.newInstance().tribeClanId.get().longValue() == 0) {
            return;
        }
        Friend friend = new Friend();
        friend.setPicUrl(TribeCenter.newInstance().tribeHead.get());
        friend.setNickName(TribeCenter.newInstance().tribeName.get() + "(" + this.context.getString(R.string.base_main_tribe) + ")");
        friend.setUserId(TribeCenter.newInstance().tribeClanId.get().longValue());
        friend.setStatus(10);
        list.add(0, friend);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<Friend> listItemViewModel) {
        gVar.a(BR.ViewModel, R.layout.base_item_team_invite);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(final OnResponseListener<List<Friend>> onResponseListener) {
        final ArrayList arrayList = new ArrayList();
        FriendManager.getFriendsList(this.context, new OnResponseListener<List<Friend>>() { // from class: com.sandboxol.center.view.dialog.teaminvite.TeamInviteListModel.1
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
                TeamInviteListModel.this.hasTribe(arrayList);
                onResponseListener.onSuccess(arrayList);
                TeamInviteListModel.this.friendSize.set(0);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                TeamInviteListModel.this.hasTribe(arrayList);
                onResponseListener.onSuccess(arrayList);
                ServerOnError.showOnServerError(((DefaultListModel) TeamInviteListModel.this).context, i);
                TeamInviteListModel.this.friendSize.set(0);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(List<Friend> list) {
                if (list == null) {
                    onResponseListener.onSuccess(new ArrayList());
                    return;
                }
                Iterator<Friend> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Friend next = it.next();
                    if (next.getUserId() == 32) {
                        list.remove(next);
                        break;
                    }
                }
                Collections.sort(list, new TeamInviteComparator());
                TeamInviteListModel.this.hasTribe(list);
                TeamInviteListModel.this.friendSize.set(Integer.valueOf(list.size()));
                onResponseListener.onSuccess(list);
            }
        }, getRefreshToken(), false);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<Friend> getItemViewModel(Friend friend) {
        return new TeamInviteItemViewModel(this.context, friend, this.gameMassage, this.teamMembers);
    }
}
