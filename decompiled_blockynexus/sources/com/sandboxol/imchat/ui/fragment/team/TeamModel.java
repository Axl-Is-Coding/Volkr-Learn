package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.listener.ITeamManagerListener;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDone;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamError;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoing;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequest;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponse;
import com.sandboxol.center.router.moduleInfo.game.team.util.GRPCUtils;
import com.sandboxol.center.router.moduleInfo.game.team.util.TeamManagerClient;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.c.ma;
import com.sandboxol.greendao.c.ra;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.PartyMemberInfo;
import com.sandboxol.greendao.entity.TeamMember;
import com.sandboxol.greendao.entity.TribeMember;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.center.PartyCenter;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatSharedConstant;
import com.sandboxol.imchat.entity.PartyModifyPositionInfo;
import com.sandboxol.imchat.utils.PartyEventLogic;
import com.sandboxol.imchat.web.ChatGameApi;
import com.sandboxol.messager.MessagerClient;
import com.tendcloud.tenddata.ab;
import io.grpc.Status;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class TeamModel {
    private Context context;
    private CountDownTimer countDownTimer;
    private int enterTimes;
    private GameMassage gameMassage;
    private boolean isEnterGame;
    private boolean isRetryGame;
    public TeamManagerClient managerClient;
    private int reEnterTimes;
    private List<TeamMember> teamMembers;
    final List<com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember> modifyPositionMemberList = new ArrayList();
    private ITeamManagerListener iTeamManagerListener = new AnonymousClass5();

    /* JADX INFO: renamed from: com.sandboxol.imchat.ui.fragment.team.TeamModel$5, reason: invalid class name */
    class AnonymousClass5 implements ITeamManagerListener {
        AnonymousClass5() {
        }

        public /* synthetic */ void a(Long l) {
            TeamModel.this.onFinish();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.ITeamManagerListener
        public void onTeamCompleted() {
            MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.ITeamManagerListener
        public void onTeamError(Status status) {
            MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
            switch (AnonymousClass8.$SwitchMap$io$grpc$Status$Code[status.getCode().ordinal()]) {
                case 2:
                    TeamModel.this.startCountDownTimer();
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_disconnected_with_the_server);
                    break;
                case 3:
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_not_exist);
                    TeamModel.this.onFinish();
                    break;
                case 4:
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_invalid_argument);
                    TeamModel.this.onFinish();
                    break;
                case 5:
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_num_is_full);
                    TeamModel.this.onFinish();
                    break;
                case 6:
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_permission_denied);
                    TeamModel.this.onFinish();
                    break;
                case 7:
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.inner_error);
                    TeamModel.this.onFinish();
                    break;
                case 8:
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_not_exist);
                    TeamModel.this.onFinish();
                    break;
            }
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.ITeamManagerListener
        public void onTeamNext(TeamResponse teamResponse) {
            if (TeamModel.this.teamMembers == null) {
                return;
            }
            int i = AnonymousClass8.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[teamResponse.getStateCase().ordinal()];
            if (i == 1) {
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                return;
            }
            if (i == 2) {
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                if (TeamModel.this.countDownTimer != null) {
                    AppToastUtils.showLongPositiveTipToast(TeamModel.this.context, R.string.imchat_party_reconnect);
                    TeamModel.this.stopCountDownTimer();
                }
                TeamGoing going = teamResponse.getGoing();
                if (going != null && going.getTeammembersList() != null) {
                    long captainId = going.getCaptainId();
                    String teamId = going.getTeamId();
                    TeamModel.this.gameMassage.setTeamId(teamId);
                    TeamModel.this.gameMassage.setCaptainId(captainId);
                    TeamModel.this.gameMassage.setPsid(going.getPsid());
                    PartyCenter.newInstance().teamId.set(teamId);
                    Messenger.getDefault().send(TeamModel.this.gameMassage, ChatMessageToken.TOKEN_UPDATE_GAME_MASSAGE);
                    TeamModel.this.teamMembers.clear();
                    for (com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember teamMember : going.getTeammembersList()) {
                        TeamMember teamMember2 = new TeamMember();
                        teamMember2.setNickName(teamMember.getUsername());
                        teamMember2.setUserId(teamMember.getUserid());
                        teamMember2.setCaptainId(captainId);
                        teamMember2.setPicUrl(teamMember.getPicurl());
                        teamMember2.setTeamId(teamId);
                        teamMember2.setPosition(teamMember.getPosition());
                        teamMember2.setStatus(teamMember.getStatus().ordinal());
                        teamMember2.setSex(teamMember.getSex());
                        teamMember2.setVip(teamMember.getVip());
                        TeamModel.this.teamMembers.add(teamMember2);
                        TeamModel.this.savePartyMemberInfo(teamMember2);
                    }
                }
                TeamModel.this.reEnterPartyReport();
                Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_TEAM_REFRESH_MEMBER);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    if (i == 5 && teamResponse.getStartGame()) {
                        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CLICK_START_SHOW_LOADING_DIALOG);
                        return;
                    }
                    return;
                }
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                TeamError err = teamResponse.getErr();
                int code = err.getCode();
                if (code == 1) {
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_num_is_full);
                    TeamModel.this.onFinish();
                    return;
                }
                if (code == 2) {
                    SharedUtils.putBoolean(TeamModel.this.context, ChatSharedConstant.ENTER_GAME_CHAT_CLOSE + TeamModel.this.gameMassage.getMessageId(), true);
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.team_not_exist);
                    TeamModel.this.onFinish();
                    return;
                }
                if (code == 20) {
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.party_need_two_teams_lest);
                    return;
                } else if (code == 21) {
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.party_get_address_fail);
                    return;
                } else {
                    if (TextUtils.isEmpty(err.getMessage())) {
                        return;
                    }
                    AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, err.getMessage());
                    return;
                }
            }
            TeamDone done = teamResponse.getDone();
            int done2 = done.getDone();
            if (done2 == 0) {
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.party_team_close);
                return;
            }
            if (done2 != 1) {
                if (done2 != 2) {
                    return;
                }
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                SharedUtils.putBoolean(TeamModel.this.context, ChatSharedConstant.ENTER_GAME_CHAT_MESSAGE_ID + TeamModel.this.gameMassage.getMessageId(), true);
                AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, TeamModel.this.context.getString(R.string.party_be_kick_out));
                Messenger.getDefault().sendNoMsg(MessageToken.EXIT_PARTY_CLOSE_DIALOG);
                Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.imchat.ui.fragment.team.a
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f18780a.a((Long) obj);
                    }
                }, new Action1() { // from class: com.sandboxol.imchat.ui.fragment.team.c
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        ((Throwable) obj).printStackTrace();
                    }
                });
                return;
            }
            EnterRealmsResult enterRealmsResult = new EnterRealmsResult();
            enterRealmsResult.setGameAddr(done.getGameaddr());
            enterRealmsResult.setChatRoomId("miniGame" + done.getGameaddr().replace(":", "").replace(Consts.DOT, ""));
            enterRealmsResult.setMapName(done.getMname());
            enterRealmsResult.setMapUrl(done.getDownurl());
            enterRealmsResult.setMapId(done.getMid());
            enterRealmsResult.setRegion(done.getRegion());
            enterRealmsResult.setRequestId(done.getRequestId());
            enterRealmsResult.setTeam(true);
            Game game = new Game();
            game.setGameName(TeamModel.this.gameMassage.getGameName());
            game.setGameId(TeamModel.this.gameMassage.getGameType().equals(StringConstant.BED_WAR_HALL_GAME_ID) ? "g1008" : TeamModel.this.gameMassage.getGameType());
            game.setIsNewEngine(done.getIsNewEngine() ? 1 : 0);
            enterRealmsResult.setGame(game);
            Messenger.getDefault().send(enterRealmsResult, GameMessageToken.TOKEN_ENTER_GAME);
            SharedUtils.putBoolean(TeamModel.this.context, ChatSharedConstant.ENTER_GAME_START + TeamModel.this.gameMassage.getMessageId(), true);
            TeamModel.this.eventReport();
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.imchat.ui.fragment.team.TeamModel$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase;
        static final /* synthetic */ int[] $SwitchMap$io$grpc$Status$Code = new int[Status.Code.values().length];

        static {
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.CANCELLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.FAILED_PRECONDITION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.PERMISSION_DENIED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.INTERNAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase = new int[TeamResponse.StateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[TeamResponse.StateCase.STATE_NOT_SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[TeamResponse.StateCase.GOING.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[TeamResponse.StateCase.DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[TeamResponse.StateCase.ERR.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[TeamResponse.StateCase.STARTGAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public TeamModel(Context context, GameMassage gameMassage, List<TeamMember> list) {
        this.context = context;
        this.gameMassage = gameMassage;
        this.teamMembers = list;
        initManagerClient();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createOrJoinTeam(TeamRequest teamRequest) {
        TeamManagerClient teamManagerClient = this.managerClient;
        if (teamManagerClient == null) {
            return;
        }
        try {
            teamManagerClient.team(teamRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
            Context context = this.context;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.team_create_failure));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eventReport() {
        PartyEventLogic.enterGameSuccess(this.context, this.gameMassage);
        PartyEventLogic.reportEnterGameLogic(this.context, this.gameMassage, this.enterTimes);
        this.enterTimes++;
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_REMOVE_MEMBER, Long.class, new Action1<Long>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.1
            @Override // rx.functions.Action1
            public void call(Long l) {
                TeamModel.this.removeTeamMember(l.longValue());
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_START_GAME_EXIT_CHAT, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.2
            @Override // rx.functions.Action0
            public void call() {
                TeamModel.this.isEnterGame = true;
                TeamManagerClient teamManagerClient = TeamModel.this.managerClient;
                if (teamManagerClient != null) {
                    try {
                        try {
                            teamManagerClient.shutdownTeam();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } finally {
                        TeamModel.this.managerClient = null;
                    }
                }
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_MODIFY_MEMBER_POSITION, PartyModifyPositionInfo.class, new Action1<PartyModifyPositionInfo>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.3
            @Override // rx.functions.Action1
            public void call(PartyModifyPositionInfo partyModifyPositionInfo) {
                TeamModel.this.modifyPositionMemberList.clear();
                Observable.from(partyModifyPositionInfo.getModifyPositionMemberList()).subscribe(new Action1<TeamMember>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.3.1
                    @Override // rx.functions.Action1
                    public void call(TeamMember teamMember) {
                        TeamModel.this.modifyPositionMemberList.add(com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember.newBuilder().setPosition(teamMember.getPosition()).setPicurl(teamMember.getPicUrl()).setUserid(teamMember.getUserId()).setUsername(teamMember.getNickName()).build());
                    }
                });
                TeamModel teamModel = TeamModel.this;
                teamModel.syncMembers(teamModel.modifyPositionMemberList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinish() {
        AppInfoCenter.newInstance().setNowParty(false);
        Messenger.getDefault().sendNoMsg(ChatMessageToken.EXIT_PARTY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reEnterPartyReport() {
        if (this.isRetryGame) {
            PartyEventLogic.reportRetryPartyLogic(this.context, this.gameMassage, this.reEnterTimes);
            this.reEnterTimes++;
            this.isRetryGame = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTeamMember(long j) {
        createOrJoinTeam(GRPCUtils.removeMember(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePartyMemberInfo(final TeamMember teamMember) {
        if (teamMember != null) {
            ra.newInstance().a(teamMember.getUserId(), new com.sandboxol.greendao.a.c<TribeMember>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.6
                @Override // com.sandboxol.greendao.a.c
                public void onError(int i, String str) {
                }

                @Override // com.sandboxol.greendao.a.c
                public void onSuccess(TribeMember tribeMember) {
                    if (tribeMember == null) {
                        ma.newInstance().a(teamMember.getUserId(), new com.sandboxol.greendao.a.c<PartyMemberInfo>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.6.1
                            @Override // com.sandboxol.greendao.a.c
                            public void onError(int i, String str) {
                            }

                            @Override // com.sandboxol.greendao.a.c
                            public void onSuccess(PartyMemberInfo partyMemberInfo) {
                                if (partyMemberInfo == null) {
                                    ma.newInstance().a(new PartyMemberInfo(0L, teamMember.getUserId(), 0L, teamMember.getNickName(), teamMember.getPicUrl()));
                                    RongIM.getInstance().refreshUserInfoCache(new UserInfo(String.valueOf(teamMember.getUserId()), teamMember.getNickName(), Uri.parse(teamMember.getPicUrl())));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCountDownTimer() {
        this.countDownTimer = new CountDownTimer(ab.R, 1000L) { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                AppToastUtils.showShortNegativeTipToast(TeamModel.this.context, R.string.imchat_party_exit);
                TeamModel.this.onFinish();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.countDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCountDownTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.countDownTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncMembers(List<com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember> list) {
        createOrJoinTeam(GRPCUtils.syncMembers(list));
    }

    public void initManagerClient() {
        ChatGameApi.getPartyAuth(this.context, this.gameMassage.getUserId(), this.gameMassage.getPsid(), this.gameMassage.getIsNewEngine() == 1, new OnResponseListener<PartyAuthInfo>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamModel.4
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                ServerOnError.showOnServerError(TeamModel.this.context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(PartyAuthInfo partyAuthInfo) {
                String[] strArrSplit = partyAuthInfo.getPartyService().split(":");
                if (strArrSplit.length >= 2) {
                    TeamModel.this.managerClient = TeamManagerClient.newInstance(strArrSplit[0], Integer.valueOf(strArrSplit[1]).intValue(), TeamModel.this.gameMassage.getUserId(), TeamModel.this.gameMassage.getToken());
                    TeamModel.this.gameMassage.setCountry(partyAuthInfo.getCountry() + "");
                    TeamModel teamModel = TeamModel.this;
                    teamModel.managerClient.setCreateTeamListener(teamModel.iTeamManagerListener);
                    try {
                        if (TeamModel.this.isEnterGame) {
                            TeamModel.this.isEnterGame = false;
                            TeamModel.this.createOrJoinTeam(GRPCUtils.joinTeam(TeamModel.this.gameMassage));
                        } else if (TeamModel.this.gameMassage.isCreate()) {
                            TeamModel.this.createOrJoinTeam(GRPCUtils.createTeam(TeamModel.this.gameMassage));
                        } else {
                            TeamModel.this.createOrJoinTeam(GRPCUtils.joinTeam(TeamModel.this.gameMassage));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public boolean isEnterGame() {
        return this.isEnterGame;
    }

    public void myTeamStartGame() {
        createOrJoinTeam(GRPCUtils.teamInQueue(""));
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CLICK_START_SHOW_LOADING_DIALOG);
    }

    public void onDestroy() {
        stopCountDownTimer();
        Messenger.getDefault().unregister(this);
    }

    public void reconnectManagerClient() {
        this.gameMassage.setCreate(false);
        initManagerClient();
    }

    public void setRetryGame(boolean z) {
        this.isRetryGame = z;
    }
}
