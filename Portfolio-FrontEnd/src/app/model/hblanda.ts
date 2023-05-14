export class HBlanda {
    id?: number;
    personaId: number;
    nombreHB: String;
    porcentajeHB: String;

    constructor(personaId: number, nombreHB: String, porcentajeHB: String){
        this.personaId=personaId;
        this.nombreHB=nombreHB;
        this.porcentajeHB=porcentajeHB;
    }
}
