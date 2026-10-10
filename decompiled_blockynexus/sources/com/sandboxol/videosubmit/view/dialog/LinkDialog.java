package com.sandboxol.videosubmit.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.constant.VideoSubmitEventConstant;
import com.sandboxol.videosubmit.constant.VideoSubmitStringConstant;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogLinkBinding;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.entity.LinkInfo;
import com.sandboxol.videosubmit.view.widget.SpinnerPopupWindow;
import com.sandboxol.videosubmit.web.VideoSubmitApi;
import com.sandboxol.videosubmit.web.VideoSubmitError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class LinkDialog extends FullScreenDialog {
    private String activityId;
    private VideosubmitDialogLinkBinding binding;
    private BGTubeInfoResponse configInfo;
    private String gameId;
    private String gameName;
    private String link;
    public ReplyCommand onCloseCommand;
    public ReplyCommand onGameNamesCommand;
    public ReplyCommand<String> onGetLinkCommand;
    public ReplyCommand onSubmitCommand;
    public ReplyCommand onVideoTypeCommand;
    private SpinnerPopupWindow spinnerPopupWindow;
    private SubmitSucceedDialog submitSucceedDialog;
    private String type;

    public LinkDialog(Context context, String str, BGTubeInfoResponse bGTubeInfoResponse) {
        super(context);
        this.onCloseCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f18926a.onClose();
            }
        });
        this.onSubmitCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18923a.onSubmit();
            }
        });
        this.onVideoTypeCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18924a.onVideoType();
            }
        });
        this.onGameNamesCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18922a.onGameNames();
            }
        });
        this.onGetLinkCommand = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.videosubmit.view.dialog.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18925a.a((String) obj);
            }
        });
        this.activityId = str;
        this.configInfo = bGTubeInfoResponse;
        initView();
    }

    private void initView() {
        this.binding = (VideosubmitDialogLinkBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.videosubmit_dialog_link, (ViewGroup) null, false);
        this.binding.setViewModel(this);
        setContentView(this.binding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_FILL_EXIT);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGameNames() {
        BGTubeInfoResponse bGTubeInfoResponse = this.configInfo;
        if (bGTubeInfoResponse == null || bGTubeInfoResponse.getGames() == null || this.configInfo.getGames().size() == 0) {
            return;
        }
        final List<LinkInfo> games = this.configInfo.getGames();
        ArrayList arrayList = new ArrayList();
        Iterator<LinkInfo> it = games.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getGameName());
        }
        this.spinnerPopupWindow = new SpinnerPopupWindow(this.context, arrayList);
        this.spinnerPopupWindow.setOnItemClickListener(new SpinnerPopupWindow.OnItemClickListener() { // from class: com.sandboxol.videosubmit.view.dialog.i
            @Override // com.sandboxol.videosubmit.view.widget.SpinnerPopupWindow.OnItemClickListener
            public final void onClick(int i, long j) {
                this.f18929a.a(games, i, j);
            }
        });
        this.spinnerPopupWindow.showLocation(this.binding.spGameName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubmit() {
        String str;
        String str2;
        String str3;
        String str4 = this.link;
        if (str4 == null || "".equals(str4) || (str = this.type) == null || "".equals(str) || (str2 = this.gameName) == null || "".equals(str2) || (str3 = this.gameId) == null || "".equals(str3)) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.videosubmit_dialog_register_format_null);
            return;
        }
        if (!this.link.startsWith("https://www.youtube.com/") && !this.link.startsWith("http://www.youtube.com/") && !this.link.startsWith("https://youtu.be/") && !this.link.startsWith("http://youtu.be/")) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.videosubmit_dialog_submit_link_error);
        } else {
            VideoSubmitApi.postVideoLink(this.context, new LinkInfo().setLink(this.link).setVideoType(this.type).setGameCode(this.gameId).setGameName(this.gameName), this.activityId, new OnResponseListener() { // from class: com.sandboxol.videosubmit.view.dialog.LinkDialog.1
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i, String str5) {
                    VideoSubmitError.showErrorTip(((FullScreenDialog) LinkDialog.this).context, i);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i) {
                    ServerOnError.showOnServerError(((FullScreenDialog) LinkDialog.this).context, i);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(Object obj) {
                    if (!SharedUtils.getBoolean(((FullScreenDialog) LinkDialog.this).context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_USER_ID_LINK + AccountCenter.newInstance().userId.get())) {
                        SharedUtils.putBoolean(((FullScreenDialog) LinkDialog.this).context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_USER_ID_LINK + AccountCenter.newInstance().userId.get(), true);
                    }
                    LinkDialog.this.dismiss();
                    LinkDialog linkDialog = LinkDialog.this;
                    linkDialog.submitSucceedDialog = new SubmitSucceedDialog(((FullScreenDialog) linkDialog).context);
                    LinkDialog.this.submitSucceedDialog.show();
                    ReportDataAdapter.onEvent(((FullScreenDialog) LinkDialog.this).context, VideoSubmitEventConstant.CLINCK_BGTUBE_FILL_OK);
                }
            });
            ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_FILL_SURE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoType() {
        BGTubeInfoResponse bGTubeInfoResponse = this.configInfo;
        if (bGTubeInfoResponse == null || bGTubeInfoResponse.getVideoTypes() == null || this.configInfo.getVideoTypes().size() == 0) {
            return;
        }
        final List<String> videoTypes = this.configInfo.getVideoTypes();
        this.spinnerPopupWindow = new SpinnerPopupWindow(this.context, videoTypes);
        this.spinnerPopupWindow.setOnItemClickListener(new SpinnerPopupWindow.OnItemClickListener() { // from class: com.sandboxol.videosubmit.view.dialog.h
            @Override // com.sandboxol.videosubmit.view.widget.SpinnerPopupWindow.OnItemClickListener
            public final void onClick(int i, long j) {
                this.f18927a.b(videoTypes, i, j);
            }
        });
        this.spinnerPopupWindow.showLocation(this.binding.spType);
    }

    public /* synthetic */ void a(String str) {
        this.link = str;
    }

    public /* synthetic */ void b(List list, int i, long j) {
        this.binding.spType.setText((CharSequence) list.get(i));
        this.type = (String) list.get(i);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_FILL_EXIT);
    }

    public /* synthetic */ void a(List list, int i, long j) {
        LinkInfo linkInfo = (LinkInfo) list.get(i);
        this.binding.spGameName.setText(linkInfo.getGameName());
        this.gameName = linkInfo.getGameName();
        this.gameId = linkInfo.getGameCode();
    }
}
