package input;

import ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean lefPressed,
                    rightPressed;
    private int mouseX,
                mouseY;
    private UIManager uiManager;

    public MouseManager() {
    }

    //implemented methods
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            lefPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            lefPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;

        if (uiManager != null){
            uiManager.onMouseRelease(e);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if (uiManager != null){
            uiManager.onMouseMove(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    //GETTERS

    public boolean isLefPressed(){
        return lefPressed;
    }

    public boolean isRightPressed(){
        return rightPressed;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

}
