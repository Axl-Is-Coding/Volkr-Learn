package com.disabngo.blockynexus.view.activity.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.Toolbar;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.webview.config.FullscreenHolder;
import com.disabngo.blockynexus.view.activity.webview.config.d;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.tendcloud.tenddata.aa;
import fi.iki.elonen.NanoHTTPD;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends AppCompatActivity implements com.disabngo.blockynexus.view.activity.webview.config.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressBar f11234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebView f11235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f11236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.disabngo.blockynexus.view.activity.webview.config.c f11237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Toolbar f11239f;
    private TextView g;
    private String h;
    private boolean i;

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.WEB_SHARE_SUCCESS, new Action0() { // from class: com.disabngo.blockynexus.view.activity.webview.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11242a.j();
            }
        });
    }

    private void initToolBar() {
        setSupportActionBar(this.f11239f);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.g(false);
        }
        this.f11239f.setOverflowIcon(androidx.core.content.b.c(this, R.drawable.ic_more));
        this.g.postDelayed(new b(this), 1900L);
        setTitle(this.h);
    }

    private void l() {
        this.f11238e = getIntent().getStringExtra("mUrl");
        this.h = getIntent().getStringExtra("mTitle");
        this.i = getIntent().getBooleanExtra("isShowToolBar", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        final WebView.HitTestResult hitTestResult = this.f11235b.getHitTestResult();
        if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
            return false;
        }
        j.a aVar = new j.a(this);
        aVar.a(new String[]{"查看大图", "保存图片到相册"}, new DialogInterface.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.webview.WebViewActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e("picUrl", hitTestResult.getExtra());
                if (i != 0) {
                }
            }
        });
        aVar.c();
        return true;
    }

    private void n() {
        com.disabngo.blockynexus.view.activity.webview.utils.b.a(this, androidx.core.content.b.a(this, R.color.colorPrimary), 0);
        this.f11234a = (ProgressBar) findViewById(R.id.pb_progress);
        this.f11235b = (WebView) findViewById(R.id.webview_detail);
        this.f11236c = (FrameLayout) findViewById(R.id.video_fullView);
        this.f11239f = (Toolbar) findViewById(R.id.title_tool_bar);
        this.g = (TextView) findViewById(R.id.tv_gun_title);
        if (this.i) {
            initToolBar();
        } else {
            this.f11239f.setVisibility(8);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void o() {
        this.f11234a.setVisibility(0);
        WebSettings settings = this.f11235b.getSettings();
        settings.setLoadWithOverviewMode(false);
        settings.setSaveFormData(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setUseWideViewPort(true);
        this.f11235b.setInitialScale(100);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setTextZoom(100);
        this.f11237d = new com.disabngo.blockynexus.view.activity.webview.config.c(this);
        this.f11235b.setWebChromeClient(this.f11237d);
        this.f11235b.addJavascriptInterface(new com.disabngo.blockynexus.view.activity.webview.config.b(this), "js");
        this.f11235b.setWebViewClient(new d(this));
        this.f11235b.setOnLongClickListener(new c(this));
    }

    private void p() {
        this.f11235b.loadUrl("javascript:javacalljs()");
        this.f11235b.loadUrl("javascript:javacalljswithargs('android传入到网页里的数据，有参')");
    }

    private void q() {
        this.f11235b.loadUrl("javascript:(function(){var objs = document.getElementsByTagName(\"img\");for(var i=0;i<objs.length;i++){objs[i].onclick=function(){window.injectedObject.imageClick(this.getAttribute(\"src\"));}}})()");
    }

    private void r() {
        this.f11235b.loadUrl("javascript:(function(){var objs =document.getElementsByTagName(\"li\");for(var i=0;i<objs.length;i++){objs[i].onclick=function(){window.injectedObject.textClick(this.getAttribute(\"type\"),this.getAttribute(\"item_pk\"));}}})()");
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void c() {
        q();
        r();
        p();
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void d() {
        this.f11235b.setVisibility(4);
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void e() {
        this.f11236c.setVisibility(0);
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void f() {
        this.f11236c.setVisibility(8);
    }

    public void fullViewAddView(View view) {
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        this.f11236c = new FullscreenHolder(this);
        this.f11236c.addView(view);
        frameLayout.addView(this.f11236c);
    }

    public FrameLayout g() {
        return this.f11236c;
    }

    public void h() {
        if (Build.VERSION.SDK_INT >= 21) {
            finishAfterTransition();
        } else {
            finish();
        }
    }

    public void i() {
        this.f11237d.onHideCustomView();
        setRequestedOrientation(1);
    }

    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void j() {
        WebView webView = this.f11235b;
        if (webView != null) {
            try {
                webView.loadUrl("javascript:onShareSuccess()");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == com.disabngo.blockynexus.view.activity.webview.config.c.f11246a) {
            this.f11237d.a(intent, i2);
        } else if (i == com.disabngo.blockynexus.view.activity.webview.config.c.f11247b) {
            this.f11237d.b(intent, i2);
        }
        boolean z = true;
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            z = false;
        }
        if (i2 == -1 && z) {
            ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.SHARE_SUC);
            j();
        }
        ChannelManager.onActivityResult(i, i2, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        l();
        n();
        o();
        this.f11235b.loadUrl(this.f11238e);
        a(getIntent());
        initMessenger();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Messenger.getDefault().unregister(this);
        this.f11236c.removeAllViews();
        WebView webView = this.f11235b;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f11235b);
            }
            this.f11235b.removeAllViews();
            this.f11235b.loadDataWithBaseURL(null, "", NanoHTTPD.MIME_HTML, "utf-8", null);
            this.f11235b.stopLoading();
            this.f11235b.setWebChromeClient(null);
            this.f11235b.setWebViewClient(null);
            this.f11235b.destroy();
            this.f11235b = null;
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f11237d.a()) {
            i();
            return true;
        }
        if (this.f11235b.canGoBack()) {
            this.f11235b.goBack();
            return true;
        }
        h();
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            h();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f11235b.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f11235b.onResume();
        this.f11235b.resumeTimers();
    }

    public void setTitle(String str) {
        this.g.setText(str);
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void a() {
        this.f11235b.setVisibility(0);
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void b() {
        this.f11234a.setVisibility(8);
    }

    @Override // com.disabngo.blockynexus.view.activity.webview.config.a
    public void a(int i) {
        this.f11234a.setVisibility(0);
        this.f11234a.setProgress(i);
        if (i == 100) {
            this.f11234a.setVisibility(8);
        }
    }

    private void a(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            try {
                String scheme = data.getScheme();
                String host = data.getHost();
                String path = data.getPath();
                Log.e("data", "Scheme: " + scheme + "\nhost: " + host + "\npath: " + path);
                StringBuilder sb = new StringBuilder();
                sb.append(scheme);
                sb.append(aa.f19741a);
                sb.append(host);
                sb.append(path);
                this.f11235b.loadUrl(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra("mUrl", str);
        if (str2 == null) {
            str2 = "加载中...";
        }
        intent.putExtra("mTitle", str2);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra("mUrl", str);
        if (str2 == null) {
            str2 = "加载中...";
        }
        intent.putExtra("mTitle", str2);
        intent.putExtra("isShowToolBar", z);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra("mUrl", str);
        intent.putExtra("mTitle", "详情");
        context.startActivity(intent);
    }
}
