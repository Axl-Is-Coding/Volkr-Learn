package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamLocalUriFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends m<InputStream> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final UriMatcher f4397d = new UriMatcher(-1);

    static {
        f4397d.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f4397d.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f4397d.addURI("com.android.contacts", "contacts/#/photo", 2);
        f4397d.addURI("com.android.contacts", "contacts/#", 3);
        f4397d.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f4397d.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public o(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = f4397d.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return a(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return a(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.m
    public InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamB = b(uri, contentResolver);
        if (inputStreamB != null) {
            return inputStreamB;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.m
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
