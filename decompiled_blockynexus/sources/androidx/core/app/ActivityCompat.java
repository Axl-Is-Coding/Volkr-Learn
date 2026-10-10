package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends androidx.core.content.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f932c;

    public interface a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean a(Activity activity, int i, int i2, Intent intent);

        boolean a(Activity activity, String[] strArr, int i);
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends SharedElementCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f933a;

        d(q qVar) {
            this.f933a = qVar;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f933a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f933a.a(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f933a.a(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f933a.a(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f933a.a(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f933a.b(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f933a.a(list, list2, new androidx.core.app.b(this, onSharedElementsReadyListener));
        }
    }

    protected ActivityCompat() {
    }

    public static b a() {
        return f932c;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            if (g.a(activity)) {
                return;
            }
            activity.recreate();
        }
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void setEnterSharedElementCallback(Activity activity, q qVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(qVar != null ? new d(qVar) : null);
        }
    }

    public static void setExitSharedElementCallback(Activity activity, q qVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(qVar != null ? new d(qVar) : null);
        }
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, String[] strArr, int i) {
        b bVar = f932c;
        if (bVar == null || !bVar.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof a) {
                new Handler(Looper.getMainLooper()).post(new androidx.core.app.a(strArr, activity, i));
            }
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
