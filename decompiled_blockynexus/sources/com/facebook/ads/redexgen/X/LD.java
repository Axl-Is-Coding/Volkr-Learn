package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Deque;
import java.util.LinkedList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class LD {
    public static String[] A05;
    public final int A01;
    public final int A02;
    public final Deque<String> A04 = new LinkedList();
    public final Deque<String> A03 = new LinkedList();

    @Nullable
    public String A00 = null;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"YlFlQWjICGV8ywqag1b6Ay", "5zJBssfwfWeqrXRnFZsUzQPBIx8wM7U1", "dym1tHqC1dmHFSZgnmQvvBCyptXRCFyE", "ReBl50wuVZKzAeHcErw", "r5gi9DkEhDoZU86", "diW2RgJl9ou5SRwuprc", "1r89rpPGUWvit", "BXJhCJIGpStJQsMIN6w6cfyx8EdHGsbw"};
    }

    public LD(int i, int i2) {
        this.A02 = i;
        this.A01 = i2;
    }

    public final Iterable<String> A01() {
        return this.A03;
    }

    public final Iterable<String> A02() {
        return this.A04;
    }

    @Nullable
    public final String A03() {
        return this.A00;
    }

    public final void A04() {
        String str = this.A00;
        if (str != null) {
            this.A04.addLast(str);
            if (this.A04.size() > this.A02) {
                this.A04.removeFirst();
            }
        }
        if (this.A03.size() > 0) {
            this.A00 = this.A03.removeFirst();
        } else {
            if (A05[4].length() == 3) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "rBMTTnNnBAlsPJgH9pl";
            strArr[3] = "RhxgQAx1k3YbBH8x5Ji";
            this.A00 = null;
        }
    }

    public final void A05(String str) {
        this.A03.addLast(str);
        if (this.A03.size() <= this.A01) {
            return;
        }
        String str2 = this.A00;
        if (str2 != null) {
            this.A04.addLast(str2);
        }
        this.A00 = this.A03.removeFirst();
        if (this.A04.size() > this.A02) {
            this.A04.removeFirst();
        }
    }
}
