package pixelBlend.filters;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class EmbossFilter implements Filter {

    @Override
    public BufferedImage addFilter(BufferedImage image, Integer param) {
        float[] EmbossKernel = {
                -2f, -1f,  0f,
                -1f,  1f,  1f,
                0f,  1f,  2f

        };


        Kernel kernel = new Kernel(3, 3, EmbossKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return op.filter(image, null);
    }
}
