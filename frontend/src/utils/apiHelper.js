const API = "http://localhost:"

export const getSMT = async(puerto, ruta) => {
    try {
        const res = await fetch(`${API}${puerto}/api/v1/${ruta}`,
        {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
        if(!res.ok) throw new Error("ERROR al ejecutar: ", ruta)
        const data =  await res.json()
        return data
    } catch(e) {
        console.error(e)
        return []
    }
}


export const getSMT_ID = async(puerto, ruta, id) => {
    try {
        const res = await fetch(`${API}${puerto}/api/v1/${ruta}/${id}`,
        {
            method: "GET"
        })
        if(!res.ok) throw new Error("ERROR al ejecutar: ", ruta, ", ID: ", id)
        const data =  await res.json()
        return data
    } catch(e) {
        console.error(e)
        return null
    }
}
export const loginSIS = async(puerto, ruta, cuerpo) => {
    try {
        const res = await fetch(`${API}${puerto}/api/v1/${ruta}`,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cuerpo)
        })
        if(!res.ok) throw new Error("ERROR al ejecutar: ", ruta)
        const data =  await res.json()
        return data
    } catch(e) {
        console.error(e)
        return null
    }
}

export const postSMT = async(puerto, ruta, cuerpo) => {
    try {
        console.log("ENVIANDO:", cuerpo)
        const res  = await fetch(`${API}${puerto}/api/v1/${ruta}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cuerpo)
        })
        if(!res.ok) throw new Error("Error al ejecutar: ", ruta)
        const data = await res.json()
        return data
    } catch(e) {
        console.error("Couldnt execute "+`${API}${puerto}/api/v1/${ruta}`)
        console.error(e)
        return e
    }
}

export const putSMT = async(puerto, ruta, cuerpo) => {
    try {
        console.log(cuerpo)
        const res  = await fetch(`${API}${puerto}/api/v1/${ruta}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cuerpo)
        })
        if(!res.ok) throw new Error("Error al ejecutar: ", ruta)
        const data = await res.json()
        return data
    } catch(e) {
        console.error(e)
        return e
    }
}

export const deleteSMT = async(puerto, ruta, id) => {
    try {
        const res = await fetch(`${API}${puerto}/api/v1/${ruta}/${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
        if(!res.ok) throw new Error("Error al ejecutar: ", ruta)
        const data = await res.text()
        return data
    } catch(e) {
        console.error(e)
        return e
    }
}