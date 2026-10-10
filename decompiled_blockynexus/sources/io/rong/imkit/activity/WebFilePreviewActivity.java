package io.rong.imkit.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.tendcloud.tenddata.cp;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.imkit.RongIM;
import io.rong.imkit.tools.RongWebviewActivity;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.utils.FileTypeUtils;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.FileInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class WebFilePreviewActivity extends RongBaseActivity implements View.OnClickListener {
    private static final String APK_FILE = ".apk";
    public static final int DELETED = 3;
    public static final int DOWNLOADED = 1;
    public static final int DOWNLOADING = 2;
    public static final int DOWNLOAD_CANCEL = 5;
    public static final int DOWNLOAD_ERROR = 4;
    public static final int DOWNLOAD_PAUSE = 7;
    public static final int DOWNLOAD_SUCCESS = 6;
    public static final int NOT_DOWNLOAD = 0;
    private static final String PATH = "webfile";
    public static final int REQUEST_CODE_PERMISSION = 104;
    private static final String TAG = "WebFilePreviewActivity";
    private static final String TXT_FILE = ".txt";
    private long downloadedFileLength;
    private File mAttachFile;
    protected View mCancel;
    private FrameLayout mContentContainer;
    protected TextView mDownloadProgressTextView;
    private LinearLayout mDownloadProgressView;
    private Button mFileButton;
    protected FileDownloadInfo mFileDownloadInfo;
    private ProgressBar mFileDownloadProgressBar;
    private FileInfo mFileInfo;
    private TextView mFileNameView;
    private TextView mFileSizeView;
    private ImageView mFileTypeImage;
    private String pausedPath;
    private SupportResumeStatus supportResumeTransfer = SupportResumeStatus.NOT_SET;

    private class FileDownloadInfo {
        String fileName;
        String path;
        int progress;
        long size;
        int state;
        String uid;
        String url;

        private FileDownloadInfo() {
        }
    }

    private enum SupportResumeStatus {
        NOT_SET(-1),
        NOT_SUPPORT(0),
        SUPPORT(1);

        int value;

        SupportResumeStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static SupportResumeStatus valueOf(int i) {
            for (SupportResumeStatus supportResumeStatus : values()) {
                if (i == supportResumeStatus.getValue()) {
                    return supportResumeStatus;
                }
            }
            SupportResumeStatus supportResumeStatus2 = NOT_SET;
            supportResumeStatus2.value = i;
            return supportResumeStatus2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void downloadFile() {
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        if (!PermissionCheckUtil.checkPermissions(this, strArr)) {
            PermissionCheckUtil.requestPermissions(this, strArr, 104);
            return;
        }
        this.mFileDownloadInfo.state = 2;
        if (this.supportResumeTransfer == SupportResumeStatus.SUPPORT) {
            this.mFileButton.setText(getResources().getString(R.string.rc_cancel));
            this.mCancel.setVisibility(8);
            this.mDownloadProgressView.setVisibility(0);
            this.mDownloadProgressTextView.setVisibility(8);
            this.mFileInfo = getFileInfo(this.pausedPath);
            FileInfo fileInfo = this.mFileInfo;
            if (fileInfo != null) {
                this.downloadedFileLength = fileInfo.getFinished();
            } else {
                FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
                double d2 = fileDownloadInfo.size;
                double d3 = fileDownloadInfo.progress;
                Double.isNaN(d3);
                Double.isNaN(d2);
                this.downloadedFileLength = (long) ((d2 * (d3 / 100.0d)) + 0.5d);
            }
            this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size)}));
        } else {
            this.mFileButton.setVisibility(8);
            this.mDownloadProgressView.setVisibility(0);
            this.mDownloadProgressTextView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize(0L), FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size)}));
        }
        RongIM rongIM = RongIM.getInstance();
        FileDownloadInfo fileDownloadInfo2 = this.mFileDownloadInfo;
        rongIM.downloadMediaFile(fileDownloadInfo2.uid, fileDownloadInfo2.url, fileDownloadInfo2.fileName, fileDownloadInfo2.path, new IRongCallback.IDownloadMediaFileCallback() { // from class: io.rong.imkit.activity.WebFilePreviewActivity.3
            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onCanceled() {
                WebFilePreviewActivity webFilePreviewActivity = WebFilePreviewActivity.this;
                webFilePreviewActivity.mFileDownloadInfo.state = 5;
                webFilePreviewActivity.refreshDownloadState();
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                WebFilePreviewActivity webFilePreviewActivity = WebFilePreviewActivity.this;
                FileDownloadInfo fileDownloadInfo3 = webFilePreviewActivity.mFileDownloadInfo;
                if (fileDownloadInfo3.state != 5) {
                    fileDownloadInfo3.state = 4;
                    webFilePreviewActivity.refreshDownloadState();
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onFileNameChanged(String str) {
                WebFilePreviewActivity.this.mFileDownloadInfo.fileName = str;
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onProgress(int i) {
                WebFilePreviewActivity webFilePreviewActivity = WebFilePreviewActivity.this;
                FileDownloadInfo fileDownloadInfo3 = webFilePreviewActivity.mFileDownloadInfo;
                int i2 = fileDownloadInfo3.state;
                if (i2 == 5 || i2 == 7) {
                    return;
                }
                fileDownloadInfo3.progress = i;
                fileDownloadInfo3.state = 2;
                webFilePreviewActivity.refreshDownloadState();
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onSuccess() {
                WebFilePreviewActivity webFilePreviewActivity = WebFilePreviewActivity.this;
                FileDownloadInfo fileDownloadInfo3 = webFilePreviewActivity.mFileDownloadInfo;
                fileDownloadInfo3.state = 6;
                try {
                    webFilePreviewActivity.mAttachFile = new File(fileDownloadInfo3.path, fileDownloadInfo3.fileName);
                } catch (Exception e2) {
                    RLog.e(WebFilePreviewActivity.TAG, "downloadFile" + e2);
                }
                WebFilePreviewActivity.this.refreshDownloadState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFileDownloadInfo() {
        this.pausedPath = FileUtils.getTempFilePath(this, this.mFileDownloadInfo.uid);
        this.mFileInfo = getFileInfo(this.pausedPath);
        if (this.mAttachFile.exists()) {
            FileInfo fileInfo = this.mFileInfo;
            if (fileInfo == null) {
                this.mFileDownloadInfo.state = 1;
            } else {
                if (fileInfo.isStop()) {
                    this.mFileDownloadInfo.state = 7;
                }
                if (this.mFileInfo.isDownLoading()) {
                    if (RongIMClient.getInstance().isFileDownloading(this.mFileDownloadInfo.uid)) {
                        this.mFileDownloadInfo.state = 2;
                    } else {
                        this.mFileDownloadInfo.state = 7;
                    }
                }
            }
        } else {
            if (this.mFileInfo != null) {
                FileUtils.removeFile(this.pausedPath);
            }
            this.mFileDownloadInfo.state = 0;
        }
        refreshDownloadState();
    }

    private FileInfo getFileInfo(String str) throws Throwable {
        try {
            String stringFromFile = FileUtils.getStringFromFile(str);
            if (TextUtils.isEmpty(stringFromFile)) {
                return null;
            }
            return getFileInfoFromJsonString(stringFromFile);
        } catch (Exception e2) {
            RLog.e(TAG, "getFileInfo", e2);
            return null;
        }
    }

    private FileInfo getFileInfoFromJsonString(String str) {
        FileInfo fileInfo = new FileInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            fileInfo.setFileName(jSONObject.optString("filename"));
            fileInfo.setUrl(jSONObject.optString("url"));
            fileInfo.setLength(jSONObject.optLong(cp.a.LENGTH));
            fileInfo.setFinished(jSONObject.optLong("finish"));
            fileInfo.setStop(jSONObject.optBoolean("isStop", false));
            fileInfo.setDownLoading(jSONObject.optBoolean("isDownLoading", false));
        } catch (JSONException e2) {
            RLog.e(TAG, "getFileInfoFromJsonString", e2);
        }
        return fileInfo;
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mFileDownloadInfo = new FileDownloadInfo();
        this.mFileDownloadInfo.url = intent.getStringExtra("fileUrl");
        this.mFileDownloadInfo.fileName = intent.getStringExtra("fileName");
        this.mFileDownloadInfo.size = Long.valueOf(intent.getStringExtra("fileSize")).longValue();
        this.mFileDownloadInfo.uid = RongUtils.md5(this.mFileDownloadInfo.fileName + this.mFileDownloadInfo.size);
        this.mFileDownloadInfo.path = FileUtils.getCachePath(this, PATH);
        this.mFileTypeImage.setImageResource(FileTypeUtils.fileTypeImageId(getApplicationContext(), this.mFileDownloadInfo.fileName));
        this.mFileNameView.setText(this.mFileDownloadInfo.fileName);
        this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size));
        this.mFileButton.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
        FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
        this.mAttachFile = new File(fileDownloadInfo.path, fileDownloadInfo.fileName);
        if (this.mAttachFile.exists()) {
            this.mFileButton.setText(getString(R.string.rc_ac_file_download_open_file_btn));
        }
        RongIM.getInstance().supportResumeBrokenTransfer(this.mFileDownloadInfo.url, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.activity.WebFilePreviewActivity.1
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                WebFilePreviewActivity webFilePreviewActivity = WebFilePreviewActivity.this;
                webFilePreviewActivity.mFileDownloadInfo.state = 4;
                webFilePreviewActivity.refreshDownloadState();
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                WebFilePreviewActivity.this.supportResumeTransfer = bool.booleanValue() ? SupportResumeStatus.SUPPORT : SupportResumeStatus.NOT_SUPPORT;
                WebFilePreviewActivity.this.getFileDownloadInfo();
            }
        });
    }

    private void initView() {
        this.mContentContainer = (FrameLayout) findViewById(R.id.rc_ac_ll_content_container);
        this.mContentContainer.addView(LayoutInflater.from(this).inflate(R.layout.rc_ac_file_preview_content, (ViewGroup) null));
        this.mFileTypeImage = (ImageView) findViewById(R.id.rc_ac_iv_file_type_image);
        this.mFileNameView = (TextView) findViewById(R.id.rc_ac_tv_file_name);
        this.mFileSizeView = (TextView) findViewById(R.id.rc_ac_tv_file_size);
        this.mFileButton = (Button) findViewById(R.id.rc_ac_btn_download_button);
        this.mDownloadProgressView = (LinearLayout) findViewById(R.id.rc_ac_ll_progress_view);
        this.mCancel = findViewById(R.id.rc_btn_cancel);
        this.mDownloadProgressTextView = (TextView) findViewById(R.id.rc_ac_tv_download_progress);
        this.mFileDownloadProgressBar = (ProgressBar) findViewById(R.id.rc_ac_pb_download_progress);
        ((TextView) findViewById(R.id.rc_action_bar_title)).setText(R.string.rc_ac_file_download_preview);
        this.mCancel.setVisibility(8);
        onCreateActionbar(new RongBaseActivity.ActionBar());
    }

    private void startToDownload() {
        if (RongIM.getInstance().getCurrentConnectionStatus() == RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE) {
            Toast.makeText(this, getString(R.string.rc_notice_network_unavailable), 0).show();
            return;
        }
        if (this.supportResumeTransfer == SupportResumeStatus.NOT_SET) {
            RongIM.getInstance().supportResumeBrokenTransfer(this.mFileDownloadInfo.url, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.activity.WebFilePreviewActivity.2
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    WebFilePreviewActivity webFilePreviewActivity = WebFilePreviewActivity.this;
                    webFilePreviewActivity.mFileDownloadInfo.state = 4;
                    webFilePreviewActivity.refreshDownloadState();
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Boolean bool) {
                    int i = WebFilePreviewActivity.this.mFileDownloadInfo.state;
                    if (i == 0 || i == 3 || i == 4 || i == 5) {
                        WebFilePreviewActivity.this.supportResumeTransfer = SupportResumeStatus.valueOf(bool.booleanValue() ? 1 : 0);
                        WebFilePreviewActivity.this.downloadFile();
                    }
                }
            });
            return;
        }
        int i = this.mFileDownloadInfo.state;
        if (i == 0 || i == 4 || i == 3 || i == 5) {
            downloadFile();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mFileButton) {
            FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
            switch (fileDownloadInfo.state) {
                case 0:
                case 3:
                case 4:
                case 5:
                    startToDownload();
                    break;
                case 1:
                case 6:
                    File file = this.mAttachFile;
                    if (file != null) {
                        openFile(fileDownloadInfo.fileName, file.getAbsolutePath());
                    }
                    break;
                case 2:
                    fileDownloadInfo.state = 7;
                    RongIMClient.getInstance().pauseDownloadMediaFile(this.mFileDownloadInfo.uid, null);
                    this.mFileButton.setText(getResources().getString(R.string.rc_ac_file_preview_download_resume));
                    this.mFileInfo = getFileInfo(this.pausedPath);
                    FileInfo fileInfo = this.mFileInfo;
                    if (fileInfo != null) {
                        this.downloadedFileLength = fileInfo.getFinished();
                    } else {
                        FileDownloadInfo fileDownloadInfo2 = this.mFileDownloadInfo;
                        double d2 = fileDownloadInfo2.size;
                        double d3 = fileDownloadInfo2.progress;
                        Double.isNaN(d3);
                        Double.isNaN(d2);
                        this.downloadedFileLength = (long) ((d2 * (d3 / 100.0d)) + 0.5d);
                    }
                    this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_pause, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size)}));
                    break;
                case 7:
                    if (RongIM.getInstance().getCurrentConnectionStatus() == RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE) {
                        Toast.makeText(this, getString(R.string.rc_notice_network_unavailable), 0).show();
                        break;
                    } else if (this.supportResumeTransfer == SupportResumeStatus.SUPPORT) {
                        this.mFileDownloadInfo.state = 2;
                        downloadFile();
                        int i = this.mFileDownloadInfo.state;
                        if (i != 4 && i != 5) {
                            this.mFileButton.setText(getResources().getString(R.string.rc_cancel));
                            break;
                        }
                    }
                    break;
            }
        }
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.rc_ac_file_download);
        initView();
        initData();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        getFileDownloadInfo();
    }

    public void openFile(String str, String str2) {
        if (openInsidePreview(str, str2)) {
            return;
        }
        Intent openFileIntent = FileTypeUtils.getOpenFileIntent(str, str2);
        try {
            if (openFileIntent != null) {
                openFileIntent.addFlags(1);
                startActivity(openFileIntent);
            } else {
                Toast.makeText(this, getString(R.string.rc_ac_file_preview_can_not_open_file), 0).show();
            }
        } catch (Exception unused) {
            Toast.makeText(this, getString(R.string.rc_ac_file_preview_can_not_open_file), 0).show();
        }
    }

    protected boolean openInsidePreview(String str, String str2) {
        if (str2.endsWith(TXT_FILE)) {
            Intent intent = new Intent(this, (Class<?>) RongWebviewActivity.class);
            intent.setPackage(getPackageName());
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("url", FileProvider.getUriForFile(this, getPackageName() + getString(R.string.rc_authorities_fileprovider), new File(str2)).toString());
            } else {
                intent.putExtra("url", "file://" + str2);
            }
            intent.putExtra("title", str);
            startActivity(intent);
            return true;
        }
        if (!str2.endsWith(APK_FILE)) {
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            Toast.makeText(this, getString(R.string.rc_file_not_exist), 0).show();
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Intent dataAndType = new Intent("android.intent.action.VIEW").setDataAndType(FileProvider.getUriForFile(this, getPackageName() + getString(R.string.rc_authorities_fileprovider), file), "application/vnd.android.package-archive");
                dataAndType.addFlags(1);
                startActivity(dataAndType);
            } catch (Exception unused) {
                throw new RuntimeException("Please check IMKit Manifest FileProvider config.");
            }
        } else {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            intent2.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            startActivity(intent2);
        }
        return true;
    }

    protected void refreshDownloadState() {
        FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
        switch (fileDownloadInfo.state) {
            case 0:
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                break;
            case 1:
                this.mFileButton.setText(getString(R.string.rc_ac_file_download_open_file_btn));
                break;
            case 2:
                this.mDownloadProgressView.setVisibility(0);
                this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                FileDownloadInfo fileDownloadInfo2 = this.mFileDownloadInfo;
                double d2 = fileDownloadInfo2.size;
                double d3 = fileDownloadInfo2.progress;
                Double.isNaN(d3);
                Double.isNaN(d2);
                this.downloadedFileLength = (long) ((d2 * (d3 / 100.0d)) + 0.5d);
                this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size)}));
                if (this.supportResumeTransfer != SupportResumeStatus.SUPPORT) {
                    this.mFileButton.setVisibility(8);
                } else {
                    this.mDownloadProgressTextView.setVisibility(8);
                    this.mFileButton.setText(getString(R.string.rc_cancel));
                }
                break;
            case 3:
                this.mFileSizeView.setText(FileTypeUtils.formatFileSize(fileDownloadInfo.size));
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                break;
            case 4:
                if (this.supportResumeTransfer == SupportResumeStatus.SUPPORT) {
                    this.mDownloadProgressView.setVisibility(0);
                    this.mFileInfo = getFileInfo(this.pausedPath);
                    FileInfo fileInfo = this.mFileInfo;
                    if (fileInfo != null) {
                        this.mFileDownloadInfo.progress = (int) ((fileInfo.getFinished() * 100) / this.mFileInfo.getLength());
                    }
                    this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                    FileDownloadInfo fileDownloadInfo3 = this.mFileDownloadInfo;
                    double d4 = fileDownloadInfo3.size;
                    double d5 = fileDownloadInfo3.progress;
                    Double.isNaN(d5);
                    Double.isNaN(d4);
                    this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_pause, new Object[]{FileTypeUtils.formatFileSize((long) ((d4 * (d5 / 100.0d)) + 0.5d)), FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size)}));
                    this.mFileButton.setText(getString(R.string.rc_ac_file_preview_download_resume));
                } else {
                    this.mDownloadProgressView.setVisibility(8);
                    this.mFileButton.setVisibility(0);
                    this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size));
                    this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                }
                Toast.makeText(this, getString(R.string.rc_ac_file_preview_download_error), 0).show();
                break;
            case 5:
                this.mDownloadProgressView.setVisibility(8);
                this.mFileDownloadProgressBar.setProgress(0);
                this.mFileButton.setVisibility(0);
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size));
                Toast.makeText(this, getString(R.string.rc_ac_file_preview_download_cancel), 0).show();
                break;
            case 6:
                this.mDownloadProgressView.setVisibility(8);
                this.mFileButton.setVisibility(0);
                this.mFileButton.setText(getString(R.string.rc_ac_file_download_open_file_btn));
                this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size));
                Toast.makeText(this, getString(R.string.rc_ac_file_preview_downloaded) + this.mFileDownloadInfo.path, 0).show();
                break;
            case 7:
                this.mDownloadProgressView.setVisibility(0);
                FileInfo fileInfo2 = this.mFileInfo;
                if (fileInfo2 != null) {
                    this.mFileDownloadInfo.progress = (int) ((fileInfo2.getFinished() * 100) / this.mFileInfo.getLength());
                    this.downloadedFileLength = this.mFileInfo.getFinished();
                } else {
                    FileDownloadInfo fileDownloadInfo4 = this.mFileDownloadInfo;
                    double d6 = fileDownloadInfo4.size;
                    double d7 = fileDownloadInfo4.progress;
                    Double.isNaN(d7);
                    Double.isNaN(d6);
                    this.downloadedFileLength = (long) ((d6 * (d7 / 100.0d)) + 0.5d);
                }
                this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_pause, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileDownloadInfo.size)}));
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_download_resume));
                break;
        }
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    public void setContentView(int i) {
        this.mContentContainer.removeAllViews();
        this.mContentContainer.addView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }
}
