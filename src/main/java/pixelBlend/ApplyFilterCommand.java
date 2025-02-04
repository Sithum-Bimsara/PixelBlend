package pixelBlend;

import pixelBlend.filters.GrayScaleFilter;
import java.awt.image.BufferedImage;

public class ApplyFilterCommand implements ImageCommand {
    private BufferedImage previousState;
    private BufferedImage currentState;
    private GrayScaleFilter filter;

    public ApplyFilterCommand(BufferedImage image, GrayScaleFilter filter) {
        this.previousState = deepCopy(image);
        this.filter = filter;
        this.currentState = filter.addFilter(image);
    }

    @Override
    public BufferedImage execute() {
        return currentState;
    }

    @Override
    public BufferedImage undo() {
        return previousState;
    }

    private BufferedImage deepCopy(BufferedImage image) {
        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        copy.getGraphics().drawImage(image, 0, 0, null);
        return copy;
    }
}
