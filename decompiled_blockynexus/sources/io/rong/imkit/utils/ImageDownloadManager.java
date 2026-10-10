package io.rong.imkit.utils;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class ImageDownloadManager {
    private static final String TAG = "ImageDownloadManager";
    private static ImageDownloadManager instance;
    private static Context mContext;
    private DownloadManager downloadManager;
    private DownloadStatusListener downloadStatusListener;
    private String imageString;
    private long taskId;
    private String savePath = "download";
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: io.rong.imkit.utils.ImageDownloadManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ImageDownloadManager.this.checkDownloadStatus();
        }
    };

    public enum DownloadStatusError {
        DEVICE_DISABLE,
        DOWNLOAD_FAILED
    }

    public interface DownloadStatusListener {
        void downloadFailed(DownloadStatusError downloadStatusError);

        void downloadSuccess(String str, Bitmap bitmap);
    }

    private ImageDownloadManager() {
        Context context = mContext;
        if (context == null) {
            throw new NullPointerException("mContext is empty ,need invoke init!");
        }
        this.downloadManager = (DownloadManager) context.getSystemService("download");
    }

    private boolean canDownloadManagerState() {
        try {
            int applicationEnabledSetting = mContext.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownloadStatus() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(getTaskId());
        Cursor cursorQuery = this.downloadManager.query(query);
        if (cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
            if (i == 1) {
                Log.e(TAG, "STATUS_PENDING");
                return;
            }
            if (i == 2) {
                Log.e(TAG, "STATUS_RUNNING");
                return;
            }
            if (i == 4) {
                Log.e(TAG, "STATUS_PAUSED");
                return;
            }
            if (i != 8) {
                if (i != 16) {
                    return;
                }
                this.downloadStatusListener.downloadFailed(DownloadStatusError.DOWNLOAD_FAILED);
                Log.e(TAG, "STATUS_FAILED");
                return;
            }
            String str = mContext.getExternalFilesDir(this.savePath) + "/" + this.imageString + ".jpg";
            this.downloadStatusListener.downloadSuccess("file://" + str, null);
            mContext.unregisterReceiver(this.receiver);
            Log.e(TAG, "STATUS_SUCCESSFUL PATH: " + str);
        }
    }

    public static ImageDownloadManager getInstance() {
        if (instance == null) {
            synchronized (ImageDownloadManager.class) {
                if (instance == null) {
                    instance = new ImageDownloadManager();
                }
            }
        }
        return instance;
    }

    private long getTaskId() {
        return this.taskId;
    }

    public static void init(Context context) {
        mContext = context;
    }

    private void setTaskId(long j) {
        this.taskId = j;
    }

    public void downloadImage(String str, DownloadStatusListener downloadStatusListener) {
        if (TextUtils.isEmpty(str) && downloadStatusListener == null) {
            throw new NullPointerException("parameter is error");
        }
        this.downloadStatusListener = downloadStatusListener;
        if (!canDownloadManagerState()) {
            Log.e(TAG, "DownloadManager is disable or Device ROM remove it");
            downloadStatusListener.downloadFailed(DownloadStatusError.DEVICE_DISABLE);
            return;
        }
        this.imageString = str.substring(str.length() - 7);
        String str2 = mContext.getExternalFilesDir(this.savePath) + "/" + this.imageString + ".jpg";
        if (new File(str2).exists()) {
            downloadStatusListener.downloadSuccess(str2, null);
            return;
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalFilesDir(mContext, this.savePath, this.imageString + ".jpg");
            setTaskId(this.downloadManager.enqueue(request));
            mContext.registerReceiver(this.receiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "Can only download HTTP/HTTPS URIs");
            downloadStatusListener.downloadFailed(DownloadStatusError.DOWNLOAD_FAILED);
        } catch (IllegalStateException unused2) {
            Log.e(TAG, "The external storage directory cannot be found or created");
            downloadStatusListener.downloadFailed(DownloadStatusError.DOWNLOAD_FAILED);
        } catch (SecurityException unused3) {
            Log.e(TAG, "downloadImage securityException");
            downloadStatusListener.downloadFailed(DownloadStatusError.DOWNLOAD_FAILED);
        }
    }
}
