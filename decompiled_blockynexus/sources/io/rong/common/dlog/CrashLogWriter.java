package io.rong.common.dlog;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class CrashLogWriter extends SimpleLogWriter {
    public CrashLogWriter(String str) {
        super(str + File.separator + LogEntity.CrashLogFileName);
    }

    @Override // io.rong.common.dlog.SimpleLogWriter, io.rong.common.dlog.LogWriter
    public void write(String str) {
        internalWrite(str);
    }
}
