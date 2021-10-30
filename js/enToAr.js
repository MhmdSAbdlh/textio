var boolean = false;
var temp;

function engToAr(){
    let textArea = document.getElementById('textArea').value.toLowerCase();
    if(!boolean){
        temp = document.getElementById('textArea').value;
        document.getElementById('textArea').value = engToArabic(textArea);
        document.getElementById("textArea").style.direction = "rtl";
        document.getElementById('btn').textContent = "Back";
        boolean = true;
    }
    else{
        document.getElementById('textArea').value = temp;
        document.getElementById("textArea").style.direction = "ltr";
        document.getElementById('btn').textContent = "En→Ar";
        boolean = false;
    }
}

function engToArabic(textArea) {
    let toArabic = Array.from(textArea);
    for (let i = 0; i < toArabic.length; i++) {
        if (i < toArabic.length - 1) {
            if ((i == 0 && toArabic[i] == 'a') ||
                (toArabic[i] == 'a' && toArabic[i - 1] == ' ' && i > 0) ||
                (toArabic[i] == 'a' && toArabic[i + 1] == ' ') ||
                (toArabic[i] == 'a' && toArabic[i + 1] == 'a') ||
                (i == 0 && toArabic[i] == 'e') ||
                (toArabic[i] == 'e' && toArabic[i - 1] == ' ' && i > 0) ||
                (i == 0 && toArabic[i] == 'i') ||
                (toArabic[i] == 'i' && toArabic[i - 1] == ' ' && i > 0))
                toArabic[i] = 'ا';
            else if (toArabic[i] == 'g' && toArabic[i + 1] == 'h') {
                toArabic[i] = 'غ';
                toArabic[i + 1] = 'َ';
            }
            else if ((toArabic[i] == 'c' && toArabic[i + 1] == 'h') ||
                (toArabic[i] == 's' && toArabic[i + 1] == 'h')) {
                toArabic[i] = 'ش';
                toArabic[i + 1] = 'َ';
            }
            else if ((toArabic[i] == 'e' && toArabic[i + 1] == 'i') ||
                (toArabic[i] == 'i' && toArabic[i + 1] == 'e') ||
                (toArabic[i] == 'y' && toArabic[i + 1] == 'e') ||
                (toArabic[i] == 'e' && toArabic[i + 1] == 'e')) {
                toArabic[i] = 'ي';
                toArabic[i + 1] = 'ْ';
            }
            else if (toArabic[i] == 'k' && toArabic[i + 1] == 'h') {
                toArabic[i] = 'خ';
                toArabic[i + 1] = 'َ';
            }
            else if ((toArabic[i] == 'e' && toArabic[i + 1] == ' ') ||
                (toArabic[i] == 'i' && toArabic[i + 1] == ' ')) {
                toArabic[i] = 'ي';
                toArabic[i + 1] = ' ';
            }

            else
            engArChar(toArabic, i);
        }
        else if (i == toArabic.length - 1)
            if (toArabic[i] == 'e' || toArabic[i] == 'i')
                toArabic[i] = 'ي';
            else if (toArabic[i] == 'a')
                toArabic[i] = 'ا';

            else
            engArChar(toArabic, i);

        else
        engArChar(toArabic, i);
    }
    textArea = toArabic.join("");
    return textArea;
}

function engArChar(toArabic, i) {
    switch (toArabic[i]) {
        case 'q':
            toArabic[i] = 'ك';
            break;
        case 'w':
            toArabic[i] = 'و';
            break;
        case 'e':
            toArabic[i] = 'َ';
            break;
        case 'r':
            toArabic[i] = 'ر';
            break;
        case 't':
            toArabic[i] = 'ت';
            break;
        case 'y':
            toArabic[i] = 'ي';
            break;
        case 'u':
            toArabic[i] = 'ي';
            break;
        case 'i':
            toArabic[i] = 'ي';
            break;
        case 'o':
            toArabic[i] = 'و';
            break;
        case 'p':
            toArabic[i] = 'ب';
            break;
        case 'a':
            toArabic[i] = 'َ';
            break;
        case 's':
            toArabic[i] = 'س';
            break;
        case 'd':
            toArabic[i] = 'د';
            break;
        case 'f':
            toArabic[i] = 'ف';
            break;
        case 'g':
            toArabic[i] = 'غ';
            break;
        case 'h':
            toArabic[i] = 'ه';
            break;
        case 'j':
            toArabic[i] = 'ج';
            break;
        case 'k':
            toArabic[i] = 'ك';
            break;
        case 'l':
            toArabic[i] = 'ل';
            break;
        case 'z':
            toArabic[i] = 'ز';
            break;
        case 'c':
            toArabic[i] = 'س';
            break;
        case 'v':
            toArabic[i] = 'ف';
            break;
        case 'b':
            toArabic[i] = 'ب';
            break;
        case 'n':
            toArabic[i] = 'ن';
            break;
        case 'm':
            toArabic[i] = 'م';
            break;
        case '?':
            toArabic[i] = '؟';
            break;
        case '2':
            toArabic[i] = 'أ';
            break;
        case '3':
            toArabic[i] = 'ع';
            break;
        case '5':
            toArabic[i] = 'خ';
            break;
        case '7':
            toArabic[i] = 'ح';
            break;
        case '8':
            toArabic[i] = 'غ';
            break;
        case '6':
            toArabic[i] = 'ط';
            break;
        case '9':
            toArabic[i] = 'ص';
            break;
        case '4':
            toArabic[i] = 'ض';
            break;
        case '1':
            toArabic[i] = 'ظ';
            break;
        case '0':
            toArabic[i] = 'ذ';
            break;
        default:
            break;
    }
}
