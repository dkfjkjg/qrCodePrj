package cn.edu.ahpu.qrcode.test01;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

public class GucasQRCodeDecoder {
	public GucasQRCodeDecoder() {
		
	}
	
	/**
	 * decode qrcode image.
	 * @param qrcodePicfilePath
	 * @return decoding value.
	 */
	public static String decode(String qrcodePicfilePath) {
		/* 读取二维码图像数据 */
		File imageFile = new File(qrcodePicfilePath);
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Decoding failed, read QRCode image error: " + e.getMessage());
			return null;
		}
		/* 解二维码 */
		QRCodeDecoder decoder = new QRCodeDecoder();
		String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
		return decodedData;
	}
}

class J2SEImageGucas implements QRCodeImage {
	BufferedImage image;

	public J2SEImageGucas(BufferedImage image) {
		this.image = image;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getPixel(int x, int y) {
		return image.getRGB(x, y);
	}
}

