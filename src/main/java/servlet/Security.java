package servlet;

import java.util.*;
import java.nio.charset.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

//import org.bouncycastle.util.encoders.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Security{
	private static String ALGORITHM = "RSA/ECB/PKCS1Padding";
	private static String seed = "123456789";
	private static int generaByteLenght = 1024;
	private static String path = "sec/";
	private static PublicKey public_key = null;
	private static PrivateKey private_key = null;
	
	public KeyPair createKey(){
		KeyPair generatedKeyPair = null;
		try{
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = new SecureRandom();
			random.setSeed(seed.getBytes());
			keygen.initialize(generaByteLenght, random);           // Generate 1024-bit keys
			generatedKeyPair = keygen.generateKeyPair();
			this.private_key = generatedKeyPair.getPrivate();
			this.public_key = generatedKeyPair.getPublic();
			//dumpKeyPair();
			try{
				SaveKeyPair();
			}catch(IOException er){
				er.printStackTrace();
			}
		}catch(NoSuchAlgorithmException e){
			System.out.println(e.toString());
		}
		return generatedKeyPair;
	}
	public void setKeyRule(Map<Object,Object> map){
		if(map.containsKey((Object)"seed")){
			this.seed = map.get((Object)"seed").toString();
			System.out.println("Seed Exist: "+this.seed);
		}
		if(map.containsKey((Object)"algorithm")){
			this.ALGORITHM = map.get((Object)"algorithm").toString();
			System.out.println("ALGORITHM Exist: "+this.ALGORITHM);
		}
		if(map.containsKey((Object)"keylength")){
			this.generaByteLenght = Integer.valueOf(map.get((Object)"keylength").toString());
			System.out.println(this.generaByteLenght);
		}
		if(map.containsKey((Object)"path")){
			this.path = map.get((Object)"path").toString();
			System.out.println("path Exist: "+this.path);
		}
	}
	public Map dumpKeyPair() {
		//System.out.println("Public Key: " + getHexString(public_key.getEncoded()));
		//System.out.println("Private Key: " + getHexString(private_key.getEncoded()));
		Map map = new HashMap();
		map.put("public",getHexString(public_key.getEncoded()));
		map.put("private",getHexString(private_key.getEncoded()));
		return map;
	}
	public String getHexString(byte[] b) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < b.length; i++){
			result.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}
	public void SaveKeyPair() throws IOException {
		File file = new File(path);
		file.mkdirs();
		// Store Public Key.
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(public_key.getEncoded());
		FileOutputStream fos = new FileOutputStream(path + "/public.key");
		fos.write(x509EncodedKeySpec.getEncoded());
		fos.close();
		// Store Private Key.
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(private_key.getEncoded());
		fos = new FileOutputStream(path + "/private.key");
		fos.write(pkcs8EncodedKeySpec.getEncoded());
		fos.close();
	}
	
	private byte[] encrypt(String data){
		byte[] result = null;
		try{
			result = cryptByRSA(data.getBytes("UTF-8"),public_key,ALGORITHM,Cipher.ENCRYPT_MODE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private String decrypt(byte[] encrypt){
		String result = "";
		try{
			byte[] decry = cryptByRSA(encrypt,private_key,ALGORITHM,Cipher.DECRYPT_MODE);
			result = new String(decry,"UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private byte[] cryptByRSA(byte[] data,Key key,String thm, int mode){
		try{
			Cipher cipher = Cipher.getInstance(thm);
			if(mode == Cipher.ENCRYPT_MODE)
				cipher.init(Cipher.ENCRYPT_MODE,(RSAPublicKey)key);
			else
				cipher.init(Cipher.DECRYPT_MODE,(RSAPrivateKey)key);
			return cipher.doFinal(data);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public String doEcnry(String data){
		String r = "";
		try{
			byte[] result = encrypt(data);
			//r = new String(result,"ISO-8859-1");//, StandardCharsets.UTF_8
			r = Arrays.toString(result);
		}catch(Exception e){
			r = e.toString();
		}
		return r;
	}
	public String doDecry(String data){
		String enc = "";
		try{
			data = data.replace("[","");
			data = data.replace("]","");
			String[] tmp = data.split(",");
			//System.out.println(Arrays.toString(tmp));
			//byte[] result = data.getBytes();//StandardCharsets.UTF_8
			byte[] result = new byte[tmp.length];
			int i = 0;
			for(String t : tmp){
				result[i] = Byte.parseByte(t);
				i++;
			}
			enc = decrypt(result);
		}catch(Exception e){
			enc = e.toString();
		}
		return enc;
	}
}