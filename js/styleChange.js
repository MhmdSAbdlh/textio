function changeSize(){
    document.getElementById('textArea').style.fontSize = document.getElementById('fontSize').value + "px";
}

function changeColor(){
    document.getElementById('textArea').style.color = document.getElementById('html5colorpicker').value;
}

function changeFont(){
    document.getElementById('textArea').style.fontFamily = document.getElementById('fontName').value;
}

function italicS(){
    if(document.getElementById('italicS').checked){
        document.getElementById('textArea').style.fontStyle = document.getElementById('italicS').value;
        document.getElementById('italicLabel').style.color = '#001E6C';
        document.getElementById('italicLabel').style.fontStyle = 'italic';
    }
    else{
        document.getElementById('textArea').style.fontStyle = "normal";
        document.getElementById('italicLabel').style.color = 'rgb(184,197,254)';
        document.getElementById('italicLabel').style.fontStyle = 'normal';
    }
}

function boldS(){
    if(document.getElementById('boldS').checked){
        document.getElementById('textArea').style.fontWeight = document.getElementById('boldS').value;
        document.getElementById('boldLabel').style.color = '#001E6C';
        document.getElementById('boldLabel').style.fontWeight = 'bold';
    }
    else{
        document.getElementById('textArea').style.fontWeight = "normal";
        document.getElementById('boldLabel').style.color = 'rgb(184,197,254)';
        document.getElementById('boldLabel').style.fontWeight = 'normal';
    }
}

function underlineS(){
    if(document.getElementById('underlineS').checked){
        document.getElementById('textArea').style.textDecoration = document.getElementById('underlineS').value;
        document.getElementById('undelineLabel').style.color = '#001E6C';
        document.getElementById('undelineLabel').style.textDecoration = 'underline';
    }
    else{
        document.getElementById('textArea').style.textDecoration = "none";
        document.getElementById('undelineLabel').style.color = 'rgb(184,197,254)';
        document.getElementById('undelineLabel').style.textDecoration = 'none';
    }
}