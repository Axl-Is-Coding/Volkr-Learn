package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.databinding.BaseDialogScrapMakeSureBinding;
import com.sandboxol.center.entity.ScrapMakeSureInfo;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.ColorTextHelper;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapMakeSureDialog extends FullScreenDialog {
    private boolean isSending;
    private OnMakeSureClickListener listener;
    public ScrapMakeSureInfo message;
    public ReplyCommand onCancelCommand;
    public ReplyCommand onSureCommand;
    private int sendType;
    public ObservableField<Spanned> tips;

    /* JADX INFO: renamed from: com.sandboxol.center.view.dialog.ScrapMakeSureDialog$1, reason: invalid class name */
    class AnonymousClass1 extends OnResponseListener<String> {
        AnonymousClass1() {
        }

        public /* synthetic */ void a() {
            VipManager.showSubscribeDialog(((FullScreenDialog) ScrapMakeSureDialog.this).context);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onError(int i, String str) {
            if (i == 10113) {
                new TwoButtonDialog(((FullScreenDialog) ScrapMakeSureDialog.this).context).setDetailText(R.string.base_scrap_not_vip_can_t_give_away).setRightButtonText(R.string.base_vip_open).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.center.view.dialog.n
                    @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                    public final void onClick() {
                        this.f16385a.a();
                    }
                }).show();
                VipManager.reportVipSubWin(((FullScreenDialog) ScrapMakeSureDialog.this).context);
            } else {
                ScrapOnError.showErrorTip(((FullScreenDialog) ScrapMakeSureDialog.this).context, i);
            }
            ScrapMakeSureDialog.this.isSending = false;
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            ServerOnError.showOnServerError(((FullScreenDialog) ScrapMakeSureDialog.this).context, i);
            ScrapMakeSureDialog.this.isSending = false;
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(String str) {
            AppToastUtils.showShortPositiveTipToast(((FullScreenDialog) ScrapMakeSureDialog.this).context, R.string.scrap_agree_tips);
            if (ScrapMakeSureDialog.this.listener != null) {
                ScrapMakeSureDialog.this.listener.onSure(str);
            }
            ScrapMakeSureDialog.this.dismiss();
            MessagerClient.getIns().sendMsg0(MessageToken.TOKEN_SCRAP_CLOSE_BAG);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM);
        }
    }

    public interface OnMakeSureClickListener {
        void onSure(String str);
    }

    public ScrapMakeSureDialog(Context context, ScrapMakeSureInfo scrapMakeSureInfo, int i, OnMakeSureClickListener onMakeSureClickListener) {
        super(context);
        this.tips = new ObservableField<>();
        this.onCancelCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f16386a.a();
            }
        });
        this.onSureCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.m
            @Override // rx.functions.Action0
            public final void call() {
                this.f16384a.send();
            }
        });
        this.message = scrapMakeSureInfo;
        this.listener = onMakeSureClickListener;
        this.sendType = i;
        initView();
    }

    private void initView() {
        BaseDialogScrapMakeSureBinding baseDialogScrapMakeSureBinding = (BaseDialogScrapMakeSureBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.base_dialog_scrap_make_sure, (ViewGroup) null, false);
        baseDialogScrapMakeSureBinding.setScrapMakeSureDialog(this);
        setContentView(baseDialogScrapMakeSureBinding.getRoot());
        this.tips.set(new ColorTextHelper.Builder().appendText(this.context.getString(R.string.scrap_make_sure_tips), "#333333").appendText(this.message.getScrapName(), ScrapOutlineViewReturnHelper.getTextColor(this.message.getScrapLevel())).create().getColorText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send() {
        if (this.isSending) {
            return;
        }
        this.isSending = true;
        ScrapApi.sendScrap(this.context, this.message.getUserId(), this.message.getScrapId(), this.sendType, new AnonymousClass1());
    }

    public /* synthetic */ void a() {
        dismiss();
    }
}
