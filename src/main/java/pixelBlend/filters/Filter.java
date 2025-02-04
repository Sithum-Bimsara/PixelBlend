package pixelBlend.filters;

import java.awt.image.BufferedImage;

public interface Filter {
    BufferedImage addFilter(BufferedImage image);
}
