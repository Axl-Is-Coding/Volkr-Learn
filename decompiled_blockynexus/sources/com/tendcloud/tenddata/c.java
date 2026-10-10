package com.tendcloud.tenddata;

import android.app.Activity;
import android.os.Message;
import com.tendcloud.tenddata.zz;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class c {
    private c() {
    }

    static void a(Activity activity, final a aVar) {
        try {
            ab.n = 0;
            zz.b().removeMessages(0);
            if (activity == null || (activity.getChangingConfigurations() & 128) != 128) {
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            zz.a aVar2 = new zz.a();
                            aVar2.paraMap.put("apiType", 10);
                            aVar2.paraMap.put("occurTime", Long.valueOf(System.currentTimeMillis()));
                            aVar2.paraMap.put("service", aVar);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } else {
                m.iForDeveloper("Ignore page changing during screen switch");
                zz.f20077d = true;
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    static void b(final Activity activity, final a aVar) {
        try {
            if (ab.F) {
                ab.n = 1;
                zz.b().removeMessages(0);
                Message messageObtain = Message.obtain();
                messageObtain.obj = aVar;
                messageObtain.what = 0;
                zz.b().sendMessageDelayed(messageObtain, ab.R);
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            zz.a aVar2 = new zz.a();
                            aVar2.paraMap.put("apiType", 11);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("pageName", activity != null ? activity.getLocalClassName() : "");
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    static void a(a aVar) {
        if (ab.F || !a()) {
            return;
        }
        a(null, aVar);
    }

    private static boolean a() {
        boolean zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) Class.forName("android.app.Activity").getDeclaredMethod("isResumed", new Class[0]).invoke(b(), new Object[0])).booleanValue();
            ab.F = true;
            return zBooleanValue;
        } catch (Throwable th) {
            m.eForInternal(th);
            return zBooleanValue;
        }
    }

    private static Activity b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
        } catch (Throwable unused) {
        }
        for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                return (Activity) declaredField3.get(obj);
            }
            return null;
        }
        return null;
    }
}
