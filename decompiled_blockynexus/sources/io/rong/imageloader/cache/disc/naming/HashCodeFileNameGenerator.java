package io.rong.imageloader.cache.disc.naming;

/* JADX INFO: loaded from: classes5.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // io.rong.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
