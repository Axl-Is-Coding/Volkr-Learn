package io.rong.imkit.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.just.agentweb.DefaultWebClient;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.common.RongWebView;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;

/* JADX INFO: loaded from: classes5.dex */
public class RongWebviewActivity extends RongBaseActivity {
    private static final String TAG = "RongWebviewActivity";
    private String mPrevUrl;
    private ProgressBar mProgressBar;
    protected RongWebView mWebView;
    protected TextView mWebViewTitle;
    private OnTitleReceivedListener onTitleReceivedListener;

    public interface OnTitleReceivedListener {
        void onTitleReceived(String str);
    }

    private class RongWebChromeClient extends WebChromeClient {
        private RongWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            if (RongWebviewActivity.this.isFinishing()) {
                return;
            }
            RongWebviewActivity.this.finish();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                RongWebviewActivity.this.mProgressBar.setVisibility(8);
            } else {
                if (RongWebviewActivity.this.mProgressBar.getVisibility() == 8) {
                    RongWebviewActivity.this.mProgressBar.setVisibility(0);
                }
                RongWebviewActivity.this.mProgressBar.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            TextView textView = RongWebviewActivity.this.mWebViewTitle;
            if (textView != null && TextUtils.isEmpty(textView.getText())) {
                RongWebviewActivity.this.mWebViewTitle.setText(str);
            }
            if (RongWebviewActivity.this.onTitleReceivedListener != null) {
                RongWebviewActivity.this.onTitleReceivedListener.onTitleReceived(str);
            }
        }
    }

    private class RongWebViewDownLoadListener implements DownloadListener {
        private RongWebViewDownLoadListener() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            RongWebviewActivity rongWebviewActivity = RongWebviewActivity.this;
            if (rongWebviewActivity.checkIntent(rongWebviewActivity, intent)) {
                RongWebviewActivity.this.startActivity(intent);
                if (LibStorageUtils.FILE.equals(uri.getScheme()) && uri.toString().endsWith(".txt")) {
                    RongWebviewActivity.this.finish();
                }
            }
        }
    }

    private class RongWebviewClient extends WebViewClient {
        private RongWebviewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RongWebviewActivity.this);
            builder.setMessage(R.string.rc_notification_error_ssl_cert_invalid);
            builder.setPositiveButton(R.string.rc_dialog_ok, new DialogInterface.OnClickListener() { // from class: io.rong.imkit.tools.RongWebviewActivity.RongWebviewClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(R.string.rc_dialog_cancel, new DialogInterface.OnClickListener() { // from class: io.rong.imkit.tools.RongWebviewActivity.RongWebviewClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                }
            });
            builder.create().show();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (RongWebviewActivity.this.mPrevUrl == null) {
                RongWebviewActivity.this.mPrevUrl = str;
                RongWebviewActivity.this.mWebView.loadUrl(str);
                return true;
            }
            if (RongWebviewActivity.this.mPrevUrl.equals(str)) {
                return false;
            }
            if (str.toLowerCase().startsWith(DefaultWebClient.HTTP_SCHEME) || str.toLowerCase().startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                RongWebviewActivity.this.mPrevUrl = str;
                RongWebviewActivity.this.mWebView.loadUrl(str);
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            intent.setFlags(536870912);
            try {
                RongWebviewActivity.this.startActivity(intent);
            } catch (Exception e2) {
                RLog.e(RongWebviewActivity.TAG, "not apps install for this intent =" + e2.toString());
                RLog.e(RongWebviewActivity.TAG, "RongWebviewClient", e2);
            }
            return true;
        }
    }

    public boolean checkIntent(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_ac_webview);
        Intent intent = getIntent();
        this.mWebView = (RongWebView) findViewById(R.id.rc_webview);
        this.mProgressBar = (ProgressBar) findViewById(R.id.rc_web_progressbar);
        this.mWebViewTitle = (TextView) findViewById(R.id.rc_action_bar_title);
        this.mWebView.setVerticalScrollbarOverlay(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT > 11) {
            this.mWebView.getSettings().setDisplayZoomControls(false);
        }
        this.mWebView.getSettings().setSupportZoom(true);
        this.mWebView.setWebViewClient(new RongWebviewClient());
        this.mWebView.setWebChromeClient(new RongWebChromeClient());
        this.mWebView.setDownloadListener(new RongWebViewDownLoadListener());
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        if (Build.VERSION.SDK_INT >= 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
        String stringExtra = intent.getStringExtra("url");
        Uri data = intent.getData();
        if (stringExtra != null) {
            if (getResources().getBoolean(R.bool.rc_set_java_script_enabled)) {
                if (stringExtra.startsWith("file://")) {
                    this.mWebView.getSettings().setJavaScriptEnabled(false);
                } else {
                    this.mWebView.getSettings().setJavaScriptEnabled(true);
                }
            }
            this.mPrevUrl = stringExtra;
            this.mWebView.loadUrl(stringExtra);
            String stringExtra2 = intent.getStringExtra("title");
            if (this.mWebViewTitle != null && !TextUtils.isEmpty(stringExtra2)) {
                this.mWebViewTitle.setText(stringExtra2);
            }
        } else if (data != null) {
            this.mPrevUrl = data.toString();
            this.mWebView.loadUrl(data.toString());
        }
        onCreateActionbar(new RongBaseActivity.ActionBar());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.mWebView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebView.goBack();
        return true;
    }

    public void setOnTitleReceivedListener(OnTitleReceivedListener onTitleReceivedListener) {
        this.onTitleReceivedListener = onTitleReceivedListener;
    }
}
