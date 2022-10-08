package com.example.erweima;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class erweima {

    public static void main(String[] args) throws WriterException, IOException {
        MultiFormatWriter mfw=new MultiFormatWriter();

        String content="hai long666";
        BarcodeFormat type=BarcodeFormat.QR_CODE;
        int width=600;
        int height=600;
        Map map=new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        map.put(EncodeHintType.MARGIN,2);

        BitMatrix matrix = mfw.encode(content, type, width, height, map);

        int black= Color.BLACK.getRGB();
        int white=Color.WHITE.getRGB();
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                image.setRGB(x,y,matrix.get(x,y)?black:white);
            }
        }
        File file=new File("D://test//hailong.jpg");
        ImageIO.write(image,"jpg",file);



    }
}
