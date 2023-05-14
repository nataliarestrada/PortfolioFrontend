export class persona{
    id?: number;
    nombre: String;
    ocupacion: String;
    bannerUrl: String;
    email: String;
    linkedinUrl: String;
    githubUrl: String;
    facebookUrl: String;
    twtterUrl: String;
    instagramUrl: String;
    descripcion: String;
    imgUrl: String;

    constructor(nombre: String, ocupacion: String, bannerUrl: String,  email: String, linkedinUrl: String, githubUrl: String,
        facebookUrl: String, twtterUrl: String, instagramUrl: String, descripcion: String, imgUrl: String){
        this.nombre = nombre;
        this.ocupacion= ocupacion;
        this.bannerUrl=bannerUrl;
        this.email=email;
        this.linkedinUrl=linkedinUrl;
        this.githubUrl=githubUrl;
        this.facebookUrl=facebookUrl;
        this.twtterUrl=twtterUrl;
        this.instagramUrl=instagramUrl;
        this.descripcion=descripcion;
        this.imgUrl=imgUrl;
    }

}