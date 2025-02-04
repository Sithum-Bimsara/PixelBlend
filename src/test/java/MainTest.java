import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testImageLoading() {
        File imageFile = new File(getClass().getClassLoader().getResource("pic.png").getFile());
        assertTrue(imageFile.exists(), "Image file does not exist");

        try {
            BufferedImage image = ImageIO.read(imageFile);

            assertNotNull(image, "Image should not be null");

            assertTrue(image.getWidth() > 0, "Image width should be greater than 0");
            assertTrue(image.getHeight() > 0, "Image height should be greater than 0");
        } catch (IOException e) {
            fail("Exception occurred while loading image: " + e.getMessage());
        }
    }
}
