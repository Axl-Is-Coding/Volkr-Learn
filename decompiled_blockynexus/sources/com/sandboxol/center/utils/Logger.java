package com.sandboxol.center.utils;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    public static final String DEFAULT_TAG = "Logger";

    public enum TYPE {
        NORMAL(" "),
        WITH_PATH("%c{-3}"),
        WITH_THREAD("%t Thread:"),
        WITH_THREAD_PATH("%t Thread: %c{-3}"),
        WITH_TIME_THREAD_PATH("%d{HH:mm:ss} - %t Thread: %c{-3}");

        private String format;

        TYPE(String str) {
            this.format = str;
        }

        public String getFormat() {
            return this.format;
        }
    }

    public static void config(TYPE type, boolean z) {
        com.apkfuns.logutils.a aVarA = com.apkfuns.logutils.c.a();
        aVarA.a(z);
        aVarA.a(type.getFormat());
    }
}
