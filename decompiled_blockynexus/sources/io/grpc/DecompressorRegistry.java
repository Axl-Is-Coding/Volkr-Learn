package io.grpc;

import com.google.common.base.h;
import com.google.common.base.m;
import io.grpc.Codec;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class DecompressorRegistry {
    static final h ACCEPT_ENCODING_JOINER = h.a(',');
    private static final DecompressorRegistry DEFAULT_INSTANCE = emptyInstance().with(new Codec.Gzip(), true).with(Codec.Identity.NONE, false);
    private final String advertisedDecompressors;
    private final Map<String, DecompressorInfo> decompressors;

    private static final class DecompressorInfo {
        final boolean advertised;
        final Decompressor decompressor;

        DecompressorInfo(Decompressor decompressor, boolean z) {
            m.a(decompressor);
            this.decompressor = decompressor;
            this.advertised = z;
        }
    }

    private DecompressorRegistry(Decompressor decompressor, boolean z, DecompressorRegistry decompressorRegistry) {
        String messageEncoding = decompressor.getMessageEncoding();
        m.a(!messageEncoding.contains(","), "Comma is currently not allowed in message encoding");
        int size = decompressorRegistry.decompressors.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(decompressorRegistry.decompressors.containsKey(decompressor.getMessageEncoding()) ? size : size + 1);
        for (DecompressorInfo decompressorInfo : decompressorRegistry.decompressors.values()) {
            String messageEncoding2 = decompressorInfo.decompressor.getMessageEncoding();
            if (!messageEncoding2.equals(messageEncoding)) {
                linkedHashMap.put(messageEncoding2, new DecompressorInfo(decompressorInfo.decompressor, decompressorInfo.advertised));
            }
        }
        linkedHashMap.put(messageEncoding, new DecompressorInfo(decompressor, z));
        this.decompressors = Collections.unmodifiableMap(linkedHashMap);
        this.advertisedDecompressors = ACCEPT_ENCODING_JOINER.a((Iterable<?>) getAdvertisedMessageEncodings());
    }

    public static DecompressorRegistry emptyInstance() {
        return new DecompressorRegistry();
    }

    public static DecompressorRegistry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public Set<String> getAdvertisedMessageEncodings() {
        HashSet hashSet = new HashSet(this.decompressors.size());
        for (Map.Entry<String, DecompressorInfo> entry : this.decompressors.entrySet()) {
            if (entry.getValue().advertised) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Set<String> getKnownMessageEncodings() {
        return this.decompressors.keySet();
    }

    public String getRawAdvertisedMessageEncodings() {
        return this.advertisedDecompressors;
    }

    public Decompressor lookupDecompressor(String str) {
        DecompressorInfo decompressorInfo = this.decompressors.get(str);
        if (decompressorInfo != null) {
            return decompressorInfo.decompressor;
        }
        return null;
    }

    public DecompressorRegistry with(Decompressor decompressor, boolean z) {
        return new DecompressorRegistry(decompressor, z, this);
    }

    private DecompressorRegistry() {
        this.decompressors = new LinkedHashMap(0);
        this.advertisedDecompressors = "";
    }
}
