package pixelBlend;

import pixelBlend.filters.GrayScaleFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Main {
    private static Stack<BufferedImage> undoStack = new Stack<>();
    private static Stack<BufferedImage> redoStack = new Stack<>();
    private static BufferedImage currentImage;

    public static void main(String[] args) {
        try {
            String pathname = "photo.png";
            currentImage = ImageIO.read(new File(pathname));
            System.out.println("Image Loaded Successfully");
            System.out.println("Width: " + currentImage.getWidth());
            System.out.println("Height: " + currentImage.getHeight());


            applyFilter(new GrayScaleFilter());


            undo();

            //redo();



            ImageIO.write(currentImage, "png", new File("new_" + pathname));

        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    public static void applyFilter(GrayScaleFilter filter) {

        undoStack.push(deepCopy(currentImage));
        redoStack.clear();
        currentImage = filter.addFilter(currentImage);
        System.out.println("Filter Applied.");
    }

    public static void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(deepCopy(currentImage));
            currentImage = undoStack.pop();
            System.out.println("Undo Performed.");
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public static void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(deepCopy(currentImage)); // Save current state in undo stack
            currentImage = redoStack.pop();
            System.out.println("Redo Performed.");
        } else {
            System.out.println("No more redo steps available.");
        }
    }


    private static BufferedImage deepCopy(BufferedImage image) {
        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        copy.getGraphics().drawImage(image, 0, 0, null);
        return copy;
    }
}