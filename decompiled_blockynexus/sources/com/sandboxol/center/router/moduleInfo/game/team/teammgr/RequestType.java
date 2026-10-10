package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.r;

/* JADX INFO: loaded from: classes3.dex */
public enum RequestType implements r.c {
    LIST(0),
    FAST(1),
    UNRECOGNIZED(-1);

    public static final int FAST_VALUE = 1;
    public static final int LIST_VALUE = 0;
    private static final r.d<RequestType> internalValueMap = new r.d<RequestType>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.teammgr.RequestType.1
        public RequestType findValueByNumber(int i) {
            return RequestType.forNumber(i);
        }
    };
    private final int value;

    RequestType(int i) {
        this.value = i;
    }

    public static RequestType forNumber(int i) {
        if (i == 0) {
            return LIST;
        }
        if (i != 1) {
            return null;
        }
        return FAST;
    }

    public static r.d<RequestType> internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static RequestType valueOf(int i) {
        return forNumber(i);
    }
}
