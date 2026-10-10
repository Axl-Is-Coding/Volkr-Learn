package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.l;
import com.google.android.gms.plus.PlusShare;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: NotificationCompatJellybean.java */
/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f1022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1023c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1021a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f1024d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f1021a) {
            if (f1023c) {
                return null;
            }
            try {
                if (f1022b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1023c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1022b = declaredField;
                }
                Bundle bundle = (Bundle) f1022b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1022b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1023c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f1023c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, l.a aVar) {
        builder.addAction(aVar.e(), aVar.j(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.g()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }

    static Bundle a(l.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.e());
        bundle2.putCharSequence("title", aVar.j());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.g()));
        bundle2.putBoolean("showsUserInterface", aVar.i());
        bundle2.putInt("semanticAction", aVar.h());
        return bundle2;
    }

    private static Bundle a(p pVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", pVar.g());
        bundle.putCharSequence(PlusShare.KEY_CALL_TO_ACTION_LABEL, pVar.f());
        bundle.putCharSequenceArray("choices", pVar.c());
        bundle.putBoolean("allowFreeFormInput", pVar.a());
        bundle.putBundle("extras", pVar.e());
        Set<String> setB = pVar.b();
        if (setB != null && !setB.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setB.size());
            Iterator<String> it = setB.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] a(p[] pVarArr) {
        if (pVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[pVarArr.length];
        for (int i = 0; i < pVarArr.length; i++) {
            bundleArr[i] = a(pVarArr[i]);
        }
        return bundleArr;
    }
}
