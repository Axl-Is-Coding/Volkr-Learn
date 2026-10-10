package com.disabngo.blockynexus.view.activity.friendmatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.request.target.SimpleTarget;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.E;
import com.disabngo.blockynexus.databinding.AbstractC0607i;
import com.disabngo.blockynexus.entity.UserMapInfo;
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.disabngo.blockynexus.view.dialog.Aa;
import com.disabngo.blockynexus.view.dialog.Da;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class FriendMatchViewModel extends ViewModel {
    private Activity activity;
    private AbstractC0607i binding;
    private Aa friendMatchGuideDialog;
    private FriendMatchModel model;
    private UserMapInfo myMapUserInfo;
    private com.bumptech.glide.request.f circleRequestOptions = new com.bumptech.glide.request.f().placeholder(R.mipmap.ic_head_default_circle).error(R.mipmap.ic_head_default_circle).circleCrop().diskCacheStrategy(p.f4581a);
    public ObservableField<Boolean> isEnableSearch = new ObservableField<>(true);
    public ObservableField<Boolean> isStartAnimation = new ObservableField<>(false);
    public ObservableField<Boolean> isShowLight = new ObservableField<>(false);
    public ReplyCommand onBackCommand = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f10617a.onBack();
        }
    });
    public ReplyCommand onSearchCommand = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f10608a.onSearch();
        }
    });

    public FriendMatchViewModel(Activity activity, AbstractC0607i abstractC0607i) {
        this.activity = activity;
        this.binding = abstractC0607i;
        initView();
        initData();
    }

    private void getUserMapInfoList(final boolean z) {
        FriendMatchModel friendMatchModel = this.model;
        if (friendMatchModel != null) {
            friendMatchModel.getUserMapInfoList(this.activity, this.myMapUserInfo, new OnDataListener() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.j
                @Override // com.sandboxol.common.interfaces.OnDataListener
                public final void onSuccess(Object obj) {
                    this.f10622a.a(z, (List) obj);
                }
            });
        }
    }

    private void initData() {
        this.model = new FriendMatchModel();
        Intent intent = this.activity.getIntent();
        if (intent != null) {
            this.myMapUserInfo = (UserMapInfo) intent.getSerializableExtra(StringConstant.FRIEND_MATCH_MY_LOCATION_INFO);
        }
        showGuideDialog();
        ReportDataAdapter.onEvent(this.activity, EventConstant.FRIEND_MATCH_CREATE);
    }

    private void initView() {
        this.binding.j.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        if (this.activity.isFinishing()) {
            return;
        }
        this.activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearch() {
        if (this.isEnableSearch.get().booleanValue()) {
            refreshNearbyFriends(false);
        }
        ReportDataAdapter.onEvent(this.activity, EventConstant.FIND_CLICK_RADAR);
    }

    private void refreshNearbyFriends(boolean z) {
        try {
            this.binding.g.moveCenter();
            this.binding.g.isCanMove(false);
            this.isEnableSearch.set(false);
            this.isStartAnimation.set(true);
            this.isShowLight.set(false);
            this.binding.j.setSelected(false);
            getUserMapInfoList(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void showGuideDialog() {
        if (SharedUtils.getBoolean((Context) this.activity, SharedConstant.FRIEND_MATCH_IS_FIRST, true)) {
            this.friendMatchGuideDialog = new Aa(this.activity);
            Aa aa = this.friendMatchGuideDialog;
            aa.a(new OnViewClickListener() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.c
                @Override // com.disabngo.blockynexus.interfaces.OnViewClickListener
                public final void onClick() {
                    this.f10607a.f();
                }
            }, new OnDataListener() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.e
                @Override // com.sandboxol.common.interfaces.OnDataListener
                public final void onSuccess(Object obj) {
                    this.f10609a.a((UserMapInfo) obj);
                }
            });
            aa.show();
            SharedUtils.putBoolean(this.activity, SharedConstant.FRIEND_MATCH_IS_FIRST, false);
        }
    }

    private void showMapFriendInfoDialog(UserMapInfo userMapInfo, final boolean z) {
        if (this.model == null || userMapInfo.getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(this.activity);
        loadingDialog.show();
        final double dA = E.a(this.myMapUserInfo.getLatitude(), this.myMapUserInfo.getLongitude(), userMapInfo.getLatitude(), userMapInfo.getLongitude());
        this.model.getFriendInfo(this.activity, userMapInfo.getUserId(), new OnDataListener() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.i
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f10618a.a(loadingDialog, dA, z, (Friend) obj);
            }
        });
    }

    private void stopAnimation() {
        this.isStartAnimation.set(false);
        this.isShowLight.set(true);
        this.isEnableSearch.set(true);
        this.binding.g.isCanMove(true);
        this.binding.j.setSelected(true);
    }

    public /* synthetic */ void a(final boolean z, final List list) {
        if (list == null) {
            Aa aa = this.friendMatchGuideDialog;
            if (aa != null && aa.isShowing()) {
                this.friendMatchGuideDialog.dismiss();
            }
            stopAnimation();
            return;
        }
        this.model.setViewXY(list, this.binding);
        this.binding.g.removeAllFriendView();
        final int size = list.size();
        for (final int i = 0; i < size; i++) {
            Observable.timer(r0 * 200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.g
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f10612a.a(list, i, size, z, (Long) obj);
                }
            });
        }
    }

    public /* synthetic */ void f() {
        refreshNearbyFriends(true);
        ReportDataAdapter.onEvent(this.activity, EventConstant.FIND_CLICK_RADAR);
    }

    public /* synthetic */ void a(List list, int i, int i2, boolean z, Long l) {
        Activity activity = this.activity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        final UserMapInfo userMapInfo = (UserMapInfo) list.get(i);
        final View viewInflate = this.activity.getLayoutInflater().inflate(R.layout.item_friend_match_friend, (ViewGroup) null);
        try {
            com.bumptech.glide.c.a(this.activity).mo54load(TextUtils.isEmpty(userMapInfo.getPic()) ? Integer.valueOf(R.mipmap.ic_head_default_circle) : userMapInfo.getPic()).thumbnail(0.1f).apply((com.bumptech.glide.request.a<?>) this.circleRequestOptions).into(new SimpleTarget<Drawable>() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.FriendMatchViewModel.1
                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, com.bumptech.glide.request.a.b bVar) {
                    onResourceReady((Drawable) obj, (com.bumptech.glide.request.a.b<? super Drawable>) bVar);
                }

                public void onResourceReady(Drawable drawable, com.bumptech.glide.request.a.b<? super Drawable> bVar) {
                    ((ImageView) viewInflate.findViewById(R.id.ivFriend)).setImageDrawable(drawable);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) (userMapInfo.getX() - (SizeUtil.dp2px(this.activity, 47.0f) / 2.0f));
        layoutParams.topMargin = (int) (userMapInfo.getY() - (SizeUtil.dp2px(this.activity, 57.0f) / 2.0f));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10610a.a(userMapInfo, view);
            }
        });
        viewInflate.setAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.friend_match_marker_alpha));
        this.binding.g.addView(viewInflate, layoutParams);
        if (i == i2 - 1) {
            stopAnimation();
            if (z) {
                Messenger.getDefault().send(userMapInfo, MessageToken.TOKEN_MAP_FRIEND_USER_INFO);
            }
        }
    }

    public /* synthetic */ void a(UserMapInfo userMapInfo, View view) {
        this.binding.g.setLastMove();
        showMapFriendInfoDialog(userMapInfo, false);
    }

    public /* synthetic */ void a(LoadingDialog loadingDialog, double d2, boolean z, Friend friend) {
        loadingDialog.dismiss();
        if (friend != null) {
            new Da(this.activity, friend, d2, z).show();
        }
    }

    public /* synthetic */ void a(UserMapInfo userMapInfo) {
        this.binding.g.moveCenter();
        showMapFriendInfoDialog(userMapInfo, true);
        ReportDataAdapter.onEvent(this.activity, EventConstant.FIND_CLICK_ICON);
    }
}
