package com.sandboxol.imchat.ui.fragment.partydress;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.PartyDressManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.util.TeamManagerClient;
import com.sandboxol.center.router.moduleInfo.party.PartyMessageToken;
import com.sandboxol.center.router.moduleInfo.party.PartyStringConstant;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.greendao.entity.TeamMember;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.center.PartyCenter;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.databinding.FragmentPartyDressBinding;
import com.sandboxol.imchat.entity.UserMessage;
import com.sandboxol.imchat.ui.dialog.TeamDialog;
import com.sandboxol.imchat.ui.fragment.team.TeamModel;
import com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter;
import com.sandboxol.imchat.utils.CompareList;
import com.sandboxol.imchat.utils.PartyEventLogic;
import com.sandboxol.messager.MessagerClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class PartyDressViewModel extends ViewModel {
    private FragmentPartyDressBinding binding;
    private Context context;
    private GameMassage gameMassage;
    private boolean isFirstCreate;
    private AnimationDrawable loadingAnim;
    private TeamModel teamModel;
    private boolean isAnybodyInGame = false;
    private ObservableField<Boolean> isRenderingFinish = new ObservableField<>(false);
    public ObservableField<Boolean> isHideBgImage = new ObservableField<>(false);
    public ObservableField<Boolean> isShowLoading = new ObservableField<>(true);
    public ObservableField<Boolean> isCaptain = new ObservableField<>(false);
    private ObservableField<Integer> teamNum = new ObservableField<>(1);
    private List<TeamMember> teamMembers = new ArrayList();
    private List<Long> sentTimeList = new ArrayList();
    private Map<String, TeamMember> nicknameMap = new HashMap();
    private Map<String, Long> nicknameToUserId = new HashMap();
    private Map<String, TeamMember> lastNicknameMap = new HashMap();

    public PartyDressViewModel(Context context, FragmentPartyDressBinding fragmentPartyDressBinding, GameMassage gameMassage) {
        this.binding = fragmentPartyDressBinding;
        this.context = context;
        this.gameMassage = gameMassage;
        initData();
        initMessenger();
        startAnim();
    }

    private void addMember(List<TeamMember> list) {
        if (list.size() != 0) {
            for (TeamMember teamMember : list) {
                if (teamMember.getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
                    Messenger.getDefault().send(Boolean.valueOf(teamMember.getCaptainId() == AccountCenter.newInstance().userId.get().longValue()), ChatMessageToken.IS_PARTY_CAPTAIN);
                }
                PartyDressManager.addMember(teamMember);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeBackground(int i) {
        PartyDressManager.changeBackground(i == 4 ? StringConstant.CUSTOM_BG_PARTY_4 : StringConstant.CUSTOM_BG_PARTY_2);
    }

    private void initData() {
        GameMassage gameMassage = this.gameMassage;
        if (gameMassage != null) {
            this.teamModel = new TeamModel(this.context, gameMassage, this.teamMembers);
            this.isCaptain.set(Boolean.valueOf(this.gameMassage.isCaptain()));
            return;
        }
        ToastUtils.showLongToast(this.context, R.string.team_create_failure);
        Context context = this.context;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        ((Activity) this.context).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMembers() {
        this.isShowLoading.set(false);
        stopAnim();
        this.teamNum.set(Integer.valueOf(this.teamMembers.size()));
        initNicknameMap(this.teamMembers);
        if (this.lastNicknameMap.size() != 0) {
            if (this.teamMembers.size() < this.lastNicknameMap.size()) {
                kickMember();
                updateMember();
            }
            if (this.teamMembers.size() > this.lastNicknameMap.size()) {
                addMember();
            }
            if (this.teamMembers.size() == this.lastNicknameMap.size()) {
                updateMember();
            }
        } else {
            addMember(this.teamMembers);
        }
        saveLastNicknameMap(this.teamMembers);
        if (this.isFirstCreate) {
            return;
        }
        PartyEventLogic.enterPartySuccess(this.context, this.gameMassage);
        this.isFirstCreate = true;
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_MEMBER_NUM_UPDATE, Integer.class, new Action1<Integer>() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.1
            @Override // rx.functions.Action1
            public void call(Integer num) {
                if (num.intValue() >= 1) {
                    PartyDressViewModel.this.isShowLoading.set(false);
                    PartyDressViewModel.this.stopAnim();
                }
                PartyDressViewModel.this.teamNum.set(num);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_UPDATE_GAME_MASSAGE, GameMassage.class, new Action1<GameMassage>() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.2
            @Override // rx.functions.Action1
            public void call(GameMassage gameMassage) {
                PartyDressViewModel.this.isCaptain.set(Boolean.valueOf(gameMassage.isCaptain()));
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_PARTY_SHRINK_EDIT_TEXT, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.3
            @Override // rx.functions.Action0
            public void call() {
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_PARTY_ROOM_CLOSE, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.4
            @Override // rx.functions.Action0
            public void call() {
                if (!(PartyDressViewModel.this.context instanceof Activity) || ((Activity) PartyDressViewModel.this.context).isFinishing()) {
                    return;
                }
                ((Activity) PartyDressViewModel.this.context).finish();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_REFRESH_MEMBER, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.5
            @Override // rx.functions.Action0
            public void call() {
                if (((Boolean) PartyDressViewModel.this.isRenderingFinish.get()).booleanValue()) {
                    PartyDressViewModel partyDressViewModel = PartyDressViewModel.this;
                    partyDressViewModel.changeBackground(partyDressViewModel.gameMassage.getMemberCount());
                    PartyDressViewModel.this.initMembers();
                }
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.START_PARTY_GAME, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.partydress.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f18778a.f();
            }
        });
        MessagerClient.getIns().registerMsg0(PartyDressViewModel.class, PartyMessageToken.PARTY_ADD_PLAYER, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.imchat.ui.fragment.partydress.b
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f18774a.h();
            }
        });
        MessagerClient.getIns().registerMsg1(PartyDressViewModel.class, PartyMessageToken.PARTY_CLICK_PLAYER, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.6
            @Override // com.sandboxol.messager.a.b
            public void onCall(com.sandboxol.messager.a.f fVar) {
                String strC = fVar.c(PartyStringConstant.PARTY_CLICK_PLAYER_NAME);
                if (TextUtils.equals(strC, AccountCenter.newInstance().nickName.get()) || strC == null || PartyDressViewModel.this.nicknameToUserId == null || PartyDressViewModel.this.nicknameToUserId.size() == 0 || PartyDressViewModel.this.nicknameToUserId.get(strC) == null) {
                    return;
                }
                Messenger.getDefault().send(PartyDressViewModel.this.nicknameToUserId.get(strC), ChatMessageToken.START_PARTY_FRIEND_INFO_DIALOG);
            }
        });
        MessagerClient.getIns().registerMsg1(PartyDressViewModel.class, PartyMessageToken.PARTY_KICK_PLAYER, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.7
            @Override // com.sandboxol.messager.a.b
            public void onCall(com.sandboxol.messager.a.f fVar) {
                final String strC = fVar.c(PartyStringConstant.PARTY_CLICK_PLAYER_NAME);
                if (strC == null || PartyDressViewModel.this.nicknameToUserId == null || PartyDressViewModel.this.nicknameToUserId.size() == 0 || PartyDressViewModel.this.nicknameToUserId.get(strC) == null) {
                    return;
                }
                new TeamDialog(PartyDressViewModel.this.context).setDetailText(PartyDressViewModel.this.context.getString(R.string.party_remove_member)).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel.7.1
                    @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                    public void onClick() {
                        Messenger.getDefault().send(PartyDressViewModel.this.nicknameToUserId.get(strC), ChatMessageToken.TOKEN_TEAM_REMOVE_MEMBER);
                    }
                }).show();
            }
        });
        Messenger.getDefault().register(this, CommonMessageToken.SEND_RONG_MESSAGE, UserMessage.class, new Action1() { // from class: com.sandboxol.imchat.ui.fragment.partydress.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18773a.a((UserMessage) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_APP_CHECK_UPDATE, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.partydress.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18776a.i();
            }
        });
    }

    private void initNicknameMap(List<TeamMember> list) {
        this.nicknameMap.clear();
        if (list.size() != 0) {
            for (TeamMember teamMember : list) {
                this.nicknameMap.put(String.valueOf(teamMember.getUserId()), teamMember);
                this.nicknameToUserId.put(teamMember.getNickName(), Long.valueOf(teamMember.getUserId()));
            }
        }
    }

    private void kickMember() {
        for (String str : CompareList.getReduceaListThanbList(new ArrayList(this.nicknameMap.keySet()), new ArrayList(this.lastNicknameMap.keySet()))) {
            if (this.lastNicknameMap.get(str) != null && this.lastNicknameMap.get(str).getNickName() != null) {
                PartyDressManager.removeMember(Long.parseLong(str), this.lastNicknameMap.get(str).getNickName());
            }
        }
    }

    private void saveLastNicknameMap(List<TeamMember> list) {
        this.lastNicknameMap.clear();
        if (list.size() != 0) {
            for (TeamMember teamMember : list) {
                this.lastNicknameMap.put(String.valueOf(teamMember.getUserId()), teamMember);
            }
        }
    }

    private void startAnim() {
        this.loadingAnim = (AnimationDrawable) this.binding.ivLoading.getBackground();
        if (this.loadingAnim.isRunning()) {
            return;
        }
        this.loadingAnim.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAnim() {
        if (this.loadingAnim.isRunning()) {
            this.loadingAnim.stop();
        }
    }

    private void updateMember() {
        this.isAnybodyInGame = false;
        for (TeamMember teamMember : this.nicknameMap.values()) {
            if (teamMember.isCaptain()) {
                PartyDressManager.changePartyOwner(teamMember.getNickName());
                Messenger.getDefault().send(Boolean.valueOf(teamMember.getCaptainId() == AccountCenter.newInstance().userId.get().longValue()), ChatMessageToken.IS_PARTY_CAPTAIN);
            }
            PartyDressManager.changeOnGameState(teamMember.getNickName(), teamMember.getStatus() == 1);
            if (teamMember.getStatus() == 1) {
                this.isAnybodyInGame = true;
            }
        }
    }

    public /* synthetic */ void a(UserMessage userMessage) {
        if (this.nicknameMap.get(userMessage.getUserId()) == null || this.nicknameMap.get(userMessage.getUserId()).getNickName() == null) {
            return;
        }
        boolean z = true;
        Iterator<Long> it = this.sentTimeList.iterator();
        while (it.hasNext()) {
            if (userMessage.getSentTime() == it.next().longValue() && userMessage.getSentTime() != 0) {
                z = false;
            }
        }
        if (z) {
            this.sentTimeList.add(Long.valueOf(userMessage.getSentTime()));
            PartyDressManager.sendChat(this.nicknameMap.get(userMessage.getUserId()).getNickName(), userMessage.getMessage());
        }
    }

    public /* synthetic */ void f() {
        if (this.teamNum.get().intValue() <= 1) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.party_num_too_less);
            return;
        }
        if (this.gameMassage.getCaptainId() != AccountCenter.newInstance().userId.get().longValue()) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.imchat_party_start_game);
        } else if (this.isAnybodyInGame) {
            AppToastUtils.showLongPositiveTipToast(this.context, R.string.imchat_party_somebody_in_game);
        } else {
            this.teamModel.myTeamStartGame();
            PartyEventLogic.clickStartParty(this.context, this.gameMassage);
        }
    }

    public /* synthetic */ void h() {
        TeamAdapter.showTeamInviteDialog(this.context, this.teamMembers, this.gameMassage);
    }

    public /* synthetic */ void i() {
        TeamManagerClient teamManagerClient;
        TeamModel teamModel = this.teamModel;
        if (teamModel == null || (teamManagerClient = teamModel.managerClient) == null) {
            return;
        }
        try {
            try {
                teamManagerClient.shutdownTeam();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.teamModel.managerClient = null;
            this.teamModel.reconnectManagerClient();
        } catch (Throwable th) {
            this.teamModel.managerClient = null;
            throw th;
        }
    }

    public /* synthetic */ void j() {
        this.isRenderingFinish.set(true);
        Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.imchat.ui.fragment.partydress.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18775a.a((Long) obj);
            }
        }, new Action1() { // from class: com.sandboxol.imchat.ui.fragment.partydress.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
        PartyDressManager.changeMode(2, this.gameMassage.getMemberCount());
        List<TeamMember> list = this.teamMembers;
        if (list == null || list.size() == 0) {
            return;
        }
        changeBackground(this.gameMassage.getMemberCount());
        initMembers();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        TeamManagerClient teamManagerClient;
        TeamModel teamModel = this.teamModel;
        if (teamModel != null && (teamManagerClient = teamModel.managerClient) != null) {
            try {
                try {
                    teamManagerClient.shutdownTeam();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.teamModel.managerClient = null;
            }
        }
        if (this.isCaptain.get().booleanValue() && this.teamNum.get().intValue() == 1 && this.gameMassage != null) {
            Messenger.getDefault().send(this.gameMassage.getChatRoomId(), ChatMessageToken.TOKEN_LAST_MEMBER_EXIT_CHAT_ROOM);
        }
        this.teamModel.onDestroy();
        Messenger.getDefault().unregister(this);
        MessagerClient.getIns().unRegisterMsg(PartyDressViewModel.class);
        PartyCenter.newInstance().teamId.set("");
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        TeamManagerClient teamManagerClient;
        super.onPause();
        if (((Activity) this.context).isFinishing()) {
            PartyDressManager.onPauseByGroupView(this.binding.dressViewGroup);
            TeamModel teamModel = this.teamModel;
            if (teamModel == null || (teamManagerClient = teamModel.managerClient) == null) {
                return;
            }
            try {
                try {
                    teamManagerClient.shutdownTeam();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.teamModel.managerClient = null;
            }
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        PartyDressManager.onResumeByViewGroup(this.context, this.binding.dressViewGroup, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.partydress.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18777a.j();
            }
        });
        if (this.teamModel.isEnterGame()) {
            this.teamModel.initManagerClient();
            this.teamModel.setRetryGame(true);
        }
    }

    private void addMember() {
        for (String str : CompareList.getAddaListThanbList(new ArrayList(this.nicknameMap.keySet()), new ArrayList(this.lastNicknameMap.keySet()))) {
            if (this.nicknameMap.get(str) != null) {
                PartyDressManager.addMember(this.nicknameMap.get(str));
            }
        }
    }

    public /* synthetic */ void a(Long l) {
        this.isHideBgImage.set(true);
    }
}
