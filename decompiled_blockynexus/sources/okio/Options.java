package okio;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractC2931b;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Options extends AbstractC2931b<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    /* JADX INFO: compiled from: Options.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) throws IOException {
            int i4;
            int i5;
            int i6;
            int i7;
            Buffer buffer2;
            int i8 = i;
            if (!(i2 < i3)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i9 = i2; i9 < i3; i9++) {
                if (!(list.get(i9).size() >= i8)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i8 == byteString.size()) {
                int iIntValue = list2.get(i2).intValue();
                int i10 = i2 + 1;
                ByteString byteString3 = list.get(i10);
                i4 = i10;
                i5 = iIntValue;
                byteString = byteString3;
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.getByte(i8) == byteString2.getByte(i8)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i11 = 0;
                for (int i12 = i8; i12 < iMin && byteString.getByte(i12) == byteString2.getByte(i12); i12++) {
                    i11++;
                }
                long intCount = j + getIntCount(buffer) + ((long) 2) + ((long) i11) + 1;
                buffer.writeInt(-i11);
                buffer.writeInt(i5);
                int i13 = i8 + i11;
                while (i8 < i13) {
                    buffer.writeInt(byteString.getByte(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i3) {
                    if (!(i13 == list.get(i4).size())) {
                        throw new IllegalStateException("Check failed.");
                    }
                    buffer.writeInt(list2.get(i4).intValue());
                    return;
                } else {
                    Buffer buffer3 = new Buffer();
                    buffer.writeInt(((int) (getIntCount(buffer3) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer3, i13, list, i4, i3, list2);
                    buffer.writeAll(buffer3);
                    return;
                }
            }
            int i14 = 1;
            for (int i15 = i4 + 1; i15 < i3; i15++) {
                if (list.get(i15 - 1).getByte(i8) != list.get(i15).getByte(i8)) {
                    i14++;
                }
            }
            long intCount2 = j + getIntCount(buffer) + ((long) 2) + ((long) (i14 * 2));
            buffer.writeInt(i14);
            buffer.writeInt(i5);
            for (int i16 = i4; i16 < i3; i16++) {
                byte b2 = list.get(i16).getByte(i8);
                if (i16 == i4 || b2 != list.get(i16 - 1).getByte(i8)) {
                    buffer.writeInt(b2 & 255);
                }
            }
            Buffer buffer4 = new Buffer();
            while (i4 < i3) {
                byte b3 = list.get(i4).getByte(i8);
                int i17 = i4 + 1;
                int i18 = i17;
                while (true) {
                    if (i18 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (b3 != list.get(i18).getByte(i8)) {
                            i6 = i18;
                            break;
                        }
                        i18++;
                    }
                }
                if (i17 == i6 && i8 + 1 == list.get(i4).size()) {
                    buffer.writeInt(list2.get(i4).intValue());
                    i7 = i6;
                    buffer2 = buffer4;
                } else {
                    buffer.writeInt(((int) (intCount2 + getIntCount(buffer4))) * (-1));
                    i7 = i6;
                    buffer2 = buffer4;
                    buildTrieRecursive(intCount2, buffer4, i8 + 1, list, i4, i6, list2);
                }
                buffer4 = buffer2;
                i4 = i7;
            }
            buffer.writeAll(buffer4);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) throws IOException {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ee, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(okio.ByteString... r17) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 334
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, f fVar) {
        this(byteStringArr, iArr);
    }

    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractC2930a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractC2931b, kotlin.collections.AbstractC2930a
    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractC2931b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractC2931b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.AbstractC2931b, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
