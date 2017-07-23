package aux;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class SaltandPepper {
int contx=0;
int conty=0;

    public static void main(String[] args) throws IOException {
        String [] aux = toAddNoise("/home/estudiante/Escritorio/", "clare___claymore_by_hime_soph.png");
        String [] aux2 = toRemoveNoise(aux[0], aux[1]);        
        String [] aux3 = toAddNoiseConquer("/home/estudiante/Escritorio/", "clare___claymore_by_hime_soph.png");
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
    public static String[] toAddNoiseConquer(String path, String fileName) throws IOException {
        BufferedImage image = ImageIO.read(new File(path + fileName));
        double random;
        double umbral = 5;

        
        
        
        return saveImage(image, path, "SaltAndPepperConquer.png");        
    }
  public static String[] Recogerimage(BufferedImage image,String path) throws IOException {
       int []vec=new int[10000];
       ArrayList<Color>colorx=new ArrayList<>();
       for(int i=0;i<image.getWidth();i++)
           for(int j=0;j<image.getHeight();j++){
               int colorImagen=image.getRGB(i, j);
               Color c=new Color(colorImagen);
               colorx.add(c);
               
           }

        return saveImage(image, path, "Restored.png");        
    }
    public  int divImage(  ArrayList<Color>colorx ,int inicio,int Finalc) throws IOException {
     
    int media=colorx.size()/2;
     int izquierda =divImage(colorx,inicio,media);
     int dercha=divImage(colorx,media,Finalc);
     return 0;
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