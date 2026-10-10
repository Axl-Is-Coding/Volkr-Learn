package kotlin.d;

import java.util.NoSuchElementException;
import kotlin.collections.w;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f22835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22837d;

    public c(int i, int i2, int i3) {
        this.f22837d = i3;
        this.f22834a = i2;
        boolean z = true;
        if (this.f22837d <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f22835b = z;
        this.f22836c = this.f22835b ? i : this.f22834a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22835b;
    }

    @Override // kotlin.collections.w
    public int nextInt() {
        int i = this.f22836c;
        if (i != this.f22834a) {
            this.f22836c = this.f22837d + i;
        } else {
            if (!this.f22835b) {
                throw new NoSuchElementException();
            }
            this.f22835b = false;
        }
        return i;
    }
}
