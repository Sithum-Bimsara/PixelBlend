package pixelBlend;

import pixelBlend.filters.BrightnessFilter;
import pixelBlend.handler.ImageHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String pathname = "pic.png";
            ImageHandler imageHandler = new ImageHandler();

            BufferedImage image = imageHandler.loadImage(pathname);

            BrightnessFilter brightnessFilter = new BrightnessFilter();
            image = brightnessFilter.addFilter(image, 200);

            pathname = "new" + pathname;
            imageHandler.saveImage(image, pathname);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
}