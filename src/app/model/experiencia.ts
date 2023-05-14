export class Experiencia {
    id? : number;
    personaId: number;
    puestoExpe: String;
    periodoExpe: String;
    organismoExpe: String;
    descripcionExpe: String;
    urlLogoExpe: String;

    constructor(personaId: number, puestoExpe: String, periodoExpe: String
        , organismoExpe: String, descripcionExpe: String, urlLogoExpe: String){

        this.personaId=personaId;
        this.puestoExpe=puestoExpe;
        this.periodoExpe=periodoExpe;
        this.organismoExpe=organismoExpe;
        this.descripcionExpe=descripcionExpe;
        this.urlLogoExpe=urlLogoExpe;
        
    }
}
