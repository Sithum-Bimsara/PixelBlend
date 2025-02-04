package pixelBlend;

import java.awt.image.BufferedImage;

public interface ImageCommand {
    BufferedImage execute();
    BufferedImage undo();
}

