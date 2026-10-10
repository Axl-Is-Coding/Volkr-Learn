package com.sandboxol.videosubmit.view.dialog.signupinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import androidx.databinding.e;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpInfoBinding;
import com.sandboxol.videosubmit.entity.BGTubeSignInfoResponse;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class SignUpInfoDialog extends FullScreenDialog {
    public ObservableField<String> countryName;
    private BGTubeSignInfoResponse data;
    public ObservableField<Integer> linkCount;
    public LinkListLayout listLayout;
    public LinkListModel listModel;
    public ReplyCommand onCloseCommand;
    public ObservableField<String> youtubeName;

    public SignUpInfoDialog(Context context, BGTubeSignInfoResponse bGTubeSignInfoResponse) {
        super(context);
        this.onCloseCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.signupinfo.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18939a.onClose();
            }
        });
        this.youtubeName = new ObservableField<>();
        this.countryName = new ObservableField<>();
        this.linkCount = new ObservableField<>();
        this.listLayout = new LinkListLayout();
        this.data = bGTubeSignInfoResponse;
        initView();
        initData();
    }

    private void initData() {
        BGTubeSignInfoResponse bGTubeSignInfoResponse = this.data;
        if (bGTubeSignInfoResponse == null) {
            this.listModel = new LinkListModel(this.context, R.string.no_data, new BGTubeSignInfoResponse().getLinkList());
            return;
        }
        this.youtubeName.set(bGTubeSignInfoResponse.getYoutubeName());
        this.countryName.set(this.data.getLanguageName());
        this.linkCount.set(Integer.valueOf(this.data.getLinkCount()));
        this.listModel = new LinkListModel(this.context, R.string.no_data, this.data.getLinkList());
    }

    private void initView() {
        VideosubmitDialogSignUpInfoBinding videosubmitDialogSignUpInfoBinding = (VideosubmitDialogSignUpInfoBinding) e.a(LayoutInflater.from(this.context), R.layout.videosubmit_dialog_sign_up_info, (ViewGroup) null, false);
        videosubmitDialogSignUpInfoBinding.setViewModel(this);
        setContentView(videosubmitDialogSignUpInfoBinding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        dismiss();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }
}
