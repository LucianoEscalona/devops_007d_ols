import { useState } from "react"
import { loginSIS } from "../utils/apiHelper"
import { useNavigate } from "react-router-dom"

function Login(){
  
  const [cor, setCor] = useState("")
  const [pas, setPas] = useState("")
  const nav = useNavigate()

  const login = async() => {
    const usuario = {
      id: 0,
      nombre: "",
      apellido: "",
      correo: cor,
      contrasenia: pas,
      rol: ""
    }
    const res = await loginSIS("8080","usuario/login",usuario)
    console.log(res)
    try {
      if(res!=null){
        localStorage.setItem("sesion",JSON.stringify(res))
        console.log(res)
        alert("Sesion iniciada correctamente!")
        nav("/")
      }
    } catch (error) {
      
    }
    }
  

  return(
    <>
    <div className="center_card m-0">
        <div className="div_style form_card_size">
            <h3>Iniciar sesion</h3>
            <p className="mb-0">Correo</p>
            <input 
              type="text" 
              value={cor} 
              onChange={(e)=>setCor(e.target.value)}
              />
            <p className="mb-0">Contraseña</p>
            <input 
              type="password" 
              value={pas} 
              onChange={(e)=>setPas(e.target.value)}
              />
            <p></p>
            <button className="mb-2" onClick={()=>login()}>Iniciar sesion</button>
            <p className="mb-1">No tienes cuenta?, <a href="/register">registrate aqui!</a></p>
            <p className="mb-0"><a href="/">Volver al Inicio.</a></p>
        </div>
    </div>
    </>
  )
}

export default Login