
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractListModel;

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
        files.add(new Data(path,".."));
        for (File f : dir.listFiles()) {
            files.add(new Data(f.getAbsolutePath(),f.getName()));
        }
        sortFiles();
        fireContentsChanged(this, 0, files.size()-1);
    }
    
    public void sortFiles(){
        Collections.sort(files,new FileComparer());
    }
    
    public void advancedSorting(){
        Collections.sort(files,new AdvancedSorting());
        fireContentsChanged(this, 0, files.size()-1);
    }
}
