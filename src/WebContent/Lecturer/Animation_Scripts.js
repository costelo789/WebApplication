/*FUNCTION FOR PAGE'S ANIMATION*/
function openR1() {
    //document.getElementById("Row1").style.width = "1000px";
    document.getElementById("theEnrollmentList").style.left = "0%";
    document.getElementById("theModuleList").style.marginLeft = "100%";
    //document.body.style.backgroundColor = "#2a69d1";
}
   
function closeR1() {
    //document.getElementById("Row1").style.width = "0";
    document.getElementById("theEnrollmentList").style.left = "-100%";
    document.getElementById("theModuleList").style.marginLeft= "0%";
    //document.body.style.backgroundColor = "#2a69d1";
}