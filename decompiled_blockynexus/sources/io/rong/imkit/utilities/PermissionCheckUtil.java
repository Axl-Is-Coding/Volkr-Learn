package io.rong.imkit.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.h;
import androidx.fragment.app.Fragment;
import io.rong.common.RLog;
import io.rong.imkit.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PermissionCheckUtil {
    private static final String TAG = "PermissionCheckUtil";

    @TargetApi(19)
    public static boolean canDrawOverlays(Context context) {
        return canDrawOverlays(context, true);
    }

    public static boolean checkPermissions(Context context, String[] strArr) {
        if (strArr.length == 0) {
            return true;
        }
        for (String str : strArr) {
            if ((isFlyme() || Build.VERSION.SDK_INT < 23) && str.equals("android.permission.RECORD_AUDIO")) {
                RLog.i(TAG, "Build.MODEL = " + Build.MODEL);
                if (Build.BRAND.toLowerCase().equals("meizu") && Build.MODEL.equals("M1852")) {
                    return hasPermission(context, str);
                }
                if (!hasRecordPermision(context)) {
                    return false;
                }
            } else if (!hasPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static String getNotGrantedPermissionMsg(Context context, String[] strArr, int[] iArr) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getResources().getString(R.string.rc_permission_grant_needed));
            sb.append("(");
            for (int i = 0; i < strArr.length; i++) {
                try {
                    if (iArr[i] == -1) {
                        sb.append(context.getString(context.getResources().getIdentifier("rc_" + strArr[i], "string", context.getPackageName()), 0));
                        if (i != strArr.length - 1) {
                            sb.append(" ");
                        }
                    }
                } catch (Resources.NotFoundException unused) {
                    RLog.e(TAG, "One of the permissions is not recognized by SDK." + Arrays.toString(strArr));
                }
            }
            sb.append(")");
            return sb.toString();
        }
        return "";
    }

    private static boolean hasPermission(Context context, String str) {
        if (h.a(str) == null) {
            return true;
        }
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    private static boolean hasRecordPermision(Context context) {
        AudioRecord audioRecord;
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 12, 2);
        boolean z = false;
        if (minBufferSize < 0) {
            RLog.e(TAG, "bufferSizeInBytes = " + minBufferSize);
            return false;
        }
        AudioRecord audioRecord2 = null;
        try {
            audioRecord = new AudioRecord(1, 44100, 12, 2, minBufferSize);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            audioRecord.startRecording();
            audioRecord2 = audioRecord;
        } catch (Exception e3) {
            e = e3;
            audioRecord2 = audioRecord;
            RLog.e(TAG, "hasRecordPermision", e);
        }
        if (audioRecord2 == null) {
            RLog.e(TAG, "audioRecord is null");
            return false;
        }
        if (audioRecord2.getRecordingState() == 3) {
            audioRecord2.stop();
            z = true;
        }
        audioRecord2.release();
        return z;
    }

    private static boolean isFlyme() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception e2) {
            RLog.e(TAG, "isFlyme", e2);
        }
        return str != null && str.toLowerCase().contains("flyme");
    }

    public static boolean requestPermissions(Fragment fragment, String[] strArr) {
        return requestPermissions(fragment, strArr, 0);
    }

    @TargetApi(11)
    private static void showPermissionAlert(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(context).setMessage(str).setPositiveButton(R.string.rc_confirm, onClickListener).setNegativeButton(R.string.rc_cancel, onClickListener).setCancelable(false).create().show();
    }

    public static void showRequestPermissionFailedAlter(final Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: io.rong.imkit.utilities.PermissionCheckUtil.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i != -1) {
                    return;
                }
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                context.startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= 21) {
            new AlertDialog.Builder(context, android.R.style.Theme.Material.Light.Dialog.Alert).setMessage(str).setPositiveButton(R.string.rc_confirm, onClickListener).setNegativeButton(R.string.rc_cancel, onClickListener).setCancelable(false).create().show();
        } else {
            new AlertDialog.Builder(context).setMessage(str).setPositiveButton(R.string.rc_confirm, onClickListener).setNegativeButton(R.string.rc_cancel, onClickListener).setCancelable(false).create().show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fc  */
    @android.annotation.TargetApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean canDrawOverlays(final android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.PermissionCheckUtil.canDrawOverlays(android.content.Context, boolean):boolean");
    }

    public static boolean requestPermissions(final Fragment fragment, String[] strArr, int i) {
        if (strArr.length == 0 || fragment.getActivity() == null || fragment.isDetached()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if ((isFlyme() || Build.VERSION.SDK_INT < 23) && str.equals("android.permission.RECORD_AUDIO")) {
                showPermissionAlert(fragment.getContext(), fragment.getString(R.string.rc_permission_grant_needed) + fragment.getString(R.string.rc_permission_microphone), new DialogInterface.OnClickListener() { // from class: io.rong.imkit.utilities.PermissionCheckUtil.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (-1 == i2) {
                            fragment.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }
                });
                return false;
            }
            if (!hasPermission(fragment.getActivity(), str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        fragment.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i);
        return false;
    }

    public static boolean requestPermissions(Activity activity, String[] strArr) {
        return requestPermissions(activity, strArr, 0);
    }

    private static String getNotGrantedPermissionMsg(Context context, List<String> list) {
        if (list != null && list.size() != 0) {
            HashSet hashSet = new HashSet();
            try {
                for (String str : list) {
                    hashSet.add(context.getString(context.getResources().getIdentifier("rc_" + str, "string", context.getPackageName()), 0));
                }
                StringBuilder sb = new StringBuilder("(");
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    sb.append((String) it.next());
                    sb.append(" ");
                }
                return new StringBuilder(sb.toString().trim() + ")").toString();
            } catch (Resources.NotFoundException unused) {
                RLog.e(TAG, "one of the permissions is not recognized by SDK." + list.toString());
            }
        }
        return "";
    }

    @TargetApi(23)
    public static boolean requestPermissions(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT < 23 || strArr.length == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!hasPermission(activity, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i);
        return false;
    }
}
