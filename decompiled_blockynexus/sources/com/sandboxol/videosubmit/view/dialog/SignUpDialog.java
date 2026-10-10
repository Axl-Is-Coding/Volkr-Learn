package com.sandboxol.videosubmit.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.constant.VideoSubmitEventConstant;
import com.sandboxol.videosubmit.constant.VideoSubmitMessageToken;
import com.sandboxol.videosubmit.constant.VideoSubmitStringConstant;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpBinding;
import com.sandboxol.videosubmit.utils.ViewUtils;
import com.sandboxol.videosubmit.view.widget.SpinnerPopupWindow;
import com.sandboxol.videosubmit.web.VideoSubmitApi;
import com.sandboxol.videosubmit.web.VideoSubmitError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class SignUpDialog extends FullScreenDialog {
    private String activityId;
    private VideosubmitDialogSignUpBinding binding;
    private String language;
    private String languageName;
    public ReplyCommand onCloseCommand;
    public ReplyCommand onCountryCommand;
    public ReplyCommand<String> onGetYtCommand;
    public ReplyCommand onSubmitCommand;
    private RegisterSucceedDialog registerSucceedDialog;
    private SpinnerPopupWindow spinnerPopupWindow;
    private String youtubeName;

    public SignUpDialog(Context context, String str) {
        super(context);
        this.onCloseCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.m
            @Override // rx.functions.Action0
            public final void call() {
                this.f18934a.onClose();
            }
        });
        this.onSubmitCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f18932a.onSubmit();
            }
        });
        this.onCountryCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f18931a.onLanguage();
            }
        });
        this.onGetYtCommand = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.videosubmit.view.dialog.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18933a.a((String) obj);
            }
        });
        this.activityId = str;
        initView();
    }

    private void initView() {
        this.binding = (VideosubmitDialogSignUpBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.videosubmit_dialog_sign_up, (ViewGroup) null, false);
        this.binding.setViewModel(this);
        setContentView(this.binding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_SIGN_EXIT);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLanguage() {
        Map<String, String> languages = ViewUtils.getLanguages();
        final ArrayList arrayList = new ArrayList(languages.values());
        final ArrayList arrayList2 = new ArrayList(languages.keySet());
        this.spinnerPopupWindow = new SpinnerPopupWindow(this.context, arrayList);
        this.spinnerPopupWindow.setOnItemClickListener(new SpinnerPopupWindow.OnItemClickListener() { // from class: com.sandboxol.videosubmit.view.dialog.n
            @Override // com.sandboxol.videosubmit.view.widget.SpinnerPopupWindow.OnItemClickListener
            public final void onClick(int i, long j) {
                this.f18935a.a(arrayList, arrayList2, i, j);
            }
        });
        this.spinnerPopupWindow.showLocation(this.binding.spLanguageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubmit() {
        String str;
        String str2 = this.youtubeName;
        if (str2 == null || "".equals(str2) || (str = this.language) == null || "".equals(str)) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.videosubmit_dialog_register_format_null);
        } else {
            VideoSubmitApi.postSignUp(this.context, this.youtubeName, this.language, this.activityId, new OnResponseListener() { // from class: com.sandboxol.videosubmit.view.dialog.SignUpDialog.1
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i, String str3) {
                    VideoSubmitError.showErrorTip(((FullScreenDialog) SignUpDialog.this).context, i);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i) {
                    ServerOnError.showOnServerError(((FullScreenDialog) SignUpDialog.this).context, i);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(Object obj) {
                    Messenger.getDefault().send(1, VideoSubmitMessageToken.TOKEN_REFRESH_SIGN_UP_STATUS);
                    if (!SharedUtils.getBoolean(((FullScreenDialog) SignUpDialog.this).context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_USER_ID_SIGN + AccountCenter.newInstance().userId.get())) {
                        SharedUtils.putBoolean(((FullScreenDialog) SignUpDialog.this).context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_USER_ID_SIGN + AccountCenter.newInstance().userId.get(), true);
                    }
                    SignUpDialog.this.dismiss();
                    SignUpDialog signUpDialog = SignUpDialog.this;
                    signUpDialog.registerSucceedDialog = new RegisterSucceedDialog(((FullScreenDialog) signUpDialog).context);
                    SignUpDialog.this.registerSucceedDialog.show();
                    ReportDataAdapter.onEvent(((FullScreenDialog) SignUpDialog.this).context, VideoSubmitEventConstant.CLICK_BGTUBE_SIGN_OK);
                }
            });
            ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_SIGN_SURE);
        }
    }

    public /* synthetic */ void a(String str) {
        this.youtubeName = str;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLICK_BGTUBE_SIGN_EXIT);
    }

    public /* synthetic */ void a(List list, List list2, int i, long j) {
        this.binding.spLanguageName.setText((CharSequence) list.get(i));
        this.languageName = (String) list.get(i);
        this.language = (String) list2.get(i);
    }
}
