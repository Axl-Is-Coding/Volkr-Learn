package com.sandboxol.videosubmit.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public interface Constants {

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SignUpStatus {
        public static final int NOT = 0;
        public static final int YES = 1;
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabType {
        public static final int REWARD = 1;
        public static final int TIME = 0;
    }
}
