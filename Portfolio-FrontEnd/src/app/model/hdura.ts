export class HDura {
    id?: number;
    personaId: number;
    nombreHD: String;
    porcentajeHD: String;

    constructor(personaId: number, nombreHD: String, porcentajeHD: String){
        this.personaId=personaId;
        this.nombreHD=nombreHD;
        this.porcentajeHD=porcentajeHD;
    }
}
