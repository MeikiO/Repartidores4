

export function Saludo({ nombre, destino }) {
    return <p>Hola, {nombre}. Está usted en {destino}</p>;
}


/* Las funciones para usar de fuera de carpeta pon export

- Se pueden poner mas de 1 export

*/

export function BloqueDeSaludos() {
    return (
        <div>
            <Saludo nombre="Alice" destino="MuyLejos"/>
            <Saludo nombre="Bob" destino="MasLejos"/>
            <Saludo nombre="Eve" destino="EntreUnLejosYOtro"/>
        </div>
    );
}