package com.sandboxol.center.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VipSubscribeStatus {
    public static final String SUBSCRIPTION_CANCELED = "3";
    public static final String SUBSCRIPTION_DEFERRED = "9";
    public static final String SUBSCRIPTION_EXPIRED = "13";
    public static final String SUBSCRIPTION_IN_GRACE_PERIOD = "6";
    public static final String SUBSCRIPTION_ON_HOLD = "5";
    public static final String SUBSCRIPTION_PAUSED = "10";
    public static final String SUBSCRIPTION_PAUSE_SCHEDULE_CHANGED = "11";
    public static final String SUBSCRIPTION_PRICE_CHANGE_CONFIRMED = "8";
    public static final String SUBSCRIPTION_PURCHASED = "4";
    public static final String SUBSCRIPTION_RECOVERED = "1";
    public static final String SUBSCRIPTION_RENEWED = "2";
    public static final String SUBSCRIPTION_RESTARTED = "7";
    public static final String SUBSCRIPTION_REVOKED = "12";
}
