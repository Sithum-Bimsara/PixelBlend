package pixelBlend.filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScaleFilter implements Filter {

    @Override
    public BufferedImage addFilter(BufferedImage img) {
        System.out.println("Applying Grayscale Filter.");

        // Create a new grayscale image
        BufferedImage grayImage = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY
        );

        // Draw the original image into the new grayscale image
        Graphics g = grayImage.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        return grayImage;
    }
}