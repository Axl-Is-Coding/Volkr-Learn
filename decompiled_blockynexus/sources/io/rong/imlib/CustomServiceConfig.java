package io.rong.imlib;

import android.net.Uri;
import io.rong.imlib.model.CSLMessageItem;
import io.rong.message.CSHumanEvaluateItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class CustomServiceConfig {
    public int adminTipTime;
    public String adminTipWord;
    public String announceClickUrl;
    public String announceMsg;
    public String companyIcon;
    public String companyName;
    public CSEvaEntryPoint evaEntryPoint;
    public CSEvaType evaluateType;
    public ArrayList<CSHumanEvaluateItem> humanEvaluateList;
    public boolean isBlack;
    public boolean isDisableLocation;
    public boolean isReportResolveStatus;
    public CSLeaveMessageType leaveMessageConfigType;
    public ArrayList<CSLMessageItem> leaveMessageNativeInfo;
    public String msg;
    public CSQuitSuspendType quitSuspendType;
    public boolean robotSessionNoEva;
    public Uri uri;
    public int userTipTime;
    public String userTipWord;

    public enum CSEvaEntryPoint {
        EVA_LEAVE(0),
        EVA_EXTENSION(1),
        EVA_NONE(2),
        EVA_END(3);

        private int value;

        CSEvaEntryPoint(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static CSEvaEntryPoint valueOf(int i) {
            for (CSEvaEntryPoint cSEvaEntryPoint : values()) {
                if (i == cSEvaEntryPoint.getValue()) {
                    return cSEvaEntryPoint;
                }
            }
            return EVA_LEAVE;
        }
    }

    public enum CSEvaSolveStatus {
        UNRESOLVED(0),
        RESOLVED(1),
        RESOLVING(2);

        private int value;

        CSEvaSolveStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static CSEvaSolveStatus valueOf(int i) {
            for (CSEvaSolveStatus cSEvaSolveStatus : values()) {
                if (i == cSEvaSolveStatus.getValue()) {
                    return cSEvaSolveStatus;
                }
            }
            return UNRESOLVED;
        }
    }

    public enum CSEvaType {
        EVA_SEPARATELY(0),
        EVA_UNIFIED(1);

        private int value;

        CSEvaType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CSLeaveMessageType {
        NATIVE(0),
        WEB(1);

        private int value;

        CSLeaveMessageType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CSQuitSuspendType {
        NONE(-1),
        NO_SUSPEND(0),
        SUSPEND(1);

        private int value;

        CSQuitSuspendType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static CSQuitSuspendType valueOf(int i) {
            for (CSQuitSuspendType cSQuitSuspendType : values()) {
                if (i == cSQuitSuspendType.getValue()) {
                    return cSQuitSuspendType;
                }
            }
            return NONE;
        }
    }
}
