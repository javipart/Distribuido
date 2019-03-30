function search() {
    let xhr = new XMLHttpRequest();
    let doc = document.getElementById("doc").value;
    let toSend = "document=" + doc;
    let dateC = new Date();
    xhr.open("POST","SearchServlet", true);
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            if(xhr.responseText == "null"){
                swal("ERROR!","La conexion con la base de datos no esta disponible","error")
            }
            if(xhr.responseText.length > 0 && xhr.responseText != "null"){
                let json = JSON.parse(xhr.responseText);
                let documentDb = json.document;
                let typeDocumentBd = json.typeDocument;
                let nameDb = json.name;
                let lastnameDb = json.lastname;
                let birthdayBd = json.birthdate;
                let dateB = new Date(birthdayBd);
                let salaryJS = json.salary;
                let validate = "undefined";
                let age = dateC.getFullYear()-dateB.getFullYear();
                var Parent = document.getElementById("table");
                while(Parent.hasChildNodes())
                {
                    Parent.removeChild(Parent.firstChild);
                }
                if(new String(documentDb).valueOf() == new String(validate).valueOf()){
                    swal("AVISO!","La persona con documento "+doc+" no existe","info");
                }
                else {

                    let row = "<tr><td>" + documentDb + "</td><td>" + typeDocumentBd + "</td><td>" + nameDb + "</td><td>" + lastnameDb + "</td><td>" + age + "</td><td>" + salaryJS + "</td></tr>";
                    let personV = document.createElement("TR");
                    personV.innerHTML = row;
                    document.getElementById("table").appendChild(personV);
                }
            }
        }
    };
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(toSend);
}