package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.r;

/* JADX INFO: loaded from: classes3.dex */
public enum TeamType implements r.c {
    NONE(0),
    PUBLIC(1),
    PRIVATE(2),
    UNRECOGNIZED(-1);

    public static final int NONE_VALUE = 0;
    public static final int PRIVATE_VALUE = 2;
    public static final int PUBLIC_VALUE = 1;
    private static final r.d<TeamType> internalValueMap = new r.d<TeamType>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamType.1
        public TeamType findValueByNumber(int i) {
            return TeamType.forNumber(i);
        }
    };
    private final int value;

    TeamType(int i) {
        this.value = i;
    }

    public static TeamType forNumber(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return PUBLIC;
        }
        if (i != 2) {
            return null;
        }
        return PRIVATE;
    }

    public static r.d<TeamType> internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static TeamType valueOf(int i) {
        return forNumber(i);
    }
}
