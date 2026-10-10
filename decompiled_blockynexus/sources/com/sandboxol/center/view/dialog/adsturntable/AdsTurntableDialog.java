package com.sandboxol.center.view.dialog.adsturntable;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.databinding.BaseDialogAdsTurntableBinding;
import com.sandboxol.center.entity.AdsTurntableInfo;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.center.web.error.GameOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class AdsTurntableDialog extends FullScreenDialog {
    private int POSITION_REQUEST;
    private BaseDialogAdsTurntableBinding binding;
    public ObservableField<Boolean> canWatch;
    private String gameId;
    private List<AdsTurntableInfo> list;
    private OnViewClickListener listener;
    private AdsLinearLayoutManager mLayoutManager;
    public ReplyCommand onCancelCommand;
    public ReplyCommand onWatchAdsCommand;
    private int rewardPosition;

    /* JADX INFO: renamed from: com.sandboxol.center.view.dialog.adsturntable.AdsTurntableDialog$1, reason: invalid class name */
    class AnonymousClass1 extends RecyclerView.m {
        AnonymousClass1() {
        }

        public /* synthetic */ void a() {
            AdsTurntableDialog.this.initPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (AdsTurntableDialog.this.canWatch.get().booleanValue() || i != 0) {
                return;
            }
            AdsTurntableDialog.this.canWatch.set(true);
            if (AdsTurntableDialog.this.rewardPosition > 0) {
                if (AdsTurntableDialog.this.listener != null) {
                    AdsTurntableDialog.this.listener.onClick();
                }
                new CampaignGetIntegralRewardDialog(((FullScreenDialog) AdsTurntableDialog.this).context).setStringData(((AdsTurntableInfo) AdsTurntableDialog.this.list.get(AdsTurntableDialog.this.rewardPosition - 1)).getPicUrl(), null).setOnViewClick(new OnViewClickListener() { // from class: com.sandboxol.center.view.dialog.adsturntable.a
                    @Override // com.sandboxol.common.listener.OnViewClickListener
                    public final void onClick() {
                        this.f16367a.a();
                    }
                }).show();
            }
        }
    }

    public AdsTurntableDialog(Context context, List<AdsTurntableInfo> list, String str) {
        super(context);
        this.canWatch = new ObservableField<>(true);
        this.onCancelCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.adsturntable.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f16370a.onCancel();
            }
        });
        this.onWatchAdsCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.adsturntable.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f16369a.onWatchAds();
            }
        });
        this.POSITION_REQUEST = 2147483646;
        this.rewardPosition = -1;
        this.gameId = str;
        this.list = list;
        initView();
        initData();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRewardPosition(Long l) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == l.longValue()) {
                return i + 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPosition() {
        this.binding.rvReward.scrollToPosition(0);
    }

    private void onStartLottery() {
        this.canWatch.set(false);
        this.rewardPosition = -1;
        this.mLayoutManager.setSpeedFast();
        this.binding.rvReward.smoothScrollToPosition(this.POSITION_REQUEST);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_GAME_ITEM_START_AD, this.gameId);
        GameApi.getAdsTurntableReward(this.context, this.gameId, new OnResponseListener<Long>() { // from class: com.sandboxol.center.view.dialog.adsturntable.AdsTurntableDialog.2
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
                AdsTurntableDialog.this.binding.rvReward.smoothScrollToPosition(AdsTurntableDialog.this.mLayoutManager.findFirstCompletelyVisibleItemPosition() + 1);
                GameOnError.showErrorTip(((FullScreenDialog) AdsTurntableDialog.this).context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                AdsTurntableDialog.this.binding.rvReward.smoothScrollToPosition(AdsTurntableDialog.this.mLayoutManager.findFirstCompletelyVisibleItemPosition() + 1);
                ServerOnError.showOnServerError(((FullScreenDialog) AdsTurntableDialog.this).context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(Long l) {
                AdsTurntableDialog adsTurntableDialog = AdsTurntableDialog.this;
                adsTurntableDialog.rewardPosition = adsTurntableDialog.getRewardPosition(l);
                int iFindFirstCompletelyVisibleItemPosition = AdsTurntableDialog.this.mLayoutManager.findFirstCompletelyVisibleItemPosition() + 1;
                AdsTurntableDialog.this.binding.rvReward.smoothScrollToPosition((((((AdsTurntableDialog.this.list.size() * 1) + iFindFirstCompletelyVisibleItemPosition) + (AdsTurntableDialog.this.list.size() - (iFindFirstCompletelyVisibleItemPosition % AdsTurntableDialog.this.list.size()))) + AdsTurntableDialog.this.rewardPosition) - 1) + 1);
                ReportDataAdapter.onEvent(((FullScreenDialog) AdsTurntableDialog.this).context, AdsEventConstant.REWARD_AD_GIVE, String.valueOf(AdsManager.getAdsInfo().getGameIntType()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWatchAds() {
        if (AdsManager.isVideoLoaded()) {
            AdsManager.showRewardVideo(3, this.gameId);
        } else {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.ads_is_loading);
        }
    }

    public /* synthetic */ void a() {
        if (TextUtils.isEmpty(this.gameId)) {
            return;
        }
        onStartLottery();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Messenger.getDefault().unregister(this);
    }

    public void initData() {
        this.mLayoutManager = new AdsLinearLayoutManager(this.context, 0, false);
        this.binding.rvReward.setLayoutManager(this.mLayoutManager);
        this.binding.rvReward.setAdapter(new AdsTurntableAdapter(this.context, this.list));
        this.binding.rvReward.addOnScrollListener(new AnonymousClass1());
    }

    public void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.ADS_TURNTABLE_GET_REWARD, new Action0() { // from class: com.sandboxol.center.view.dialog.adsturntable.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f16368a.a();
            }
        });
    }

    protected void initView() {
        this.binding = (BaseDialogAdsTurntableBinding) e.a(LayoutInflater.from(this.context), R.layout.base_dialog_ads_turntable, (ViewGroup) null, false);
        this.binding.setAdsTurntableDialog(this);
        setContentView(this.binding.getRoot());
    }

    public void onCancel() {
        if (isShowing()) {
            cancel();
        }
    }

    public AdsTurntableDialog setRewardListener(OnViewClickListener onViewClickListener) {
        this.listener = onViewClickListener;
        return this;
    }
}
