import { useEffect, useState } from 'react'
import { Link, useNavigate, useLocation } from 'react-router-dom'

function Navbar() {
    
    const cerrarSesion = () => {
        localStorage.clear("sesion")
        window.location.reload()
    }
    const sesionActiva = localStorage.getItem("sesion")

    return(
        <>
        <nav className="navbar navbar-expand-lg bg-body-tertiary pad-0">
            <div className="container-fluid navbar_style">

                <Link className="navbar-brand force_c_white" to="/"> - DevOps - </Link>
                <button className="navbar-toggler force_border" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="force_c_white">""</span>
                </button>

                <div className="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <Link className="nav-link active nav_link_style" aria-current="page" to="/">Inicio</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link active nav_link_style" aria-current="page" to="/productos">Productos</Link>
                        </li>
                        {sesionActiva ? (
                            <>
                            <li className="nav-item">
                                <Link className="nav-link active nav_link_style" aria-current="page" to="#" onClick={cerrarSesion}>Cerrar sesion</Link>
                            </li>
                            </>
                        ) : (
                            <>
                            <li className="nav-item">
                                <Link className="nav-link active nav_link_style" aria-current="page" to="/login">Iniciar sesion</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link active nav_link_style" aria-current="page" to="/register">Registrarse</Link>
                            </li>
                            </>
                        )}
                        
                    </ul>
                </div>

            </div>
        </nav>
        </>
    )
}

export default Navbar