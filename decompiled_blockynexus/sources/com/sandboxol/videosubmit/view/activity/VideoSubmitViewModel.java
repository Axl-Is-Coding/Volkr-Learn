package com.sandboxol.videosubmit.view.activity;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.VideoSubmitActivityConfig;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.videosubmit.constant.VideoSubmitEventConstant;
import com.sandboxol.videosubmit.constant.VideoSubmitMessageToken;
import com.sandboxol.videosubmit.databinding.ActivityVideoSubmitBinding;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.entity.BGTubeMultiLanguageConfig;
import com.sandboxol.videosubmit.entity.BGTubeSignInfoResponse;
import com.sandboxol.videosubmit.entity.SignStatusResponse;
import com.sandboxol.videosubmit.view.dialog.LinkDialog;
import com.sandboxol.videosubmit.view.dialog.SignUpDialog;
import com.sandboxol.videosubmit.view.dialog.signupinfo.SignUpInfoDialog;
import com.sandboxol.videosubmit.web.VideoSubmitApi;
import com.sandboxol.videosubmit.web.VideoSubmitError;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class VideoSubmitViewModel extends ViewModel {
    private ActivityVideoSubmitBinding binding;
    private Context context;
    private boolean isGotoLinkDialog;
    private LinkDialog linkDialog;
    private SignUpDialog signUpDialog;
    private SignUpInfoDialog signUpInfoDialog;
    public ObservableField<String> submissionStartTime = new ObservableField<>();
    public ObservableField<String> submissionEndTime = new ObservableField<>();
    public ObservableField<String> awardDate = new ObservableField<>();
    public ObservableField<Integer> signUpStatus = new ObservableField<>(0);
    public ObservableField<String> headUri = new ObservableField<>();
    public ObservableField<String> profitRules = new ObservableField<>("");
    public ReplyCommand onBackCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.activity.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f18916a.onBack();
        }
    });
    public ReplyCommand onSignUpCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.activity.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f18915a.onSignUp();
        }
    });
    public ReplyCommand onSubmitCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.activity.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f18917a.onSubmit();
        }
    });
    public ReplyCommand onSignUpInfoCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.activity.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f18918a.onSignUpInfo();
        }
    });
    private String activityId = "";
    public ObservableField<BGTubeInfoResponse> configInfo = new ObservableField<>();
    public ObservableField<EventRulesAdapter> eventRulesAdapter = new ObservableField<>();
    public ObservableField<WinnersAdapter> winnerAdapter = new ObservableField<>();
    public ObservableField<TipsAdapter> tipsAdapter = new ObservableField<>();
    public ObservableField<GamesAdapter> gamesAdapter = new ObservableField<>();
    public ObservableField<ThemesAdapter> themesAdapter = new ObservableField<>();

    public VideoSubmitViewModel(Context context, boolean z, ActivityVideoSubmitBinding activityVideoSubmitBinding) {
        this.context = context;
        this.binding = activityVideoSubmitBinding;
        this.isGotoLinkDialog = z;
        initData();
        initMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getConfig(final int i) {
        VideoSubmitApi.getBGTubeConfigInfo(this.context, new OnResponseListener<BGTubeInfoResponse>() { // from class: com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel.3
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i2, String str) {
                VideoSubmitError.showErrorTip(VideoSubmitViewModel.this.context, i2);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i2) {
                ServerOnError.showOnServerError(VideoSubmitViewModel.this.context, i2);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(BGTubeInfoResponse bGTubeInfoResponse) {
                VideoSubmitViewModel.this.configInfo.set(bGTubeInfoResponse);
                VideoSubmitViewModel.this.initView(bGTubeInfoResponse);
                if (i == 1 && VideoSubmitViewModel.this.isGotoLinkDialog) {
                    VideoSubmitViewModel.this.onSubmit();
                }
            }
        });
    }

    private void initData() {
        VideoSubmitActivityConfig videoSubmitActivityConfig = AppInfoCenter.newInstance().getAppConfig().getVideoSubmitActivityConfig();
        if (videoSubmitActivityConfig != null && !TextUtils.isEmpty(videoSubmitActivityConfig.getVideoSubmitActivityId())) {
            this.activityId = videoSubmitActivityConfig.getVideoSubmitActivityId();
        }
        VideoSubmitApi.getSignUpStatus(this.context, this.activityId, new OnResponseListener<SignStatusResponse>() { // from class: com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel.1
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
                VideoSubmitError.showErrorTip(VideoSubmitViewModel.this.context, i);
                VideoSubmitViewModel videoSubmitViewModel = VideoSubmitViewModel.this;
                videoSubmitViewModel.getConfig(videoSubmitViewModel.signUpStatus.get().intValue());
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                ServerOnError.showOnServerError(VideoSubmitViewModel.this.context, i);
                VideoSubmitViewModel videoSubmitViewModel = VideoSubmitViewModel.this;
                videoSubmitViewModel.getConfig(videoSubmitViewModel.signUpStatus.get().intValue());
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(SignStatusResponse signStatusResponse) {
                if (signStatusResponse != null) {
                    VideoSubmitViewModel.this.signUpStatus.set(Integer.valueOf(signStatusResponse.getStatus()));
                    VideoSubmitViewModel.this.headUri.set(signStatusResponse.getPicURl());
                }
                VideoSubmitViewModel videoSubmitViewModel = VideoSubmitViewModel.this;
                videoSubmitViewModel.getConfig(videoSubmitViewModel.signUpStatus.get().intValue());
            }
        });
        VideoSubmitApi.getBGTubeMultiLanguageConfig(this.context, this.activityId, new OnResponseListener<BGTubeMultiLanguageConfig>() { // from class: com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel.2
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
                VideoSubmitError.showErrorTip(VideoSubmitViewModel.this.context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                ServerOnError.showOnServerError(VideoSubmitViewModel.this.context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(BGTubeMultiLanguageConfig bGTubeMultiLanguageConfig) {
                if (bGTubeMultiLanguageConfig != null) {
                    VideoSubmitViewModel.this.eventRulesAdapter.set(new EventRulesAdapter(VideoSubmitViewModel.this.context, bGTubeMultiLanguageConfig.getEventRules()));
                    VideoSubmitViewModel.this.tipsAdapter.set(new TipsAdapter(VideoSubmitViewModel.this.context, bGTubeMultiLanguageConfig.getTips()));
                    VideoSubmitViewModel.this.profitRules.set(bGTubeMultiLanguageConfig.getProfitRules());
                }
            }
        });
    }

    private void initMessage() {
        Messenger.getDefault().register(this, VideoSubmitMessageToken.TOKEN_REFRESH_SIGN_UP_STATUS, Integer.class, new Action1() { // from class: com.sandboxol.videosubmit.view.activity.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18914a.a((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(BGTubeInfoResponse bGTubeInfoResponse) {
        this.submissionStartTime.set(bGTubeInfoResponse.getSubmissionTime().getStartTime());
        this.submissionEndTime.set(bGTubeInfoResponse.getSubmissionTime().getEndTime());
        this.awardDate.set(bGTubeInfoResponse.getAwardDate());
        this.winnerAdapter.set(new WinnersAdapter(bGTubeInfoResponse.getPreviousWinners()));
        this.gamesAdapter.set(new GamesAdapter(this.context, bGTubeInfoResponse.getOptionalSubmissionGameUrls()));
        this.themesAdapter.set(new ThemesAdapter(bGTubeInfoResponse.getOptionalVideoThemes()));
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.context);
        flexboxLayoutManager.c(1);
        flexboxLayoutManager.b(0);
        flexboxLayoutManager.a(4);
        flexboxLayoutManager.d(0);
        this.binding.vThemes.rvGames.setLayoutManager(flexboxLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        Context context = this.context;
        if (context != null) {
            ((Activity) context).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSignUp() {
        if (this.signUpDialog == null) {
            this.signUpDialog = new SignUpDialog(this.context, this.activityId);
        }
        this.signUpDialog.show();
        ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_SIGN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSignUpInfo() {
        VideoSubmitApi.getBGTubeSignInfoResponse(this.context, this.activityId, new OnResponseListener<BGTubeSignInfoResponse>() { // from class: com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel.4
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
                VideoSubmitError.showErrorTip(VideoSubmitViewModel.this.context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                ServerOnError.showOnServerError(VideoSubmitViewModel.this.context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(BGTubeSignInfoResponse bGTubeSignInfoResponse) {
                VideoSubmitViewModel videoSubmitViewModel = VideoSubmitViewModel.this;
                videoSubmitViewModel.signUpInfoDialog = new SignUpInfoDialog(videoSubmitViewModel.context, bGTubeSignInfoResponse);
                VideoSubmitViewModel.this.signUpInfoDialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubmit() {
        ObservableField<BGTubeInfoResponse> observableField;
        if (this.linkDialog == null && (observableField = this.configInfo) != null) {
            this.linkDialog = new LinkDialog(this.context, this.activityId, observableField.get());
        }
        this.linkDialog.show();
        ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_FILL);
    }

    public /* synthetic */ void a(Integer num) {
        this.signUpStatus.set(num);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }
}
