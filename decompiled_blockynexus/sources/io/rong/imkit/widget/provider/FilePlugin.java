package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.RongIM;
import io.rong.imkit.activity.FileManagerActivity;
import io.rong.imkit.model.FileInfo;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.IPluginRequestPermissionResultCallback;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.FileMessage;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public class FilePlugin implements IPluginModule, IPluginRequestPermissionResultCallback {
    private static final int REQUEST_FILE = 100;
    private static final int REQUEST_FILE_Q = 101;
    private static final String TAG = "FileInputProvider";
    private static final int TIME_DELAY = 400;
    private Conversation.ConversationType conversationType;
    private String targetId;

    private static class SendMediaMessageThread extends Thread {
        private Conversation.ConversationType conversationType;
        private HashSet<FileInfo> selectedFileInfos;
        private String targetId;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            for (FileInfo fileInfo : this.selectedFileInfos) {
                FileMessage fileMessageObtain = FileMessage.obtain(Uri.parse("file://" + fileInfo.getFilePath()));
                if (fileMessageObtain != null) {
                    fileMessageObtain.setType(fileInfo.getSuffix());
                    RongIM.getInstance().sendMediaMessage(Message.obtain(this.targetId, this.conversationType, fileMessageObtain), (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException e2) {
                        RLog.e(FilePlugin.TAG, "sendMediaMessage e:" + e2.toString());
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        private SendMediaMessageThread(Conversation.ConversationType conversationType, String str, HashSet<FileInfo> hashSet) {
            this.conversationType = conversationType;
            this.targetId = str;
            this.selectedFileInfos = hashSet;
        }
    }

    private static class SendMediaMessageThreadForQ extends Thread {
        private Conversation.ConversationType conversationType;
        private String targetId;
        private Uri uri;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileMessage fileMessageObtain = FileMessage.obtain(RongIM.getInstance().getApplicationContext(), this.uri);
            if (fileMessageObtain != null) {
                RongIM.getInstance().sendMediaMessage(Message.obtain(this.targetId, this.conversationType, fileMessageObtain), (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);
                try {
                    Thread.sleep(400L);
                } catch (InterruptedException e2) {
                    RLog.e(FilePlugin.TAG, "sendMediaMessage e:" + e2.toString());
                    Thread.currentThread().interrupt();
                }
            }
        }

        private SendMediaMessageThreadForQ(Conversation.ConversationType conversationType, String str, Uri uri) {
            this.conversationType = conversationType;
            this.targetId = str;
            this.uri = uri;
        }
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_ic_files_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_plugins_files);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100) {
            if (intent != null) {
                new SendMediaMessageThread(this.conversationType, this.targetId, (HashSet) intent.getSerializableExtra("sendSelectedFiles")).start();
                return;
            }
            return;
        }
        if (i != 101 || intent == null) {
            return;
        }
        new SendMediaMessageThreadForQ(this.conversationType, this.targetId, intent.getData()).start();
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        this.conversationType = rongExtension.getConversationType();
        this.targetId = rongExtension.getTargetId();
        if (LibStorageUtils.isBuildAndTargetForQ(fragment.getContext())) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            rongExtension.startActivityForPluginResult(intent, 101, this);
            return;
        }
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        if (PermissionCheckUtil.checkPermissions(fragment.getContext(), strArr)) {
            rongExtension.startActivityForPluginResult(new Intent(fragment.getActivity(), (Class<?>) FileManagerActivity.class), 100, this);
        } else {
            rongExtension.requestPermissionForPluginResult(strArr, 255, this);
        }
    }

    @Override // io.rong.imkit.plugin.IPluginRequestPermissionResultCallback
    public boolean onRequestPermissionResult(Fragment fragment, RongExtension rongExtension, int i, String[] strArr, int[] iArr) {
        if (PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
            rongExtension.startActivityForPluginResult(new Intent(fragment.getActivity(), (Class<?>) FileManagerActivity.class), 100, this);
            return true;
        }
        rongExtension.showRequestPermissionFailedAlter(PermissionCheckUtil.getNotGrantedPermissionMsg(fragment.getActivity(), strArr, iArr));
        return true;
    }
}
