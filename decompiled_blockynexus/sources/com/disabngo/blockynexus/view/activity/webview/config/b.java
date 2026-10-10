package com.disabngo.blockynexus.view.activity.webview.config;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.shareactivity.ShareActivityDialog;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.center.utils.ARouterUtils;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.googlepay.view.fragment.recharge.k;

/* JADX INFO: compiled from: MyJavascriptInterface.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11245a;

    public b(Context context) {
        this.f11245a = context;
    }

    @JavascriptInterface
    public void TCAgent(String str, String str2) {
        if (str2 == null) {
            ReportDataAdapter.onEvent(this.f11245a, str);
        } else if ("".equals(str2)) {
            ReportDataAdapter.onEvent(this.f11245a, str);
        } else {
            ReportDataAdapter.onEvent(this.f11245a, str, str2);
        }
    }

    @JavascriptInterface
    public void close() {
        ((Activity) this.f11245a).finish();
    }

    @JavascriptInterface
    public String getAccessToken() {
        return AccountCenter.newInstance().token.get();
    }

    @JavascriptInterface
    public String getAppName() {
        return this.f11245a.getResources().getString(R.string.app_name);
    }

    @JavascriptInterface
    public String getDeviceId() {
        return CommonHelper.getAndroidId(this.f11245a);
    }

    @JavascriptInterface
    public String getLanguage() {
        return CommonHelper.getLanguage();
    }

    @JavascriptInterface
    public String getUserId() {
        return String.valueOf(AccountCenter.newInstance().userId.get());
    }

    @JavascriptInterface
    public int getVersionCode() {
        return BaseApplication.getApp().getMetaDataAppVersion();
    }

    @JavascriptInterface
    public String getVersionName() {
        return "1.24.4";
    }

    @JavascriptInterface
    public void goToRecharge() {
        Context context = this.f11245a;
        TemplateUtils.startTemplate(context, k.class, context.getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
    }

    @JavascriptInterface
    public void goToShop() {
        com.disabngo.blockynexus.c.a.a(this.f11245a);
    }

    @JavascriptInterface
    public void goToVip() {
        VipManager.enterVipFragment(this.f11245a);
    }

    @JavascriptInterface
    public void imageClick(String str) {
        Log.e("imageClick", "----点击了图片");
        Log.e("src", str);
    }

    @JavascriptInterface
    public void jumpMiniGame(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.MINI_GAME_ID, str);
        Context context = this.f11245a;
        ARouterUtils.startTemplate(context, RouterFragmentPath.GameDetailModule.PAGER_GAME_DETAIL, context.getString(R.string.main_game), bundle);
    }

    @JavascriptInterface
    public void refreshMoney() {
        BillingManager.getInstance().updateUserMoney(this.f11245a);
    }

    @JavascriptInterface
    public void share(String str) {
        new ShareActivityDialog(this.f11245a, str).show();
    }

    @JavascriptInterface
    public void startFunction() {
        Log.e("startFunction", "----无参");
    }

    @JavascriptInterface
    public void textClick(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e("textClick", "----点击了文字");
        Log.e("type", str);
        Log.e("item_pk", str2);
    }

    @JavascriptInterface
    public void updateUserInfo() {
        Messenger.getDefault().sendNoMsg(MessageToken.UPDATE_USER_INFO);
    }

    @JavascriptInterface
    public void startFunction(String str) {
        Log.e("startFunction", "----有参" + str);
    }
}
