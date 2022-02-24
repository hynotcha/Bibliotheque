package Tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {

	public static String motdepassHash(String motdepass) {
		return generateHash(motdepass, "SHA-256");
	}

//	public static void main(String[] args) {
//		String data = "Heloo World";
//		String algorithm = "SHA-256";
//		String hash = generateHash(data, algorithm);
//		System.out.println(hash);
//	}

	private static String generateHash(String data, String algorithm) {
		// TODO Auto-generated method stub
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.reset();
			byte[] hash = md.digest(data.getBytes());
			return bytesToSringHex(hash);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String bytesToSringHex(byte[] hash) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; i++) {
			sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}
