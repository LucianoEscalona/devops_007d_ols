function PutProducto(){
  
  return(
    <>
    <div className="center_card m-0">
        <div className="div_style form_card_size">
            <h3>Modificar producto</h3>
            <p className="mb-0">Nombre</p>
            <input type="text" />
            <p className="mb-0">Precio</p>
            <input type="number" />
            <p className="mb-0">Stock</p>
            <input type="number" />
            <p></p>
            <button className="mb-2">Guardar cambios</button>
        </div>
    </div>
    </>
  )
}

export default PutProducto