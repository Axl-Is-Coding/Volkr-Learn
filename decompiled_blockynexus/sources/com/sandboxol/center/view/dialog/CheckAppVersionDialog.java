package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.databinding.BaseDialogAppCheckAppVersionBinding;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class CheckAppVersionDialog extends FullScreenDialog {
    private Context context;
    private boolean isForceUpdate;
    private boolean isManualCheck;
    private LatestVersion version;

    public class CheckAppVersionDialogViewModel extends ViewModel {
        public ObservableField<String> updateText = new ObservableField<>();
        public ObservableField<Boolean> isShowPic = new ObservableField<>(false);
        public ObservableField<Boolean> isMandatory = new ObservableField<>(false);
        public ObservableField<String> picUrl = new ObservableField<>();
        public ReplyCommand onClickCancelCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f16377a.onCancelClick();
            }
        });
        public ReplyCommand onClickUpdateCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f16376a.f();
            }
        });

        public CheckAppVersionDialogViewModel() {
            initData();
        }

        private void initData() {
            if (CheckAppVersionDialog.this.version.getContent(CheckAppVersionDialog.this.isForceUpdate) == null || CheckAppVersionDialog.this.version.getContent(CheckAppVersionDialog.this.isForceUpdate).isEmpty()) {
                this.updateText.set(CheckAppVersionDialog.this.context.getString(R.string.base_app_not_latest));
            } else {
                this.updateText.set(CheckAppVersionDialog.this.version.getContent(CheckAppVersionDialog.this.isForceUpdate));
            }
            if (CheckAppVersionDialog.this.version.getPicUrl() == null || "".equals(CheckAppVersionDialog.this.version.getPicUrl())) {
                this.isShowPic.set(false);
            } else {
                this.isShowPic.set(true);
                this.picUrl.set(CheckAppVersionDialog.this.version.getPicUrl());
            }
            if (CheckAppVersionDialog.this.isForceUpdate) {
                CheckAppVersionDialog.this.setCancelable(false);
                this.isMandatory.set(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onCancelClick() {
            CheckAppVersionDialog.this.dismiss();
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_NEED_UPDATE);
            ReportDataAdapter.onEvent(CheckAppVersionDialog.this.context, EventConstant.HOME_CANCEL);
        }

        private void onUpdateClick(String str) {
            saveCheckedVersion(CheckAppVersionDialog.this.version.getNewVersionCode());
            try {
                CheckAppVersionDialog.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
            ReportDataAdapter.onEvent(CheckAppVersionDialog.this.context, EventConstant.HOME_UPDATE);
        }

        private void saveCheckedVersion(int i) {
            if (CheckAppVersionDialog.this.isManualCheck) {
                return;
            }
            SharedUtils.putInt(CheckAppVersionDialog.this.context, "checked.app.version", i);
        }

        public /* synthetic */ void f() {
            if (CheckAppVersionDialog.this.version == null || CheckAppVersionDialog.this.version.getStatus() != 1) {
                onUpdateClick(UrlConstant.PLAY_STORE_URL);
            } else {
                onUpdateClick(CheckAppVersionDialog.this.version.getUrl());
            }
        }
    }

    public CheckAppVersionDialog(Context context, LatestVersion latestVersion, boolean z, boolean z2) {
        super(context);
        this.isForceUpdate = false;
        this.version = latestVersion;
        this.context = context;
        this.isManualCheck = z;
        this.isForceUpdate = z2;
        initView();
    }

    public void initView() {
        super.init(this.context);
        BaseDialogAppCheckAppVersionBinding baseDialogAppCheckAppVersionBinding = (BaseDialogAppCheckAppVersionBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.base_dialog_app_check_app_version, (ViewGroup) null, false);
        setContentView(baseDialogAppCheckAppVersionBinding.getRoot());
        baseDialogAppCheckAppVersionBinding.setCheckAppVersionDialogViewModel(new CheckAppVersionDialogViewModel());
    }
}
