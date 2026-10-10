package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.NavigableSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1646Hb {
    void A3Q(String str, C1658Hn c1658Hn) throws HZ;

    void A44(File file) throws HZ;

    long A5g();

    long A5h(String str, long j, long j2);

    @NonNull
    NavigableSet<C1650Hf> A5i(String str);

    long A5t(String str);

    InterfaceC1656Hl A5u(String str);

    void ACa(C1650Hf c1650Hf);

    void ACh(C1650Hf c1650Hf) throws HZ;

    void ADD(String str, long j) throws HZ;

    File ADc(String str, long j, long j2) throws HZ;

    C1650Hf ADe(String str, long j) throws HZ, InterruptedException;

    @Nullable
    C1650Hf ADf(String str, long j) throws HZ;
}
