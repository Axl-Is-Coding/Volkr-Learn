package com.disabngo.blockynexus.view.fragment.main;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.De;
import com.disabngo.blockynexus.e.b.l.C0868d;
import com.disabngo.blockynexus.e.b.y.C0960k;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper;
import java.util.Timer;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class MainFragmentViewModel extends ViewModel {
    public static ObservableField<Boolean> isRefreshing = new ObservableField<>(true);
    public static ObservableList<String> updateContentList = new ObservableArrayList();
    private De binding;
    private Activity context;
    private com.disabngo.blockynexus.e.b.X.d model;
    public C0868d moreGameModel;
    private Timer timer;
    public G moreGameListLayout = new G();
    private boolean isShowMainFollowFriend = false;
    private int refreshMainFollowTimes = 30;
    public ObservableField<Boolean> isOpenHeader = new ObservableField<>(true);
    public ObservableField<String> announcementContent = new ObservableField<>("");
    public ObservableField<Boolean> isShowAnnouncementContent = new ObservableField<>(false);
    public ObservableField<Integer> scrapRedPointNum = new ObservableField<>(0);
    private ObservableField<Boolean> isClosePage = new ObservableField<>(false);
    public ObservableField<Boolean> isClickedVideo = new ObservableField<>(false);
    public ReplyCommand onDiscover = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f11810a.onEnterDiscover();
        }
    });
    public ReplyCommand onActivity = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f11815a.onEnterActivity();
        }
    });
    public ReplyCommand onVip = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f11812a.onEnterVip();
        }
    });
    public ReplyCommand onRanking = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f11811a.onEnterRanking();
        }
    });
    public ReplyCommand onScrap = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f11816a.onEnterScrap();
        }
    });
    public ReplyCommand openHeaderCommand = new ReplyCommand(new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.j
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11813a.a(obj);
        }
    });
    public ReplyCommand closeHeaderCommand = new ReplyCommand(new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.n
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11817a.b(obj);
        }
    });
    public ReplyCommand contentChangeCommand = new ReplyCommand(new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11809a.c(obj);
        }
    });
    public ItemEnterOrExitVisibleHelper.OnScrollStatusListener itemListener = new I(this);

    public MainFragmentViewModel(Activity activity, De de) {
        this.context = activity;
        this.binding = de;
        this.moreGameModel = new C0868d(activity, R.string.category_no_data, this.isClosePage);
        initMessenger();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getScrapRedPointNum() {
        if (ChannelManager.isBeta()) {
            return;
        }
        ScrapApi.getScrapRedPointNum(this.context, new J(this));
    }

    private void initData() {
        if (this.model == null) {
            this.model = new com.disabngo.blockynexus.e.b.X.d();
        }
        refreshGameUpdateContentList();
        this.model.a(this.context, this.isShowAnnouncementContent, this.announcementContent);
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            new C0960k().a();
        }
        getScrapRedPointNum();
        this.isClickedVideo.set(Boolean.valueOf(SharedUtils.getBoolean((Context) this.context, SharedConstant.IS_CLICK_MORE_FRAGMENT_VIP, false)));
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_GAME_UPDATE_CONTENT_CLICK, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MainFragmentViewModel.updateContentList.remove((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f11818a.getScrapRedPointNum();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterActivity() {
        new bc().j(this.context);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_ACTIVITY_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterDiscover() {
        com.disabngo.blockynexus.d.D.a(this.context);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_EXPLORE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterRanking() {
        com.disabngo.blockynexus.d.D.b(this.context);
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_RANK_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterScrap() {
        Activity activity = this.context;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.da.h.class, activity.getString(R.string.app_scrap_main_title));
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_COLLECT_ACTIV_ENTRANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterVip() {
        VipManager.enterVipFragment(this.context);
        if (!this.isClickedVideo.get().booleanValue()) {
            SharedUtils.putBoolean(this.context, SharedConstant.IS_CLICK_MORE_FRAGMENT_VIP, true);
            this.isClickedVideo.set(true);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_CLICKED_VIP_FRAGMENT);
        }
        VipManager.reportHomeVipClick(this.context);
    }

    private void refreshGameUpdateContentList() {
        com.disabngo.blockynexus.e.b.X.d dVar = this.model;
        if (dVar != null) {
            dVar.a(this.context, updateContentList);
        }
    }

    public /* synthetic */ void a(Object obj) {
        this.isOpenHeader.set(true);
        this.binding.f7383d.getRoot().setAlpha(((Float) obj).floatValue());
        isRefreshing.set(true);
    }

    public /* synthetic */ void b(Object obj) {
        this.isOpenHeader.set(false);
        this.binding.f7382c.getRoot().setAlpha(((Float) obj).floatValue());
        isRefreshing.set(false);
    }

    public /* synthetic */ void c(Object obj) {
        this.binding.f7381b.getRoot().findViewById(R.id.layout_title).setAlpha(((Float) obj).floatValue());
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public void setClosePage(boolean z) {
        this.isClosePage.set(Boolean.valueOf(z));
    }

    public void startTimer() {
        if (AppInfoCenter.newInstance().getAdsCdConfig() != null) {
            this.refreshMainFollowTimes = AppInfoCenter.newInstance().getAppConfig().getFriendRefreshTimes();
        }
        if (this.refreshMainFollowTimes == 0) {
            this.refreshMainFollowTimes = 30;
        }
        if (this.isShowMainFollowFriend && this.timer == null) {
            this.timer = new Timer();
            Timer timer = this.timer;
            K k = new K(this);
            int i = this.refreshMainFollowTimes;
            timer.schedule(k, i * 1000, i * 1000);
        }
    }

    public void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
