package com.just.agentweb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.j;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultUIController extends AbsAgentWebUIController {
    private Activity mActivity;
    private j mAlertDialog;
    protected j mConfirmDialog;
    private ProgressDialog mProgressDialog;
    private WebParentLayout mWebParentLayout;
    private JsPromptResult mJsPromptResult = null;
    private JsResult mJsResult = null;
    private j mPromptDialog = null;
    private j mAskOpenOtherAppDialog = null;
    private Resources mResources = null;

    private void onForceDownloadAlertInternal(final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            j.a aVar = new j.a(activity);
            aVar.b(this.mResources.getString(R.string.agentweb_tips));
            aVar.a(this.mResources.getString(R.string.agentweb_honeycomblow));
            aVar.a(this.mResources.getString(R.string.agentweb_download), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain());
                    }
                }
            });
            aVar.b(this.mResources.getString(R.string.agentweb_cancel), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
            aVar.a().show();
        }
    }

    private void onJsConfirmInternal(String str, JsResult jsResult) {
        LogUtils.i(this.TAG, "activity:" + this.mActivity.hashCode() + "  ");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            toCancelJsresult(jsResult);
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            toCancelJsresult(jsResult);
            return;
        }
        if (this.mConfirmDialog == null) {
            j.a aVar = new j.a(activity);
            aVar.a(str);
            aVar.a(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                    DefaultUIController defaultUIController2 = DefaultUIController.this;
                    defaultUIController2.toCancelJsresult(defaultUIController2.mJsResult);
                }
            });
            aVar.b(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                    if (DefaultUIController.this.mJsResult != null) {
                        DefaultUIController.this.mJsResult.confirm();
                    }
                }
            });
            aVar.a(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toCancelJsresult(defaultUIController.mJsResult);
                }
            });
            this.mConfirmDialog = aVar.a();
        }
        this.mConfirmDialog.a(str);
        this.mJsResult = jsResult;
        this.mConfirmDialog.show();
    }

    private void onJsPromptInternal(String str, String str2, JsPromptResult jsPromptResult) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            jsPromptResult.cancel();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            jsPromptResult.cancel();
            return;
        }
        if (this.mPromptDialog == null) {
            final EditText editText = new EditText(activity);
            editText.setText(str2);
            j.a aVar = new j.a(activity);
            aVar.b(editText);
            aVar.b(str);
            aVar.a(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                    DefaultUIController defaultUIController2 = DefaultUIController.this;
                    defaultUIController2.toCancelJsresult(defaultUIController2.mJsPromptResult);
                }
            });
            aVar.b(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                    if (DefaultUIController.this.mJsPromptResult != null) {
                        DefaultUIController.this.mJsPromptResult.confirm(editText.getText().toString());
                    }
                }
            });
            aVar.a(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.10
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toCancelJsresult(defaultUIController.mJsPromptResult);
                }
            });
            this.mPromptDialog = aVar.a();
        }
        this.mJsPromptResult = jsPromptResult;
        this.mPromptDialog.show();
    }

    private void showChooserInternal(String[] strArr, final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            j.a aVar = new j.a(activity);
            aVar.a(strArr, -1, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    LogUtils.i(DefaultUIController.this.TAG, "which:" + i);
                    if (callback != null) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = i;
                        callback.handleMessage(messageObtain);
                    }
                }
            });
            aVar.a(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain((Handler) null, -1));
                    }
                }
            });
            this.mAlertDialog = aVar.a();
            this.mAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCancelJsresult(JsResult jsResult) {
        if (jsResult != null) {
            jsResult.cancel();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    protected void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {
        this.mActivity = activity;
        this.mWebParentLayout = webParentLayout;
        this.mResources = this.mActivity.getResources();
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onCancelLoading() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = null;
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onForceDownloadAlert(String str, Handler.Callback callback) {
        onForceDownloadAlertInternal(callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsAlert(WebView webView, String str, String str2) {
        AgentWebUtils.toastShowShort(webView.getContext().getApplicationContext(), str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        onJsConfirmInternal(str2, jsResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        onJsPromptInternal(str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onLoading(String str) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(activity);
            }
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(str);
            this.mProgressDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onMainFrameError(WebView webView, int i, String str, String str2) {
        LogUtils.i(this.TAG, "mWebParentLayout onMainFrameError:" + this.mWebParentLayout);
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.showPageMainFrameError();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onOpenPagePrompt(WebView webView, String str, final Handler.Callback callback) {
        LogUtils.i(this.TAG, "onOpenPagePrompt");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mAskOpenOtherAppDialog == null) {
                j.a aVar = new j.a(activity);
                aVar.a(this.mResources.getString(R.string.agentweb_leave_app_and_go_other_page, AgentWebUtils.getApplicationName(activity)));
                aVar.b(this.mResources.getString(R.string.agentweb_tips));
                aVar.a(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, -1));
                        }
                    }
                });
                aVar.b(this.mResources.getString(R.string.agentweb_leave), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, 1));
                        }
                    }
                });
                this.mAskOpenOtherAppDialog = aVar.a();
            }
            this.mAskOpenOtherAppDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionsDeny(String[] strArr, String str, String str2) {
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        showChooserInternal(strArr, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMainFrame() {
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.hideErrorLayout();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMessage(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
            AgentWebUtils.toastShowShort(this.mActivity.getApplicationContext(), str);
        }
    }
}
