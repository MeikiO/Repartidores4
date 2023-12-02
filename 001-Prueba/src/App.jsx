
import { useState } from 'react'


/** se importa cada una de las funciones con export */

import { Ventana_login, No_login } from './components/Login';


export default function App() {
    
    const [ventana, setVentana] = useState("Login");

    return( 

       <div>

            <h1> Parte que se renderiza fuera del if se renderiza siempre</h1>
           
            <nav>
                <button onClick={() => setVentana("Login")}> Login </button>
                <button onClick={() => setVentana("Registro")}> Registro</button>
                <button onClick={() => setVentana("Inicio")}> Inicio</button>
            </nav>

            {ventana=="Login" ?
                <Ventana_login/>       
                :
                <p> No esta en login</p>   
            },
            {ventana=="Registro" &&
                <No_login/>
            }

        </div>
    );
}