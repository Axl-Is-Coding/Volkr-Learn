package com.sandboxol.common.utils;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.e;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RxPermissionsFragment2 extends Fragment {
    private static final int PERMISSIONS_REQUEST_CODE = 42;
    private boolean mLogging;
    private Map<String, PublishSubject<e>> mSubjects = new HashMap();

    public boolean containsByPermission(String str) {
        return this.mSubjects.containsKey(str);
    }

    public PublishSubject<e> getSubjectByPermission(String str) {
        return this.mSubjects.get(str);
    }

    @TargetApi(23)
    boolean isGranted(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.checkSelfPermission(str) == 0;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    @TargetApi(23)
    boolean isRevoked(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    void log(String str) {
        if (this.mLogging) {
            Log.d(RxPermissions2.TAG, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
            }
            onRequestPermissionsResult(strArr, iArr, zArr);
        }
    }

    @TargetApi(23)
    void requestPermissions(String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public void setLogging(boolean z) {
        this.mLogging = z;
    }

    public void setSubjectForPermission(String str, PublishSubject<e> publishSubject) {
        this.mSubjects.put(str, publishSubject);
    }

    void onRequestPermissionsResult(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            log("onRequestPermissionsResult  " + strArr[i]);
            PublishSubject<e> publishSubject = this.mSubjects.get(strArr[i]);
            if (publishSubject == null) {
                Log.e(RxPermissions2.TAG, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.mSubjects.remove(strArr[i]);
            publishSubject.onNext(new e(strArr[i], iArr[i] == 0, zArr[i]));
            publishSubject.onComplete();
        }
    }
}
