package SingleResponsibility.drawingShape;

import SingleResponsibility.drawingShape.Interfaces.DrawingManager;
import SingleResponsibility.drawingShape.Interfaces.DrawingRepository;
import SingleResponsibility.drawingShape.Interfaces.Renderer;
import SingleResponsibility.drawingShape.Interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Renderer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Renderer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }

    @Override
    public void draw(Shape shape) {
        shape.draw(this.renderer, this.drawingRepository);
    }
}
