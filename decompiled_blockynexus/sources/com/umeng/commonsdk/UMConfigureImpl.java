package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class UMConfigureImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f21030a = "delayed_transmission_flag_new";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f21034e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f21035f;
    private static Context g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f21031b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f21032c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f21033d = false;
    private static int h = 0;
    private static Runnable i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f21032c == 0 || UMConfigureImpl.h >= 10) {
                    if (!UMConfigureImpl.f21033d) {
                        boolean unused = UMConfigureImpl.f21033d = true;
                        UMConfigureImpl.b(UMConfigureImpl.g);
                    }
                    if (UMConfigureImpl.f21035f != null) {
                        UMConfigureImpl.f21035f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f21035f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        g = context;
        try {
            if (f21032c < 1 || d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f21035f == null) {
                    f21035f = Executors.newScheduledThreadPool(1);
                    f21035f.scheduleAtFixedRate(i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        try {
            f21032c++;
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (f21031b != null) {
                f21031b.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && f21031b != null && f21031b.size() > 0) {
                Iterator<onMessageSendListener> it = f21031b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeInterruptFlag() {
        try {
            f21032c--;
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (f21031b != null) {
                f21031b.remove(onmessagesendlistener);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        try {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            if (f21031b != null && f21031b.size() > 0) {
                Iterator<onMessageSendListener> it = f21031b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f21030a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(f21030a, true);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f21030a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(f21030a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
