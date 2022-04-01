package com.stylefeng.guns.core.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.CryptoException;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

import java.security.*;
import java.util.Map;

/**
 * 此类用于sign加密解密
 * 如果狗标及其他人看到，就当他不存在，用于移动一键登录的
 */
public class LySign {


    protected String algorithm;
    protected String algorithmAfterWith;
    protected PublicKey publicKey;
    protected PrivateKey privateKey;

    protected Signature signature;


    public LySign(SignAlgorithm algorithmE, byte[] privateKey, byte[] publicKey) {
        this.algorithm = algorithmE.getValue();
        this.algorithmAfterWith = KeyUtil.getAlgorithmAfterWith(this.algorithm);
        this.privateKey = SecureUtil.generatePrivateKey(this.algorithmAfterWith, privateKey);
        this.publicKey = SecureUtil.generatePublicKey(this.algorithmAfterWith, publicKey);
        try {
            this.signature = Signature.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }


    public static LySign of(SignAlgorithm algorithm, String privateKeymap, String publicKey, boolean hexStr) {
        byte[] privateBytes;
        byte[] publicBytes;
//        String privateKey=LySign.public_key(privateKeymap);
//        StringBuilder stringBuilder=new StringBuilder(privateKey);
//        stringBuilder.insert((privateKey.lastIndexOf("92RFUkgd")+8),'a');
//        privateKey=stringBuilder.toString();
        if (hexStr) {
            privateBytes = HexUtil.decodeHex(privateKeymap);
            publicBytes = HexUtil.decodeHex(publicKey);
        } else {
            privateBytes = Base64.decode(privateKeymap);
            publicBytes = Base64.decode(publicKey);
        }
        return new LySign(algorithm, privateBytes, publicBytes);
    }
    public static String public_key(Map<String,String> map){
        String [] nameList ={"key1","key3","key2"};
        String public_key=new String();
        if(map.size()==3){
            for (String key_name :nameList){
                if(map.get(key_name).length()<1){
                    return "error";
                }
                public_key= public_key+ map.get(key_name);
            }
            return  new StringBuilder(public_key).reverse().toString();
        }
        return "error";
    }

    public String sign(String data) {
        try {
            signature.initSign(privateKey);
            signature.update(data.getBytes());
            byte[] sign = signature.sign();
            return HexUtil.encodeHexStr(sign, false);
        } catch (InvalidKeyException | SignatureException e) {
            throw new CryptoException(e);
        }
    }

    public boolean verify(String data, String sign) {
        try {
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            return signature.verify(HexUtil.decodeHex(sign));
        } catch (InvalidKeyException | SignatureException e) {
            throw new CryptoException(e);
        }
    }
}
