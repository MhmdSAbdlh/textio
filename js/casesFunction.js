// Strip Function
function stripT(){
    document.getElementById('textArea').value = document.getElementById('textArea').value.trim();
}

//UpperCase Function
function upperC(){
    document.getElementById('textArea').value = document.getElementById('textArea').value.toUpperCase();
}

//LowerCase Function
function lowerC(){
    document.getElementById('textArea').value = document.getElementById('textArea').value.toLowerCase();
}

//TitleCase Function
function titleC(){
    stripT();
    let i=0;
	let textC = Array.from(document.getElementById('textArea').value);
    textC[i] = textC[i].toUpperCase();
	i++;
	while(i<textC.length) {
		if(textC[i] == "." || textC[i] == "\n" || textC[i] == "?" || textC[i] == "!") {
			i++;
			while((textC[i] == " " || textC[i] == "." || textC[i] == "\n" || textC[i] == "?" || textC[i] == "!") && i<textC.length-1){
                i++;
            }
			textC[i] = textC[i].toUpperCase();
		}
		else {
			textC[i] = textC[i].toLowerCase();
			}
		i++;
	}
    document.getElementById('textArea').value = textC.join("");
}

//CapitalizeCase Function
function capitalizeC(){
	stripT();
    let i=0;
	let textC = Array.from(document.getElementById('textArea').value);
    textC[i] = textC[i].toUpperCase();
	i++;
	while(i<textC.length) {
		while((textC[i] == " " || textC[i] == "." || textC[i] == "\n" || textC[i] == "?" || textC[i] == "!") && i<textC.length-1){
                i++;
        }
		if(textC[i-1] == " " || textC[i-1] == "." || textC[i-1] == "\n" || textC[i-1] == "?" || textC[i-1] == "!")
			textC[i] = textC[i].toUpperCase();
		else
			textC[i] = textC[i].toLowerCase();
		i++;
	}
    document.getElementById('textArea').value = textC.join("");
}

//FunnyC Function
function funnyC(){
    let i=0;
	let textC = Array.from(document.getElementById('textArea').value);
	while(i<textC.length) {
		if((i+2)%2 == 0) {
				textC[i] = textC[i].toUpperCase();
				}
		else {
            textC[i] = textC[i].toLowerCase();
			}
		i++;
		}
    document.getElementById('textArea').value = textC.join("");
}