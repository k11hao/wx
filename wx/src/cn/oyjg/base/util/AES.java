package cn.oyjg.base.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static String AES_HEX = "112b1ea14ae0ac4c081c26b4974b03f8c41d40cea3418eba6c0203404cb470bf";
	private Cipher cipher;
	private IvParameterSpec dps;
	private SecretKeySpec skeySpec;

	public AES() throws Exception {
		byte[] passkey = hex2Bin(AES_HEX);
		byte[] key = getAESKey(passkey);
		byte[] iv = getAESIV(passkey);
		dps = new IvParameterSpec(iv);
		skeySpec = new SecretKeySpec(key, "AES");
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	}

	private byte[] getAESIV(byte[] keyRaw) throws Exception { // 获得32
		// byte数组中的一部分作为KEY
		byte[] iv = new byte[16];
		System.arraycopy(keyRaw, 8, iv, 0, 16);
		return iv;
	}

	private byte[] getAESKey(byte[] keyRaw) throws Exception { // 获得32
		// byte数组中的一部分作为KEY
		byte[] key = new byte[16];
		System.arraycopy(keyRaw, 0, key, 0, 8);
		System.arraycopy(keyRaw, 24, key, 8, 8);
		return key;
	}

	public String encrypt(String command) throws Exception {

		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, dps);
		byte[] buf = cipher.doFinal(command.getBytes());

		return this.byte2hexString(buf);
	}

	public String decrypt(String sSrc) throws Exception {

		cipher.init(Cipher.DECRYPT_MODE, skeySpec, dps);
		return new String(cipher.doFinal(hex2Bin(sSrc)));

	}

	private byte[] hex2Bin(String src) {
		if (src.length() < 1)
			return null;
		byte[] encrypted = new byte[src.length() / 2];
		for (int i = 0; i < src.length() / 2; i++) {
			int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);

			encrypted[i] = (byte) (high * 16 + low);
		}
		return encrypted;
	}

	private String byte2hexString(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;

		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");

			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}

		return strbuf.toString();
	}

	public static void main(String[] args) {
		AES aes = null;
		try {
			aes = new AES();
//			String para = aes.encrypt("中华人民共和国");
//			System.out.println("加密:"+para);
//			String s = aes.decrypt(para);
//			System.out.println("解密:"+s);		
			System.out.println("hibernate.dialect="+aes.encrypt("org.hibernate.dialect.MySQLDialect"));
			System.out.println("driverClassName="+aes.encrypt("com.mysql.jdbc.Driver"));
			System.out.println("url="+aes.encrypt("jdbc:mysql://192.168.1.101:3306/hotel?useUnicode=true&characterEncoding=UTF-8"));
			System.out.println("usernames="+aes.encrypt("root"));
			System.out.println("password="+aes.encrypt("root"));
			System.out.println("packagePath="+aes.encrypt("d:\\hotel\\trans"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}