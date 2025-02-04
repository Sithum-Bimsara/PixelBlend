package pixelBlend;

import pixelBlend.ImageCommand;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class ImageHistory {
    private Stack<ImageCommand> undoStack = new Stack<>();
    private Stack<ImageCommand> redoStack = new Stack<>();

    public void executeCommand(ImageCommand command) {
        undoStack.push(command);
        redoStack.clear();
    }

    public BufferedImage undo(BufferedImage currentImage) {
        if (!undoStack.isEmpty()) {
            ImageCommand command = undoStack.pop();
            redoStack.push(command);
            return command.undo();
        }
        System.out.println("No more undo steps available.");
        return currentImage;
    }

    public BufferedImage redo(BufferedImage currentImage) {
        if (!redoStack.isEmpty()) {
            ImageCommand command = redoStack.pop();
            undoStack.push(command);
            return command.execute();
        }
        System.out.println("No more redo steps available.");
        return currentImage;
    }
}
