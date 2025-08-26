package day7.ex4.test;

import day7.ex4.util.IButton;
import day7.ex4.util.IDisplay;
import day7.ex4.util.IPlug;

public class Monitor implements IPlug, IDisplay, IButton {
    private boolean isPlugged;
    private boolean isOn;
    private boolean isPushed;

    public Monitor() {
        this.isPlugged = false;
        this.isOn = false;
        this.isPushed = false;
    }

    @Override
    public void plugIn() {
        isPlugged = true;
    }

    @Override
    public void plugOut() {
        isPlugged = false;
        HideDisplay();
    }

    @Override
    public boolean isPlugged() {
        return isPlugged;
    }

    @Override
    public void ShowDisplay() {
        isOn = true;
        System.out.println("Display is showing");
    }

    @Override
    public void HideDisplay() {
        isOn = false;
        System.out.println("Display is hiding");
    }

    @Override
    public void pushButton() {
        isPushed = !isPushed;
        if(isPushed && isPlugged) {
            ShowDisplay();
        } else {
            HideDisplay();
        }
    }

    @Override
    public boolean isPushed() {
        return isPushed;
    }
}
