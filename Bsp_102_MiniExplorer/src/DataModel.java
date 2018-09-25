
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class DataModel extends AbstractListModel {

    private ArrayList<File> files = new ArrayList<>();

    @Override
    public int getSize() {
        return files.size();
    }

    @Override
    public Object getElementAt(int index) {
        return files.get(index);
    }

    public void openDir(String path) {
        File dir = new File(path);
        for (File f : dir.listFiles()) {
            files.add((Data) f);
        }
        fireContentsChanged(this, 0, files.size()-1);
    }
}
