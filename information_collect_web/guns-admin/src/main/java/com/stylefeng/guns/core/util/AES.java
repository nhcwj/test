package com.stylefeng.guns.core.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.CryptoException;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * 此类用于AES加解密密
 * 如果狗标及其他人看到，就当他不存在，用于移动一键登录的
 */
public class AES {

    private Cipher cipher;
    private SecretKey secretKey;


    public AES(String key) {
        this(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), SymmetricAlgorithm.AES.getValue()));
    }

    public AES(SecretKey secretKey) {
        try {
            this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            throw new CryptoException(e);
        }
        this.secretKey = secretKey;
    }

    public byte[] encrypt(byte[] data) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public byte[] decrypt(byte[] data) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public String encryptHex(byte[] data) {
        return HexUtil.encodeHexStr(encrypt(data));
    }

    public byte[] decryptHex(String data) {
        return decrypt(HexUtil.decodeHex(data));
    }

    public String encryptBase64(byte[] data) {
        return Base64.encode(encrypt(data));
    }

    public byte[] decryptBase64(String data) {
        return decrypt(Base64.decode(data));
    }
}
