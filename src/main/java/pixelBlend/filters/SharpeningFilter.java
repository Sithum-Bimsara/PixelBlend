package pixelBlend.filters;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class SharpeningFilter implements Filter {

    @Override
    public BufferedImage addFilter(BufferedImage image) {
        float[] SharpeningKernel = {
                0f, -1f,  0f,
                -1f,  5f, -1f,
                0f, -1f,  0f

        };


        Kernel kernel = new Kernel(3, 3, SharpeningKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return op.filter(image, null);
    }
}
