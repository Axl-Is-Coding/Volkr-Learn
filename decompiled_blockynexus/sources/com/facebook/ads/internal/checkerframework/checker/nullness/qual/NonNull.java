package com.facebook.ads.internal.checkerframework.checker.nullness.qual;

import com.facebook.ads.internal.checkerframework.framework.qual.DefaultFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultInUncheckedCodeFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import com.facebook.ads.internal.checkerframework.framework.qual.QualifierForLiterals;
import com.facebook.ads.internal.checkerframework.framework.qual.SubtypeOf;
import com.facebook.ads.internal.checkerframework.framework.qual.UpperBoundFor;
import com.facebook.ads.redexgen.X.AnonymousClass81;
import com.facebook.ads.redexgen.X.AnonymousClass82;
import com.facebook.ads.redexgen.X.EnumC14267n;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SubtypeOf({MonotonicNonNull.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@UpperBoundFor(typeKinds = {AnonymousClass81.A0I, AnonymousClass81.A0C, AnonymousClass81.A04, AnonymousClass81.A06, AnonymousClass81.A08, AnonymousClass81.A0B, AnonymousClass81.A0E, AnonymousClass81.A0J, AnonymousClass81.A05})
@Retention(RetentionPolicy.RUNTIME)
@QualifierForLiterals({EnumC14267n.A0B})
@DefaultFor({AnonymousClass82.A05})
@DefaultQualifierInHierarchy
@DefaultInUncheckedCodeFor({AnonymousClass82.A0E, AnonymousClass82.A0C})
@Documented
public @interface NonNull {
}
