package org.boxin.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@SuppressWarnings("unused")
public class Hash {
    private MessageDigest digest;
    private byte[] unHash;

    public Hash(String unHash) throws Exception {
        this.digest = MessageDigest.getInstance("SHA-1");
        this.unHash = unHash.getBytes(StandardCharsets.UTF_8);
    }
    public String getDefaultHash() {
        return invoke();
    }

    public void setUnHash(String  unHash) {
        this.unHash = unHash.getBytes(StandardCharsets.UTF_8);
    }

    public String invoke() {
        digest.update(unHash);
        byte[] digestArray = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digestArray) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String getSHA1() throws Exception {
        digest = MessageDigest.getInstance("SHA-1");
        return invoke();
    }

    public String getSHA224() throws Exception {
        digest = MessageDigest.getInstance("SHA-224");
        return invoke();
    }

    public String getSHA256() throws Exception {
        digest = MessageDigest.getInstance("SHA-256");
        return invoke();
    }

    public String getSHA384() throws Exception {
        digest = MessageDigest.getInstance("SHA-384");
        return invoke();
    }
    public String getSHA512() throws Exception {
        digest = MessageDigest.getInstance("SHA-512");
        return invoke();
    }
}
