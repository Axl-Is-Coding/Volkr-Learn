package com.sandboxol.center.download.client;

import com.sandboxol.center.download.interfaces.IClientProcess;

/* JADX INFO: loaded from: classes3.dex */
public class ClientProcess {
    public static IClientProcess getProcess(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new CommonClientProcess() : new MapClientProcess() : new CommonClientProcess() : new AloneGameClientProcess() : new CommonGameClientProcess() : new DressClientProcess();
    }
}
