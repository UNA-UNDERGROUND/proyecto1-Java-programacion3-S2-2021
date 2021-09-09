

public class Color extends MouseAdapter implements MouseListener{
    private Color color;
}

public Color (Color color) {
    this.color=color;
}

public void  mouseEntered(MouseEvent evt) {
    Component source= (Component) evt.getSource();
    source.setBackground(color);
}

public void mouseExited(MouseEvent evt){
    Component source= (Component) evt.getSource();
    source.setBackground(Color.white); 
}