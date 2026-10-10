package io.grpc;

import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.m;
import com.google.common.collect.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class Metadata {
    public static final String BINARY_HEADER_SUFFIX = "-bin";
    private final Map<String, List<MetadataEntry>> store = new LinkedHashMap();
    private int storeCount;
    public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() { // from class: io.grpc.Metadata.1
        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] parseBytes(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(byte[] bArr) {
            return bArr;
        }
    };
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() { // from class: io.grpc.Metadata.2
        @Override // io.grpc.Metadata.AsciiMarshaller
        public String parseAsciiString(String str) {
            return str;
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(String str) {
            return str;
        }
    };
    static final AsciiMarshaller<Integer> INTEGER_MARSHALLER = new AsciiMarshaller<Integer>() { // from class: io.grpc.Metadata.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Integer parseAsciiString(String str) {
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Integer num) {
            return num.toString();
        }
    };

    private static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(new String(bArr, d.f13739a));
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toAsciiString(t).getBytes(d.f13739a);
        }

        private AsciiKey(String str, AsciiMarshaller<T> asciiMarshaller) {
            super(str);
            m.a(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s. It must not end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            m.a(asciiMarshaller);
            this.marshaller = asciiMarshaller;
        }
    }

    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t);
    }

    private static class BinaryKey<T> extends Key<T> {
        private final BinaryMarshaller<T> marshaller;

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseBytes(bArr);
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toBytes(t);
        }

        private BinaryKey(String str, BinaryMarshaller<T> binaryMarshaller) {
            super(str);
            m.a(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            m.a(str.length() > 4, "empty key name");
            m.a(binaryMarshaller, "marshaller is null");
            this.marshaller = binaryMarshaller;
        }
    }

    public interface BinaryMarshaller<T> {
        T parseBytes(byte[] bArr);

        byte[] toBytes(T t);
    }

    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        private static BitSet generateValidTChars() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
                bitSet.set(c2);
            }
            for (char c3 = 'a'; c3 <= 'z'; c3 = (char) (c3 + 1)) {
                bitSet.set(c3);
            }
            return bitSet;
        }

        public static <T> Key<T> of(String str, BinaryMarshaller<T> binaryMarshaller) {
            return new BinaryKey(str, binaryMarshaller);
        }

        private static String validateName(String str) {
            m.a(str);
            m.a(str.length() != 0, "token must have at least 1 tchar");
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != ':' || i != 0) {
                    m.a(VALID_T_CHARS.get(cCharAt), "Invalid character '%s' in key name '%s'", Character.valueOf(cCharAt), str);
                }
            }
            return str;
        }

        byte[] asciiName() {
            return this.nameBytes;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.name.equals(((Key) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public final String name() {
            return this.name;
        }

        public final String originalName() {
            return this.originalName;
        }

        abstract T parseBytes(byte[] bArr);

        abstract byte[] toBytes(T t);

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }

        private Key(String str) {
            m.a(str);
            this.originalName = str;
            String lowerCase = this.originalName.toLowerCase(Locale.ROOT);
            validateName(lowerCase);
            this.name = lowerCase.intern();
            this.nameBytes = this.name.getBytes(d.f13739a);
        }

        public static <T> Key<T> of(String str, AsciiMarshaller<T> asciiMarshaller) {
            return new AsciiKey(str, asciiMarshaller);
        }
    }

    public Metadata(byte[]... bArr) {
        m.a(bArr.length % 2 == 0, "Odd number of key-value pairs: %s", Integer.valueOf(bArr.length));
        for (int i = 0; i < bArr.length; i += 2) {
            String str = new String(bArr[i], d.f13739a);
            storeAdd(str, new MetadataEntry(str.endsWith(BINARY_HEADER_SUFFIX), bArr[i + 1]));
        }
    }

    private void storeAdd(String str, MetadataEntry metadataEntry) {
        List<MetadataEntry> arrayList = this.store.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.store.put(str, arrayList);
        }
        this.storeCount++;
        arrayList.add(metadataEntry);
    }

    private String toStringInternal() {
        return this.store.toString();
    }

    public boolean containsKey(Key<?> key) {
        return this.store.containsKey(key.name());
    }

    public <T> T get(Key<T> key) {
        List<MetadataEntry> list = this.store.get(key.name());
        if (list == null) {
            return null;
        }
        return (T) list.get(list.size() - 1).getParsed(key);
    }

    public <T> Iterable<T> getAll(final Key<T> key) {
        if (containsKey(key)) {
            return L.d(L.a((Iterable) this.store.get(key.name()), (f) new f<MetadataEntry, T>() { // from class: io.grpc.Metadata.4
                @Override // com.google.common.base.f
                public T apply(MetadataEntry metadataEntry) {
                    return (T) metadataEntry.getParsed(key);
                }
            }));
        }
        return null;
    }

    public int headerCount() {
        return this.storeCount;
    }

    public Set<String> keys() {
        return Collections.unmodifiableSet(this.store.keySet());
    }

    public void merge(Metadata metadata) {
        m.a(metadata);
        for (Map.Entry<String, List<MetadataEntry>> entry : metadata.store.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                storeAdd(entry.getKey(), new MetadataEntry(entry.getValue().get(i)));
            }
        }
    }

    public <T> void put(Key<T> key, T t) {
        m.a(key, "key");
        m.a(t, "value");
        storeAdd(((Key) key).name, new MetadataEntry(key, t));
    }

    public <T> boolean remove(Key<T> key, T t) {
        m.a(key, "key");
        m.a(t, "value");
        List<MetadataEntry> list = this.store.get(key.name());
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (t.equals(list.get(i).getParsed(key))) {
                list.remove(i);
                this.storeCount--;
                return true;
            }
        }
        return false;
    }

    public <T> Iterable<T> removeAll(final Key<T> key) {
        List<MetadataEntry> listRemove = this.store.remove(key.name());
        if (listRemove == null) {
            return null;
        }
        this.storeCount -= listRemove.size();
        return L.a((Iterable) listRemove, (f) new f<MetadataEntry, T>() { // from class: io.grpc.Metadata.5
            @Override // com.google.common.base.f
            public T apply(MetadataEntry metadataEntry) {
                return (T) metadataEntry.getParsed(key);
            }
        });
    }

    public byte[][] serialize() {
        byte[][] bArr = new byte[this.storeCount * 2][];
        int i = 0;
        for (Map.Entry<String, List<MetadataEntry>> entry : this.store.entrySet()) {
            List<MetadataEntry> value = entry.getValue();
            int i2 = i;
            for (int i3 = 0; i3 < value.size(); i3++) {
                int i4 = i2 + 1;
                bArr[i2] = value.get(i3).key != null ? value.get(i3).key.asciiName() : entry.getKey().getBytes(d.f13739a);
                i2 = i4 + 1;
                bArr[i4] = value.get(i3).getSerialized();
            }
            i = i2;
        }
        return bArr;
    }

    public String toString() {
        return "Metadata(" + toStringInternal() + ")";
    }

    private static class MetadataEntry {
        boolean isBinary;
        Key key;
        Object parsed;
        byte[] serializedBinary;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public <T> T getParsed(Key<T> key) {
            T bytes = (T) this.parsed;
            if (bytes != null) {
                Key<T> key2 = this.key;
                if (key2 == key) {
                    return bytes;
                }
                this.serializedBinary = key2.toBytes(bytes);
            }
            this.key = key;
            byte[] bArr = this.serializedBinary;
            if (bArr != null) {
                bytes = key.parseBytes(bArr);
            }
            this.parsed = bytes;
            return bytes;
        }

        public byte[] getSerialized() {
            byte[] bytes = this.serializedBinary;
            if (bytes == null) {
                bytes = this.key.toBytes(this.parsed);
            }
            this.serializedBinary = bytes;
            return bytes;
        }

        public String toString() {
            if (!this.isBinary) {
                return new String(getSerialized(), d.f13739a);
            }
            if (this.parsed == null) {
                return Arrays.toString(this.serializedBinary);
            }
            return "" + this.parsed;
        }

        private MetadataEntry(Key<?> key, Object obj) {
            m.a(obj);
            this.parsed = obj;
            m.a(key);
            this.key = key;
            this.isBinary = key instanceof BinaryKey;
        }

        private MetadataEntry(boolean z, byte[] bArr) {
            m.a(bArr);
            this.serializedBinary = bArr;
            this.isBinary = z;
        }

        private MetadataEntry(MetadataEntry metadataEntry) {
            this.parsed = metadataEntry.parsed;
            this.key = metadataEntry.key;
            this.isBinary = metadataEntry.isBinary;
            this.serializedBinary = metadataEntry.serializedBinary;
        }
    }

    public void merge(Metadata metadata, Set<Key<?>> set) {
        m.a(metadata);
        for (Key<?> key : set) {
            List<MetadataEntry> list = metadata.store.get(key.name());
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    storeAdd(key.name(), new MetadataEntry(list.get(i)));
                }
            }
        }
    }

    public Metadata() {
    }
}
