package io.rong.imkit.voiceMessageDownload;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import io.rong.common.RLog;
import io.rong.imkit.RongIM;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.NetUtils;
import io.rong.imlib.model.Message;
import io.rong.message.HQVoiceMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public class HQVoiceMsgDownloadManager {
    private static final int REQUEST_MSG_DOWNLOAD_PERMISSION = 1001;
    private static final String TAG = "HQVoiceMsgDownloadManager";
    private final AutoDownloadQueue autoDownloadQueue;
    private List<AutoDownloadEntry> errorList;
    private ExecutorService executorService;
    private Future<?> future;
    private Context mContext;

    private static class HQVoiceMsgDownloadManagerHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static HQVoiceMsgDownloadManager instance = new HQVoiceMsgDownloadManager();

        private HQVoiceMsgDownloadManagerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message dequeue() {
        return this.autoDownloadQueue.dequeue();
    }

    private void downloadHQVoiceMessage() {
        this.future = this.executorService.submit(new Runnable() { // from class: io.rong.imkit.voiceMessageDownload.HQVoiceMsgDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    synchronized (HQVoiceMsgDownloadManager.this.autoDownloadQueue) {
                        if (HQVoiceMsgDownloadManager.this.autoDownloadQueue.isEmpty()) {
                            try {
                                HQVoiceMsgDownloadManager.this.autoDownloadQueue.wait();
                            } catch (InterruptedException e2) {
                                RLog.e(HQVoiceMsgDownloadManager.TAG, "downloadHQVoiceMessage e:" + e2.toString());
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    RongIM.getInstance().downloadMediaMessage(HQVoiceMsgDownloadManager.this.dequeue(), new IRongCallback.IDownloadMediaMessageCallback() { // from class: io.rong.imkit.voiceMessageDownload.HQVoiceMsgDownloadManager.1.1
                        @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
                        public void onCanceled(Message message) {
                        }

                        @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
                        public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                            if (HQVoiceMsgDownloadManager.this.errorList == null || HQVoiceMsgDownloadManager.this.errorList.contains(HQVoiceMsgDownloadManager.this.getMsgEntry(message))) {
                                return;
                            }
                            HQVoiceMsgDownloadManager.this.errorList.add(HQVoiceMsgDownloadManager.this.getMsgEntry(message));
                            RLog.i(HQVoiceMsgDownloadManager.TAG, "onError = " + errorCode.getValue() + " errorList size = " + HQVoiceMsgDownloadManager.this.errorList.size());
                        }

                        @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
                        public void onProgress(Message message, int i) {
                            RLog.d(HQVoiceMsgDownloadManager.TAG, "downloadMediaMessage onProgress");
                        }

                        @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
                        public void onSuccess(Message message) {
                            RLog.d(HQVoiceMsgDownloadManager.TAG, "downloadMediaMessage success");
                            if (HQVoiceMsgDownloadManager.this.errorList != null) {
                                HQVoiceMsgDownloadManager.this.errorList.remove(HQVoiceMsgDownloadManager.this.getMsgEntry(message));
                            }
                            HQVoiceMsgDownloadManager.this.removeUidInHashMap(message.getUId());
                        }
                    });
                }
            }
        });
    }

    public static HQVoiceMsgDownloadManager getInstance() {
        return HQVoiceMsgDownloadManagerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutoDownloadEntry getMsgEntry(Message message) {
        if (message != null && this.autoDownloadQueue.getAutoDownloadEntryHashMap().containsKey(message.getUId())) {
            return this.autoDownloadQueue.getAutoDownloadEntryHashMap().get(message.getUId());
        }
        return null;
    }

    private boolean ifMsgInHashMap(Message message) {
        return this.autoDownloadQueue.ifMsgInHashMap(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeUidInHashMap(String str) {
        this.autoDownloadQueue.getAutoDownloadEntryHashMap().remove(str);
    }

    public void enqueue(Fragment fragment, AutoDownloadEntry autoDownloadEntry) {
        if (autoDownloadEntry == null) {
            return;
        }
        Message message = autoDownloadEntry.getMessage();
        if (message.getContent() instanceof HQVoiceMessage) {
            if (!ifMsgInHashMap(message) || fragment == null) {
                String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
                if (fragment != null && fragment.isAdded() && !PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
                    PermissionCheckUtil.requestPermissions(fragment, strArr, 1001);
                }
                HQVoiceMessage hQVoiceMessage = (HQVoiceMessage) message.getContent();
                if (hQVoiceMessage.getLocalPath() == null || TextUtils.isEmpty(hQVoiceMessage.getLocalPath().toString())) {
                    synchronized (this.autoDownloadQueue) {
                        boolean zIsEmpty = this.autoDownloadQueue.isEmpty();
                        this.autoDownloadQueue.enqueue(autoDownloadEntry);
                        if (zIsEmpty) {
                            this.autoDownloadQueue.notify();
                        }
                        if (this.future.isDone() && NetUtils.isNetWorkAvailable(this.mContext)) {
                            downloadHQVoiceMessage();
                        }
                    }
                }
            }
        }
    }

    public void init(Context context) {
        AutoDownloadNetWorkChangeReceiver autoDownloadNetWorkChangeReceiver = new AutoDownloadNetWorkChangeReceiver();
        this.mContext = context.getApplicationContext();
        this.executorService = Executors.newSingleThreadExecutor();
        this.errorList = new ArrayList();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.getApplicationContext().registerReceiver(autoDownloadNetWorkChangeReceiver, intentFilter);
        } catch (Exception e2) {
            RLog.e(TAG, "registerReceiver Exception", e2);
        }
        downloadHQVoiceMessage();
    }

    void pauseDownloadService() {
    }

    public void resumeDownloadService() {
        List<AutoDownloadEntry> list = this.errorList;
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.future.isDone() && NetUtils.isNetWorkAvailable(this.mContext)) {
            downloadHQVoiceMessage();
        }
        for (int size = this.errorList.size() - 1; size >= 0; size--) {
            enqueue(this.errorList.get(size));
        }
    }

    private HQVoiceMsgDownloadManager() {
        this.autoDownloadQueue = new AutoDownloadQueue();
        this.future = null;
        this.errorList = null;
    }

    private void enqueue(AutoDownloadEntry autoDownloadEntry) {
        enqueue(null, autoDownloadEntry);
    }
}
