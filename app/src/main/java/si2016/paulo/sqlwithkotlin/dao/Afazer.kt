package si2016.paulo.sqlwithkotlin.dao

class Afazer {
    var nome: String = ""
    var feito: Int = 0

    constructor() {}

    constructor(nome: String, feito: Int) {
        this.nome = nome
        this.feito = feito
    }
}
