package org.example.julia.exception;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MakeFragment extends Fragment implements ImageButtonsHandler {
    private final int IMAGE_BUTTONS_THEMES[] = {R.id.ibJava,R.id.ibJavaScript,R.id.ibNodeJs,
            R.id.ibPython,R.id.ibPhp,R.id.ibWindows};
    private EditText etOther;
    private CheckBox cbOther;
    private boolean state;
    public MakeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_make, container, false);
        etOther = (EditText)fragmentView.findViewById(R.id.etOther);
        cbOther = (CheckBox)fragmentView.findViewById(R.id.cbOtherTheme);
        etOther.setFocusable(false);


        cbOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbOther.isChecked()){
                    etOther.setFocusableInTouchMode(true);
                    etOther.setFocusable(true);
                }else{
                    etOther.setFocusable(false);
                }
            }
        });

        for (int i = 0; i<IMAGE_BUTTONS_THEMES.length;i++){
            final ImageButton btTheme;
            btTheme = (ImageButton) fragmentView.findViewById(IMAGE_BUTTONS_THEMES[i]);
            final int BUTTON_ID = IMAGE_BUTTONS_THEMES[i];
            final int ID_BUTTON =i;

            btTheme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOff(BUTTON_ID,state,fragmentView,btTheme);
                }
            });
        }


        return fragmentView;
    }








    @Override
    public void onOff(int id, boolean status, View view,ImageButton imageButton) {
        imageButton = (ImageButton) view.findViewById(id);
        if(imageButton !=null){
            if (status){
                selectedImageButton(id,imageButton,view);
                state = false;
            }else{
                unselectedImageButton(id,imageButton,view);
                state = true;
            }
        }else{
            Toast.makeText(getContext(), "NULL", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void selectedImageButton(int id, ImageButton imageButton,View view) {
        imageButton = (ImageButton) view.findViewById(id);
        if (R.id.ibJava==id){
            imageButton.setImageResource(R.drawable.java_on_icon);
        }else if(R.id.ibWindows==id){
            imageButton.setImageResource(R.drawable.windows_on_icon);
        }else if(R.id.ibPhp==id){
            imageButton.setImageResource(R.drawable.php_on_icon);
        }else if(R.id.ibPython==id){
            imageButton.setImageResource(R.drawable.python_on_icon);
        }else if(R.id.ibNodeJs==id){
            imageButton.setImageResource(R.drawable.nodejs_on_icon);
        }else {
            imageButton.setImageResource(R.drawable.javascript_on_icon);
        }
    }

    @Override
    public void unselectedImageButton(int id, ImageButton imageButton,View view) {
        imageButton = (ImageButton) view.findViewById(id);
        if (R.id.ibJava==id){
            imageButton.setImageResource(R.drawable.java_off_icon);
        }else if(R.id.ibWindows==id){
            imageButton.setImageResource(R.drawable.windows_off_icon);
        }else if(R.id.ibPhp==id){
            imageButton.setImageResource(R.drawable.php_off_icon);
        }else if(R.id.ibPython==id){
            imageButton.setImageResource(R.drawable.python_off_icon);
        }else if(R.id.ibNodeJs==id){
            imageButton.setImageResource(R.drawable.nodejs_off_icon);
        }else {
            imageButton.setImageResource(R.drawable.javascript_off_icon);
        }

    }
}
