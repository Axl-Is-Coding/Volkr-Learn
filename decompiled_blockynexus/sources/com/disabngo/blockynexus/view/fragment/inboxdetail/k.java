package com.disabngo.blockynexus.view.fragment.inboxdetail;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.databinding.ObservableField;
import com.android.billingclient.api.BillingClient;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.databinding.AbstractC0797ze;
import com.disabngo.blockynexus.entity.Attachment;
import com.disabngo.blockynexus.entity.MailInfo;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.PermissionUtils;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: InboxDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AbstractC0797ze f11749b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MailInfo f11751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Game f11752e;
    public e g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.X.a f11753f = new com.disabngo.blockynexus.e.b.X.a();
    private ObservableField<Integer> h = new ObservableField<>();
    public ObservableField<String> i = new ObservableField<>();
    public ObservableField<Boolean> j = new ObservableField<>(true);
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.inboxdetail.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11740a.j();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.inboxdetail.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f11738a.f();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.inboxdetail.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f11739a.h();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.inboxdetail.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f11741a.i();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.disabngo.blockynexus.e.b.L.j f11750c = new com.disabngo.blockynexus.e.b.L.j();

    public k(Context context, MailInfo mailInfo, AbstractC0797ze abstractC0797ze) {
        this.f11748a = context;
        this.f11749b = abstractC0797ze;
        this.f11751d = mailInfo;
        l();
        if (mailInfo.getExtra() != null && mailInfo.getType() != 3) {
            getGameDetail();
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f11750c.a(this.f11748a, 3, new Long[]{Long.valueOf(this.f11751d.getId())}, true);
    }

    private void getGameDetail() {
        GameDetailManager.gameDetail(this.f11748a, this.f11751d.getExtra().getGameType(), EngineEnv.v1().getEngineVersion(), new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (PermissionUtils.checkAndApplyfPermissionActivity((Activity) this.f11748a, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1001) && this.f11752e != null) {
            DialogC1122va dialogC1122va = new DialogC1122va(this.f11748a, this.f11751d.getExtra().getGameType(), this.f11752e, this.f11751d.getExtra().getInviterId());
            dialogC1122va.show();
            dialogC1122va.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        GroupChatApi.enterGroupByEmail(this.f11748a, Long.valueOf(this.f11751d.getStringExtra()).longValue(), new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f11751d.getAttachment() == null || this.f11751d.getAttachment().size() == 0 || this.h.get().intValue() == 2) {
            f();
        } else {
            this.j.set(false);
            this.f11750c.a(this.f11748a, this.f11751d.getId(), new h(this));
        }
    }

    private void k() {
        MailInfo mailInfo = this.f11751d;
        if (mailInfo == null || mailInfo.getContent() == null || "".equals(this.f11751d.getContent()) || !this.f11751d.getContent().contains("***")) {
            MailInfo mailInfo2 = this.f11751d;
            if (mailInfo2 == null || mailInfo2.getContent() == null) {
                return;
            }
            this.f11749b.f9041a.setText(this.f11751d.getContent());
            return;
        }
        final String[] strArrSplit = this.f11751d.getContent().split("\\*\\*\\*");
        if (strArrSplit.length == 0) {
            this.f11749b.f9041a.setText(this.f11751d.getContent());
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String strReplace = this.f11751d.getContent().replace("***", "");
        if (strArrSplit.length >= 3) {
            strReplace = strReplace.replace(strArrSplit[2], "");
        }
        spannableStringBuilder.append((CharSequence) strReplace);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.disabngo.blockynexus.view.fragment.inboxdetail.InboxDetailViewModel$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                String[] strArr = strArrSplit;
                if (strArr.length >= 3) {
                    if (BillingClient.SkuType.INAPP.equals(strArr[2])) {
                        WebViewActivity.a(this.f11737b.f11748a, strArrSplit[1], this.f11737b.f11751d.getTitle(), true);
                        return;
                    }
                    if ("outapp".equals(strArrSplit[2])) {
                        if (strArrSplit[1].contains("youtube") && CommonHelper.isAppInstalled(this.f11737b.f11748a, "com.google.android.youtube")) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(strArrSplit[1]));
                            intent.setClassName("com.google.android.youtube", "com.google.android.youtube.UrlActivity");
                            this.f11737b.f11748a.startActivity(intent);
                            return;
                        }
                        if (!A.a(this.f11737b.f11748a)) {
                            AppToastUtils.showShortNegativeTipToast(this.f11737b.f11748a, R.string.no_browser);
                            return;
                        }
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(strArrSplit[1].replace(" ", "")));
                            this.f11737b.f11748a.startActivity(intent2);
                        } catch (ActivityNotFoundException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }, strArrSplit[0].length(), strArrSplit[0].length() + strArrSplit[1].length(), 33);
        this.f11749b.f9041a.setText(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), strArrSplit[0].length(), strArrSplit[0].length() + strArrSplit[1].length(), 33);
        this.f11749b.f9041a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f11749b.f9041a.setText(spannableStringBuilder);
    }

    private void l() {
        this.h.set(Integer.valueOf(this.f11751d.getStatus()));
        if (this.f11751d.getAttachment() == null || this.f11751d.getAttachment().size() == 0) {
            this.g = new e(this.f11748a, R.string.no_data, new ArrayList(), this.h);
            this.i.set(this.f11748a.getString(R.string.delete));
            if (this.h.get().intValue() != 2) {
                this.f11750c.a(this.f11748a, 2, new Long[]{Long.valueOf(this.f11751d.getId())}, true);
                return;
            }
            return;
        }
        this.g = new e(this.f11748a, R.string.no_data, this.f11751d.getAttachment(), this.h);
        if (this.h.get().intValue() != 2) {
            this.i.set(this.f11748a.getString(R.string.sign_in_get));
        } else {
            this.i.set(this.f11748a.getString(R.string.delete));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        List<Attachment> attachment = this.f11751d.getAttachment();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (attachment == null || attachment.size() == 0) {
            return;
        }
        for (Attachment attachment2 : attachment) {
            arrayList.add(attachment2.getIcon());
            arrayList2.add(attachment2.getName());
        }
        new CampaignGetIntegralRewardDialog(this.f11748a).setStringDataList(attachment.size(), arrayList, arrayList2).show();
    }
}
