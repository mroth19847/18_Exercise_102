
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;



public class CellRenderer implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object o, int i, boolean isSelected, boolean hasFocus) {
        JLabel label = new JLabel(o.toString());
        label.setOpaque(true);
        if(o instanceof Data){
            Data d = (Data) o;
            if(d.isDirectory()) label.setForeground(Color.red);
            else label.setForeground(Color.blue);
        }
        label.setBackground(isSelected ? Color.lightGray : Color.white);
        return label;
    }
    
}
