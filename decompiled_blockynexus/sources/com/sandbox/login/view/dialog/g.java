package com.sandbox.login.view.dialog;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.SystemHelper;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: compiled from: ReloginTipDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnDaoResponseListener<UserRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f15990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ReloginTipDialog f15991b;

    g(ReloginTipDialog reloginTipDialog, TextView textView) {
        this.f15991b = reloginTipDialog;
        this.f15990a = textView;
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UserRecord userRecord) {
        String string;
        if (userRecord != null) {
            string = SystemHelper.isUser(userRecord.getUid()) ? ((FullScreenDialog) this.f15991b).context.getString(R.string.login_relogin_tip_userId, userRecord.getUid()) : ((FullScreenDialog) this.f15991b).context.getString(R.string.login_relogin_tip_account, userRecord.getUid());
        } else {
            string = ((FullScreenDialog) this.f15991b).context.getString(R.string.login_relogin_tip_userId, AccountCenter.newInstance().userId.get() + "");
        }
        ReloginTipDialog reloginTipDialog = this.f15991b;
        String strB = reloginTipDialog.b(reloginTipDialog.f15973a.getLoginTime());
        String string2 = ((FullScreenDialog) this.f15991b).context.getString(R.string.login_relogin_tip, string, AccountCenter.newInstance().nickName.get(), strB, this.f15991b.f15973a.getAppType());
        SpannableString spannableString = new SpannableString(string2);
        if (!"".equals(string)) {
            int iIndexOf = string2.indexOf(string);
            spannableString.setSpan(new ForegroundColorSpan(((FullScreenDialog) this.f15991b).context.getResources().getColor(R.color.login_dialog_tip_red)), iIndexOf, string.length() + iIndexOf, 33);
        }
        if (AccountCenter.newInstance().nickName.get() != null && !"".equals(AccountCenter.newInstance().nickName.get())) {
            int iIndexOf2 = string2.indexOf(AccountCenter.newInstance().nickName.get());
            spannableString.setSpan(new ForegroundColorSpan(((FullScreenDialog) this.f15991b).context.getResources().getColor(R.color.login_dialog_tip_red)), iIndexOf2, AccountCenter.newInstance().nickName.get().length() + iIndexOf2, 33);
        }
        if (this.f15991b.f15973a.getAppType() != null && !"".equals(this.f15991b.f15973a.getAppType())) {
            int iIndexOf3 = string2.indexOf(this.f15991b.f15973a.getAppType());
            spannableString.setSpan(new ForegroundColorSpan(((FullScreenDialog) this.f15991b).context.getResources().getColor(R.color.login_dialog_tip_red)), iIndexOf3, this.f15991b.f15973a.getAppType().length() + iIndexOf3, 33);
        }
        if (!"".equals(strB)) {
            int iIndexOf4 = string2.indexOf(strB);
            spannableString.setSpan(new ForegroundColorSpan(((FullScreenDialog) this.f15991b).context.getResources().getColor(R.color.login_dialog_tip_red)), iIndexOf4, strB.length() + iIndexOf4, 33);
        }
        this.f15990a.setText(spannableString);
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    public void onError(int i, String str) {
    }
}
