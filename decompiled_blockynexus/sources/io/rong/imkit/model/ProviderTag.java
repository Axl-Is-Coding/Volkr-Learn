package io.rong.imkit.model;

import io.rong.imlib.model.MessageContent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProviderTag {
    boolean centerInHorizontal() default false;

    boolean hide() default false;

    Class<? extends MessageContent> messageContent();

    boolean showPortrait() default true;

    boolean showProgress() default true;

    boolean showReadState() default false;

    boolean showSummaryWithName() default true;

    boolean showWarning() default true;
}
