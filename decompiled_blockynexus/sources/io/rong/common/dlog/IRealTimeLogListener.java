package io.rong.common.dlog;

/* JADX INFO: loaded from: classes5.dex */
public interface IRealTimeLogListener {
    void OnLogGenerated(RealTimeLogInfo realTimeLogInfo);

    void OnLogUpload(String str);
}
