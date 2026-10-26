import { Routes, Route, useLocation } from 'react-router-dom'

import Navbar from './pages/Navbar'

import "./App.css"
import Inicio from './pages/Inicio'
import Producto_detalle from './pages/Producto_detalle'
import Register from './pages/Register'
import Login from './pages/Login'

function App(){
  
  return(
    <>
      <Navbar />
        <Routes>
          <Route path="/" element={<Inicio/>}/>
          <Route path="/productos" element={<Producto_detalle/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/login" element={<Login/>}/>
        </Routes>
    </>
  )
}

export default App