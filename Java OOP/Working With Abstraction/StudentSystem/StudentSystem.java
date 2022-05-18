package StudentSystem;

import PointInRectangle.input.Reader;

import static StudentSystem.ConsolePrinter.printLine;

public class StudentSystem {
    private CommandHandler handler;
    private boolean isWorking;

    public StudentSystem() {
        this.handler = new CommandHandler();
    }

    public void start() {
        this.isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(Reader.readStringArray("\\s+"));

            if (result != null && !result.equals("Exit") && !result.equals("Show")) {
                printLine(result);
            }
            isWorking = !"Exit".equals(result);
        }
    }
}

