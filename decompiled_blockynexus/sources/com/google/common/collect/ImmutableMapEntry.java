package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInValueBucket;

        NonTerminalImmutableBiMapEntry(K k, V v, ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
            super(k, v, immutableMapEntry);
            this.nextInValueBucket = immutableMapEntry2;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }

    static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInKeyBucket;

        NonTerminalImmutableMapEntry(K k, V v, ImmutableMapEntry<K, V> immutableMapEntry) {
            super(k, v);
            this.nextInKeyBucket = immutableMapEntry;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        final boolean isReusable() {
            return false;
        }
    }

    ImmutableMapEntry(K k, V v) {
        super(k, v);
        C2259n.a(k, v);
    }

    static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int i) {
        return new ImmutableMapEntry[i];
    }

    ImmutableMapEntry<K, V> getNextInKeyBucket() {
        return null;
    }

    ImmutableMapEntry<K, V> getNextInValueBucket() {
        return null;
    }

    boolean isReusable() {
        return true;
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }
}
