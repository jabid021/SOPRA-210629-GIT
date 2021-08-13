var sec=0;
var min=0;
var interval;
var numero=0;
var score=0;
var pays =
[
  {"pays":"France","capitale":"Marseille"},
  {"pays":"Irlande","capitale":"Dublin"},
  {"pays":"Mongolie","capitale":"Oulan-bator"},
  {"pays":"Burkina Faso","capitale":"Ouagadougou"},
  {"pays":"Pologne","capitale":"Varsovie"}
];


play.onclick=lancerTimer;
pause.onclick=stopTimer;
validate.onclick=verif;
reponse.onkeyup=keyReponse;

function lancerTimer()
{
interval= setInterval(calculTime,1000);
play.disabled=true;
pause.disabled=false;
timer.style.display="block";
divQuestion.style.display="block";
game();
}

function stopTimer()
{
clearInterval(interval);
play.disabled=false;
pause.disabled=true;
divQuestion.style.display="none";
}

function calculTime()
{
sec++;
if(sec==60)
{
  min++;
  sec=0;
  if(min==60){min=0;}
}

var minAffiche = (min<10) ? "0"+min : min;
var secAffiche = (sec<10) ? "0"+sec : sec;
timer.innerHTML=minAffiche+":"+secAffiche;
}

function keyReponse(e)
{
  validate.disabled=true;

  if(reponse.value!="")
  {
    validate.disabled=false;
    if(e.keyCode==13 )
    {
      verif();
    }
  }

}

function game()
{
question.innerHTML="Quelle est la capitale de : "+pays[numero].pays;

}

function verif()
{
if(reponse.value==pays[numero].capitale)
{
  score++;
  resultat.innerHTML="BONNE REPONSE ! <img width='50' src='content.png'>";
}
else
{
  resultat.innerHTML="MAUVAISE REPONSE ! <img width='50' src='angry.png'>";
}
reponse.value="";
numero++;
if(numero>=pays.length){
  finDuJeu();
}
else
{
  game();
}
}

function finDuJeu()
{
stopTimer();
play.disabled=true;
scoreFinal.innerHTML="Votre score est de "+score +" / "+pays.length;
}
