import { useNavigate } from "react-router-dom"

function Inicio(){
  
  const navegar = useNavigate()

  return(
    <>
        <div className="p-4 div_style">
            <h2>Bienvenido!</h2>
            <p>Presione aqui para comprar un producto:</p>
            <button onClick={()=>navegar("/productos")}>Ir a comprar</button>
        </div>
        
    </>
  )
}
//onClick={()=>navegar("/productos")}
export default Inicio