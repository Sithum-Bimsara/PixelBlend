package pixelBlend.filters;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class GaussianBlurFilter implements Filter{

    @Override
    public BufferedImage addFilter(BufferedImage image) {
        float[] GaussianBlurKernel = {
                1/256f, 4/256f, 6/256f, 4/256f, 1/256f,
                4/256f, 16/256f, 24/256f, 16/256f, 4/256f,
                6/256f, 24/256f, 36/256f, 24/256f, 6/256f,
                4/256f, 16/256f, 24/256f, 16/256f, 4/256f,
                1/256f, 4/256f, 6/256f, 4/256f, 1/256f
        };


        Kernel kernel = new Kernel(3, 3, GaussianBlurKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return op.filter(image, null);

    }
}
