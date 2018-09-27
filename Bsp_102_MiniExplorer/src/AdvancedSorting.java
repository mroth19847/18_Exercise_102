
import java.util.Comparator;

public class AdvancedSorting implements Comparator<Data>{

    @Override
    public int compare(Data o1, Data o2) {
        if(o1.getName().equals(".."))return -1;
        if(o2.getName().equals(".."))return 1;
        if(o1.isDirectory()&&!o2.isDirectory()) return -1;
        if(!o1.isDirectory()&&o2.isDirectory()) return 1;
        if(MiniExplorerGUI.sortedByKB){
            if(MiniExplorerGUI.asc){
                if(o1.length()>o2.length()) return -1;
                if(o1.length()<o2.length()) return 1;
                return 0;
            } else {
                if(o1.length()>o2.length()) return 1;
                if(o1.length()<o2.length()) return -1;
                return 0;       
            }
        } else {
            if(MiniExplorerGUI.asc){
                return o1.getName().compareTo(o2.getName());
            } else {
                return o1.getName().compareTo(o2.getName())*-1;
            }
        }
    }
    
}
