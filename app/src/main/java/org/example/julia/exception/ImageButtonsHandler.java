package org.example.julia.exception;

import android.view.View;
import android.widget.ImageButton;

public interface ImageButtonsHandler {
    public void onOff(int id,boolean status,View view,ImageButton imageButton);
    public void selectedImageButton(int id,ImageButton imageButton,View view);
    public void unselectedImageButton(int id,ImageButton imageButton,View view);
}
