package com.epl.ticketws.services;


import java.awt.image.BufferedImage;
import java.io.*;


import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Constants;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import org.krysalis.barcode4j.tools.UnitConv;

/**
 * Created by gcortes on 07/04/2017.
 */
public class BarCodeGenerator {

   public static byte[]  generateBarcode(String barcode, int orientation){
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       Code128Bean barcode128Bean = new Code128Bean();
       barcode128Bean.setCodeset(Code128Constants.CODESET_B);
       final int dpi = 100;

       //Configure the barcode generator
       //adjust barcode width here
       barcode128Bean.setModuleWidth(UnitConv.in2mm(1.2f / dpi));
       barcode128Bean.doQuietZone(false);


       //Open output file
       try{

           BitmapCanvasProvider canvasProvider = new BitmapCanvasProvider(
                   out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, orientation);

           barcode128Bean.generateBarcode(canvasProvider,barcode);

           canvasProvider.finish();
           out.close();
       }catch ( Exception ex) {
             ex.printStackTrace();
       }

       return out.toByteArray();

   }





    public static void main(String args[]){
        try {
            byte[] content =  generateBarcode("22001842240303",0);
            File outputFile = new File("D:/out2.png");
            OutputStream out = new FileOutputStream(outputFile);
            out.write(content,0, content.length);
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }




}
