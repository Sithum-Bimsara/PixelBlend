package pixelBlend;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String pathname = "pic.png";
            BufferedImage image = ImageIO.read(new File(pathname));
            System.out.println("Image Loaded Successfully");
            System.out.println("Width: " + image.getWidth());
            System.out.println("Height: " + image.getHeight());

            pathname = "new" + pathname;
            ImageIO.write(image, "png", new File(pathname));
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
}