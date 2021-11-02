// Shuffle char function
function shuffle(array){
    let currentIndex = array.length,  randomIndex;

    // While there remain elements to shuffle...
    while (currentIndex != 0) {
  
      // Pick a remaining element...
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex--;
  
      // And swap it with the current element.
      [array[currentIndex], array[randomIndex]] = [
        array[randomIndex], array[currentIndex]];
    }
  
    return array
}

function newKeyBtn(){
    let c = " ".charCodeAt(0);
    let textList = new Array;
	for(let i=32;i<127;i++) {
		textList.push(c);
		c++;
	}
    let shuffledList = shuffle(textList);
    let keyChar = new Array;
    for(let i=0;i<shuffledList.length;i++) {
		keyChar.push(String.fromCharCode(shuffledList[i]));
	}
    let keyString = keyChar.join("");

    document.getElementById('currentKey').value = keyString;
}
newKeyBtn();

function encBtn(){
    let textAreaArray = Array.from(document.getElementById('textArea').value);
    let shuffledArray = Array.from(document.getElementById('currentKey').value);
    for(let j=0;j<textAreaArray.length;j++){
        for(let i=0; i<shuffledArray.length;i++){
			if(textAreaArray[j] == String.fromCharCode(32+i)){
                textAreaArray[j] = shuffledArray[i];
                break;
            }
        }
    }
    document.getElementById('textArea').value = textAreaArray.join("");
}

function decBtn(){
    let textAreaArray = Array.from(document.getElementById('textArea').value);
    let shuffledArray = Array.from(document.getElementById('currentKey').value);
    for(let j=0;j<textAreaArray.length;j++){
        for(let i=0; i<shuffledArray.length;i++){
			if(textAreaArray[j] == shuffledArray[i]){
                textAreaArray[j] = String.fromCharCode(32+i);
                break;
            }
        }
    }
    document.getElementById('textArea').value = textAreaArray.join("");
}
