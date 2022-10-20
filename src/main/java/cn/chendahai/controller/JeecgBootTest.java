package cn.chendahai.controller;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 * @author: Dylan
 * @date: 2022/10/10 16:49
 */
public class JeecgBootTest {

    public static void main(String[] args) {
        byte[] var11 = a(
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHEhhLwdDhZ57SlLt/5JWFeGRy4r+NKgbA0VwkCXs7p0w1bNgKlRJOzUfjg6kMi4ygkVNNPWrXIhcdMniTbcHmawawLTa3cRM1jNdG0xg808KKNVdDilFHOFQz8AF6cvLDpsWkqzmoe2+64v0zlWbp5EpYxMMRxOwSMVKxLB8BwIDAQAB",
            "kqmCG6eh8Oce2d3xvFA4pOOA87YEh6pSU3vnXl5RXgtZX6paTjOuN3pAnRS6TqQYeGYaEdQ3hlnqERGy6J4XkxzxyhWGnMHyGTYkmBJjUDFdchYbwyHo9K+e8VhrYVqFBv782dIo8d18g/fOB9wiho4QVT2x2UnMRcbMlos1UVE=");
        System.out.println(new String(var11));
    }

    public static byte[] a(String var0, String var1) {
        try {
            byte[] var2 = Base64.getDecoder().decode(var1);
            byte[] var3 = Base64.getDecoder().decode(var0);

            KeyFactory var4 = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec var5 = new X509EncodedKeySpec(var3);
            PublicKey var6 = var4.generatePublic(var5);
            Cipher var7 = Cipher.getInstance(var4.getAlgorithm());
            var7.init(2, var6);
            return var7.doFinal(var2);
        } catch (Exception var8) {
            return null;
        }


    }

    public static JSONObject a(String var0, String var1, String var2, String var3) {
        JSONObject var4 = null;
        StringBuffer var5 = new StringBuffer();
        HttpURLConnection var6 = null;

        try {
            URL var7 = new URL(var0);
            var6 = (HttpURLConnection) var7.openConnection();
            var6.setDoOutput(true);
            var6.setDoInput(true);
            var6.setUseCaches(false);
            var6.setConnectTimeout(30000);
            var6.setReadTimeout(30000);
            var6.setRequestProperty("X-JEECG-SIGN", var3);
            var6.setRequestProperty("X-JEECG-DOCKER", "true");
            var6.setRequestMethod(var1);
            if ("GET".equalsIgnoreCase(var1)) {
                var6.connect();
            }

            OutputStream var8;
            if (null != var2) {
                var8 = var6.getOutputStream();
                var8.write(var2.getBytes("UTF-8"));
                var8.close();
            }

            InputStream var25 = var6.getInputStream();
            InputStreamReader var9 = new InputStreamReader(var25, "utf-8");
            BufferedReader var10 = new BufferedReader(var9);
            String var11 = null;

            while ((var11 = var10.readLine()) != null) {
                var5.append(var11);
            }

            var10.close();
            var9.close();
            var25.close();
            var8 = null;
            var6.disconnect();
            var4 = JSONObject.parseObject(var5.toString());
        } catch (ConnectException var22) {
            System.err.println("server connection timed out.");
        } catch (Exception var23) {
            System.err.println("https request error.");
        } finally {
            try {
                var6.disconnect();
            } catch (Exception var21) {
                var21.printStackTrace();
                System.err.println("http close error.");
            }

        }

        return var4;
    }

}
