package com.sandboxol.blockmango;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class ParamDef {
    public static final int INPUT_DOING = 2;
    public static final int INPUT_EXIT = 1;
    public static final int INPUT_SEND = 0;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GameInputTrigger {
    }
}
