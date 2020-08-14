# samay

#API para aplicar el Tipo de Cambio 
Permite aplicar un tipo de cambio a un monto. 
Verificación en Postman:
URL:
 http://localhost:8091/cambio
BODY: 
{
   "monto": "100",
    "monedaOrigen": "USD",
    "monedaDestino": "PEN"
}   
RESULTADO:
{
    "monto": 100.00,
    "montoCambio": 340.00,
    "monedaOrigen": "USD",
    "monedaDestino": "PEN",
    "tipoCambio": 3.40
}

#API para actualizar el valor de Tipo de Cambio
Permite actualizar el valor del tipo de cambio. 
Verificación en Postman:
URL:
 http://localhost:8091/tipocambios/1
BODY: 
    {
        "id": 0,
        "monedaOrigen": {
            "id": 3,
            "nombre": "USD"
        },
        "monedaDestino": {
            "id": 1,
            "nombre": "PEN"
        },
        "cambio": 3.4
    }

RESULTADO:
{
    "id": 1,
    "monedaOrigen": {
        "id": 3,
        "nombre": "USD"
    },
    "monedaDestino": {
        "id": 1,
        "nombre": "PEN"
    },
    "cambio": 3.4
}
