package test.ref_valor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class SaltandPepper {

    public static void main(String[] args) throws IOException {
        String [] aux = toAddNoise("/home/jrudascas/Desktop/", "lenna.png");
        String [] aux2 = toRemoveNoise(aux[0], aux[1]);        
    }

    public static String[] toAddNoise(String path, String fileName) throws IOException {
        BufferedImage image = ImageIO.read(new File(path + fileName));
        double random;
        double umbral = 5;

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                random = Math.random();
                if (random <= umbral / 100) {
                    image.setRGB(i, j, Color.BLACK.hashCode());
                } else if (random >= 1 - (umbral / 100)) {
                    image.setRGB(i, j, Color.WHITE.hashCode());
                }
            }
        }
        
        return saveImage(image, path, "SaltAndPepper.png");        
    }

    public static String[] toRemoveNoise(String path, String fileName) throws IOException {
        BufferedImage image = ImageIO.read(new File(path + fileName));
        BufferedImage newImage = image;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight() - 1; j++) {
                if ((image.getRGB(i, j) == Color.WHITE.hashCode()) || (image.getRGB(i, j) == Color.BLACK.hashCode())) {
                    newImage.setRGB(i, j, image.getRGB(i, j + 1));
                }
            }
        }

        return saveImage(newImage, path, "Restored.png");        
    }
    
    private static String[] saveImage(BufferedImage image, String path, String fileName) throws IOException{
        ImageIO.write(image, "PNG", new File(path + fileName));
        String[] out = {path, fileName};
        return out;
    }
}
