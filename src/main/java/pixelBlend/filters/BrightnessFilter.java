package pixelBlend.filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BrightnessFilter implements Filter {

    @Override
    public BufferedImage addFilter(BufferedImage image) {
        return null;
    }

    public BufferedImage addFilter(BufferedImage image , int percentage) {

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage brightImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));

                int red = Math.min(255, color.getRed()*(percentage/100));
                int green = Math.min(255, color.getGreen()*(percentage/100));
                int blue = Math.min(255, color.getBlue()*(percentage/100));

                Color newColor = new Color(red, green, blue);

                brightImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return brightImage;
    }
}
