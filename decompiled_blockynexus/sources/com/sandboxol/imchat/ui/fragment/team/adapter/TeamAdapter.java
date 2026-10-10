package com.sandboxol.imchat.ui.fragment.team.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.f;
import com.google.gson.j;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.greendao.entity.TeamMember;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.PartyModifyPositionInfo;
import com.sandboxol.imchat.ui.dialog.TeamDialog;
import com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperAdapter;
import com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperViewHolder;
import com.sandboxol.imchat.ui.fragment.team.helper.OnStartDragListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class TeamAdapter extends RecyclerView.a<ItemViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private int extraCount;
    private GameMassage gameMassage;
    private List<TeamMember> list;
    private final OnStartDragListener mDragStartListener;
    private int overCount;
    private int teamMemberCount;
    private List<TeamMember> teamMembers;
    Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable = new Runnable() { // from class: com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter.5
        @Override // java.lang.Runnable
        public void run() {
            TeamAdapter.this.notifyDataSetChanged();
        }
    };

    public static class ItemViewHolder extends RecyclerView.w implements ItemTouchHelperViewHolder {
        public final ImageView ivHead;
        public final ImageView ivRemove;
        public final RelativeLayout rlGroup;
        public final TextView tvNickName;
        public final TextView tvPlaying;

        public ItemViewHolder(View view) {
            super(view);
            this.tvNickName = (TextView) view.findViewById(R.id.tvNickName);
            this.tvPlaying = (TextView) view.findViewById(R.id.tv_playing);
            this.ivHead = (ImageView) view.findViewById(R.id.ivHead);
            this.ivRemove = (ImageView) view.findViewById(R.id.ivRemove);
            this.rlGroup = (RelativeLayout) view.findViewById(R.id.rlGroup);
        }

        @Override // com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperViewHolder
        public void onItemClear() {
        }

        @Override // com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperViewHolder
        public void onItemSelected() {
        }
    }

    public TeamAdapter(Context context, OnStartDragListener onStartDragListener, List<TeamMember> list, GameMassage gameMassage) {
        this.context = context;
        this.mDragStartListener = onStartDragListener;
        this.teamMembers = list;
        this.gameMassage = gameMassage;
        initData();
    }

    private void clearList() {
        for (int i = 0; i < this.list.size(); i++) {
            if (!this.list.get(i).isEmpty()) {
                this.list.set(i, new TeamMember(false, true, TextEllipsizeUtil.SignLib.END_POINT, i));
            }
        }
    }

    private void initData() {
        int i;
        this.list = new ArrayList();
        int memberCount = this.gameMassage.getTeamType() == 1 ? this.gameMassage.getMemberCount() : this.gameMassage.getMaxMember();
        for (int i2 = 0; i2 < memberCount; i2++) {
            this.list.add(new TeamMember(false, true, TextEllipsizeUtil.SignLib.END_POINT, i2));
        }
        this.teamMemberCount = this.gameMassage.getTeamType() == 1 ? this.gameMassage.getMemberCount() : this.gameMassage.getMaxMember() / this.gameMassage.getTeamCount();
        this.overCount = (this.gameMassage.getTeamType() == 1 ? this.gameMassage.getMemberCount() : this.teamMemberCount) % 6;
        if (this.teamMemberCount <= 6 || (i = this.overCount) <= 0) {
            return;
        }
        this.extraCount = 6 - i;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.extraCount; i3++) {
            arrayList.add(new TeamMember(true, true));
        }
        for (int teamCount = this.gameMassage.getTeamType() == 1 ? 1 : this.gameMassage.getTeamCount(); teamCount > 0; teamCount--) {
            this.list.addAll(this.teamMemberCount * teamCount, arrayList);
        }
    }

    private int listPosition2TeamPosition(int i) {
        int i2 = this.teamMemberCount;
        int i3 = this.extraCount;
        return i - ((i / (i2 + i3)) * i3);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMember(long j) {
        Messenger.getDefault().send(Long.valueOf(j), ChatMessageToken.TOKEN_TEAM_REMOVE_MEMBER);
    }

    public static void showTeamInviteDialog(Context context, List<TeamMember> list, GameMassage gameMassage) {
        try {
            Class.forName("com.sandboxol.center.utils.DialogUtils").getMethod("showTeamInviteDialog", Context.class, GameMassage.class, String.class).invoke(null, context, gameMassage, new j().a(list));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int teamPosition2ListPosition(int i) {
        return i + ((i / this.teamMemberCount) * this.extraCount);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.list.size();
    }

    @Override // com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperAdapter
    public void onItemDismiss(int i) {
    }

    @Override // com.sandboxol.imchat.ui.fragment.team.helper.ItemTouchHelperAdapter
    public boolean onItemMove(int i, int i2) {
        if (i != i2 && !this.list.get(i).isPlaceholder() && !this.list.get(i2).isPlaceholder()) {
            Collections.swap(this.list, i, i2);
            ArrayList arrayList = new ArrayList();
            TeamMember teamMember = this.list.get(i);
            TeamMember teamMember2 = this.list.get(i2);
            if (!teamMember.isEmpty() && !teamMember.isPlaceholder()) {
                arrayList.add(teamMember);
            }
            if (!teamMember2.isEmpty() && !teamMember2.isPlaceholder()) {
                arrayList.add(teamMember2);
            }
            teamMember.setPosition(listPosition2TeamPosition(i));
            teamMember2.setPosition(listPosition2TeamPosition(i2));
            Messenger.getDefault().send(new PartyModifyPositionInfo(arrayList), ChatMessageToken.TOKEN_TEAM_MODIFY_MEMBER_POSITION);
        }
        this.handler.post(this.runnable);
        return true;
    }

    public void onRefresh() {
        Messenger.getDefault().send(Integer.valueOf(this.teamMembers.size()), ChatMessageToken.TOKEN_TEAM_MEMBER_NUM_UPDATE);
        clearList();
        Observable.from(this.teamMembers).subscribe(new Action1<TeamMember>() { // from class: com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter.4
            @Override // rx.functions.Action1
            public void call(TeamMember teamMember) {
                TeamAdapter.this.list.set(TeamAdapter.this.teamPosition2ListPosition(teamMember.getPosition()), teamMember);
            }
        });
        this.handler.post(this.runnable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, int i) {
        final TeamMember teamMember = this.list.get(i);
        if (teamMember.isPlaceholder()) {
            itemViewHolder.rlGroup.setVisibility(4);
            return;
        }
        itemViewHolder.rlGroup.setVisibility(0);
        itemViewHolder.tvNickName.setText(teamMember.getNickName());
        f fVar = new f();
        fVar.diskCacheStrategy(p.f4584d).error(R.mipmap.ic_team_add).placeholder(R.mipmap.ic_team_add);
        try {
            c.c(this.context).mo54load((!TextUtils.isEmpty(teamMember.getPicUrl()) || teamMember.isEmpty()) ? teamMember.getPicUrl() : Integer.valueOf(R.mipmap.ic_head_default)).apply((a<?>) fVar).into(itemViewHolder.ivHead);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        if (teamMember.isEmpty()) {
            itemViewHolder.ivRemove.setVisibility(4);
        } else if (teamMember.isCaptain()) {
            itemViewHolder.ivRemove.setVisibility(0);
            itemViewHolder.ivRemove.setImageResource(R.mipmap.ic_team_captain);
        } else if (this.gameMassage.isCaptain()) {
            itemViewHolder.ivRemove.setVisibility(0);
            itemViewHolder.ivRemove.setImageResource(R.mipmap.ic_team_delete);
        } else {
            itemViewHolder.ivRemove.setVisibility(4);
        }
        itemViewHolder.tvPlaying.setVisibility(teamMember.getStatus() == 0 ? 8 : 0);
        itemViewHolder.ivHead.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (teamMember.isEmpty()) {
                    TeamAdapter.showTeamInviteDialog(TeamAdapter.this.context, TeamAdapter.this.teamMembers, TeamAdapter.this.gameMassage);
                } else if (teamMember.getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
                    Messenger.getDefault().send(Long.valueOf(teamMember.getUserId()), ChatMessageToken.START_PARTY_FRIEND_INFO_DIALOG);
                }
            }
        });
        if (this.gameMassage.isCaptain() && !teamMember.isEmpty()) {
            itemViewHolder.ivHead.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    TeamAdapter.this.mDragStartListener.onStartDrag(itemViewHolder);
                    return true;
                }
            });
        }
        if (!this.gameMassage.isCaptain() || teamMember.isEmpty() || teamMember.isCaptain()) {
            return;
        }
        itemViewHolder.ivRemove.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TeamAdapter.this.gameMassage.isCaptain() || teamMember.isCaptain()) {
                    return;
                }
                new TeamDialog(TeamAdapter.this.context).setDetailText(TeamAdapter.this.context.getString(R.string.party_remove_member)).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter.3.1
                    @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                    public void onClick() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        TeamAdapter.this.removeMember(teamMember.getUserId());
                    }
                }).show();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_team_member, viewGroup, false));
    }
}
