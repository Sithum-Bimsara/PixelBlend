package pixelBlend.filters;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class MotionBlurFilter implements Filter {

    @Override
    public BufferedImage addFilter(BufferedImage image) {
        float[] MotionBlurKernel = {
                1/5f, 1/5f, 1/5f, 1/5f, 1/5f,
                0f, 1/5f, 1/5f, 1/5f, 1/5f,
                0f, 0f, 1/5f, 1/5f, 1/5f,
                0f, 0f, 0f, 1/5f, 1/5f,
                0f, 0f, 0f, 0f, 1/5f
        };


        Kernel kernel = new Kernel(3, 3, MotionBlurKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return op.filter(image, null);
    }
}
