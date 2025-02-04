package pixelBlend;

import pixelBlend.filters.*;
import pixelBlend.handler.ImageHandler;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<BufferedImage> undoStack = new Stack<>();
    private static Stack<BufferedImage> redoStack = new Stack<>();
    private static BufferedImage currentImage;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter image path: ");
        String pathname = scanner.nextLine();
        try {
            currentImage = ImageIO.read(new File(pathname));
            System.out.println("Image Loaded Successfully");
            System.out.println("Width: " + currentImage.getWidth());
            System.out.println("Height: " + currentImage.getHeight());

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Apply Grayscale Filter");
                System.out.println("2. Apply Brightness Filter");
                System.out.println("3. Apply Box Blur Filter");
                System.out.println("4. Apply Gaussian Blur Filter");
                System.out.println("5. Apply Motion Blur Filter");
                System.out.println("6. Apply Emboss Filter");
                System.out.println("7. Apply Sharpen Filter");
                System.out.println("8. Apply Laplacian Filter");
                System.out.println("9. undo");
                System.out.println("10. Redo");
                System.out.println("11. Save and Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        applyFilter(new GrayScaleFilter());
                        break;
                    case 2:
                        // applyFilter(new BrightnessFilter());
                        break;
                    case 3:
                         applyFilter(new BoxBlurFilter());
                        break;
                    case 4:
                         applyFilter(new GaussianBlurFilter());
                        break;
                    case 5:
                         applyFilter(new MotionBlurFilter());
                        break;
                    case 6:
                         applyFilter(new EmbossFilter());
                        break;
                    case 7:
                         applyFilter(new SharpeningFilter());
                        break;
                    case 8:
                         applyFilter(new LaplacianFilter());
                        break;
                    case 9:
                        undo();
                        break;
                    case 10:
                        redo();
                        break;
                    case 11:
                        ImageIO.write(currentImage, "png", new File("new_" + pathname));
                        System.out.println("Image saved as new_" + pathname);
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    public static void applyFilter(Filter filter) {

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