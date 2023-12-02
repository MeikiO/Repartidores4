
import { useState } from 'react'

import {BloqueDeSaludos,Saludo} from './Saludo'


export function Transiciones() {
    return (
        <div class="caja-roja">
            <p>Prueba de class</p>
        </div>
    )
}

export function Ventana_login(){
    
    const [miDato, setMiDato] = useState("5");

    return (
        <div class="caja-roja">
            <p>Lo que va ha aben en miDato 1 es {miDato}</p>
            <BloqueDeSaludos/>
            <Saludo nombre={"Mikel"} destino={"Algun sitio"}></Saludo>
        </div>  
    )
}

export function No_login(){
    return (
        <div class="caja-roja">
            <p>Prueba de class</p>
        </div>
    )
}