package com.mhmdsabdlh.textio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean btnRTL = false;
    private String oldText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enToAr(View view){
        TextView textView = (TextView)findViewById(R.id.textArea);
        Button btn = (Button) view;
        if(!btnRTL) {
            oldText = textView.getText().toString();
            textView.setTextDirection(View.TEXT_DIRECTION_RTL);
            textView.setText(textView.getText().toString().toLowerCase());
            textView.setText(engToArabic(textView.getText().toString()));

            btn.setText("Back");
            btnRTL = true;
        }
        else {
            textView.setTextDirection(View.TEXT_DIRECTION_LTR);
            textView.setText(oldText);
            btnRTL = false;
            btn.setText("English to Arabic");
        }
    }

    public void cutText(View view){
        TextView textView = (TextView)findViewById(R.id.textArea);
        ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", textView.getText());
        manager.setPrimaryClip(clipData);
        textView.setText("");
    }

    public void copyText(View view){
        TextView textView = (TextView)findViewById(R.id.textArea);
        ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", textView.getText());
        manager.setPrimaryClip(clipData);
    }

    public void pasteText(View view){
        TextView textView = (TextView)findViewById(R.id.textArea);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        try {
            CharSequence textToPaste = clipboard.getPrimaryClip().getItemAt(0).getText();
            textView.setText(textToPaste);
        } catch (Exception e) {
            return;
        }
    }

    public void stripText(View view){

        TextView textView = (TextView)findViewById(R.id.textArea);
        textView.setText(textView.getText().toString().trim());
    }

    public void upperCase(View view){

        TextView textView = (TextView)findViewById(R.id.textArea);
        textView.setText(textView.getText().toString().toUpperCase());
    }

    public void lowerCase(View view){

        TextView textView = (TextView)findViewById(R.id.textArea);
        textView.setText(textView.getText().toString().toLowerCase());
    }

    public void titleCase(View view){

        TextView textView = (TextView)findViewById(R.id.textArea);
        int i=0;
        char x = textView.getText().charAt(i);
        char[] textC = textView.getText().toString().toCharArray();
        textC[i] = Character.toUpperCase(x);
        while(i<textView.getText().toString().length()-1) {
            if(x == '.' || x == '\n' || x == '?' || x == '!') {
                while(textC[i+1] == ' ' && i<textView.getText().toString().length()-2)
                    i++;
                x = textView.getText().toString().charAt(i+1);
                textC[i+1] = Character.toUpperCase(x);
            }
            else {
                x = textView.getText().toString().charAt(i+1);
                textC[i+1] = Character.toLowerCase(x);
            }
            i++;
        }
        textView.setText(String.valueOf(textC));
    }

    public void spongeBobCase(View view){

        TextView textView = (TextView)findViewById(R.id.textArea);
        int i=0;
        char x;
        char[] textC = textView.getText().toString().toCharArray();
        while(i<textView.getText().toString().length()) {
            if((i+2)%2 == 0) {
                x = textView.getText().charAt(i);
                textC[i] = Character.toUpperCase(x);
            }
            else {
                x = textView.getText().charAt(i);
                textC[i] = Character.toLowerCase(x);
            }
            i++;
        }
        textView.setText(String.valueOf(textC));
    }

    private String engToArabic(String text) {

        char[] toArabic = text.toCharArray();

        for(int i=0;i<toArabic.length;i++) {
            if(i<toArabic.length-1){//IF0
                //IF1
                if((i ==0 && toArabic[i] =='a') ||
                        (toArabic[i] == 'a' && toArabic[i-1] == ' ' && i>0) ||
                        (toArabic[i] == 'a' && toArabic[i+1] == ' ')||
                        (toArabic[i] == 'a' && toArabic[i+1] == 'a')||
                        (i == 0 && toArabic[i] =='e') ||
                        (toArabic[i] == 'e' && toArabic[i-1] == ' ' && i>0)||
                        (i == 0 && toArabic[i] =='i') ||
                        (toArabic[i] == 'i' && toArabic[i-1] == ' ' && i>0))
                    toArabic[i] = '??';
                else//ELSE1
                    if(toArabic[i] == 'g' && toArabic[i+1] == 'h'){//IF2
                        toArabic[i] = '??';
                        toArabic[i+1] = '??';
                    }
                    else//ELSE2
                        if((toArabic[i] == 'c' && toArabic[i+1] == 'h') ||//IF3
                                (toArabic[i] == 's' && toArabic[i+1] == 'h')) {
                            toArabic[i] = '??';
                            toArabic[i+1] = '??';
                        }
                        else//ELSE3
                            if((toArabic[i] == 'e' && toArabic[i+1] == 'i')||//IF4
                                    (toArabic[i] == 'i' && toArabic[i+1] == 'e')||
                                    (toArabic[i] == 'y' && toArabic[i+1] == 'e')||
                                    (toArabic[i] == 'e' && toArabic[i+1] == 'e')){
                                toArabic[i] = '??';
                                toArabic[i+1] = '??';
                            }
                            else
                            if(toArabic[i] == 'k' && toArabic[i+1] == 'h') {
                                toArabic[i] = '??';
                                toArabic[i+1] = '??';
                            }
                            else
                            if((toArabic[i] == 'e' && toArabic[i+1] == ' ')||
                                    (toArabic[i] == 'i' && toArabic[i+1] == ' ')) {
                                toArabic[i] = '??';
                                toArabic[i+1] = ' ';
                            }
                            else//ELSE4
                                engToArLetters(toArabic, i);
            }
            else
            if(i==toArabic.length-1)
                if(toArabic[i] == 'e' || toArabic[i] == 'i')
                    toArabic[i] = '??';
                else
                if(toArabic[i] == 'a')
                    toArabic[i] = '??';
                else
                    engToArLetters(toArabic,i);
            else
                engToArLetters(toArabic, i);
        }
        return String.valueOf(toArabic);
    }

    private void engToArLetters(char[] toArabic, int i) {
        switch (toArabic[i]) {
            case 'q':
                toArabic[i] = '??';
                break;
            case 'w':
                toArabic[i] = '??';
                break;
            case 'e':
                toArabic[i] = '??';
                break;
            case 'r':
                toArabic[i] = '??';
                break;
            case 't':
                toArabic[i] = '??';
                break;
            case 'y':
                toArabic[i] = '??';
                break;
            case 'u':
                toArabic[i] = '??';
                break;
            case 'i':
                toArabic[i] = '??';
                break;
            case 'o':
                toArabic[i] = '??';
                break;
            case 'p':
                toArabic[i] = '??';
                break;
            case 'a':
                toArabic[i] ='??';
                break;
            case 's':
                toArabic[i] = '??';
                break;
            case 'd':
                toArabic[i] = '??';
                break;
            case 'f':
                toArabic[i] = '??';
                break;
            case 'g':
                toArabic[i] = '??';
                break;
            case 'h':
                toArabic[i] = '??';
                break;
            case 'j':
                toArabic[i] = '??';
                break;
            case 'k':
                toArabic[i] = '??';
                break;
            case 'l':
                toArabic[i] = '??';
                break;
            case 'z':
                toArabic[i] = '??';
                break;
            case 'c':
                toArabic[i] = '??';
                break;
            case 'v':
                toArabic[i] = '??';
                break;
            case 'b':
                toArabic[i] = '??';
                break;
            case 'n':
                toArabic[i] = '??';
                break;
            case 'm':
                toArabic[i] = '??';
                break;
            case '?':
                toArabic[i] = '??';
                break;
            case '2':
                toArabic[i] = '??';
                break;
            case '3':
                toArabic[i] = '??';
                break;
            case '5':
                toArabic[i] = '??';
                break;
            case '7':
                toArabic[i] = '??';
                break;
            case '8':
                toArabic[i] = '??';
                break;
            case '6':
                toArabic[i] = '??';
                break;
            case '9':
                toArabic[i] = '??';
                break;
            case '4':
                toArabic[i] = '??';
                break;
            case '1':
                toArabic[i] = '??';
                break;
            case '0':
                toArabic[i] = '??';
                break;
            default:
                break;
        }
    }
}