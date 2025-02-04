//package pixelBlend;
//
//import java.awt.image.BufferedImage;
//import java.util.Stack;
//
//public class UndoRedo {
//    private Stack<BufferedImage> undoStack = new Stack<>();
//    private Stack<BufferedImage> redoStack = new Stack<>();
//    private BufferedImage currentImage;
//
//    public UndoRedo(BufferedImage initialImage) {
//        this.currentImage = deepCopy(initialImage);
//    }
//
//    public void applyFilter(BufferedImage newImage, ) {
//        undoStack.push(deepCopy(currentImage));
//        redoStack.clear();
//        currentImage = newImage;
//    }
//
//    public void undo() {
//        if (!undoStack.isEmpty()) {
//            redoStack.push(deepCopy(currentImage));
//            currentImage = undoStack.pop();
//            System.out.println("Undo Performed.");
//        } else {
//            System.out.println("No more undo steps available.");
//        }
//    }
//
//    public void redo() {
//        if (!redoStack.isEmpty()) {
//            undoStack.push(deepCopy(currentImage));
//            currentImage = redoStack.pop();
//            System.out.println("Redo Performed.");
//        } else {
//            System.out.println("No more redo steps available.");
//        }
//    }
//
//    public BufferedImage getCurrentImage() {
//        return currentImage;
//    }
//
//
//    private BufferedImage deepCopy(BufferedImage image) {
//        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
//        copy.getGraphics().drawImage(image, 0, 0, null);
//        return copy;
//    }
//}