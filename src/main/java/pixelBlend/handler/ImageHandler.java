package pixelBlend.handler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    public BufferedImage loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            System.out.println("Image Loaded Successfully");
            System.out.println("Width: " + image.getWidth());
            System.out.println("Height: " + image.getHeight());
            return image;
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            return null;
        }
    }

    public void saveImage(BufferedImage image, String path) {
        try {
            ImageIO.write(image, "png", new File(path));
            System.out.println("Image saved successfully: " + path);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
}
