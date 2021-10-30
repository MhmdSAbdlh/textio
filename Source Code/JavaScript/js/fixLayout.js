var boolean2 = false;
var temp2;

function fixAr(){
    let textArea = document.getElementById('textArea').value.toLowerCase();
    if(!boolean2){
        temp2 = document.getElementById('textArea').value;
        document.getElementById('textArea').value = charChange(textArea);
        document.getElementById("textArea").style.direction = "rtl";
        document.getElementById('btn2').textContent = "Back";
        boolean2 = true;
    }
    else{
        document.getElementById('textArea').value = temp2;
        document.getElementById("textArea").style.direction = "ltr";
        document.getElementById('btn2').textContent = "Fix Arabic";
        boolean2 = false;
    }
}

function charChange(textArea) {
    let toArabic = Array.from(textArea);
    for (let i = 0; i < toArabic.length; i++) {
        switch (toArabic[i]) {
            case 'q':
                toArabic[i] = 'ض';
                break;
            case 'w':
                toArabic[i] = 'ص';
                break;
            case 'W':
                toArabic[i] = 'ً';
                break;
            case 'e':
                toArabic[i] = 'ث';
                break;
            case 'r':
                toArabic[i] = 'ق';
                break;
            case 't':
                toArabic[i] = 'ف';
                break;
            case 'y':
                toArabic[i] = 'غ';
                break;
            case 'u':
                toArabic[i] = 'ع';
                break;
            case 'i':
                toArabic[i] = 'ه';
                break;
            case 'o':
                toArabic[i] = 'خ';
                break;
            case 'p':
                toArabic[i] = 'ح';
                break;
            case '[':
                toArabic[i] = 'ج';
                break;
            case ']':
                toArabic[i] = 'د';
                break;
            case 'a':
                toArabic[i] ='ش';
                break;
            case 's':
                toArabic[i] = 'س';
                break;
            case 'd':
                toArabic[i] = 'ي';
                break;
            case 'f':
                toArabic[i] = 'ب';
                break;
            case 'g':
                toArabic[i] = 'ل';
                break;
            case 'h':
                toArabic[i] = 'ا';
                break;
            case 'H':
                toArabic[i] = 'أ';
                break;
            case 'j':
                toArabic[i] = 'ت';
                break;
            case 'k':
                toArabic[i] = 'ن';
                break;
            case 'l':
                toArabic[i] = 'م';
                break;
            case ';':
                toArabic[i] = 'ك';
                break;
            case '\'':
                toArabic[i] = 'ط';
                break;
            case 'z':
                toArabic[i] = 'ئ';
                break;
            case 'x':
                toArabic[i] = 'ء';
                break;
            case 'c':
                toArabic[i] = 'ؤ';
                break;
            case 'v':
                toArabic[i] = 'ر';
                break;
            case 'b':
                toArabic[i] = 'ل';
                break;
            case 'n':
                toArabic[i] = 'ى';
                break;
            case 'N':
                toArabic[i] = 'آ';
                break;
            case 'm':
                toArabic[i] = 'ة';
                break;
            case '?':
                toArabic[i] = 'ظ';
                break;
            case ',':
                toArabic[i] = 'و';
                break;
            case '.':
                toArabic[i] = 'ز';
                break;
            case '/':
                toArabic[i] = 'ظ';
                break;
            case '`':
                toArabic[i] = 'ذ';
                break;
            default:
                break;
            }
        }
    textArea = toArabic.join("");
    return textArea;
}
