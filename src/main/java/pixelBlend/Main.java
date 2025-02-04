package pixelBlend;

import pixelBlend.ApplyFilterCommand;
import pixelBlend.filters.GrayScaleFilter;
import pixelBlend.ImageHistory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    private static BufferedImage currentImage;
    private static ImageHistory history = new ImageHistory();

    public static void main(String[] args) {
        try {
            String pathname = "photo.png";
            currentImage = ImageIO.read(new File(pathname));
            System.out.println("Image Loaded Successfully");
            System.out.println("Width: " + currentImage.getWidth());
            System.out.println("Height: " + currentImage.getHeight());

            applyFilter(new GrayScaleFilter());
            undo();
            redo();

            ImageIO.write(currentImage, "png", new File("new_" + pathname));

        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    public static void applyFilter(GrayScaleFilter filter) {
        ApplyFilterCommand command = new ApplyFilterCommand(currentImage, filter);
        currentImage = command.execute();
        history.executeCommand(command);
        System.out.println("Filter Applied.");
    }

    public static void undo() {
        currentImage = history.undo(currentImage);
        System.out.println("Undo Performed.");
    }

    public static void redo() {
        currentImage = history.redo(currentImage);
        System.out.println("Redo Performed.");
    }
}
