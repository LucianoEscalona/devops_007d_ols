import { useEffect, useState } from "react"
import CardProducto from "../components/CardProducto"
import PostProducto from "../components/PostProducto"
import { getSMT } from "../utils/apiHelper"

function Producto_detalle(){

  const [mostrar, setMostrar] = useState(false)
  const [admin, setAdmin] = useState(false)
  const [productos, setProductos] = useState([])

  useEffect(()=>{
    try{
      const sesion = JSON.parse(localStorage.getItem("sesion"))
      if(sesion.rol == "admin"){setAdmin(true)}
      try {
        const list = async()=>{
        const res = await getSMT("8081","producto/list")
        setProductos(res)
        }
        list()
      } catch (error) {
        
      }
      
    }catch(e){

    }
  },[])
  
  return(
    <>
    <div className="p-5">
      <h3 className="mb-3">Productos disponibles:</h3>
      {admin &&
        <button className="mb-5" onClick={()=>setMostrar(true)}>Registrar producto</button>
      }
      <div className="row m-0">
        {productos.map((p,i)=>(
          <CardProducto id={p.id}key={i}/>
        ))}
      </div>        
      {mostrar && 
        <PostProducto cerrar={()=>setMostrar(false)}/>
       }
    </div>
    </>
  )
}

export default Producto_detalle