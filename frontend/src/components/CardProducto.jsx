import { useEffect, useState } from "react"
import { deleteSMT, getSMT_ID, putSMT } from "../utils/apiHelper"

function CardProducto({id}){

  const [admin, setAdmin] = useState(false)
  const [producto, setProducto] = useState({})
  
  const del = async()=>{
    const res = await deleteSMT("8081","producto/delete",id)
    if(res!=null){alert("Producto eliminado")}
    window.location.reload()
  }
  const comprar = async()=>{
    const p_mod = {
      id: id,
      nombre: producto.nombre,
      precio: producto.precio,
      stock: producto.stock - 1
    }
    if(producto.stock>=1){
      const res = await putSMT("8081","producto/put",p_mod)
      if(res!=null){alert("Compra realizada!")}
      window.location.reload()
    }else{
      alert("Stock insuficiente")
    }
  }

  useEffect(()=>{
    
    console.log(id)

    try{
      const sesion = JSON.parse(localStorage.getItem("sesion"))
      if(sesion.rol == "admin"){setAdmin(true)}

      const get = async()=>{
        const res = await getSMT_ID("8081","producto/get",id)
        setProducto(res)
      }
      get()
    }catch(e){

    }
  },[id])

  return(
    <div className="div_style col-lg-3 col-md-6 col-sm-12 m-0">
      <p>{producto.nombre}</p>
      <p>Precio: {producto.precio}</p>
      <p>Stock: {producto.stock}</p>
      <button onClick={()=>comprar()}>Comprar</button>
      {admin &&
        <>
          <p></p>
          <button onClick={()=>del()}>Eliminar</button>
        </>
      }
    </div>
  )
}

export default CardProducto