package pixelBlend;

import pixelBlend.filters.Filter;

import java.awt.image.BufferedImage;

public class ApplyFilterCommand implements ImageCommand {
    private BufferedImage previousState;
    private BufferedImage currentState;
    private Filter filter;

    public ApplyFilterCommand(BufferedImage image, Filter filter, Integer param) {
        this.previousState = deepCopy(image);
        this.filter = filter;
        this.currentState = filter.addFilter(image, param);
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
