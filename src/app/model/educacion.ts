export class Educacion {
    id?: number;
    personaId: number;
    tituloEdu: String;
    periodoEdu: String;
    institucionEdu: String;
    descripcionEdu: String;
    urlLogoEdu: String;

    constructor(personaId: number, tituloEdu: String, periodoEdu: String,
        institucionEdu: String, descripcionEdu: String, urlLogoEdu: String){

        this.personaId=personaId;
        this.tituloEdu=tituloEdu;
        this.periodoEdu=periodoEdu;
        this.institucionEdu=institucionEdu;
        this.descripcionEdu=descripcionEdu;
        this.urlLogoEdu=urlLogoEdu;
    }
}
