package com.sandboxol.center.utils;

import android.content.Context;
import com.sandboxol.center.provider.MultiThreadHelper;
import com.sandboxol.center.provider.SharedProvider;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class MultiProcessSharedUtils {
    public static void getBoolean(final Context context, final String str, final Action1<Boolean> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<Boolean>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.7
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(false);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public Boolean onExecute() {
                return Boolean.valueOf(SharedProvider.getBoolean(context, str));
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(Boolean bool) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(bool);
                }
            }
        });
    }

    public static boolean getBooleanSync(Context context, String str) {
        return SharedProvider.getBoolean(context, str);
    }

    public static void getInt(final Context context, final String str, final Action1<Integer> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<Integer>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.3
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(0);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public Integer onExecute() {
                return Integer.valueOf(SharedProvider.getInt(context, str));
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(Integer num) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(num);
                }
            }
        });
    }

    public static int getIntSync(Context context, String str) {
        return SharedProvider.getInt(context, str);
    }

    public static void getLong(final Context context, final String str, final Action1<Long> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<Long>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.5
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(0L);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public Long onExecute() {
                return Long.valueOf(SharedProvider.getLong(context, str));
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(Long l) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(l);
                }
            }
        });
    }

    public static long getLongSync(Context context, String str) {
        return SharedProvider.getLong(context, str);
    }

    public static void getString(final Context context, final String str, final Action1<String> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<String>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.1
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call("");
                }
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public String onExecute() {
                return SharedProvider.getString(context, str);
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(String str2) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(str2);
                }
            }
        });
    }

    public static String getStringSync(Context context, String str) {
        return SharedProvider.getString(context, str);
    }

    public static void putBoolean(final Context context, final String str, final boolean z) {
        MultiThreadHelper.post(new Runnable() { // from class: com.sandboxol.center.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                SharedProvider.putBoolean(context, str, z);
            }
        });
    }

    public static void putInt(final Context context, final String str, final int i) {
        MultiThreadHelper.post(new Runnable() { // from class: com.sandboxol.center.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                SharedProvider.putInt(context, str, i);
            }
        });
    }

    public static void putLong(final Context context, final String str, final long j) {
        MultiThreadHelper.post(new Runnable() { // from class: com.sandboxol.center.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                SharedProvider.putLong(context, str, j);
            }
        });
    }

    public static void putString(final Context context, final String str, final String str2) {
        MultiThreadHelper.post(new Runnable() { // from class: com.sandboxol.center.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                SharedProvider.putString(context, str, str2);
            }
        });
    }

    public static void getBoolean(final Context context, final String str, final boolean z, final Action1<Boolean> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<Boolean>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.8
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(Boolean.valueOf(z));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public Boolean onExecute() {
                return Boolean.valueOf(SharedProvider.getBoolean(context, str, z));
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(Boolean bool) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(bool);
                }
            }
        });
    }

    public static boolean getBooleanSync(Context context, String str, boolean z) {
        return SharedProvider.getBoolean(context, str, z);
    }

    public static void getInt(final Context context, final String str, final int i, final Action1<Integer> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<Integer>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.4
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(Integer.valueOf(i));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public Integer onExecute() {
                return Integer.valueOf(SharedProvider.getInt(context, str, i));
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(Integer num) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(num);
                }
            }
        });
    }

    public static int getIntSync(Context context, String str, int i) {
        return SharedProvider.getInt(context, str, i);
    }

    public static void getLong(final Context context, final String str, final long j, final Action1<Long> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<Long>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.6
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(Long.valueOf(j));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public Long onExecute() {
                return Long.valueOf(SharedProvider.getLong(context, str, j));
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(Long l) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(l);
                }
            }
        });
    }

    public static long getLongSync(Context context, String str, long j) {
        return SharedProvider.getLong(context, str, j);
    }

    public static void getString(final Context context, final String str, final String str2, final Action1<String> action1) {
        MultiThreadHelper.post(new MultiThreadHelper.AsyncRun<String>() { // from class: com.sandboxol.center.utils.MultiProcessSharedUtils.2
            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onError(Throwable th) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(str2);
                }
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public String onExecute() {
                return SharedProvider.getString(context, str, str2);
            }

            @Override // com.sandboxol.center.provider.MultiThreadHelper.AsyncRun
            public void onSuccess(String str3) {
                Action1 action12 = action1;
                if (action12 != null) {
                    action12.call(str3);
                }
            }
        });
    }

    public static String getStringSync(Context context, String str, String str2) {
        return SharedProvider.getString(context, str, str2);
    }
}
