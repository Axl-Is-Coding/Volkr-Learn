package io.rong.imkit.tools;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.common.RongWebView;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.activity.CombinePicturePagerActivity;
import io.rong.imkit.model.Event;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imkit.plugin.location.AMapPreviewActivity;
import io.rong.imkit.plugin.location.AMapPreviewActivity2D;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.utils.CombineMessageUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.NetUtils;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;
import io.rong.message.LocationMessage;
import io.rong.message.SightMessage;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CombineWebViewActivity extends RongBaseActivity {
    private static final String COMBINE_FILE_PATH = "combine";
    private static final String TAG = "CombineWebViewActivity";
    public static final String TYPE_LOCAL = "local";
    public static final String TYPE_MEDIA = "media";
    private static final int VIDEO_HEIGHT = 600;
    private static final int VIDEO_WIDTH = 300;
    private ImageView mImageView;
    private int mMessageId;
    private String mPrevUrl;
    private ProgressBar mProgress;
    private TextView mTextView;
    private String mType;
    protected RongWebView mWebView;
    protected TextView mWebViewTitle;

    private class CombineWebChromeClient extends WebChromeClient {
        private CombineWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return Bitmap.createBitmap(300, 600, Bitmap.Config.ALPHA_8);
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            if (CombineWebViewActivity.this.isFinishing()) {
                return;
            }
            CombineWebViewActivity.this.finish();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                CombineWebViewActivity.this.mProgress.setVisibility(8);
                CombineWebViewActivity.this.mImageView.setVisibility(8);
                CombineWebViewActivity.this.mTextView.setVisibility(8);
                CombineWebViewActivity.this.mWebView.setVisibility(0);
            } else {
                if (CombineWebViewActivity.this.mProgress.getVisibility() == 8) {
                    CombineWebViewActivity.this.mProgress.setVisibility(0);
                }
                if (CombineWebViewActivity.this.mTextView.getVisibility() == 8) {
                    CombineWebViewActivity.this.mTextView.setText(CombineWebViewActivity.this.getString(R.string.rc_combine_webview_loading));
                    CombineWebViewActivity.this.mTextView.setVisibility(0);
                }
                if (CombineWebViewActivity.this.mWebView.getVisibility() == 0) {
                    CombineWebViewActivity.this.mWebView.setVisibility(8);
                }
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            TextView textView = CombineWebViewActivity.this.mWebViewTitle;
            if (textView == null || !TextUtils.isEmpty(textView.getText())) {
                return;
            }
            CombineWebViewActivity.this.mWebViewTitle.setText(str);
        }
    }

    private class CombineWebViewClient extends WebViewClient {
        private CombineWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            RLog.d(CombineWebViewActivity.TAG, "onPageStarted url:" + str);
            if (!"media".equals(CombineWebViewActivity.this.mType) || str == null) {
                return;
            }
            if (str.toLowerCase().startsWith("http") || str.toLowerCase().startsWith("ftp")) {
                String combineFilePath = CombineMessageUtils.getInstance().getCombineFilePath(str);
                if (new File(combineFilePath).exists()) {
                    return;
                }
                new DownloadTask().execute(str, combineFilePath);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            RLog.d(CombineWebViewActivity.TAG, "onReceivedError errorCode:" + i);
            CombineWebViewActivity.this.mProgress.setVisibility(8);
            CombineWebViewActivity.this.mImageView.setVisibility(0);
            CombineWebViewActivity.this.mTextView.setVisibility(0);
            CombineWebViewActivity.this.mWebView.setVisibility(8);
            CombineWebViewActivity.this.mTextView.setText(CombineWebViewActivity.this.getString(R.string.rc_combine_webview_download_failed));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            AlertDialog.Builder builder = new AlertDialog.Builder(CombineWebViewActivity.this);
            builder.setMessage(R.string.rc_notification_error_ssl_cert_invalid);
            builder.setPositiveButton(R.string.rc_dialog_ok, new DialogInterface.OnClickListener() { // from class: io.rong.imkit.tools.CombineWebViewActivity.CombineWebViewClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(R.string.rc_dialog_cancel, new DialogInterface.OnClickListener() { // from class: io.rong.imkit.tools.CombineWebViewActivity.CombineWebViewClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                }
            });
            builder.create().show();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            RLog.d(CombineWebViewActivity.TAG, "shouldOverrideUrlLoading mPrevUrl: " + CombineWebViewActivity.this.mPrevUrl + ", url:" + str);
            if (CombineWebViewActivity.this.mPrevUrl != null && CombineWebViewActivity.this.mPrevUrl.equals(str)) {
                return false;
            }
            if ("media".equals(CombineWebViewActivity.this.mType) && str != null && (str.toLowerCase().startsWith("http") || str.toLowerCase().startsWith("ftp"))) {
                String combineFilePath = CombineMessageUtils.getInstance().getCombineFilePath(str);
                if (new File(combineFilePath).exists()) {
                    str = Uri.parse("file://" + combineFilePath).toString();
                    CombineWebViewActivity.this.mType = "local";
                }
            }
            CombineWebViewActivity.this.mPrevUrl = str;
            CombineWebViewActivity combineWebViewActivity = CombineWebViewActivity.this;
            combineWebViewActivity.mWebView.loadUrl(combineWebViewActivity.mPrevUrl);
            return true;
        }
    }

    private static class DownloadTask extends AsyncTask<String, Void, Void> {
        private DownloadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r1) {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e5 -> B:69:0x00ec). Please report as a decompilation issue!!! */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.String... r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.tools.CombineWebViewActivity.DownloadTask.doInBackground(java.lang.String[]):java.lang.Void");
        }
    }

    private class EncodeFile {
        private String base64;
        private String mediaUrl;
        private String name;
        private String thumb;

        EncodeFile(String str, String str2) {
            this.mediaUrl = str;
            this.base64 = str2;
        }

        public String getName() {
            return this.name;
        }

        String getThumb() {
            return this.thumb;
        }

        public EncodeFile invoke() throws Throwable {
            this.thumb = CombineWebViewActivity.this.getCombineFilePath(this.mediaUrl);
            this.name = RongUtils.md5(this.mediaUrl) + ".jpg";
            File file = new File(this.thumb + this.name);
            if (!TextUtils.isEmpty(this.base64) && !file.exists()) {
                byte[] bArrDecode = null;
                try {
                    bArrDecode = Base64.decode(this.base64, 2);
                } catch (IllegalArgumentException e2) {
                    RLog.e(CombineWebViewActivity.TAG, "afterDecodeMessage Not Base64 Content!");
                    RLog.e(CombineWebViewActivity.TAG, "IllegalArgumentException ", e2);
                }
                if (!CombineWebViewActivity.isImageFile(bArrDecode)) {
                    RLog.e(CombineWebViewActivity.TAG, "afterDecodeMessage Not Image File!");
                    return this;
                }
                FileUtils.byte2File(bArrDecode, this.thumb, this.name);
            }
            return this;
        }
    }

    private class IsSightFileExists {
        private SightMessage sightMessage;

        public IsSightFileExists(SightMessage sightMessage) {
            this.sightMessage = sightMessage;
        }

        public boolean invoke() {
            String mediaDownloadDir = LibStorageUtils.getMediaDownloadDir(CombineWebViewActivity.this.getApplicationContext(), "video");
            String strShortMD5 = DeviceUtils.ShortMD5(2, this.sightMessage.getMediaUrl().toString());
            if (mediaDownloadDir.startsWith("file://")) {
                mediaDownloadDir = mediaDownloadDir.substring(7);
            }
            return new File(mediaDownloadDir + File.separator + strShortMD5).exists();
        }
    }

    private class JsInterface {
        private JsInterface() {
        }

        @JavascriptInterface
        public void sendInfoToAndroid(String str) throws Throwable {
            JSONObject jSONObject;
            try {
                RLog.d(CombineWebViewActivity.TAG, "sendInfoToAndroid type start" + str);
                jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("type");
                RLog.d(CombineWebViewActivity.TAG, "sendInfoToAndroid type:" + strOptString);
                switch (strOptString) {
                    case "RC:FileMsg":
                        CombineWebViewActivity.this.openFile(jSONObject);
                        break;
                    case "RC:LBSMsg":
                        CombineWebViewActivity.this.openMap(jSONObject);
                        break;
                    case "RC:CombineMsg":
                        CombineWebViewActivity.this.openCombine(jSONObject);
                        break;
                    case "link":
                        CombineWebViewActivity.this.openLink(jSONObject);
                        break;
                    case "phone":
                        CombineWebViewActivity.this.openPhone(jSONObject);
                        break;
                    case "RC:ImgMsg":
                        CombineWebViewActivity.this.openImage(jSONObject);
                        break;
                    case "RC:SightMsg":
                        CombineWebViewActivity.this.openSight(jSONObject);
                        break;
                }
            } catch (Exception e2) {
                RLog.e(CombineWebViewActivity.TAG, "sendInfoToAndroid", e2);
            }
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mMessageId = intent.getIntExtra("messageId", -1);
        String stringExtra = intent.getStringExtra(ShareConstants.MEDIA_URI);
        this.mType = intent.getStringExtra("type");
        String stringExtra2 = intent.getStringExtra("title");
        this.mPrevUrl = stringExtra;
        this.mWebView.loadUrl(this.mPrevUrl);
        if (this.mWebViewTitle != null && !TextUtils.isEmpty(stringExtra2)) {
            this.mWebViewTitle.setText(stringExtra2);
        }
        onCreateActionbar(new RongBaseActivity.ActionBar());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void initUI() {
        this.mWebView = (RongWebView) findViewById(R.id.rc_webview);
        this.mWebViewTitle = (TextView) findViewById(R.id.rc_action_bar_title);
        this.mProgress = (ProgressBar) findViewById(R.id.rc_web_progress);
        this.mImageView = (ImageView) findViewById(R.id.rc_web_download_failed);
        this.mTextView = (TextView) findViewById(R.id.rc_web_download_text);
        this.mWebView.setVerticalScrollbarOverlay(true);
        this.mWebView.setWebViewClient(new CombineWebViewClient());
        if (NetUtils.isNetWorkAvailable(getApplicationContext())) {
            this.mWebView.setWebChromeClient(new CombineWebChromeClient());
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.mWebView.addJavascriptInterface(new JsInterface(), "interface");
        }
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        this.mWebView.getSettings().setSupportZoom(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        this.mWebView.getSettings().setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT >= 17) {
            this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isImageFile(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return options.outWidth != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCombine(JSONObject jSONObject) {
        String str;
        String strOptString = jSONObject.optString("fileUrl");
        String combineFilePath = CombineMessageUtils.getInstance().getCombineFilePath(strOptString);
        if (new File(combineFilePath).exists()) {
            strOptString = Uri.parse("file://" + combineFilePath).toString();
            str = "local";
        } else {
            str = "media";
        }
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_COMBINEWEBVIEW);
        intent.setPackage(getPackageName());
        intent.addFlags(268435456);
        intent.putExtra(ShareConstants.MEDIA_URI, strOptString);
        intent.putExtra("type", str);
        intent.putExtra("title", jSONObject.optString("title"));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFile(JSONObject jSONObject) {
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_OPENWEBFILE);
        intent.setPackage(getPackageName());
        intent.putExtra("fileUrl", jSONObject.optString("fileUrl"));
        intent.putExtra("fileName", jSONObject.optString("fileName"));
        intent.putExtra("fileSize", jSONObject.optString("fileSize"));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openImage(JSONObject jSONObject) throws Throwable {
        String strOptString = jSONObject.optString("fileUrl");
        String strOptString2 = jSONObject.optString("imgUrl");
        EncodeFile encodeFileInvoke = new EncodeFile(strOptString, strOptString2.substring(strOptString2.indexOf(",") + 1)).invoke();
        String thumb = encodeFileInvoke.getThumb();
        String name = encodeFileInvoke.getName();
        ImageMessage imageMessageObtain = ImageMessage.obtain();
        imageMessageObtain.setThumUri(Uri.parse("file://" + thumb + name));
        imageMessageObtain.setRemoteUri(Uri.parse(strOptString));
        Message message = new Message();
        message.setContent(imageMessageObtain);
        message.setConversationType(Conversation.ConversationType.PRIVATE);
        try {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) CombinePicturePagerActivity.class);
            intent.setPackage(getApplicationContext().getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("message", message);
            getApplicationContext().startActivity(intent);
        } catch (Exception e2) {
            RLog.e(TAG, "openImage", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLink(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("link");
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
        intent.setPackage(getPackageName());
        intent.putExtra("url", strOptString);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMap(JSONObject jSONObject) {
        LocationMessage locationMessageObtain = LocationMessage.obtain(Double.parseDouble(jSONObject.optString(LocationConst.LATITUDE)), Double.parseDouble(jSONObject.optString(LocationConst.LONGITUDE)), jSONObject.optString("locationName"), null);
        try {
            Intent intent = getApplicationContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(this, (Class<?>) AMapPreviewActivity2D.class) : new Intent(this, (Class<?>) AMapPreviewActivity.class);
            intent.putExtra("location", locationMessageObtain);
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception e2) {
            RLog.e(TAG, "openMap", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPhone(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("phoneNum");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + strOptString));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSight(JSONObject jSONObject) throws Throwable {
        String strOptString = jSONObject.optString("fileUrl");
        int iOptInt = jSONObject.optInt("duration");
        String strOptString2 = jSONObject.optString("imageBase64");
        EncodeFile encodeFileInvoke = new EncodeFile(strOptString, strOptString2.substring(strOptString2.indexOf(",") + 1)).invoke();
        String thumb = encodeFileInvoke.getThumb();
        String name = encodeFileInvoke.getName();
        SightMessage sightMessage = new SightMessage();
        sightMessage.setThumbUri(Uri.parse("file://" + thumb + name));
        sightMessage.setMediaUrl(Uri.parse(strOptString));
        sightMessage.setDuration(iOptInt);
        if (new IsSightFileExists(sightMessage).invoke()) {
            String mediaDownloadDir = LibStorageUtils.getMediaDownloadDir(getApplicationContext(), "video");
            String strShortMD5 = DeviceUtils.ShortMD5(2, strOptString);
            if (mediaDownloadDir.startsWith("file://")) {
                mediaDownloadDir = mediaDownloadDir.substring(7);
            }
            sightMessage.setLocalPath(Uri.parse(mediaDownloadDir + File.separator + strShortMD5));
        }
        Message message = new Message();
        message.setContent(sightMessage);
        message.setTargetId(RongIMClient.getInstance().getCurrentUserId());
        message.setConversationType(Conversation.ConversationType.PRIVATE);
        ComponentName componentName = new ComponentName(this, "io.rong.sight.player.SightPlayerActivity");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra("Message", message);
        intent.putExtra("SightMessage", sightMessage);
        startActivity(intent);
    }

    public String getCombineFilePath(String str) {
        return FileUtils.getCachePath(getApplicationContext()) + File.separator + COMBINE_FILE_PATH + File.separator;
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_combine_webview);
        initUI();
        initData();
        RongContext.getInstance().getEventBus().register(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RongWebView rongWebView = this.mWebView;
        if (rongWebView != null) {
            rongWebView.destroy();
        }
        RongContext.getInstance().getEventBus().unregister(this);
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        int i = this.mMessageId;
        if (i == -1 || i != remoteMessageRecallEvent.getMessageId()) {
            return;
        }
        new AlertDialog.Builder(this, 5).setMessage(getString(R.string.rc_recall_success)).setPositiveButton(getString(R.string.rc_dialog_ok), new DialogInterface.OnClickListener() { // from class: io.rong.imkit.tools.CombineWebViewActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                CombineWebViewActivity.this.finish();
            }
        }).setCancelable(false).show();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.mWebView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebView.goBack();
        return true;
    }
}
