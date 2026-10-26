import { useState } from "react"
import { postSMT } from "../utils/apiHelper"

function Register(){
  
  const [nombre, setNombre] = useState("")
  const [apellido, setApellido] = useState("")
  const [correo, setCorreo] = useState("")
  const [contrasenia, setContrasenia] = useState("")
  const [rol, setRol] = useState("normal")

  const registrarse = () => {
    const usuario = {
      nombre: nombre,
      apellido: apellido,
      correo: correo,
      contrasenia: contrasenia,
      rol: rol
    }
    const post = async()=>{
      const res = await postSMT("8080","usuario/register",usuario)
      try {
        alert("Cuenta creada!")
      } catch (error) {
        alert("La cuenta ya existe!")
      }
    }
    post()
  }

  return(
    <>
    <div className="center_card m-0">
        <div className="div_style form_card_size">
            <h3>Registro</h3>

            <p className="mb-0">Nombre</p>
            <input 
              type="text" 
              value={nombre} 
              onChange={(e)=>setNombre(e.target.value)}
              />

            <p className="mb-0">Apellido</p>
            <input 
              type="text" 
              value={apellido} 
              onChange={(e)=>setApellido(e.target.value)}
              />

            <p className="mb-0">Correo</p>
            <input 
              type="text" 
              value={correo} 
              onChange={(e)=>setCorreo(e.target.value)}
              />

            <p className="mb-0">Contraseña</p>
            <input 
              type="password" 
              value={contrasenia} 
              onChange={(e)=>setContrasenia(e.target.value)}
              />
            <p></p>
            <button className="mb-2" onClick={()=>registrarse()}>Registrarme</button>
            <p className="mb-0"><a href="/login">Volver al Login.</a></p>
        </div>
        <button className="mb-2" onClick={()=>setRol("admin")}>SER ADMIN</button>
    </div>
    </>
  )
}

export default Register