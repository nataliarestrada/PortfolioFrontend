export class Proyecto {
    id?: number;
    personaId: number;
    nombreProye: String;
    descripcionProye: String;
    imgUrl: String;
    repoUrl: String;

    constructor(personaId: number, nombreProye: String, descripcionProye: String,
    imgUrl: String, repoUrl: String){

        this.personaId=personaId;
        this.nombreProye=nombreProye;
        this.descripcionProye=descripcionProye;
        this.imgUrl=imgUrl;
        this.repoUrl=repoUrl;
    }
}
