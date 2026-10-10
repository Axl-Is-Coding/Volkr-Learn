package com.just.agentweb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ActionActivity extends Activity {
    public static final String KEY_ACTION = "KEY_ACTION";
    public static final String KEY_FILE_CHOOSER_INTENT = "KEY_FILE_CHOOSER_INTENT";
    public static final String KEY_FROM_INTENTION = "KEY_FROM_INTENTION";
    public static final String KEY_URI = "KEY_URI";
    public static final int REQUEST_CODE = 596;
    private static final String TAG = "ActionActivity";
    private static ChooserListener mChooserListener;
    private static PermissionListener mPermissionListener;
    private static RationaleListener mRationaleListener;
    private Action mAction;
    private Uri mUri;

    public interface ChooserListener {
        void onChoiceResult(int i, int i2, Intent intent);
    }

    public interface PermissionListener {
        void onRequestPermissionsResult(String[] strArr, int[] iArr, Bundle bundle);
    }

    public interface RationaleListener {
        void onRationaleResult(boolean z, Bundle bundle);
    }

    private void cancelAction() {
        mChooserListener = null;
        mPermissionListener = null;
        mRationaleListener = null;
    }

    private void chooserActionCallback(int i, Intent intent) {
        ChooserListener chooserListener = mChooserListener;
        if (chooserListener != null) {
            chooserListener.onChoiceResult(REQUEST_CODE, i, intent);
            mChooserListener = null;
        }
        finish();
    }

    private void fetchFile(Action action) {
        if (mChooserListener == null) {
            finish();
        }
        realOpenFileChooser();
    }

    private void permission(Action action) {
        ArrayList<String> permissions = action.getPermissions();
        if (AgentWebUtils.isEmptyCollection(permissions)) {
            mPermissionListener = null;
            mRationaleListener = null;
            finish();
            return;
        }
        boolean zShouldShowRequestPermissionRationale = false;
        if (mRationaleListener == null) {
            if (mPermissionListener != null) {
                requestPermissions((String[]) permissions.toArray(new String[0]), 1);
            }
        } else {
            Iterator<String> it = permissions.iterator();
            while (it.hasNext() && !(zShouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale(it.next()))) {
            }
            mRationaleListener.onRationaleResult(zShouldShowRequestPermissionRationale, new Bundle());
            mRationaleListener = null;
            finish();
        }
    }

    private void realOpenCamera() {
        try {
            if (mChooserListener == null) {
                finish();
            }
            File fileCreateImageFile = AgentWebUtils.createImageFile(this);
            if (fileCreateImageFile == null) {
                mChooserListener.onChoiceResult(REQUEST_CODE, 0, null);
                mChooserListener = null;
                finish();
            }
            Intent intentCaptureCompat = AgentWebUtils.getIntentCaptureCompat(this, fileCreateImageFile);
            this.mUri = (Uri) intentCaptureCompat.getParcelableExtra("output");
            startActivityForResult(intentCaptureCompat, REQUEST_CODE);
        } catch (Throwable th) {
            LogUtils.e(TAG, "找不到系统相机");
            ChooserListener chooserListener = mChooserListener;
            if (chooserListener != null) {
                chooserListener.onChoiceResult(REQUEST_CODE, 0, null);
            }
            mChooserListener = null;
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    private void realOpenFileChooser() {
        try {
            if (mChooserListener == null) {
                finish();
                return;
            }
            Intent intent = (Intent) getIntent().getParcelableExtra(KEY_FILE_CHOOSER_INTENT);
            if (intent == null) {
                cancelAction();
            } else {
                startActivityForResult(intent, REQUEST_CODE);
            }
        } catch (Throwable th) {
            LogUtils.i(TAG, "找不到文件选择器");
            chooserActionCallback(-1, null);
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    private void realOpenVideo() {
        try {
            if (mChooserListener == null) {
                finish();
            }
            File fileCreateVideoFile = AgentWebUtils.createVideoFile(this);
            if (fileCreateVideoFile == null) {
                mChooserListener.onChoiceResult(REQUEST_CODE, 0, null);
                mChooserListener = null;
                finish();
            }
            Intent intentVideoCompat = AgentWebUtils.getIntentVideoCompat(this, fileCreateVideoFile);
            this.mUri = (Uri) intentVideoCompat.getParcelableExtra("output");
            startActivityForResult(intentVideoCompat, REQUEST_CODE);
        } catch (Throwable th) {
            LogUtils.e(TAG, "找不到系统相机");
            ChooserListener chooserListener = mChooserListener;
            if (chooserListener != null) {
                chooserListener.onChoiceResult(REQUEST_CODE, 0, null);
            }
            mChooserListener = null;
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    public static void setChooserListener(ChooserListener chooserListener) {
        mChooserListener = chooserListener;
    }

    public static void setPermissionListener(PermissionListener permissionListener) {
        mPermissionListener = permissionListener;
    }

    public static void start(Activity activity, Action action) {
        Intent intent = new Intent(activity, (Class<?>) ActionActivity.class);
        intent.putExtra(KEY_ACTION, action);
        activity.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 596) {
            if (this.mUri != null) {
                intent = new Intent().putExtra(KEY_URI, this.mUri);
            }
            chooserActionCallback(i2, intent);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            LogUtils.i(TAG, "savedInstanceState:" + bundle);
            return;
        }
        this.mAction = (Action) getIntent().getParcelableExtra(KEY_ACTION);
        Action action = this.mAction;
        if (action == null) {
            cancelAction();
            finish();
        } else {
            if (action.getAction() == 1) {
                permission(this.mAction);
                return;
            }
            if (this.mAction.getAction() == 3) {
                realOpenCamera();
            } else if (this.mAction.getAction() == 4) {
                realOpenVideo();
            } else {
                fetchFile(this.mAction);
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (mPermissionListener != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_FROM_INTENTION, this.mAction.getFromIntention());
            mPermissionListener.onRequestPermissionsResult(strArr, iArr, bundle);
        }
        mPermissionListener = null;
        finish();
    }
}
