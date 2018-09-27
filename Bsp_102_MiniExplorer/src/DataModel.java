
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

public class DataModel extends AbstractListModel<Data> {

    private ArrayList<Data> files = new ArrayList<>();

    @Override
    public int getSize() {
        return files.size();
    }

    @Override
    public Data getElementAt(int index) {
        return files.get(index);
    }

    public void openDir(String path) {
        files.clear();
        File dir = new File(path);
        files.add(new Data(path, ".."));
        for (File f : dir.listFiles()) {
            files.add(new Data(f.getAbsolutePath(), f.getName()));
        }
        sortFiles();
        fireContentsChanged(this, 0, files.size() - 1);
    }

    public void sortFiles() {
        Collections.sort(files, new FileComparer());
    }

    public void advancedSorting() {
        Collections.sort(files, new AdvancedSorting());
        fireContentsChanged(this, 0, files.size() - 1);
    }

    public void displayInf(int idx, JTextArea ta) {
        Data d = files.get(idx);
        ta.setText("");
        ta.append(String.format("Name: %s\n", d.getName()));
        ta.append(String.format("Größe in B: %d \n", d.length()));
        ta.append(String.format("Größe in KB: %d \n", d.length() / 1024));
        if (d.canRead()) {
            ta.append("Readable\n");
        }
        if (d.canWrite()) {
            ta.append("Writable\n");
        }
        if (d.canExecute()) {
            ta.append("Executable\n");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy HH:mm");
        ta.append(String.format("Datum: %s\n",sdf.format(d.lastModified())));
    }
}
