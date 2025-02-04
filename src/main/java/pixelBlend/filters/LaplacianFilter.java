package pixelBlend.filters;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class LaplacianFilter implements Filter {

    @Override
    public BufferedImage addFilter(BufferedImage image) {
        float[] LaplacianKernel = {
                0f, -1f,  0f,
                -1f,  4f, -1f,
                0f, -1f,  0f

        };


        Kernel kernel = new Kernel(3, 3, LaplacianKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return op.filter(image, null);
    }
}
