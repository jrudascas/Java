package aux;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


//Actividad
//Ajuste la rutina toAddNoise basado en la tecnica divide y venceras


/**
 * Esta rutina simula el ruido de sal y pimienta en una imagen a Color e
 * implementa la funcionalidad requerida para eliminar parcialmente el rudio
 *
 * @author jrudascas
 */
public class T9 {

    public static void main(String[] args) throws IOException {
        String[] aux = toAddNoise("/home/jrudascas/Desktop/", "lenna.png");
        String[] aux2 = toRemoveNoise(aux[0], aux[1]);
    }

    /**
     * Agrega ruido de sal y pimienta a una imagen a color
     *
     * @param path Es la ruta al directorio que contiene la imagen
     * @param fileName Es el nombre de la imagen con su extensión
     * @return Retorna un vector de dos posiciones (1. Path de la imagen
     * resultante, 2. Nombre y extensión de la imagen resultante)
     * @throws IOException Se produce una excepcion cuando la imagen no es
     * posible cargarla
     */
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

    /**
     * Elimina el ruido de sal y pimienta a una imagen a color
     *
     * @param path Es la ruta al directorio que contiene la imagen
     * @param fileName Es el nombre de la imagen con su extensión
     * @return Retorna un vector de dos posiciones (1. Path de la imagen
     * resultante, 2. Nombre y extensión de la imagen resultante)
     * @throws IOException Se produce una excepcion cuando la imagen no es
     * posible cargarla
     */
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

    /**
     * Alamcena una imagen cargada en un BufferredImage en la ruta indicada
     *
     * @param image BufferedImage con la imagen
     * @param path Ruta donde se desea almacenar la imagen
     * @param fileName Nombre y extension de la imagen (png)
     * @return Retorna un vector de dos posiciones (1. Path de la imagen
     * resultante, 2. Nombre y extensión de la imagen resultante)
     * @throws IOException Se produce una excepcion cuando la imagen no es
     * posible almacenarla
     */
    private static String[] saveImage(BufferedImage image, String path, String fileName) throws IOException {
        ImageIO.write(image, "PNG", new File(path + fileName));
        String[] out = {path, fileName};
        return out;
    }
}
