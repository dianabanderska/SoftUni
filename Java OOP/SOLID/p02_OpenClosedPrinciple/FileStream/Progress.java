package p02_OpenClosedPrinciple.FileStream;

public class Progress {
    private final File file;

    public Progress(File file)
    {
        this.file = file;
    }

    public int getCurrentPercent()
    {
        return this.file.getSent() * 100 / this.file.getLength();
    }
}
