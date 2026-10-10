package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.r;

/* JADX INFO: loaded from: classes3.dex */
public enum MemberStatusType implements r.c {
    MEMBER_STATUS_PREPARING(0),
    MEMBER_STATUS_GAMEING(1),
    UNRECOGNIZED(-1);

    public static final int MEMBER_STATUS_GAMEING_VALUE = 1;
    public static final int MEMBER_STATUS_PREPARING_VALUE = 0;
    private static final r.d<MemberStatusType> internalValueMap = new r.d<MemberStatusType>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.teammgr.MemberStatusType.1
        public MemberStatusType findValueByNumber(int i) {
            return MemberStatusType.forNumber(i);
        }
    };
    private final int value;

    MemberStatusType(int i) {
        this.value = i;
    }

    public static MemberStatusType forNumber(int i) {
        if (i == 0) {
            return MEMBER_STATUS_PREPARING;
        }
        if (i != 1) {
            return null;
        }
        return MEMBER_STATUS_GAMEING;
    }

    public static r.d<MemberStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static MemberStatusType valueOf(int i) {
        return forNumber(i);
    }
}
