package io.rong.imkit.activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.tools.RongWebviewActivity;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utils.FileTypeUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.FileInfo;
import io.rong.imlib.model.Message;
import io.rong.message.FileMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.ReferenceMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class FilePreviewActivity extends RongBaseActivity implements View.OnClickListener {
    private static final String APK_FILE = ".apk";
    public static final int DELETED = 3;
    public static final int DOWNLOADED = 1;
    public static final int DOWNLOADING = 2;
    public static final int DOWNLOAD_CANCEL = 5;
    public static final int DOWNLOAD_ERROR = 4;
    public static final int DOWNLOAD_PAUSE = 7;
    public static final int DOWNLOAD_SUCCESS = 6;
    public static final int NOT_DOWNLOAD = 0;
    public static final int ON_CANCEL_CALLBACK = 102;
    public static final int ON_ERROR_CALLBACK = 103;
    public static final int ON_PROGRESS_CALLBACK = 101;
    public static final int ON_SUCCESS_CALLBACK = 100;
    public static final int REQUEST_CODE_PERMISSION = 104;
    private static final String TAG = "FilePreviewActivity";
    private static final String TXT_FILE = ".txt";
    private FrameLayout contentContainer;
    private long downloadedFileLength;
    protected View mCancel;
    protected TextView mDownloadProgressTextView;
    private LinearLayout mDownloadProgressView;
    private Button mFileButton;
    protected FileDownloadInfo mFileDownloadInfo;
    private ProgressBar mFileDownloadProgressBar;
    protected FileMessage mFileMessage;
    private String mFileName;
    private TextView mFileNameView;
    private long mFileSize;
    private TextView mFileSizeView;
    private ImageView mFileTypeImage;
    protected Message mMessage;
    private int mProgress;
    private List<Toast> mToasts;
    private String pausedPath;
    private SupportResumeStatus supportResumeTransfer = SupportResumeStatus.NOT_SET;
    private FileInfo info = null;

    public class FileDownloadInfo {
        public String path;
        public int progress;
        public int state;

        public FileDownloadInfo() {
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
            this.info = getFileInfo();
            FileInfo fileInfo = this.info;
            if (fileInfo != null) {
                this.downloadedFileLength = fileInfo.getFinished();
            } else {
                double size = this.mFileMessage.getSize();
                double d2 = this.mFileDownloadInfo.progress;
                Double.isNaN(d2);
                Double.isNaN(size);
                this.downloadedFileLength = (long) ((size * (d2 / 100.0d)) + 0.5d);
            }
            this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileSize)}));
        } else {
            this.mFileButton.setVisibility(8);
            this.mDownloadProgressView.setVisibility(0);
            this.mDownloadProgressTextView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize(0L), FileTypeUtils.formatFileSize(this.mFileSize)}));
        }
        RongIM.getInstance().downloadMediaMessage(this.mMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFileDownloadInfo() {
        if (this.mFileMessage.getLocalPath() == null) {
            int i = this.mProgress;
            if (i <= 0 || i >= 100) {
                this.mFileDownloadInfo.state = 0;
            } else {
                FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
                fileDownloadInfo.state = 2;
                fileDownloadInfo.progress = i;
            }
        } else if (FileUtils.isFileExistsWithUri(this, this.mFileMessage.getLocalPath())) {
            this.mFileDownloadInfo.state = 1;
        } else {
            this.mFileDownloadInfo.state = 3;
        }
        refreshDownloadState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFileDownloadInfoForResumeTransfer() {
        FileMessage fileMessage = this.mFileMessage;
        if (fileMessage != null) {
            Uri localPath = fileMessage.getLocalPath();
            if (localPath != null) {
                boolean zIsFileExistsWithUri = FileUtils.isFileExistsWithUri(this, localPath);
                FileInfo fileInfo = this.info;
                if (fileInfo == null) {
                    if (zIsFileExistsWithUri) {
                        this.mFileDownloadInfo.state = 1;
                    } else {
                        this.mFileDownloadInfo.state = 3;
                    }
                } else if (zIsFileExistsWithUri) {
                    if (fileInfo.isStop()) {
                        this.mFileDownloadInfo.state = 7;
                    }
                    if (this.info.isDownLoading()) {
                        if (RongIMClient.getInstance().isFileDownloading(this.mMessage.getMessageId())) {
                            this.mFileDownloadInfo.state = 2;
                        } else {
                            this.mFileDownloadInfo.state = 7;
                        }
                    }
                } else {
                    FileUtils.removeFile(this.pausedPath);
                    this.mFileDownloadInfo.state = 3;
                }
            } else {
                FileInfo fileInfo2 = this.info;
                if (fileInfo2 != null) {
                    if (fileInfo2.isStop()) {
                        this.mFileDownloadInfo.state = 7;
                    }
                    if (this.info.isDownLoading()) {
                        if (RongIMClient.getInstance().isFileDownloading(this.mMessage.getMessageId())) {
                            this.mFileDownloadInfo.state = 2;
                        } else {
                            this.mFileDownloadInfo.state = 7;
                        }
                    }
                }
            }
        } else {
            FileInfo fileInfo3 = this.info;
            if (fileInfo3 != null) {
                if (fileInfo3.isStop()) {
                    this.mFileDownloadInfo.state = 7;
                }
                if (this.info.isDownLoading()) {
                    if (RongIMClient.getInstance().isFileDownloading(this.mMessage.getMessageId())) {
                        this.mFileDownloadInfo.state = 2;
                    } else {
                        this.mFileDownloadInfo.state = 7;
                    }
                }
            } else {
                int i = this.mProgress;
                if (i <= 0 || i >= 100) {
                    this.mFileDownloadInfo.state = 0;
                } else {
                    FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
                    fileDownloadInfo.state = 2;
                    fileDownloadInfo.progress = i;
                }
            }
        }
        refreshDownloadState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFileDownloadInfoInSubThread() {
        new Thread(new Runnable() { // from class: io.rong.imkit.activity.FilePreviewActivity.4
            @Override // java.lang.Runnable
            public void run() {
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                filePreviewActivity.info = filePreviewActivity.getFileInfo();
                FilePreviewActivity.this.runOnUiThread(new Runnable() { // from class: io.rong.imkit.activity.FilePreviewActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FilePreviewActivity.this.setViewStatusForResumeTransfer();
                        FilePreviewActivity.this.getFileDownloadInfoForResumeTransfer();
                    }
                });
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInfo getFileInfo() throws Throwable {
        try {
            String stringFromFile = FileUtils.getStringFromFile(this.pausedPath);
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

    private void getFileMessageStatus() {
        Uri fileUrl = this.mFileMessage.getFileUrl();
        Uri localPath = this.mFileMessage.getLocalPath();
        if ((localPath != null && FileUtils.isFileExistsWithUri(this, localPath)) || fileUrl == null || TextUtils.isEmpty(fileUrl.toString())) {
            setViewStatus();
            getFileDownloadInfo();
        } else {
            String string = fileUrl.toString();
            this.pausedPath = FileUtils.getTempFilePath(this, this.mMessage.getMessageId());
            RongIM.getInstance().supportResumeBrokenTransfer(string, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.activity.FilePreviewActivity.1
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    FilePreviewActivity.this.setViewStatus();
                    FilePreviewActivity.this.getFileDownloadInfo();
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Boolean bool) {
                    FilePreviewActivity.this.supportResumeTransfer = bool.booleanValue() ? SupportResumeStatus.SUPPORT : SupportResumeStatus.NOT_SUPPORT;
                    if (FilePreviewActivity.this.supportResumeTransfer != SupportResumeStatus.NOT_SUPPORT) {
                        FilePreviewActivity.this.getFileDownloadInfoInSubThread();
                    } else {
                        FilePreviewActivity.this.setViewStatus();
                        FilePreviewActivity.this.getFileDownloadInfo();
                    }
                }
            });
        }
    }

    private void initData() {
        if (getIntent() == null) {
            return;
        }
        this.mFileDownloadInfo = new FileDownloadInfo();
        this.mFileMessage = (FileMessage) getIntent().getParcelableExtra("FileMessage");
        this.mMessage = (Message) getIntent().getParcelableExtra("Message");
        this.mProgress = getIntent().getIntExtra("Progress", 0);
        this.mToasts = new ArrayList();
        this.mFileName = this.mFileMessage.getName();
        this.mFileTypeImage.setImageResource(FileTypeUtils.fileTypeImageId(getApplicationContext(), this.mFileName));
        this.mFileNameView.setText(this.mFileName);
        this.mFileSize = this.mFileMessage.getSize();
        this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileSize));
        this.mFileButton.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
        RongContext.getInstance().getEventBus().register(this);
    }

    private void initView() {
        this.contentContainer = (FrameLayout) findViewById(R.id.rc_ac_ll_content_container);
        this.contentContainer.addView(LayoutInflater.from(this).inflate(R.layout.rc_ac_file_preview_content, (ViewGroup) null));
        this.mFileTypeImage = (ImageView) findViewById(R.id.rc_ac_iv_file_type_image);
        this.mFileNameView = (TextView) findViewById(R.id.rc_ac_tv_file_name);
        this.mFileSizeView = (TextView) findViewById(R.id.rc_ac_tv_file_size);
        this.mFileButton = (Button) findViewById(R.id.rc_ac_btn_download_button);
        this.mDownloadProgressView = (LinearLayout) findViewById(R.id.rc_ac_ll_progress_view);
        this.mCancel = findViewById(R.id.rc_btn_cancel);
        this.mFileDownloadProgressBar = (ProgressBar) findViewById(R.id.rc_ac_pb_download_progress);
        this.mDownloadProgressTextView = (TextView) findViewById(R.id.rc_ac_tv_download_progress);
        ((TextView) findViewById(R.id.rc_action_bar_title)).setText(R.string.rc_ac_file_download_preview);
        onCreateActionbar(new RongBaseActivity.ActionBar());
    }

    private void processApkFile(Uri uri) {
        if (FileUtils.uriStartWithContent(uri)) {
            Intent dataAndType = new Intent("android.intent.action.VIEW").setDataAndType(uri, "application/vnd.android.package-archive");
            dataAndType.addFlags(1);
            startActivity(dataAndType);
            return;
        }
        String string = uri.toString();
        if (FileUtils.uriStartWithFile(uri)) {
            string = string.substring(7);
        }
        File file = new File(string);
        if (!file.exists()) {
            Toast.makeText(this, getString(R.string.rc_file_not_exist), 0).show();
            return;
        }
        if (Build.VERSION.SDK_INT < 24) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            startActivity(intent);
            return;
        }
        try {
            Intent dataAndType2 = new Intent("android.intent.action.VIEW").setDataAndType(FileProvider.getUriForFile(this, getPackageName() + getString(R.string.rc_authorities_fileprovider), file), "application/vnd.android.package-archive");
            dataAndType2.addFlags(1);
            startActivity(dataAndType2);
        } catch (Exception unused) {
            throw new RuntimeException("Please check IMKit Manifest FileProvider config.");
        }
    }

    private void processTxtFile(String str, Uri uri) {
        Intent intent = new Intent(this, (Class<?>) RongWebviewActivity.class);
        intent.setPackage(getPackageName());
        if (FileUtils.uriStartWithContent(uri)) {
            intent.putExtra("url", uri);
        } else {
            String string = uri.toString();
            if (FileUtils.uriStartWithFile(uri)) {
                string = string.substring(7);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("url", FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + getApplicationContext().getResources().getString(R.string.rc_authorities_fileprovider), new File(string)).toString());
            } else {
                intent.putExtra("url", "file://" + string);
            }
        }
        intent.putExtra("title", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewStatus() {
        if (this.mMessage.getMessageDirection() == Message.MessageDirection.RECEIVE) {
            int i = this.mProgress;
            if (i == 0) {
                this.mDownloadProgressView.setVisibility(8);
                this.mFileButton.setVisibility(0);
            } else if (i == 100) {
                this.mDownloadProgressView.setVisibility(8);
                this.mFileButton.setVisibility(0);
            } else {
                this.mFileButton.setVisibility(8);
                this.mDownloadProgressView.setVisibility(0);
                this.mFileDownloadProgressBar.setProgress(this.mProgress);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewStatusForResumeTransfer() {
        this.mFileButton.setVisibility(0);
        this.mDownloadProgressTextView.setVisibility(8);
        this.mCancel.setVisibility(8);
    }

    private void startToDownload() {
        if (!(this.mMessage.getContent() instanceof MediaMessageContent)) {
            refreshDownloadState();
            return;
        }
        resetMediaMessageLocalPath();
        if (RongIM.getInstance().getCurrentConnectionStatus() != RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED) {
            Toast.makeText(this, getString(R.string.rc_notice_network_unavailable), 0).show();
            return;
        }
        MediaMessageContent mediaMessageContent = (MediaMessageContent) this.mMessage.getContent();
        if (mediaMessageContent != null && (mediaMessageContent.getMediaUrl() == null || TextUtils.isEmpty(mediaMessageContent.getMediaUrl().toString()))) {
            Toast.makeText(this, getString(R.string.rc_ac_file_url_error), 0).show();
            finish();
            return;
        }
        if (this.supportResumeTransfer == SupportResumeStatus.NOT_SET) {
            RongIM.getInstance().supportResumeBrokenTransfer(this.mFileMessage.getFileUrl().toString(), new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.activity.FilePreviewActivity.2
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                    filePreviewActivity.mFileDownloadInfo.state = 4;
                    filePreviewActivity.refreshDownloadState();
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Boolean bool) {
                    int i = FilePreviewActivity.this.mFileDownloadInfo.state;
                    if (i == 0 || i == 3 || i == 4 || i == 5) {
                        FilePreviewActivity.this.supportResumeTransfer = SupportResumeStatus.valueOf(bool.booleanValue() ? 1 : 0);
                        FilePreviewActivity.this.downloadFile();
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

    public Message getMessage() {
        return this.mMessage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.mFileButton) {
            if (view == this.mCancel) {
                FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
                if (fileDownloadInfo.state != 5) {
                    fileDownloadInfo.state = 5;
                    refreshDownloadState();
                    RongIM.getInstance().cancelDownloadMediaMessage(this.mMessage, null);
                    return;
                }
                return;
            }
            return;
        }
        FileDownloadInfo fileDownloadInfo2 = this.mFileDownloadInfo;
        switch (fileDownloadInfo2.state) {
            case 0:
            case 3:
            case 4:
            case 5:
                startToDownload();
                break;
            case 1:
            case 6:
                openFile(this.mFileName, this.mFileMessage.getLocalPath());
                break;
            case 2:
                if (this.supportResumeTransfer == SupportResumeStatus.SUPPORT) {
                    fileDownloadInfo2.state = 7;
                    RongIM.getInstance().pauseDownloadMediaMessage(this.mMessage, null);
                    this.info = getFileInfo();
                    FileInfo fileInfo = this.info;
                    if (fileInfo != null) {
                        this.downloadedFileLength = fileInfo.getFinished();
                    } else {
                        double size = this.mFileMessage.getSize();
                        double d2 = this.mFileDownloadInfo.progress;
                        Double.isNaN(d2);
                        Double.isNaN(size);
                        this.downloadedFileLength = (long) ((size * (d2 / 100.0d)) + 0.5d);
                    }
                    this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_pause, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileSize)}));
                    this.mFileButton.setText(getResources().getString(R.string.rc_ac_file_preview_download_resume));
                }
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

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.rc_ac_file_download);
        initView();
        initData();
        getFileMessageStatus();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        RongContext.getInstance().getEventBus().unregister(this);
        try {
            Iterator<Toast> it = this.mToasts.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        } catch (Exception e2) {
            RLog.e(TAG, "onDestroy", e2);
        }
        super.onDestroy();
    }

    public void onEventMainThread(Event.FileMessageEvent fileMessageEvent) {
        if (this.mMessage.getMessageId() == fileMessageEvent.getMessage().getMessageId()) {
            switch (fileMessageEvent.getCallBackType()) {
                case 100:
                    if (this.mFileDownloadInfo.state != 5 && fileMessageEvent.getMessage() != null && fileMessageEvent.getMessage().getContent() != null) {
                        if (fileMessageEvent.getMessage().getContent() instanceof FileMessage) {
                            this.mFileMessage = (FileMessage) fileMessageEvent.getMessage().getContent();
                            FileMessage fileMessage = this.mFileMessage;
                            fileMessage.setLocalPath(Uri.parse(fileMessage.getLocalPath().toString()));
                            this.mFileDownloadInfo.path = this.mFileMessage.getLocalPath().toString();
                        } else {
                            ReferenceMessage referenceMessage = (ReferenceMessage) fileMessageEvent.getMessage().getContent();
                            this.mFileMessage.setLocalPath(Uri.parse(referenceMessage.getLocalPath().toString()));
                            this.mFileDownloadInfo.path = referenceMessage.getLocalPath().toString();
                        }
                        this.mFileDownloadInfo.state = 6;
                        refreshDownloadState();
                        break;
                    }
                    break;
                case 101:
                    FileDownloadInfo fileDownloadInfo = this.mFileDownloadInfo;
                    int i = fileDownloadInfo.state;
                    if (i != 5 && i != 7) {
                        fileDownloadInfo.state = 2;
                        fileDownloadInfo.progress = fileMessageEvent.getProgress();
                        refreshDownloadState();
                        break;
                    }
                    break;
                case 102:
                    this.mFileDownloadInfo.state = 5;
                    refreshDownloadState();
                    break;
                case 103:
                    FileDownloadInfo fileDownloadInfo2 = this.mFileDownloadInfo;
                    if (fileDownloadInfo2.state != 5) {
                        fileDownloadInfo2.state = 4;
                        refreshDownloadState();
                    }
                    break;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.pausedPath = FileUtils.getTempFilePath(this, this.mMessage.getMessageId());
        getFileDownloadInfoInSubThread();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    public void openFile(String str, Uri uri) {
        try {
            if (!openInsidePreview(str, uri)) {
                Intent openFileIntent = FileTypeUtils.getOpenFileIntent(getApplicationContext(), str, uri);
                if (openFileIntent != null) {
                    openFileIntent.addFlags(1);
                    startActivity(openFileIntent);
                } else {
                    Toast.makeText(this, getString(R.string.rc_ac_file_preview_can_not_open_file), 0).show();
                }
            }
        } catch (Exception e2) {
            RLog.e(TAG, "openFile", e2);
            Toast.makeText(this, getString(R.string.rc_ac_file_preview_can_not_open_file), 0).show();
        }
    }

    protected boolean openInsidePreview(String str, Uri uri) {
        String string = uri.toString();
        if (string.endsWith(TXT_FILE)) {
            processTxtFile(str, uri);
            return true;
        }
        if (!string.endsWith(APK_FILE)) {
            return false;
        }
        processApkFile(uri);
        return true;
    }

    protected void refreshDownloadState() {
        switch (this.mFileDownloadInfo.state) {
            case 0:
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                break;
            case 1:
                this.mFileButton.setText(getString(R.string.rc_ac_file_download_open_file_btn));
                break;
            case 2:
                if (this.supportResumeTransfer != SupportResumeStatus.SUPPORT) {
                    this.mFileButton.setVisibility(8);
                    this.mDownloadProgressView.setVisibility(0);
                    this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                    double size = this.mFileMessage.getSize();
                    double d2 = this.mFileDownloadInfo.progress;
                    Double.isNaN(d2);
                    Double.isNaN(size);
                    this.mDownloadProgressTextView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize((long) ((size * (d2 / 100.0d)) + 0.5d)), FileTypeUtils.formatFileSize(this.mFileSize)}));
                } else {
                    this.mDownloadProgressView.setVisibility(0);
                    this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                    double size2 = this.mFileMessage.getSize();
                    double d3 = this.mFileDownloadInfo.progress;
                    Double.isNaN(d3);
                    Double.isNaN(size2);
                    this.downloadedFileLength = (long) ((size2 * (d3 / 100.0d)) + 0.5d);
                    this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_tv, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileSize)}));
                    this.mDownloadProgressTextView.setVisibility(8);
                    this.mFileButton.setText(getString(R.string.rc_cancel));
                }
                break;
            case 3:
                this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileSize));
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                break;
            case 4:
                if (this.supportResumeTransfer == SupportResumeStatus.SUPPORT) {
                    this.mDownloadProgressView.setVisibility(0);
                    this.info = getFileInfo();
                    FileInfo fileInfo = this.info;
                    if (fileInfo != null) {
                        this.mFileDownloadInfo.progress = (int) ((fileInfo.getFinished() * 100) / this.info.getLength());
                    }
                    this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                    double size3 = this.mFileMessage.getSize();
                    double d4 = this.mFileDownloadInfo.progress;
                    Double.isNaN(d4);
                    Double.isNaN(size3);
                    this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_pause, new Object[]{FileTypeUtils.formatFileSize((long) ((size3 * (d4 / 100.0d)) + 0.5d)), FileTypeUtils.formatFileSize(this.mFileSize)}));
                    this.mFileButton.setText(getString(R.string.rc_ac_file_preview_download_resume));
                } else {
                    this.mDownloadProgressView.setVisibility(8);
                    this.mFileButton.setVisibility(0);
                    this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileSize));
                    this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                }
                Toast toastMakeText = Toast.makeText(this, getString(R.string.rc_ac_file_preview_download_error), 0);
                if (this.mFileDownloadInfo.state != 5) {
                    toastMakeText.show();
                }
                this.mToasts.add(toastMakeText);
                break;
            case 5:
                this.mDownloadProgressView.setVisibility(8);
                this.mFileDownloadProgressBar.setProgress(0);
                this.mFileButton.setVisibility(0);
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_begin_download));
                this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileSize));
                Toast.makeText(this, getString(R.string.rc_ac_file_preview_download_cancel), 0).show();
                break;
            case 6:
                this.mDownloadProgressView.setVisibility(8);
                this.mFileButton.setVisibility(0);
                this.mFileButton.setText(getString(R.string.rc_ac_file_download_open_file_btn));
                this.mFileSizeView.setText(FileTypeUtils.formatFileSize(this.mFileSize));
                Toast.makeText(this, getString(R.string.rc_ac_file_preview_downloaded) + this.mFileDownloadInfo.path, 0).show();
                break;
            case 7:
                this.mDownloadProgressView.setVisibility(0);
                FileInfo fileInfo2 = this.info;
                if (fileInfo2 != null) {
                    this.mFileDownloadInfo.progress = (int) ((fileInfo2.getFinished() * 100) / this.info.getLength());
                    this.downloadedFileLength = this.info.getFinished();
                } else {
                    double size4 = this.mFileMessage.getSize();
                    double d5 = this.mFileDownloadInfo.progress;
                    Double.isNaN(d5);
                    Double.isNaN(size4);
                    this.downloadedFileLength = (long) ((size4 * (d5 / 100.0d)) + 0.5d);
                }
                this.mFileDownloadProgressBar.setProgress(this.mFileDownloadInfo.progress);
                this.mFileSizeView.setText(getString(R.string.rc_ac_file_download_progress_pause, new Object[]{FileTypeUtils.formatFileSize(this.downloadedFileLength), FileTypeUtils.formatFileSize(this.mFileSize)}));
                this.mFileButton.setText(getString(R.string.rc_ac_file_preview_download_resume));
                break;
        }
    }

    protected void resetMediaMessageLocalPath() {
        FileMessage fileMessage = this.mMessage.getContent() instanceof FileMessage ? (FileMessage) this.mMessage.getContent() : this.mMessage.getContent() instanceof ReferenceMessage ? (FileMessage) ((ReferenceMessage) this.mMessage.getContent()).getReferenceContent() : null;
        if (!(fileMessage instanceof FileMessage) || fileMessage.getLocalPath() == null || TextUtils.isEmpty(fileMessage.getLocalPath().toString())) {
            return;
        }
        fileMessage.setLocalPath(null);
        this.mFileMessage.setLocalPath(null);
        EventBus.getDefault().post(this.mMessage);
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    public void setContentView(int i) {
        this.contentContainer.removeAllViews();
        this.contentContainer.addView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        Message message = this.mMessage;
        if (message != null && message.getMessageId() == remoteMessageRecallEvent.getMessageId()) {
            new AlertDialog.Builder(this, 5).setMessage(getString(R.string.rc_recall_success)).setPositiveButton(getString(R.string.rc_dialog_ok), new DialogInterface.OnClickListener() { // from class: io.rong.imkit.activity.FilePreviewActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    FilePreviewActivity.this.finish();
                }
            }).setCancelable(false).show();
        }
    }
}
