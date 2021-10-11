function principal(){
    //console.log("Hola")
    const conexion="https://localhost:4567";
    const email = document.getElementById("email").value;
    const passwordUser = document.getElementById("registoContra").value;

    console.log(email)
    console.log(passwordUser)

    let usuario = {
        mail: email,
        password: passwordUser

    }

    axios.post(conexion+"/login", usuario).then( res => {
        if(res.data!=""){
            alert(res.data)
        }
        else {
            window.location.href="secure/inicio.html";
        }

    })


}