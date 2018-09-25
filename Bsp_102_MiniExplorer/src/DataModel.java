
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class DataModel extends AbstractListModel{

    private ArrayList<File> files = new ArrayList<>();
    
    @Override
    public int getSize() {
        return files.size();
    }

    @Override
    public Object getElementAt(int index) {
        return files.get(index);
    }
    
//    File dir = new File(".");
//    for (File f : dir.listFiles()){
//            f.isDirectory()
//            System.out.println(f.getAbsolutePath());
//    }
    
}
