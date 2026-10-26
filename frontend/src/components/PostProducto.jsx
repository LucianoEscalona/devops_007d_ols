import { useEffect, useState } from "react"
import { postSMT } from "../utils/apiHelper"

function PostProducto({cerrar}){
  
  const [nombre, setNombre] = useState("")
  const [precio, setPrecio] = useState("")
  const [stock, setStock] = useState("")

  const agregarProducto = () => {
    const producto = {
      nombre: nombre,
      precio: precio,
      stock: stock
    }
    const post = async() => {
      try {
        const res = await postSMT("8081","producto/post",producto)
        console.log(res)
        alert("Producto guardado")
      } catch (error) {
        alert("No se pudo guardar el producto")
      }
    }
    post()
  }

  return(
    <>
    <div className="center_card m-0">
        <div className="div_style form_card_size">
            <h3>Crear nuevo producto</h3>
            <p className="mb-0">Nombre</p>
            <input 
              type="text" 
              value={nombre} 
              onChange={(e)=>setNombre(e.target.value)}
              />

            <p className="mb-0">Precio</p>
            <input 
              type="number" 
              value={precio} 
              onChange={(e)=>setPrecio(e.target.value)}
              />

            <p className="mb-0">Stock</p>
            <input
              type="number" 
              value={stock} 
              onChange={(e)=>setStock(e.target.value)}
              />

            <p></p>
            <button className="mb-2" onClick={()=>agregarProducto()}>Guardar producto</button>
            <button onClick={cerrar}>Cerrar</button>
        </div>
    </div>
    </>
  )
}

export default PostProducto