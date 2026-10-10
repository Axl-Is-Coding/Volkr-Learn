package com.sandboxol.imchat.ui.fragment.team;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.Vibrator;
import android.view.View;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.util.TeamManagerClient;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.greendao.entity.TeamMember;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.center.PartyCenter;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.databinding.FragmentTeamBinding;
import com.sandboxol.imchat.ui.dialog.PartyGuideDialog;
import com.sandboxol.imchat.ui.fragment.team.adapter.TeamAdapter;
import com.sandboxol.imchat.ui.fragment.team.helper.OnStartDragListener;
import com.sandboxol.imchat.ui.fragment.team.helper.SimpleItemTouchHelperCallback;
import com.sandboxol.imchat.utils.PartyEventLogic;
import com.tendcloud.tenddata.ab;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class TeamViewModel extends ViewModel {
    public static final int MAX_GRID = 6;
    private TeamAdapter adapter;
    private FragmentTeamBinding binding;
    private Context context;
    private GameMassage gameMassage;
    private boolean isFirstCreate;
    private ItemTouchHelper itemTouchHelper;
    private AnimationDrawable loadingAnim;
    private TeamModel teamModel;
    private Timer timer;
    private long ticks = 0;
    private List<TeamMember> teamMembers = new ArrayList();
    public ObservableField<String> teamNumText = new ObservableField<>("");
    public ObservableField<Boolean> isShowLoading = new ObservableField<>(true);
    public ObservableField<Boolean> isCaptain = new ObservableField<>(false);
    private ObservableField<Integer> teamNum = new ObservableField<>(1);
    private ObservableField<Integer> inGameCount = new ObservableField<>();
    public ReplyCommand<Boolean> onCheckCommand = new ReplyCommand<>(new Action1<Boolean>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.1
        @Override // rx.functions.Action1
        public void call(Boolean bool) {
            TeamViewModel.this.scrollMemberList(bool);
        }
    });
    public ReplyCommand<Boolean> onCheckCommand2 = new ReplyCommand<>(new Action1<Boolean>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.2
        @Override // rx.functions.Action1
        public void call(Boolean bool) {
            if (TeamViewModel.this.binding.cbPartyMember.isChecked() != bool.booleanValue()) {
                TeamViewModel.this.binding.cbPartyMember.setChecked(bool.booleanValue());
            }
        }
    });
    public ReplyCommand startGame = new ReplyCommand(new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.3
        @Override // rx.functions.Action0
        public void call() {
            if (((Integer) TeamViewModel.this.teamNum.get()).intValue() <= 1) {
                AppToastUtils.showShortNegativeTipToast(TeamViewModel.this.context, R.string.party_num_too_less);
            } else if (((Integer) TeamViewModel.this.inGameCount.get()).intValue() > 0) {
                AppToastUtils.showShortNegativeTipToast(TeamViewModel.this.context, TeamViewModel.this.context.getString(R.string.imchat_party_in_game_team_count, TeamViewModel.this.inGameCount.get()));
            } else {
                TeamViewModel.this.teamModel.myTeamStartGame();
                PartyEventLogic.clickStartParty(TeamViewModel.this.context, TeamViewModel.this.gameMassage);
            }
        }
    });

    public TeamViewModel(Context context, FragmentTeamBinding fragmentTeamBinding, GameMassage gameMassage) {
        this.binding = fragmentTeamBinding;
        this.context = context;
        this.gameMassage = gameMassage;
        initData();
        initMessenger();
        startAnim();
        if (gameMassage.isCaptain()) {
            createTeamTimer();
        }
    }

    private void createTeamTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.11
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((Activity) TeamViewModel.this.context).runOnUiThread(new Runnable() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TeamViewModel.this.ticks += 100;
                    }
                });
            }
        }, 0L, 100L);
    }

    private void initData() {
        GameMassage gameMassage = this.gameMassage;
        if (gameMassage != null) {
            this.teamModel = new TeamModel(this.context, gameMassage, this.teamMembers);
            this.isCaptain.set(Boolean.valueOf(this.gameMassage.isCaptain()));
            initView();
        } else {
            ToastUtils.showLongToast(this.context, R.string.team_create_failure);
            Context context = this.context;
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return;
            }
            ((Activity) this.context).finish();
        }
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_MEMBER_NUM_UPDATE, Integer.class, new Action1<Integer>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.6
            @Override // rx.functions.Action1
            public void call(Integer num) {
                if (!TeamViewModel.this.isFirstCreate) {
                    PartyEventLogic.enterPartySuccess(TeamViewModel.this.context, TeamViewModel.this.gameMassage);
                }
                if (!TeamViewModel.this.isFirstCreate && TeamViewModel.this.gameMassage.isCaptain() && num.intValue() != 0) {
                    TeamViewModel.this.stopTimer();
                    TeamViewModel.this.isFirstCreate = true;
                    Messenger messenger = Messenger.getDefault();
                    StringBuilder sb = new StringBuilder();
                    sb.append(TeamViewModel.this.gameMassage.getRegionId());
                    sb.append(":");
                    TeamViewModel teamViewModel = TeamViewModel.this;
                    sb.append(teamViewModel.returnTimeSection(teamViewModel.ticks));
                    messenger.send(sb.toString(), ChatMessageToken.TOKEN_CHAT_CREATE_GROUP_TIME);
                }
                if (num.intValue() >= 1) {
                    TeamViewModel.this.isShowLoading.set(false);
                    TeamViewModel.this.stopAnim();
                }
                TeamViewModel.this.setTeamNumText(num);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_UPDATE_GAME_MASSAGE, GameMassage.class, new Action1<GameMassage>() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.7
            @Override // rx.functions.Action1
            public void call(GameMassage gameMassage) {
                TeamViewModel.this.isCaptain.set(Boolean.valueOf(gameMassage.isCaptain()));
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_REFRESH_MEMBER, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.8
            @Override // rx.functions.Action0
            public void call() {
                TeamViewModel.this.adapter.onRefresh();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_PARTY_SHRINK_EDIT_TEXT, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.9
            @Override // rx.functions.Action0
            public void call() {
                TeamViewModel.this.binding.cbPartyMember.setChecked(true);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_PARTY_ROOM_CLOSE, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.10
            @Override // rx.functions.Action0
            public void call() {
                if (!(TeamViewModel.this.context instanceof Activity) || ((Activity) TeamViewModel.this.context).isFinishing()) {
                    return;
                }
                ((Activity) TeamViewModel.this.context).finish();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_APP_CHECK_UPDATE, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.team.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18781a.f();
            }
        });
    }

    private void initRecyclerViewGroupName(final int i) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(SizeUtil.sp2px(this.context, 11.0f));
        paint.setColor(-13421773);
        paint.setStrokeWidth(3.0f);
        final Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(this.context.getResources().getColor(com.sandboxol.common.R.color.mainBgColor));
        paint2.setStrokeWidth(1.0f);
        final int teamCount = this.gameMassage.getTeamType() == 1 ? 1 : this.gameMassage.getTeamCount();
        this.binding.rvTeam.addItemDecoration(new RecyclerView.h() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.4
            @Override // androidx.recyclerview.widget.RecyclerView.h
            public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
                super.onDrawOver(canvas, recyclerView, tVar);
                int childCount = recyclerView.getChildCount();
                int i2 = teamCount;
                if (i2 == 0 || childCount / i2 == 0 || TeamViewModel.this.gameMassage.getMaxMember() / teamCount == 0) {
                    return;
                }
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i3 % (childCount / teamCount) == 0) {
                        View viewFindViewById = recyclerView.getChildAt(i3).findViewById(R.id.ivHead);
                        Rect rect = new Rect();
                        String string = TeamViewModel.this.context.getString(R.string.party_team, Integer.valueOf((i3 / (TeamViewModel.this.gameMassage.getMaxMember() / teamCount)) + 1));
                        paint.getTextBounds(string, 0, string.length(), rect);
                        canvas.drawText(string, viewFindViewById.getX(), r3.getTop() + rect.height() + SizeUtil.dp2px(TeamViewModel.this.context, 7.0f), paint);
                    }
                }
                if (childCount / teamCount != 0) {
                    for (int i4 = 0; i4 < childCount; i4++) {
                        int i5 = i + i4;
                        int i6 = teamCount;
                        if (i5 >= ((i4 / (childCount / i6)) + 1) * (childCount / i6)) {
                            View childAt = recyclerView.getChildAt(i4);
                            canvas.drawRect(childAt.getLeft(), childAt.getBottom() - SizeUtil.dp2px(TeamViewModel.this.context, 1.0f), childAt.getRight(), childAt.getBottom(), paint2);
                        }
                    }
                }
            }
        });
    }

    private void initRecyclerViewTouch(int i) {
        this.adapter = new TeamAdapter(this.context, new OnStartDragListener() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.5
            @Override // com.sandboxol.imchat.ui.fragment.team.helper.OnStartDragListener
            public void onStartDrag(RecyclerView.w wVar) {
                Vibrator vibrator = (Vibrator) TeamViewModel.this.context.getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(100L);
                }
                TeamViewModel.this.itemTouchHelper.b(wVar);
            }
        }, this.teamMembers, this.gameMassage);
        this.binding.rvTeam.setHasFixedSize(true);
        this.binding.rvTeam.setAdapter(this.adapter);
        this.binding.rvTeam.setLayoutManager(new GridLayoutManager(this.context, i));
        this.itemTouchHelper = new ItemTouchHelper(new SimpleItemTouchHelperCallback(this.adapter));
        this.itemTouchHelper.a(this.binding.rvTeam);
    }

    private void initView() {
        int memberCount = this.gameMassage.getTeamType() == 1 ? this.gameMassage.getMemberCount() : this.gameMassage.getMaxMember() / this.gameMassage.getTeamCount();
        if (memberCount > 6) {
            memberCount = 6;
        }
        initRecyclerViewGroupName(memberCount);
        initRecyclerViewTouch(memberCount);
        showPartyGuiDialog(memberCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int returnTimeSection(long j) {
        if (j <= 100) {
            return 100;
        }
        if (j <= 200) {
            return 200;
        }
        if (j <= 500) {
            return 500;
        }
        if (j <= 1000) {
            return 1000;
        }
        if (j <= 2000) {
            return 2000;
        }
        if (j <= 5000) {
            return 5000;
        }
        if (j <= 10000) {
            return 10000;
        }
        return j <= 20000 ? BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT : j <= ab.R ? 30000 : 30001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollMemberList(final Boolean bool) {
        if (!bool.booleanValue()) {
            this.binding.cbPartyMember2.setVisibility(8);
            this.binding.llGroup.setVisibility(0);
        }
        this.binding.llGroup.animate().translationY(bool.booleanValue() ? -this.binding.rvTeam.getHeight() : WheelView.DividerConfig.FILL).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.sandboxol.imchat.ui.fragment.team.TeamViewModel.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (bool.booleanValue()) {
                    TeamViewModel.this.binding.cbPartyMember2.setVisibility(0);
                    TeamViewModel.this.binding.llGroup.setVisibility(8);
                }
            }
        });
        if (this.binding.cbPartyMember2.isChecked() != bool.booleanValue()) {
            this.binding.cbPartyMember2.setChecked(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamNumText(Integer num) {
        this.inGameCount.set(0);
        Iterator<TeamMember> it = this.teamMembers.iterator();
        while (it.hasNext()) {
            if (it.next().getStatus() == 1) {
                ObservableField<Integer> observableField = this.inGameCount;
                observableField.set(Integer.valueOf(observableField.get().intValue() + 1));
            }
        }
        if (this.inGameCount.get().intValue() > 0) {
            this.teamNumText.set(this.context.getString(R.string.imchat_party_in_game_team_count, this.inGameCount.get()));
        } else {
            this.teamNum.set(num);
            this.teamNumText.set(this.context.getString(R.string.party_fragment_num, num, Integer.valueOf(this.gameMassage.getMaxMember())));
        }
    }

    private void showPartyGuiDialog(int i) {
        if (this.gameMassage.isCreate() && this.gameMassage.getTeamType() == 2 && SharedUtils.getBoolean(this.context, SharedConstant.PARTY_GUIDE_IS_FIRST_SHOW, true)) {
            new PartyGuideDialog(this.context, i).show();
            SharedUtils.putBoolean(this.context, SharedConstant.PARTY_GUIDE_IS_FIRST_SHOW, false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public /* synthetic */ void f() {
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
        stopTimer();
        PartyCenter.newInstance().teamId.set("");
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        TeamModel teamModel;
        TeamManagerClient teamManagerClient;
        super.onPause();
        if (!((Activity) this.context).isFinishing() || (teamModel = this.teamModel) == null || (teamManagerClient = teamModel.managerClient) == null) {
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

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        if (this.teamModel.isEnterGame()) {
            this.teamModel.initManagerClient();
            this.teamModel.setRetryGame(true);
        }
    }
}
