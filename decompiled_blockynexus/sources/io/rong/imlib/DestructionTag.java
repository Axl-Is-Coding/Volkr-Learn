package io.rong.imlib;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface DestructionTag {
    public static final int FLAG_COUNT_DOWN_WHEN_CLICK = 0;
    public static final int FLAG_COUNT_DOWN_WHEN_VISIBLE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DestructionFlag {
    }

    int destructionFlag() default 1;
}
