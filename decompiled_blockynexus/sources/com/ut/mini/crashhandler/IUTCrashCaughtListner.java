package com.ut.mini.crashhandler;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IUTCrashCaughtListner {
    Map<String, String> onCrashCaught(Thread thread, Throwable th);
}
