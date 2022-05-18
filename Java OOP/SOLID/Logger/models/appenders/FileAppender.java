package Logger.models.appenders;

import Logger.interfaces.File;
import Logger.interfaces.Layout;
import Logger.models.files.LogFile;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    protected void append(String text) {
        this.file.write(text);
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d", super.toString(), this.file.getSize());
    }
}
