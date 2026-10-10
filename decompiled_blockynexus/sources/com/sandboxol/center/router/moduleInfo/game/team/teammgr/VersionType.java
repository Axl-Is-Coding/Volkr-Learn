package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.r;

/* JADX INFO: loaded from: classes3.dex */
public enum VersionType implements r.c {
    VERSION_ZERO(0),
    VERSION_ONE(1),
    UNRECOGNIZED(-1);

    public static final int VERSION_ONE_VALUE = 1;
    public static final int VERSION_ZERO_VALUE = 0;
    private static final r.d<VersionType> internalValueMap = new r.d<VersionType>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.teammgr.VersionType.1
        public VersionType findValueByNumber(int i) {
            return VersionType.forNumber(i);
        }
    };
    private final int value;

    VersionType(int i) {
        this.value = i;
    }

    public static VersionType forNumber(int i) {
        if (i == 0) {
            return VERSION_ZERO;
        }
        if (i != 1) {
            return null;
        }
        return VERSION_ONE;
    }

    public static r.d<VersionType> internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VersionType valueOf(int i) {
        return forNumber(i);
    }
}
