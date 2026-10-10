package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.r;

/* JADX INFO: loaded from: classes3.dex */
public enum TeamStatusType implements r.c {
    TEAM_STATUS_PREPARING(0),
    TEAM_STATUS_GAMEING(1),
    UNRECOGNIZED(-1);

    public static final int TEAM_STATUS_GAMEING_VALUE = 1;
    public static final int TEAM_STATUS_PREPARING_VALUE = 0;
    private static final r.d<TeamStatusType> internalValueMap = new r.d<TeamStatusType>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamStatusType.1
        public TeamStatusType findValueByNumber(int i) {
            return TeamStatusType.forNumber(i);
        }
    };
    private final int value;

    TeamStatusType(int i) {
        this.value = i;
    }

    public static TeamStatusType forNumber(int i) {
        if (i == 0) {
            return TEAM_STATUS_PREPARING;
        }
        if (i != 1) {
            return null;
        }
        return TEAM_STATUS_GAMEING;
    }

    public static r.d<TeamStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static TeamStatusType valueOf(int i) {
        return forNumber(i);
    }
}
